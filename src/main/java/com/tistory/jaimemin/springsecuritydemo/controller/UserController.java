package com.tistory.jaimemin.springsecuritydemo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jaimemin.springsecuritydemo.controller.request.UserRegisterRequestBody;
import com.tistory.jaimemin.springsecuritydemo.controller.response.ResultResponse;
import com.tistory.jaimemin.springsecuritydemo.domain.user.CreateUser;
import com.tistory.jaimemin.springsecuritydemo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/api/v1/register")
	public ResultResponse<String> register(@RequestBody UserRegisterRequestBody requestBody) {
		String result = userService.register(
			new CreateUser(requestBody.getUsername(), bCryptPasswordEncoder.encode(requestBody.getPassword()))
		);

		return ResultResponse.ok(result);
	}
}
