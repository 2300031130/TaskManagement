package com.klef.fsd.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Manager {
	@Id
	private String username;
	private String name;
	private String email;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
