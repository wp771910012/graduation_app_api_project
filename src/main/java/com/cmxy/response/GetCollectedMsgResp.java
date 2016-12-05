package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.JobOffer;
import com.cmxy.entity.Position;

public class GetCollectedMsgResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Position> positions;
	private List<JobOffer> jobOffers;
	private Integer type;
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}
	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
