package com.tistory.jaimemin.springsecuritydemo.controller.request;

import com.tistory.jaimemin.springsecuritydemo.annotation.CustomEncryption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequestBody {

	private String id;

	@CustomEncryption
	private String password;
}
