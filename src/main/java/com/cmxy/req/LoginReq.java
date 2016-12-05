package com.cmxy.req;

import java.io.Serializable;

public class LoginReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long phone;
	private String passWord;
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

}
