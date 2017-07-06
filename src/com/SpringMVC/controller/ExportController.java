package com.SpringMVC.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringMVC.service.ICustomerService;

@Controller
@RequestMapping("/export")
public class ExportController {
	
	@Autowired
	ICustomerService cs;
	
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletResponse response){
		
		
		return null;
		
	}
}
