package com.SpringMVC.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.SpringMVC.entity.Pic;
import com.SpringMVC.util.PagedResult;

public interface IUploadService {
	public void uploadPic(MultipartFile file ,String userName) throws Exception;
	public PagedResult<Pic> getAllDownloadByName(String fileName,Integer pageNo, Integer pageSize) ;
}
