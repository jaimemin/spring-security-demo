package com.tistory.jaimemin.springsecuritydemo.domain.user;

import java.util.List;

import com.tistory.jaimemin.springsecuritydemo.domain.Authority;
import com.tistory.jaimemin.springsecuritydemo.domain.EncryptionAlgorithm;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

	private String username;

	private String password;

	private EncryptionAlgorithm algorithm;

	private List<Authority> authorities;
}
