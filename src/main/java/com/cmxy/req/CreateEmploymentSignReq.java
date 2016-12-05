package com.cmxy.req;

import java.io.Serializable;

public class CreateEmploymentSignReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;
	private Integer type;
	private String city;
	private String business;
	private String position;
	private String pay;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	

}
