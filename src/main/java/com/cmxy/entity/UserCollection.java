package com.cmxy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户收藏实体
 * @author 95
 *
 */
@Entity
@Table(name="t_userCollection")
public class UserCollection {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userCollectionId;
	private Long uid;
	private Long jid;
	private Long pid;
	private Integer type;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getUserCollectionId() {
		return userCollectionId;
	}
	public void setUserCollectionId(Long userCollectionId) {
		this.userCollectionId = userCollectionId;
	}
	public Long getJid() {
		return jid;
	}
	public void setJid(Long jid) {
		this.jid = jid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	

}
