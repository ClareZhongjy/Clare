package com.SpringMVC.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SpringMVC.dao.UploadMapper;
import com.SpringMVC.entity.Pic;
import com.SpringMVC.service.IUploadService;

@Service("uploadService")
public class UploadService implements IUploadService {

	@Autowired
	UploadMapper udao;
	
	@Override
	public void uploadPic(MultipartFile file) {
		
		byte[] b1;
		try {
			b1 = file.getBytes();
		
		
		Pic p = new Pic();
		
		p.setUsername("user");
		p.setPic(b1);
		
		udao.uploadPic(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
