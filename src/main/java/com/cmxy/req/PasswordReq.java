package com.cmxy.req;

import java.io.Serializable;

public class PasswordReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;
	private String oldWord;
	private String newWord;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getOldWord() {
		return oldWord;
	}
	public void setOldWord(String oldWord) {
		this.oldWord = oldWord;
	}
	public String getNewWord() {
		return newWord;
	}
	public void setNewWord(String newWord) {
		this.newWord = newWord;
	}
	

}
