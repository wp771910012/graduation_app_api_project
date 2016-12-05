package com.cmxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmxy.req.CreateInfomationReq;
import com.cmxy.req.CreateJobOffer;
import com.cmxy.req.CreatePositionReq;
import com.cmxy.response.Response;
import com.cmxy.service.ManagerSerive;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerSerive managerService;
	
	@RequestMapping(value="/createInfomation",produces="application/json",method=RequestMethod.POST)
	public Response createInfomation(@RequestBody CreateInfomationReq createInfomationReq){
		return managerService.createInfomation(createInfomationReq);
	}
	@RequestMapping(value="/createPosition",produces="application/json",method=RequestMethod.POST)
	public Response createPosition(@RequestBody CreatePositionReq createPositionReq){
		return managerService.createPosition(createPositionReq);
	}
	@RequestMapping(value="/createJobOffer",produces="application/json",method=RequestMethod.POST)
	public Response createJobOffer(@RequestBody CreateJobOffer createJobOffer){
		return managerService.createJobOffer(createJobOffer);
	}
}
