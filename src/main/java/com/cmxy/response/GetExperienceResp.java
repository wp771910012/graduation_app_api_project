package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.Experience;

public class GetExperienceResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Experience> experiences;

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	

}
