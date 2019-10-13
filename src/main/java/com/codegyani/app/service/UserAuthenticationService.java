package com.codegyani.app.service;

import com.codegyani.app.model.AuthenticationRequest;
import com.codegyani.app.security.JwtUser;

public interface UserAuthenticationService {

	String createAuthenticationToken(AuthenticationRequest authenticationRequest);

	String refreshAndGetAuthenticationToken(String authToken, JwtUser user);

}
