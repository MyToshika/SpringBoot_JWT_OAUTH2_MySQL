package com.mytoshika.auth.service;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mytoshika.auth.exception.AuthenticationException;
import com.mytoshika.auth.model.AuthenticationRequest;
import com.mytoshika.auth.security.JwtTokenUtil;
import com.mytoshika.auth.security.JwtUser;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService{
	
    @Value("${authentication.service.url}")
    private String authURL;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String createAuthenticationToken(AuthenticationRequest authenticationRequest){
    	requireNonNull(authenticationRequest);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
         
        ResponseEntity<String> result = restTemplate.exchange(authURL, HttpMethod.GET, entity, String.class);
        
        if(result.getBody().toString().equals("success")) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final String authToken = jwtTokenUtil.generateToken(userDetails, null);
            return authToken;
        }else {
        	throw new AuthenticationException("User is not authenticated.");
        }
    }
    
    @Override
    public String refreshAndGetAuthenticationToken(String  authToken, JwtUser user) {
    	requireNonNull(authToken);
    	requireNonNull(user);
    	
        if (jwtTokenUtil.canTokenBeRefreshed(authToken, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(authToken);
            return refreshedToken;
        } else {
        	throw new AuthenticationException("Token is invalid.");
        }
    }
}
