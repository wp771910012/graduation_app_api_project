package com.cmxy.req;

import java.io.Serializable;

public class SMSReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long phone;
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "SMSReq [phone=" + phone + "]";
	}
	
}
