package com.cmxy.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
import com.cmxy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	private static Logger logger = LogManager.getLogger(UserController.class.getName());
	
	@RequestMapping(value="/SMSRequest",produces="application/json",method=RequestMethod.POST)
	public Response SMSRequest(@RequestBody SMSReq smsReq){
		return userService.SMSRequest(smsReq);
	}
	
	@RequestMapping(value="/register",produces="application/json",method=RequestMethod.POST)
	public Response register(@RequestBody RegisterReq registerReq){
		return userService.register(registerReq);
	}
	@RequestMapping(value="/login",produces="application/json",method=RequestMethod.POST)
	public Response login(@RequestBody LoginReq loginReq){
		return userService.Login(loginReq);
	}
	@RequestMapping(value="/changePhone",produces="application/json",method=RequestMethod.POST)
	public Response changePhone(@RequestBody ChangePhoneReq changePhoneReq){
		return userService.changePhone(changePhoneReq);
	}

	@RequestMapping(value="/upImg",method={RequestMethod.POST,RequestMethod.GET})
	public Response upImg(@RequestParam("roncooFile") MultipartFile file,@RequestParam("uid") Long uid){
		return userService.upImg(file,uid);
	}
	@RequestMapping(value="/changePassWord",produces="application/json",method=RequestMethod.POST)
	public Response changePassWord(@RequestBody PasswordReq passwordReq){
		return userService.changePassword(passwordReq);
	}
	@RequestMapping(value="/upDetail",produces="application/json",method=RequestMethod.POST)
	public Response upDetail(@RequestBody UpDetailReq upDetailReq){
		return userService.UpDetial(upDetailReq);
	}
	@RequestMapping(value="/downImg",method={RequestMethod.POST,RequestMethod.GET})
	public void downImg(@RequestBody @RequestParam Long uid , HttpServletResponse response) throws IOException{
	     File file=userService.downImg(uid);
		 FileInputStream inputStream = new FileInputStream(file);  
         response.setHeader("Content-Length", String.valueOf(file.length()));  
         ByteArrayOutputStream outStream=new ByteArrayOutputStream();
         byte[] buffer=new byte[1024*4];
         int n=0;
         while ( (n=inputStream.read(buffer)) !=-1) {
        	 outStream.write(buffer,0,n);
         } 
         byte[] bos =outStream.toByteArray();
         OutputStream out = null;  
         out = response.getOutputStream();  
         
         out.write(bos);  
         out.flush();  
         out.close();  
         inputStream.close();  
	}
	@RequestMapping(value="/getSchools",produces="application/json",method=RequestMethod.POST)
	public Response getSchools(){
		return userService.getSchools();
	}
	@RequestMapping(value="/createTeam",produces="application/json",method=RequestMethod.POST)
	public Response createTeam(@RequestBody CreateTeamReq createTeamReq){
		return userService.createTeam(createTeamReq);
	}
	@RequestMapping(value="/getTeams",produces="application/json",method=RequestMethod.POST)
	public Response getTeams(){
		return userService.getTeams();
	}
	@RequestMapping(value="/chooseTeam",produces="application/json",method=RequestMethod.POST)
	public Response chooseTeam(@RequestBody ChooseTeamReq chooseTeamReq){
		return userService.chooseTeam(chooseTeamReq);
	}
	@RequestMapping(value="/createEmloymentSign",produces="application/json",method=RequestMethod.POST)
	public Response createEmloymentSign(@RequestBody CreateEmploymentSignReq createEmploymentSignReq){
		return userService.createEmploymentSign(createEmploymentSignReq);
	}
	@RequestMapping(value="/getEmloymentSign",produces="application/json",method=RequestMethod.POST)
	public Response getEmloymentSign(@RequestBody UidReq uidReq){
		return userService.getEmloymentSign(uidReq);
	}
	@RequestMapping(value="/createExperience",produces="application/json",method=RequestMethod.POST)
	public Response createExperience(@RequestBody CreateExperienceReq createExperienceReq){
		return userService.createExperience(createExperienceReq);
	}
	@RequestMapping(value="/getExperience",produces="application/json",method=RequestMethod.POST)
	public Response getExperience(@RequestBody UidReq uidReq){
		return userService.getExperience(uidReq);
	}
	@RequestMapping(value="/getInfomation",produces="application/json",method=RequestMethod.POST)
	public Response getInfomation(){
		return userService.getInfomation();
	}
	@RequestMapping(value="/getPosition",produces="application/json",method=RequestMethod.POST)
	public Response getPosition(){
		return userService.getPosition();
	}
	@RequestMapping(value="/getJobOffer",produces="application/json",method=RequestMethod.POST)
	public Response getJobOffer(){
		return userService.getJobOffer();
	}
	@RequestMapping(value="/collectMsg",produces="application/json",method=RequestMethod.POST)
	public Response collectMsg(@RequestBody CollectionReq collectionReq){
		return userService.collectMsg(collectionReq);
	}
	@RequestMapping(value="/getCollectedMsg",produces="application/json",method=RequestMethod.POST)
	public Response getCollectedMsg(@RequestBody GetCollectionReq getCollectionReq){
		return userService.getCollectedMsg(getCollectionReq);
	}
	@RequestMapping(value="createMatter",produces="application/json",method=RequestMethod.POST)
	public Response createMatter(@RequestBody CreateMatterReq createMatterReq){
		return userService.createMatter(createMatterReq);
	}
	@RequestMapping(value="discuss",produces="application/json",method=RequestMethod.POST)
	public Response discuss(@RequestBody DiscussReq discussReq){
		return userService.discuss(discussReq);
	}
	@RequestMapping(value="getMatter",produces="application/json",method=RequestMethod.POST)
	public Response getMatter(@RequestBody GetMatterReq getMatterReq){
		return userService.getMatter(getMatterReq);
	}
	
}
