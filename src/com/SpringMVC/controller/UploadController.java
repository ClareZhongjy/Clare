package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("/preUpload.do")
	public String preUpload(){
		return "upload/upload";
	}
}
