package com.cts.service;
import com.cts.Entity.User;


public interface UserService {

	
	public int registerUser(User user);

	public String loginUser(User user);
}
