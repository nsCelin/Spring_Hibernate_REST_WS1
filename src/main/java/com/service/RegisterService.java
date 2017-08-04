package com.service;

import com.inputs.RegisterInput;
import com.entity.Register;
import com.general.Status;

public interface RegisterService {
		
	public Status registerNewUser(RegisterInput registerInput);
	public Register checkUserExists(String email);
}
