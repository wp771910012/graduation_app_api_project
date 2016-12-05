package com.cmxy.req;

import java.io.Serializable;

public class CreateInfomationReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tittle;
	private String sender;
	private String text;
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
