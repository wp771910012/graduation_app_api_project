package com.cmxy.req;

import java.io.Serializable;

public class CollectionReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;
	private Long operatorId;
	private Integer type;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CollectionReq [uid=" + uid + ", operatorId=" + operatorId + ", type=" + type + "]";
	}
	

}
