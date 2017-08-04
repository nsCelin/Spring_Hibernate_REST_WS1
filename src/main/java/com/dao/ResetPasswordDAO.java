package com.dao;

import com.entity.Register;

public interface ResetPasswordDAO {

	public Register checkUserExists(String email);
	public void updatePassword(String newPassword,String email);
	public void saveToken(String hashcode, String email);
	public String retrieveEmail(String token);
}
