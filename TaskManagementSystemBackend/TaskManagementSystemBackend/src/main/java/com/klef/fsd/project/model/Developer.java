package com.klef.fsd.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Developer {
	@Id
	private String username;
	private String name;
	private String email;
	private String contact;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getContact() {
		return contact;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
