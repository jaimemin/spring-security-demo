package com.tistory.jaimemin.springsecuritydemo.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {

	private final List<UserDetails> users;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.stream()
			.filter(user -> user.getUsername().equals(username))
			.findFirst()
			.orElseThrow(() -> new UsernameNotFoundException("User [" + username + "] not found"));
	}
}
