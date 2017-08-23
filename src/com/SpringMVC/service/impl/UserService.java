package com.SpringMVC.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMVC.dao.UserMapper;
import com.SpringMVC.entity.User;
import com.SpringMVC.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	UserMapper userDao;
	
	@Override
	public User getUserByLogin(User user) {
		User result = userDao.getUserByLogin(user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = userDao.updateUser(user);
		return result;
	}

	@Override
	public User findUserByName(String userName) {
		User user = userDao.findUserByName(userName);
		return user;
	}
	
}
