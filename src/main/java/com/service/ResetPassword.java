package com.service;

import com.entity.Register;
import com.general.Status;
import com.inputs.Email;

public interface ResetPassword {
		
	public Status resetPassword(Email email);
	public Register checkUserExists(String email);
	public void updateForgetPassword(String newPassword, String confirmNewPassword,String token);
}
