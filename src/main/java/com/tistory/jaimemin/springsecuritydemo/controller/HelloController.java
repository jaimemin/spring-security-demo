package com.tistory.jaimemin.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/v1/hello")
	String hello() {
		return "Hello World";
	}
}
