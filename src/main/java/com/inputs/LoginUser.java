package com.inputs;

//import javax.validation.constraints.NotNull; - For @NotNull

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	
	//@NotNull(message="Please provide your email")
	@NotEmpty(message = "Email cannot be empty")
	@Size(min=12,max=32, message ="Email must be between the 12 and 32 characters")
	String email;
	
	@NotEmpty(message = "Please provide your password")
	@Size(min=6,max=20)
	String password;
	
    byte [] token;
    
	public LoginUser(){		
	}
	
	public LoginUser(String email, String password, byte[] token){
		this.email = email;
		this.password= password;
		this.token = token;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}
	
	public String toString(){
		return "Email :" + email + "Passowrd :" + password + "Token :" + token;
	}
}
