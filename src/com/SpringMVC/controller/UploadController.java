package com.SpringMVC.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController{
	
	@RequestMapping("/preUpload.do")
	public String preUpload(){
		return "upload/upload";
	}
	@ResponseBody
	@RequestMapping(value="/streamUpload.do",produces="application/json;charset=UTF-8" )
	public String streamUpload(@RequestParam("file") CommonsMultipartFile file) throws Exception{
		  try {
	            //获取输出流
	            OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
	            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
	            InputStream is=file.getInputStream();
	            int temp;
	            //一个一个字节的读取并写入
	            while((temp=is.read())!=(-1))
	            {
	                os.write(temp);
	            }
	           os.flush();
	           os.close();
	           is.close();
	         
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    
		  return "uploaded";
	}
}
