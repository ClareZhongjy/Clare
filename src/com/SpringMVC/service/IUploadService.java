package com.SpringMVC.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {
	public void uploadPic(MultipartFile file) throws Exception;
}
