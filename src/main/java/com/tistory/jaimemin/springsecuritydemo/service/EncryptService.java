package com.tistory.jaimemin.springsecuritydemo.service;

import org.springframework.stereotype.Service;

@Service
public class EncryptService {

	public String encrypt(String password) {
		return "encrypted_" + password;
	}
}
