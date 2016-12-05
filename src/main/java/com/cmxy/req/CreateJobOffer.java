package com.cmxy.req;

import java.io.Serializable;

public class CreateJobOffer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tittle;
	private String text;
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
	

}
