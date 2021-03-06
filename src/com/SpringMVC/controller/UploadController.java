package com.SpringMVC.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.SpringMVC.common.HttpConstants;
import com.SpringMVC.entity.Customer;
import com.SpringMVC.entity.Pic;
import com.SpringMVC.entity.User;
import com.SpringMVC.service.impl.UploadService;
import com.SpringMVC.util.PagedResult;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController{
	
	@Autowired
	UploadService uservice;
	
	@RequestMapping("/preUpload.do")
	public String preUpload(){
		return "upload/upload";
	}
	@ResponseBody
	@RequestMapping(value="/streamUpload.do",produces="application/json;charset=UTF-8" )
	public String streamUpload(@RequestParam("file") CommonsMultipartFile file) throws Exception{
		long startTime=System.currentTimeMillis();  
		try {
			  
			  //获取输出流
			  
	            OutputStream os=new FileOutputStream("F:/SpringMVC/upload/"+new Date().getTime()+file.getOriginalFilename());
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
		  long endTime = System.currentTimeMillis();
			String times = String.valueOf((endTime-startTime)/1000.00)+"s";
			System.out.println("time:"+ times);
		  return times;
	}
	
	@ResponseBody
	@RequestMapping(value="/multipartUpload.do")
	public String multipartUpload(@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException{
		long startTime=System.currentTimeMillis();
		String path = "F:/SpringMVC/multipart_upload/"+new Date().getTime()+file.getOriginalFilename();
		File file2 = new File(path);
		file.transferTo(file2);
		long endTime = System.currentTimeMillis();
		String times = String.valueOf((endTime-startTime)/1000.00)+"s";
		System.out.println("time:"+ times);
		
		return times;
	}
	@ResponseBody
	@RequestMapping(value="/springUpload.do")
	public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException{
		long startTime=System.currentTimeMillis();
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
			
			//获取multiRequest 中所有的文件名
	        Iterator iter = multipart.getFileNames();
	        
	        while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multipart.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }
		}
		
		long  endTime=System.currentTimeMillis();
		
		String times = String.valueOf((endTime-startTime)/1000.00)+"s";
		System.out.println("time:"+ times);
		
		return times;
	}
	@RequestMapping(value="/preUploadPic.do")
	public String preUploadPic(){
		return "pic/uploadPic";
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/uploadPic.do",method=RequestMethod.POST)
	public String uploadPic(HttpServletRequest request) throws IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		try{
		User user = (User) request.getSession().getAttribute(HttpConstants.SESSION_ATTRIBUTE_USER);
		
		String userName = user.getCnName();
		
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
			
			//获取multiRequest 中所有的文件名
	        Iterator iter = multipart.getFileNames();
	        
	        while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multipart.getFile(iter.next().toString());
                uservice.uploadPic(file,userName);
            }
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("success");
		return "success";
		
	}
	
	@RequestMapping(value="/downloadPic.do",method=RequestMethod.POST)
	public String downloadPic(HttpServletRequest request,
            HttpServletResponse response){
		String tempFileName = "1.jpg";
		String filepath = "E://SpringMVC/download/";
		File filepaths = new File(filepath);
		if(!filepaths.exists()){
			filepaths.mkdirs();
		}
		 File file = new File(filepath+tempFileName);
	     
	     
		 response.setHeader("Content-Disposition", "attachment;filename=" +tempFileName);
	       
	      
		
		byte[] files = uservice.downloadPic(tempFileName);
		
		byte[] files2 = files;
		
		OutputStream output;
		
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(files, 0, files.length);
			fos.close();
			
			
			output = response.getOutputStream();
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
			bufferedOutPut.flush();
			bufferedOutPut.write(files2);
			
			bufferedOutPut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return null;
		
	}
	@RequestMapping(value="/preDownloadPic.do",method=RequestMethod.GET)
	public String preDownloadPic(){
		
		return "pic/downloadPic";
	}
	
	@RequestMapping(value="/downloadList.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String downloadList(Integer pageNumber,Integer pageSize ,String fileName){
		PagedResult<Pic> picList = uservice.getAllDownloadByName(fileName,pageNumber,pageSize); 
		return responseSuccess(picList);
		
	}
}
