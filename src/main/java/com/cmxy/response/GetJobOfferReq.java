package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.JobOffer;

public class GetJobOfferReq extends Response{
	private List<JobOffer> jobOffers;

	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}
	

}
