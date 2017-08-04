package com.dao;

import com.entity.Register;

public interface LoginUserDAO {

	public Register retrieveLoginUserDetails(String email);
	public void save();
}
