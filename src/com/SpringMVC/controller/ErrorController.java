package com.SpringMVC.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String accessDenied(ModelMap model){
		
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
		
	}
	
	private String getPrincipal() {
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails){
			username = ((UserDetails)principal).getUsername();
		}else{
			username = principal.toString();
		}
		return username;
	}
	
}
