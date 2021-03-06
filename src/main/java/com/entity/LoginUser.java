// default package
// Generated 19/07/2016 2:36:11 PM by Hibernate Tools 5.1.0.Beta1
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoginUser generated by hbm2java
 */
@Entity
@Table(name = "login_user", catalog = "stp")
public class LoginUser implements java.io.Serializable {

	private String email;
	private String password;

	public LoginUser() {
	}

	public LoginUser(String email) {
		this.email = email;
	}

	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Id

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "email:"+this.email;
	}

}
