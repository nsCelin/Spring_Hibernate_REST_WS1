package com.inputs;

public class ChangePassword {
	
	private String newPassword;
	private String confirmNewPassword;
	private String token;;
	
	public String getNewPassword() {
		
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		
		this.newPassword = newPassword;
	}
	public String getConfirmNewPassword() {
		
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		
		this.confirmNewPassword = confirmNewPassword;
	}
	
	public String getToken(){
		
		return token;
	}
	
	public void setToken(String token){
		
		this.token=token;
	}
}
