package com.tistory.jaimemin.springsecuritydemo.config;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());

		if ("jaimemin".equals(username) && "1234".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, List.of());
		}

		throw new RuntimeException("auth error");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
