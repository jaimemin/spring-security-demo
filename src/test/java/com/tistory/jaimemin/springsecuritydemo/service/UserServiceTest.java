package com.tistory.jaimemin.springsecuritydemo.service;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tistory.jaimemin.springsecuritydemo.domain.user.CreateUser;
import com.tistory.jaimemin.springsecuritydemo.domain.user.User;
import com.tistory.jaimemin.springsecuritydemo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserService userService;

	@Test
	@DisplayName("user가 존재하면 RuntimeException 발생시킨다.")
	void user_exists_so_runtime_exception_occurs() {
		// given
		CreateUser create = new CreateUser("jaimemin", "1234");
		given(userRepository.userExists(create.getUsername())).willReturn(true);

		// when & then
		RuntimeException runtimeException = Assertions.assertThrows(
			RuntimeException.class,
			() -> userService.register(create)
		);
		Assertions.assertEquals(
			runtimeException.getMessage(),
			"User [jaimemin] already exists"
		);
	}

	@Test
	@DisplayName("user가 존재하지 않으면 회원가입을 수행한다.")
	void user_does_not_exists_so_register_success() {
		// given
		CreateUser create = new CreateUser("jaimemin", "1234");
		given(userRepository.userExists(create.getUsername())).willReturn(false);
		given(userRepository.create(create))
			.willReturn(User.builder()
				.username(create.getUsername())
				.build());

		// when
		String register = userService.register(create);

		// then
		Assertions.assertEquals(register, create.getUsername());
		verify(userRepository, times(1)).create(create);
	}
}