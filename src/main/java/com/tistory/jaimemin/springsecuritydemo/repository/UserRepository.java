package com.tistory.jaimemin.springsecuritydemo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.jaimemin.springsecuritydemo.domain.user.CreateUser;
import com.tistory.jaimemin.springsecuritydemo.domain.user.User;
import com.tistory.jaimemin.springsecuritydemo.exception.UserNotFoundException;
import com.tistory.jaimemin.springsecuritydemo.repository.entity.AuthorityEntity;
import com.tistory.jaimemin.springsecuritydemo.repository.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

	private final UserJpaRepository userJpaRepository;

	private final AuthorityJpaRepository authorityJpaRepository;

	@Transactional(readOnly = true)
	public Boolean userExists(String username) {
		return userJpaRepository.findUserByUsername(username).isPresent();
	}

	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		return userJpaRepository.findUserByUsername(username)
			.orElseThrow(UserNotFoundException::new)
			.toUser();
	}

	@Transactional
	public User create(CreateUser create) {
		UserEntity user = userJpaRepository.save(UserEntity.newUser(create));
		AuthorityEntity authority = authorityJpaRepository.save(new AuthorityEntity("READ", user));
		user.replaceAuthority(List.of(authority));

		return user.toUser();
	}
}
