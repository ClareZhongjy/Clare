package com.SpringMVC.dao;

import org.apache.ibatis.annotations.Param;

import com.SpringMVC.entity.Pic;

public interface UploadMapper {

	void uploadPic(Pic p);

	byte[] getDownloadPic(@Param("filename")String tempFileName);

}
