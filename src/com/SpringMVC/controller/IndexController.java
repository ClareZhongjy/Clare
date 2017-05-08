package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/left.do")
	public String left(){
		return "left";
	}
	
	@RequestMapping("/top.do")
	public String top(){
		return "top";
	}
	
	
	
	@RequestMapping("/")
	public String enterMain(){
		return "plat";
	}
	
}
