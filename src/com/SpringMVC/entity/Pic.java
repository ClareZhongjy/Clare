package com.SpringMVC.entity;

public class Pic {
//http://blog.csdn.net/u013160024/article/details/51849732
	private String username;
	private byte[] pic;
	private String filename;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
