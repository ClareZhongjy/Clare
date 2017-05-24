package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/left")
	public String left(){
		return "left";
	}
	
	@RequestMapping("/top")
	public String top(){
		return "top";
	}
	
	
	
	@RequestMapping("/main")
	public String enterMain(){
		return "plat";
	}
	
	
	@RequestMapping("/welcome")
	public String preWelcome(){
		return "index";
	}
	
	
}
