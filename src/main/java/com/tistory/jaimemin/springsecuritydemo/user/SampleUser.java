package com.tistory.jaimemin.springsecuritydemo.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SampleUser implements UserDetails {

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "READ");
	}

	@Override
	public String getPassword() {
		return "1234";
	}

	@Override
	public String getUsername() {
		return "test";
	}
}
