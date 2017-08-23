package com.SpringMVC.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SpringMVC.common.HttpConstants;
import com.SpringMVC.entity.User;
import com.SpringMVC.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("preLogin.do")
	public String preLogin(){
		return "login/login";
	}
	
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(@ModelAttribute User user,HttpSession session){
		
		logger.info("User: "+user.getUserName());
		logger.info("Session: "+session.getId());
		User result = userService.getUserByLogin(user);
		
		result.setSession(session.getId());
		
		int update = userService.updateUser(result);
		logger.info("Result: "+result.toString());
		
		session.setAttribute(HttpConstants.SESSION_ATTRIBUTE_USER, result);
		
		return "plat";
	}
	
	@RequestMapping(value="/loginOut.do",method=RequestMethod.GET)
	public String loginOut(String userName,HttpSession session){
		User result = userService.findUserByName(userName);
		result.setSession("");
		userService.updateUser(result);
		session.setAttribute(HttpConstants.SESSION_ATTRIBUTE_USER, null);
		return "login/login";
	}
}
