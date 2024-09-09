package com.tistory.jaimemin.springsecuritydemo.aop;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tistory.jaimemin.springsecuritydemo.controller.request.HelloRequestBody;
import com.tistory.jaimemin.springsecuritydemo.service.EncryptService;

@ExtendWith(MockitoExtension.class)
class PasswordEncryptionAspectTest {

	PasswordEncryptionAspect passwordEncryptionAspect;

	@Mock
	EncryptService encryptService;

	@BeforeEach
	void setup() {
		passwordEncryptionAspect = new PasswordEncryptionAspect(encryptService);
	}

	@Test
	void test() {
		// given
		HelloRequestBody requestBody = new HelloRequestBody("id", "password");
		when(encryptService.encrypt(any())).thenReturn("encrypted");

		// when
		passwordEncryptionAspect.fieldEncryption(requestBody);

		// then
		assertThat(requestBody.getPassword()).isEqualTo("encrypted");
	}
}