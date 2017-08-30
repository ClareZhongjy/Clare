package com.SpringMVC.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SpringMVC.dao.UploadMapper;
import com.SpringMVC.entity.Pic;
import com.SpringMVC.service.IUploadService;
import com.SpringMVC.util.BeanUtil;
import com.SpringMVC.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("uploadService")
public class UploadService implements IUploadService {

	@Autowired
	UploadMapper udao;
	
	@Override
	public void uploadPic(MultipartFile file, String userName) {
		
		byte[] b1;
		try {
			b1 = file.getBytes();
		
		
		Pic p = new Pic();
		
		p.setUsername(userName);
		p.setPic(b1);
		p.setFilename(file.getOriginalFilename());
		udao.uploadPic(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] downloadPic(String tempFileName) {
		
		byte[] files = null;
		try{
			Pic pic = udao.getDownloadPic(tempFileName);
			files = pic.getPic();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return files;
	}
	@Override
	public PagedResult<Pic> getAllDownloadByName(String fileName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		
		PagedResult<Pic> picList = BeanUtil.toPagedResult(udao.getAllDownloadByName(fileName));
		return picList;
	}

}
