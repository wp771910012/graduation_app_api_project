package com.cmxy.req;

import java.io.Serializable;

public class ChooseTeamReq implements Serializable{
	private Long uid;
	private Long tid;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	

}
