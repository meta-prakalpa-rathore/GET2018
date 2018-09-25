package com.metacube.training.model;

public class User {

    private String username;
    private String password;
    private String role;
	public User() {
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean match(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
