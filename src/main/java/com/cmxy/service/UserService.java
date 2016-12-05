package com.cmxy.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.cmxy.req.ChangePhoneReq;
import com.cmxy.req.ChooseTeamReq;
import com.cmxy.req.CollectionReq;
import com.cmxy.req.CreateEmploymentSignReq;
import com.cmxy.req.CreateExperienceReq;
import com.cmxy.req.CreateMatterReq;
import com.cmxy.req.CreateTeamReq;
import com.cmxy.req.DiscussReq;
import com.cmxy.req.GetCollectionReq;
import com.cmxy.req.GetMatterReq;
import com.cmxy.req.LoginReq;
import com.cmxy.req.PasswordReq;
import com.cmxy.req.RegisterReq;
import com.cmxy.req.SMSReq;
import com.cmxy.req.UidReq;
import com.cmxy.req.UpDetailReq;
import com.cmxy.response.Response;

public interface UserService {
	public Response register(RegisterReq registerReq);
	public Response SMSRequest(SMSReq smsReq);
	public Response Login(LoginReq loginReq);
	public Response changePhone(ChangePhoneReq changePhoneReq);
	public Response upImg(MultipartFile file,Long uid);
	public Response changePassword(PasswordReq passwordReq);
	public Response UpDetial(UpDetailReq upDetailReq);
	public File downImg(Long uid);
	public Response getSchools();
	public Response createTeam(CreateTeamReq createTeamReq);
	public Response getTeams();
	public Response chooseTeam(ChooseTeamReq chooseTeamReq); 
	public Response createEmploymentSign(CreateEmploymentSignReq createEmploymentSignReq);
	public Response getEmloymentSign(UidReq uidReq);
	public Response createExperience(CreateExperienceReq createExperienceReq);
	public Response getExperience(UidReq uidReq);
	public Response getInfomation();
	public Response getPosition();
	public Response getJobOffer();
	public Response collectMsg(CollectionReq collectionReq);
	public Response getCollectedMsg(GetCollectionReq getCollectionReq);
	public Response createMatter(CreateMatterReq createMatterReq);
	public Response discuss(DiscussReq discussReq);
	public Response getMatter(GetMatterReq getMatterReq);

}
