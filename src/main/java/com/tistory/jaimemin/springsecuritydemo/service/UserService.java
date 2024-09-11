package com.tistory.jaimemin.springsecuritydemo.service;

import org.springframework.stereotype.Service;

import com.tistory.jaimemin.springsecuritydemo.domain.user.CreateUser;
import com.tistory.jaimemin.springsecuritydemo.domain.user.User;
import com.tistory.jaimemin.springsecuritydemo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public String register(CreateUser create) {
		if (userRepository.userExists(create.getUsername())) {
			throw new RuntimeException(String.format("User [%s] already exists", create.getUsername()));
		}

		return userRepository.create(create).getUsername();
	}

	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
}
