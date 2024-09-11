package com.tistory.jaimemin.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tistory.jaimemin.springsecuritydemo.repository.entity.AuthorityEntity;

public interface AuthorityJpaRepository extends JpaRepository<AuthorityEntity, Long> {
}
