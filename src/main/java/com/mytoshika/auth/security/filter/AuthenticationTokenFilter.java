package com.mytoshika.auth.security.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mytoshika.auth.security.JwtTokenUtil;

/**
 * @author pussingh5
 *
 * This filter is to verify and validate the token for all authenticated request.
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Value("${jwt.header}")
	private String tokenHeader;

	private List<String> excludedUrls;

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {	
		String username = null;

		//logger.info("\n \n URL: "+request.getRequestURL().toString());
		excludedUrls = Arrays.asList("springfox-swagger-ui", "swagger-resources", "swagger-ui.html", "/v2/api-docs", "/api/create/token", "/api/user/register");
		if(!(excludedUrls.stream().filter(url-> request.getRequestURL().toString().toLowerCase().contains(url.toLowerCase())).count() > 0) && !request.getMethod().equals("OPTIONS")) {
			String authToken = request.getHeader(this.tokenHeader);
			
			if(null == authToken) {
				logger.info("Token can not be left blank.");
				throw new ServiceException("Token can not be left blank.");
			}
			
			if(authToken.startsWith("Bearer ")) {
				authToken = authToken.substring(7);
				username = jwtTokenUtil.getUsernameFromToken(authToken);
			}

			if(null == username) {
				logger.info("Username can not be left blank.");
				throw new ServiceException("Username can not be left blank.");
			}
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user: " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}else{
				logger.info("token is invalided.");
				throw new ServiceException("token is invalided");
			}

		}

		filterChain.doFilter(request, response);
	}
}