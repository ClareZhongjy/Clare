package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SpringMVC.entity.User;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@RequestMapping("preLogin.do")
	public String preLogin(){
		return "login/login";
	}
	
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(@ModelAttribute User user){
		System.out.println("User: "+user.getUserName());
		return "plat";
	}
}
