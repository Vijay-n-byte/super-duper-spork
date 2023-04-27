package com.example.demospring1.dto;

public class Logindto {
	
	private String username;
	private String password;
	@Override
	public String toString() {
		return "Logindto [username=" + username + ", password=" + password + "]";
	}
	public Logindto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Logindto() {
		super();
	}
	
	

}
