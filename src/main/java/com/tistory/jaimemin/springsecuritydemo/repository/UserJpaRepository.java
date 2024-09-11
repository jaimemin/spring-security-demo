package com.tistory.jaimemin.springsecuritydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tistory.jaimemin.springsecuritydemo.repository.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findUserByUsername(String username);
}
