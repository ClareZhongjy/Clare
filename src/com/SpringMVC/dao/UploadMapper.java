package com.SpringMVC.dao;

import org.apache.ibatis.annotations.Param;

import com.SpringMVC.entity.Pic;

public interface UploadMapper {

	void uploadPic(Pic p);

	Pic getDownloadPic(@Param("filename")String tempFileName);

}
