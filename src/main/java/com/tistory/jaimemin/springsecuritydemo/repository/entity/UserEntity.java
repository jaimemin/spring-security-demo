package com.tistory.jaimemin.springsecuritydemo.repository.entity;

import java.util.ArrayList;
import java.util.List;

import com.tistory.jaimemin.springsecuritydemo.domain.EncryptionAlgorithm;
import com.tistory.jaimemin.springsecuritydemo.domain.user.CreateUser;
import com.tistory.jaimemin.springsecuritydemo.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	@Enumerated(EnumType.STRING)
	private EncryptionAlgorithm algorithm;

	@OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
	private List<AuthorityEntity> authorities = new ArrayList<>();

	public UserEntity(String username, String password, EncryptionAlgorithm algorithm) {
		this.username = username;
		this.password = password;
		this.algorithm = algorithm;
	}

	public User toUser() {
		return User.builder()
			.username(this.username)
			.password(this.password)
			.algorithm(this.algorithm)
			.authorities(this.authorities.stream()
				.map(AuthorityEntity::toAuthority)
				.toList())
			.build();
	}

	public void replaceAuthority(List<AuthorityEntity> newAuthorities) {
		this.authorities = authorities;
	}

	public static UserEntity newUser(CreateUser create) {
		return new UserEntity(
			create.getUsername(),
			create.getPassword(),
			EncryptionAlgorithm.BCRYPT
		);
	}
}
