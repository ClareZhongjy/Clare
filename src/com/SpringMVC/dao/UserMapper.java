package com.SpringMVC.dao;

import com.SpringMVC.entity.User;

public interface UserMapper {
	public User getUserByLogin(User user);

	public int updateUser(User user);
}
