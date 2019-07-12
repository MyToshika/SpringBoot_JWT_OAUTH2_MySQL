package com.mytoshika.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.auth.aop.Loggable;
import com.mytoshika.auth.model.AuthenticationRequest;
import com.mytoshika.auth.model.AuthenticationResponse;
import com.mytoshika.auth.security.JwtUser;
import com.mytoshika.auth.service.UserAuthenticationService;

/**
 * @author pussingh5
 *
 * This file is for authentication the user and provide and refresh the JWT token.
 */
@RestController
public class UserAuthenticationRestController {


    @Value("${jwt.header}")
    private String tokenHeader;
    
//    @Autowired
//    private UserDetailsService userDetailsService;
//    
//    @Autowired
//    private UserRepository userRepository;
//    
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private AuthorityRepository authorityRepository;
    
    @Autowired
    private UserAuthenticationService userAuthenticationService;
    
    private final Log logger = LogFactory.getLog(this.getClass());

    @Loggable
    @RequestMapping(value = "${jwt.route.authentication.create}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
       
    	final String authToken = userAuthenticationService.createAuthenticationToken(authenticationRequest);
    	logger.info("Generated token: "+authToken);

        // Return the token
        return ResponseEntity.ok(new AuthenticationResponse(authToken));
    }

    @Loggable
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    	
        String  authToken    = request.getHeader(tokenHeader);
        if(authToken.startsWith("Bearer ")) {
        	authToken = authToken.substring(7);
        }
        logger.info("Received token: "+authToken+" to refresh.");
        
        JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(new AuthenticationResponse(userAuthenticationService.refreshAndGetAuthenticationToken(authToken, user)));
    }
    
    @Loggable
    @RequestMapping(value = "api/user", method = RequestMethod.GET)
    public JwtUser getUserDetails(HttpServletRequest request) {

        return (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
//    @Loggable
//    @RequestMapping(value = "api/user/register", method = RequestMethod.POST)
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//
//    	GenericResponse response = new GenericResponse();
//    	response.setStatus("success");
//    	
//    	UserDetails userDetails = null;
//    	try {
//    		userDetails = userDetailsService.loadUserByUsername(user.getUsername());
//    	}catch (Exception e) {
//    		logger.info(String.format("Warning exception = %s ", e.getMessage()));
//    	}
//    	
//		if(null != userDetails) {
//			response.setStatus("failure");
//			response.setMessage(String.format("User is already exist for this username: %s", user.getUsername()));
//			
//			return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
//		}
//    	
//    	User userEntity = new User();
//    	userEntity.setUsername(user.getUsername());
//    	userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
//    	userEntity.setEmail(user.getEmail());
//    	userEntity.setFirstname(user.getFirstname());
//    	userEntity.setLastname(user.getLastname());
//    	userEntity.setEnabled(true);
//    	userEntity.setLastPasswordResetDate(new Date());
//    	
//    	userEntity.setAuthorities(Arrays.asList(authorityRepository.findByName(AuthorityName.ROLE_ADMIN)));
//    	
//    	long size = userRepository.findAll().size();
//    	userEntity.setId(size+1);
//    	userRepository.save(userEntity);
//    	
//        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
//    }

}
