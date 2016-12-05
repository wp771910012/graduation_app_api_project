package com.cmxy.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 就业岗位实体类
 * @author 95
 *
 */
@Entity
@Table(name="t_position")
public class Position {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long pid;
	private Date createTime;
	private String address;
	private String tittle;
	private String name;
	private String contactsName;
	private String Email;
	private String pay;
	private String request;
	private Integer requirPeople;
	private Integer hadPeople;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactsName() {
		return contactsName;
	}
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Integer getRequirPeople() {
		return requirPeople;
	}
	public void setRequirPeople(Integer requirPeople) {
		this.requirPeople = requirPeople;
	}
	public Integer getHadPeople() {
		return hadPeople;
	}
	public void setHadPeople(Integer hadPeople) {
		this.hadPeople = hadPeople;
	}
	

}
