package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.School;

public class GetSchoolsResp extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<School> schools;
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	
	

}
