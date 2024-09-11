package com.tistory.jaimemin.springsecuritydemo.repository.entity;

import com.tistory.jaimemin.springsecuritydemo.domain.Authority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorities")
public class AuthorityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "userEntity")
	private UserEntity userEntity;

	public AuthorityEntity(String name, UserEntity user) {
		this.name = name;
		this.userEntity = user;
	}

	public Authority toAuthority() {
		return Authority.builder()
			.name(this.name)
			.build();
	}
}
