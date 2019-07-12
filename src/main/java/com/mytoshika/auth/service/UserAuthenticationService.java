package com.mytoshika.auth.service;

import com.mytoshika.auth.model.AuthenticationRequest;
import com.mytoshika.auth.security.JwtUser;

public interface UserAuthenticationService {

	String createAuthenticationToken(AuthenticationRequest authenticationRequest);

	String refreshAndGetAuthenticationToken(String authToken, JwtUser user);

}
