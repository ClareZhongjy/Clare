package com.SpringMVC.service;

import com.SpringMVC.entity.User;

public interface IUserService {
	
	public User getUserByLogin(User user);

	public int updateUser(User user);

	public User findUserByName(String userName);
	
	
	
}
