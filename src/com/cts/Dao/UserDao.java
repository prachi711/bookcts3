package com.cts.Dao;

import com.cts.Entity.User;

public interface UserDao {

	
	// public UserDao getUserDAOImpl();
	
	public int registerUser(User user);
	public String loginUser(User user);
}
