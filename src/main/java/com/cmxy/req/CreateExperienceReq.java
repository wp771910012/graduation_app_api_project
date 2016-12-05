package com.cmxy.req;

import java.io.Serializable;
import java.sql.Date;

public class CreateExperienceReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;
	private String address;
	private String text;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
