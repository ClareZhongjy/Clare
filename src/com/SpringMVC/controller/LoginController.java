package com.SpringMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	
	
	@RequestMapping(value="/main.do",method=RequestMethod.GET)
	public String login(@ModelAttribute User user,HttpSession session){
		
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
	
		logger.info("User: "+userDetails.getUsername());
		logger.info("Session: "+session.getId());
		user.setUserName(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		User result = userService.findUserByName(user.getUserName());
		
		result.setSession(session.getId());
		
		int update = userService.updateUser(result);
		logger.info("Result: "+result.toString());
		
		session.setAttribute(HttpConstants.SESSION_ATTRIBUTE_USER, result);
		
		return "plat";
	}
	
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public String loginOut(String userName,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		User result = userService.findUserByName(userDetails.getUsername());
		result.setSession("");
		userService.updateUser(result);
		session.setAttribute(HttpConstants.SESSION_ATTRIBUTE_USER, null);
		//return "login/login";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth !=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		//return "redirect:login?logout";
		return "redirect:main.do";
	}
}
