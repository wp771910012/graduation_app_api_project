package com.cmxy.req;

import java.io.Serializable;

public class UpDetailReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;
	private String name;
	private Long sid;
	private String profession;
	private String Email;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

}
