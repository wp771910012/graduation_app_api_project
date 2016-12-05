package com.cmxy.req;

import java.io.Serializable;
import java.sql.Date;

public class CreateTeamReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;
	private Long sid;
	private String year;
	private String profession;
	private String clazz;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	

}
