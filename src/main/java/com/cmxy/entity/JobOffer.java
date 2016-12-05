package com.cmxy.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 招聘信息实体
 * @author 95
 *
 */
@Entity
@Table(name="t_jobOffer")
public class JobOffer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long jid;
	private String tittle;
	private String text;
	private Date createTime;
	public Long getJid() {
		return jid;
	}
	public void setJid(Long jid) {
		this.jid = jid;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
