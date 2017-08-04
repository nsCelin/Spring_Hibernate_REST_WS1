package com.service;

import com.inputs.LoginUser;
import com.exceptions.CustomerNotFoundException;
import com.general.Session;

public interface LoginService {
		
	public Session processInput(LoginUser loginUser) throws CustomerNotFoundException;
}
