package com.example.login.model;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm {
	@Size(min = 4, max = 20)
	private String id;
	@Size(min = 4, max = 20)
	private String password;
}
