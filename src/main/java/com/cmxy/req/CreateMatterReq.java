package com.cmxy.req;

import java.io.Serializable;
import java.sql.Date;

public class CreateMatterReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long sender;
	private Long[] reciver;
	private Date deadline;
	private String text;
	public Long getSender() {
		return sender;
	}
	public void setSender(Long sender) {
		this.sender = sender;
	}
	public Long[] getReciver() {
		return reciver;
	}
	public void setReciver(Long[] reciver) {
		this.reciver = reciver;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
