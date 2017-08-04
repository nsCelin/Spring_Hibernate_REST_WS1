package com.inputs;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@NotEmpty
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	
	public User(){		
	}
		
	public User(String email,String password, String firstName, String lastName, int phoneNumber){
		super();
		this.email=email;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
