package com.cmxy.service;

import com.cmxy.req.CreateInfomationReq;
import com.cmxy.req.CreateJobOffer;
import com.cmxy.req.CreatePositionReq;
import com.cmxy.response.Response;

public interface ManagerSerive {
	public Response createInfomation(CreateInfomationReq createInfomationReq);
	public Response createPosition(CreatePositionReq createPositionReq);
	public Response createJobOffer(CreateJobOffer createJobOffer);
}
