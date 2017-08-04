package com.dao;

import com.entity.Register;


public interface RegisterDAO {

	public void save(Register register);
	public Register checkUserExists(String email);
}
