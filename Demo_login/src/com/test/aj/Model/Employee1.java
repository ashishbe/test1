package com.test.aj.Model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;
import javax.validation.constraints.NotNull;



public class Employee1 {

	@NotEmpty(message = "username should not be empty")
	String username;
	
	@NotEmpty(message = "password should not be empty")
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
