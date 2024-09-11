package com.tistory.jaimemin.springsecuritydemo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.jaimemin.springsecuritydemo.domain.Authority;
import com.tistory.jaimemin.springsecuritydemo.repository.entity.AuthorityEntity;
import com.tistory.jaimemin.springsecuritydemo.repository.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorityRepository {

	private final AuthorityJpaRepository authorityJpaRepository;

	@Transactional
	public Authority create(String name, UserEntity user) {
		return authorityJpaRepository.save(new AuthorityEntity(name, user))
			.toAuthority();
	}
}
