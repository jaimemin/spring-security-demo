package com.tistory.jaimemin.springsecuritydemo.user;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class SampleUserTest {

	@Test
	void sampleUserTest() {
		SampleUser sampleUser = new SampleUser();

		assertThat(sampleUser.getUsername()).isEqualTo("test");
		assertThat(sampleUser.getPassword()).isEqualTo("1234");
		assertThat(sampleUser.getAuthorities().size()).isEqualTo(1);

		Optional<? extends GrantedAuthority> read = sampleUser.getAuthorities()
			.stream()
			.filter(authority -> "READ".equals(authority.getAuthority()))
			.findFirst();
		read.ifPresent(each -> assertThat(each.getAuthority()).isEqualTo("READ"));
	}
}