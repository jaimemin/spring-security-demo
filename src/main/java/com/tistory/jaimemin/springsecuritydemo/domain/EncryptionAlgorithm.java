package com.tistory.jaimemin.springsecuritydemo.domain;

import lombok.Getter;

@Getter
public enum EncryptionAlgorithm {
	BCRYPT,
	SCRYPT,
	;
}
