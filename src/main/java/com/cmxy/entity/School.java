package com.cmxy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学校实体
 * @author 95
 *
 */
@Entity
@Table(name="t_school")
public class School {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long sid;
	private String name;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
