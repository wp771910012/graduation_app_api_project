package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.Infomation;

public class GetInfomationResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Infomation> infomations;

	public List<Infomation> getInfomations() {
		return infomations;
	}

	public void setInfomations(List<Infomation> infomations) {
		this.infomations = infomations;
	}
	

}
