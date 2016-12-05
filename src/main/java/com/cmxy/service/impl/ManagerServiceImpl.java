package com.cmxy.service.impl;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmxy.entity.Infomation;
import com.cmxy.entity.JobOffer;
import com.cmxy.entity.Position;
import com.cmxy.persistence.InfomationDao;
import com.cmxy.persistence.JobOfferDao;
import com.cmxy.persistence.PositionDao;
import com.cmxy.req.CreateInfomationReq;
import com.cmxy.req.CreateJobOffer;
import com.cmxy.req.CreatePositionReq;
import com.cmxy.response.Response;
import com.cmxy.response.ResponseEnum;
import com.cmxy.service.ManagerSerive;

@Service("managerService")
public class ManagerServiceImpl implements ManagerSerive {
	@Autowired
	private InfomationDao infomationDao;
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private JobOfferDao jobOfferDao;

	@Override
	public Response createInfomation(CreateInfomationReq createInfomationReq) {
		// TODO Auto-generated method stub
		Infomation infomation=new Infomation();
		infomation.setCreateTime(Date.valueOf(LocalDate.now()));
		infomation.setSender(createInfomationReq.getSender());
		infomation.setText(createInfomationReq.getText());
		infomation.setTittle(createInfomationReq.getTittle());
		infomationDao.save(infomation);
		return ResponseEnum.SUCCESS.getResp();
	}

	@Override
	public Response createPosition(CreatePositionReq createPositionReq) {
		// TODO Auto-generated method stub
		Position position=new Position();
		position.setAddress(createPositionReq.getAddress());
		position.setContactsName(createPositionReq.getContactsName());
		position.setCreateTime(Date.valueOf(LocalDate.now()));
		position.setEmail(createPositionReq.getEmail());
		position.setHadPeople(createPositionReq.getHadPeople());
		position.setName(createPositionReq.getName());
		position.setPay(createPositionReq.getPay());
		position.setRequest(createPositionReq.getRequest());
		position.setRequirPeople(createPositionReq.getRequirPeople());
		position.setTittle(createPositionReq.getTittle());
		positionDao.save(position);
		return ResponseEnum.SUCCESS.getResp();
	}

	@Override
	public Response createJobOffer(CreateJobOffer createJobOffer) {
		// TODO Auto-generated method stub
		JobOffer jobOffer=new JobOffer();
        jobOffer.setCreateTime(Date.valueOf(LocalDate.now()));
        jobOffer.setText(createJobOffer.getText());
        jobOffer.setTittle(createJobOffer.getTittle());
        jobOfferDao.save(jobOffer);
		return ResponseEnum.SUCCESS.getResp();
	}

	

}
