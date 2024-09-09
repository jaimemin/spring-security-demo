package com.tistory.jaimemin.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jaimemin.springsecuritydemo.controller.request.HelloRequestBody;
import com.tistory.jaimemin.springsecuritydemo.service.EncryptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final EncryptService encryptService;

	@GetMapping("/api/v1/hello")
	String hello(@RequestBody HelloRequestBody request) {
		String encrypted = encryptService.encrypt(request.getPassword());

		return encrypted;
	}
}
