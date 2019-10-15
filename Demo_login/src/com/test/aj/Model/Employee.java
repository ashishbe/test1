package com.test.aj.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "emp_spring")
public class Employee {

	@Id
	@GeneratedValue
	int id;
	

	@NotNull(message = "name not be empty")
	String name;
	
	@Email @NotNull
	String email;
	
	@Size(min = 3 , max = 10 , message = "password length should be min {min} and max {max}")
//	@Pattern(regexp=".+@.+\\.[a-z]+")
	@NotNull
	String password;
    
	@Size(min = 10 , max = 10 , message="mobile number leangth should be 10")
 //   @Pattern(regexp="^[a-zA-Z0-9]{3}",message="should be only number")
	@NotNull
	String mobileno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
