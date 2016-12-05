package com.cmxy.response;

import com.cmxy.entity.EmploymentSign;

public class GetEmloymentSignResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmploymentSign employmentSign;

	public EmploymentSign getEmploymentSign() {
		return employmentSign;
	}

	public void setEmploymentSign(EmploymentSign employmentSign) {
		this.employmentSign = employmentSign;
	}
	

}
