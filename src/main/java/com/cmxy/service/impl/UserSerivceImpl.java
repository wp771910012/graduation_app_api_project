package com.cmxy.service.impl;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.cmxy.entity.Comment;
import com.cmxy.entity.EmploymentSign;
import com.cmxy.entity.Experience;
import com.cmxy.entity.Infomation;
import com.cmxy.entity.JobOffer;
import com.cmxy.entity.Matter;
import com.cmxy.entity.Position;
import com.cmxy.entity.SMS;
import com.cmxy.entity.Team;
import com.cmxy.entity.User;
import com.cmxy.entity.UserCollection;
import com.cmxy.persistence.CommentDao;
import com.cmxy.persistence.EmploymentSignDao;
import com.cmxy.persistence.ExperienceDao;
import com.cmxy.persistence.InfomationDao;
import com.cmxy.persistence.JobOfferDao;
import com.cmxy.persistence.MatterDao;
import com.cmxy.persistence.PositionDao;
import com.cmxy.persistence.SMSDao;
import com.cmxy.persistence.SchoolDao;
import com.cmxy.persistence.TeamDao;
import com.cmxy.persistence.UserCollectionDao;
import com.cmxy.persistence.UserDao;
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
import com.cmxy.response.GetCollectedMsgResp;
import com.cmxy.response.GetEmloymentSignResp;
import com.cmxy.response.GetExperienceResp;
import com.cmxy.response.GetInfomationResp;
import com.cmxy.response.GetJobOfferReq;
import com.cmxy.response.GetMatterResq;
import com.cmxy.response.GetPositionReq;
import com.cmxy.response.GetSchoolsResp;
import com.cmxy.response.GetTeamsResp;
import com.cmxy.response.LoginResp;
import com.cmxy.response.MatterWithDiscuss;
import com.cmxy.response.Response;
import com.cmxy.response.ResponseEnum;
import com.cmxy.service.UserService;
import com.cmxy.util.SMSUtil;
@Service("userService")
public class UserSerivceImpl implements UserService {
	private static Logger logger = LogManager.getLogger(UserService.class.getName());

	@Autowired
	private SMSDao sMSDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private EmploymentSignDao employmentSignDao;
	@Autowired
	private ExperienceDao experienceDao;
	@Autowired
	private InfomationDao infomationDao;
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private JobOfferDao jobOfferDao;
	@Autowired
	private UserCollectionDao userCollectionDao;
	@Autowired
	private MatterDao matterDao;
	@Autowired
	private CommentDao commentDao;


	@Override
	public Response register(RegisterReq registerReq) {
		// TODO Auto-generated method stub
		SMS sms=sMSDao.findByPhone(registerReq.getPhone());
		if(sms!=null){
			if(userDao.findByPhone(registerReq.getPhone())!=null){
				return ResponseEnum.REGISTER_ERR_4.getResp();
			}else {	
				if(sms.getDeadline().toLocalDateTime().plusMinutes(3).isAfter(LocalDateTime.now())){
					if(registerReq.getCode().equals(sms.getCode())){
						User user=new User();
						user.setPhone(registerReq.getPhone());
						user.setPassWord(registerReq.getPassWord());
						userDao.save(user);
						return ResponseEnum.SUCCESS.getResp();
					}else {
						return ResponseEnum.REGISTER_ERR_1.getResp();
					}
				}else {
					return ResponseEnum.REGISTER_ERR_2.getResp();				
				}
			}
		}else {
			return ResponseEnum.REGISTER_ERR_3.getResp();			
		}
	}

	@Override
	public Response SMSRequest(SMSReq smsReq) {
		// TODO Auto-generated method stub

		String code="";
		for (int i = 0; i < 6; i++) {
			char c = (char) (randomInt(0, 10) + '0');
			code += String.valueOf(c);
		}
		if(SMSUtil.send(smsReq.getPhone().toString(), code)){
			SMS sms=sMSDao.findByPhone(smsReq.getPhone());
			if(sms!=null){
				sms.setCode(code);
				sms.setDeadline(Timestamp.valueOf(LocalDateTime.now()));
				sMSDao.save(sms);
			}else {
				sms=new SMS();
				sms.setPhone(smsReq.getPhone());
				sms.setCode(code);
				sms.setDeadline(Timestamp.valueOf(LocalDateTime.now()));
				sMSDao.save(sms);
			}
			return ResponseEnum.SUCCESS.getResp();
		}else {
			return ResponseEnum.SMS_ERR.getResp();			
		}
	}
	public int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
	}

	@Override
	public Response Login(LoginReq loginReq) {
		// TODO Auto-generated method stub
		User user=userDao.findByPhone(loginReq.getPhone());
		if(user!=null){
			if (user.getPassWord().equals(loginReq.getPassWord())) {
				LoginResp loginResp=new LoginResp();
				loginResp.setUser(user);
				loginResp.setResultCode(0);
				loginResp.setResultMessage("成功");
				return loginResp;
			}else {
				return ResponseEnum.LOGIN_ERR_2.getResp();
			}
		}else {
			return ResponseEnum.LOGIN_ERR_1.getResp();
		}
	}

	@Override
	public Response changePhone(ChangePhoneReq changePhoneReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(changePhoneReq.getUid());
		if(user!=null){
			SMS sms=sMSDao.findByPhone(changePhoneReq.getPhone());
			if(sms!=null){
				if(sms.getDeadline().toLocalDateTime().plusMinutes(3).isAfter(LocalDateTime.now())){
					if(sms.getCode().equals(changePhoneReq.getCode())){
						user.setPhone(changePhoneReq.getPhone());
						userDao.save(user);
						return ResponseEnum.SUCCESS.getResp();
					}else {
						return ResponseEnum.REGISTER_ERR_1.getResp();
					}
				}else {
					return ResponseEnum.REGISTER_ERR_2.getResp();
				}
			}else {
				return ResponseEnum.REGISTER_ERR_3.getResp();
			}
		}else {
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response upImg(MultipartFile file, Long uid) {
		// TODO Auto-generated method stub
		if(uid==null){
			return ResponseEnum.MSG_MISS_1.getResp();
		}
		if (file.isEmpty()) {
			return ResponseEnum.UPIMG_ERR_1.getResp();
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));

		// 文件上传路径
		String filePath =System.getProperty("user.dir")+"/Image/";

		// 解决中文问题，liunx下中文路径，图片显示问题
		// fileName = UUID.randomUUID() + suffixName;

		File dest = new File(filePath + uid+suffixName);

		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		System.out.println(filePath + uid+suffixName);
		try {
			file.transferTo(dest);
			User user=userDao.findOne(uid);
			user.setImg((filePath + uid+suffixName).replace('\\', '/'));
			userDao.save(user);
			return ResponseEnum.SUCCESS.getResp();
		} catch (Exception e){
			return ResponseEnum.UPIMG_ERR_2.getResp();
		}
	}

	@Override
	public Response changePassword(PasswordReq passwordReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(passwordReq.getUid());
		if(user!=null){
			if(user.getPassWord().equals(passwordReq.getOldWord())){
				user.setPassWord(passwordReq.getNewWord());
				userDao.save(user);
				return ResponseEnum.SUCCESS.getResp();
			}else {
				return ResponseEnum.CHANGEPASSWORD_ERR_1.getResp();
			}
		}else {
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response UpDetial(UpDetailReq upDetailReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(upDetailReq.getUid());
		if(user!=null){
			user.setName(upDetailReq.getName());
			user.setSid(upDetailReq.getSid());
			user.setProfession(upDetailReq.getProfession());
			user.setEmail(upDetailReq.getEmail());
			userDao.save(user);
			return ResponseEnum.SUCCESS.getResp();
		}else {
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public File downImg(Long uid) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(uid);
		File file =new File(user.getImg());

		return file;
	}

	@Override
	public Response getSchools() {
		// TODO Auto-generated method stub
		GetSchoolsResp getSchoolsResp=new GetSchoolsResp();
		getSchoolsResp.setResultCode(0);
		getSchoolsResp.setResultMessage("成功");
		getSchoolsResp.setSchools(schoolDao.findAll());
		return getSchoolsResp;
	}

	@Override
	public Response createTeam(CreateTeamReq createTeamReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(createTeamReq.getUid());
		if(user!=null){
			try{
				Team team=new Team();
				team.setClazz(createTeamReq.getClazz());
				team.setYear(createTeamReq.getYear());
				team.setProfession(createTeamReq.getProfession());
				team.setSid(createTeamReq.getSid());
				teamDao.save(team);
				user.setTid(team.getTid());
				userDao.save(user);
				return ResponseEnum.SUCCESS.getResp();
			}catch (Exception e) {
				// TODO: handle exception
				logger.warn(e.getMessage());
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return ResponseEnum.FAIL.getResp();
			}
		}else{
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response getTeams() {
		// TODO Auto-generated method stub
		GetTeamsResp getTeamsResp=new GetTeamsResp();
		getTeamsResp.setResultCode(0);
		getTeamsResp.setResultMessage("成功");
		getTeamsResp.setTeams(teamDao.findAll());
		return getTeamsResp;
	}

	@Override
	public Response chooseTeam(ChooseTeamReq chooseTeamReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(chooseTeamReq.getUid());
		if(user!=null){
			user.setTid(chooseTeamReq.getTid());
			userDao.save(user);
			return ResponseEnum.SUCCESS.getResp();
		}else{
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response createEmploymentSign(CreateEmploymentSignReq createEmploymentSignReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(createEmploymentSignReq.getUid());
		if(user!=null){
			try{
				EmploymentSign employmentSign=new EmploymentSign();
				employmentSign.setBusiness(createEmploymentSignReq.getBusiness());
				employmentSign.setCity(createEmploymentSignReq.getCity());
				employmentSign.setPay(createEmploymentSignReq.getPay());
				employmentSign.setPosition(createEmploymentSignReq.getPosition());
				employmentSign.setType(createEmploymentSignReq.getType());
				employmentSignDao.save(employmentSign);
				user.setEid(employmentSign.getEid());
				userDao.save(user);
				return ResponseEnum.SUCCESS.getResp();
			}catch (Exception e) {
				// TODO: handle exception
				logger.warn(e.getMessage());
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return ResponseEnum.FAIL.getResp();
			}

		}else{
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response getEmloymentSign(UidReq uidReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(uidReq.getUid());
		if(user!=null){
			EmploymentSign employmentSign=employmentSignDao.findOne(user.getEid());
			if(employmentSign!=null){
				GetEmloymentSignResp getEmloymentSignResp=new GetEmloymentSignResp();
				getEmloymentSignResp.setEmploymentSign(employmentSign);
				getEmloymentSignResp.setResultCode(0);
				getEmloymentSignResp.setResultMessage("成功");
				return getEmloymentSignResp;
			}else {
				return ResponseEnum.GETEMLOYMENTSIGN_ERR_1.getResp();
			}
		}else{
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response createExperience(CreateExperienceReq createExperienceReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(createExperienceReq.getUid());
		if(user!=null){
			Experience experience=new Experience();
			experience.setAddress(createExperienceReq.getAddress());
			experience.setCreateTime(Date.valueOf(LocalDate.now()));
			experience.setText(createExperienceReq.getText());
			experience.setUid(createExperienceReq.getUid());
			experienceDao.save(experience);
			return ResponseEnum.SUCCESS.getResp();
		}else{
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}

	@Override
	public Response getExperience(UidReq uidReq) {
		// TODO Auto-generated method stub
		User user=userDao.findOne(uidReq.getUid());
		if(user!=null){
			GetExperienceResp experienceResp=new GetExperienceResp();
			experienceResp.setExperiences(experienceDao.findByUid(uidReq.getUid()));
			experienceResp.setResultCode(0);
			experienceResp.setResultMessage("成功");
			return experienceResp;
		}else{
			return ResponseEnum.MSG_MISS_1.getResp();
		}
	}
	@Override
	public Response getInfomation() {
		// TODO Auto-generated method stub
		List<Infomation> list=infomationDao.findAll();
		GetInfomationResp getInfomationResp=new GetInfomationResp();
		getInfomationResp.setInfomations(list);
		getInfomationResp.setResultCode(0);
		getInfomationResp.setResultMessage("成功");
		return getInfomationResp;
	}

	@Override
	public Response getPosition() {
		// TODO Auto-generated method stub
		GetPositionReq getPositionReq=new GetPositionReq();
		getPositionReq.setPositions(positionDao.findAll());
		getPositionReq.setResultCode(0);
		getPositionReq.setResultMessage("成功");
		return getPositionReq;
	}

	@Override
	public Response getJobOffer() {
		// TODO Auto-generated method stub
		GetJobOfferReq getJobOfferReq=new GetJobOfferReq();
		getJobOfferReq.setJobOffers(jobOfferDao.findAll());
		getJobOfferReq.setResultCode(0);
		getJobOfferReq.setResultMessage("成功");
		return getJobOfferReq;
	}

	@Override
	public Response collectMsg(CollectionReq collectionReq) {
		// TODO Auto-generated method stub
		UserCollection collection=new UserCollection();
		User user=userDao.findOne(collectionReq.getUid());
		if(user!=null){
			collection.setUid(collectionReq.getUid());
			collection.setType(collectionReq.getType());
			switch (collectionReq.getType()) {
			case 1:
				if(jobOfferDao.findOne(collectionReq.getOperatorId())!=null){
					collection.setJid(collectionReq.getOperatorId());
				}else{
					return ResponseEnum.COLLECTMSG_ERR_1.getResp();
				}
				break;
			case 2:
				if(positionDao.findOne(collectionReq.getOperatorId())!=null){
					collection.setPid(collectionReq.getOperatorId());
				}else{
					return ResponseEnum.COLLECTMSG_ERR_1.getResp();
				}
				break;
			default:
				break;
			}
			userCollectionDao.save(collection);
			return ResponseEnum.SUCCESS.getResp();
		}else {
			return ResponseEnum.MSG_MISS_1.getResp();			
		}

	}

	@Override
	public Response getCollectedMsg(GetCollectionReq getCollectionReq) {
		// TODO Auto-generated method stub
		GetCollectedMsgResp getCollectedMsgResp=new GetCollectedMsgResp();
		User user=userDao.findOne(getCollectionReq.getUid());
		if(user!=null){
			getCollectedMsgResp.setType(getCollectionReq.getType());
			switch (getCollectionReq.getType()) {
			case 1:
				List<JobOffer> list=new ArrayList<JobOffer>();
				userCollectionDao.findByUidAndType(getCollectionReq.getUid(), getCollectionReq.getType())
				.forEach(c->{
					list.add(jobOfferDao.findOne(c.getJid()));
				});
				getCollectedMsgResp.setJobOffers(list);
				break;
			case 2:
				List<Position> list2=new ArrayList<Position>();
				userCollectionDao.findByUidAndType(getCollectionReq.getUid(), getCollectionReq.getType())
				.forEach(c->{
					list2.add(positionDao.findOne(c.getPid()));
				});
				getCollectedMsgResp.setPositions(list2);
				break;
			default:
				break;
			}
			getCollectedMsgResp.setResultCode(0);
			getCollectedMsgResp.setResultMessage("成功");
			return getCollectedMsgResp;
		}else {
			return ResponseEnum.MSG_MISS_1.getResp();			
		}
	}

	@Override
	public Response createMatter(CreateMatterReq createMatterReq) {
		// TODO Auto-generated method stub
		for(Long u:createMatterReq.getReciver()){
			if(userDao.findOne(u)==null)
				return ResponseEnum.MSG_MISS_1.getResp();
		}
		if(userDao.findOne(createMatterReq.getSender())==null)
			return ResponseEnum.MSG_MISS_1.getResp();
		Matter matter=new Matter();
		matter.setCreateDate(Date.valueOf(LocalDate.now()));
		matter.setDeadline(createMatterReq.getDeadline());
		StringBuffer str=new StringBuffer();
		Arrays.asList(createMatterReq.getReciver()).forEach(l->{
			str.append("-"+l+"-");
		});
		matter.setReciver(str.toString());
		matter.setText(createMatterReq.getText());
		matter.setSender(createMatterReq.getSender());
		matterDao.save(matter);
		return ResponseEnum.SUCCESS.getResp();
	}

	@Override
	public Response discuss(DiscussReq discussReq) {
		// TODO Auto-generated method stub
		if(matterDao.findOne(discussReq.getMid())==null)
			return ResponseEnum.MSG_MISS_2.getResp();
		if(userDao.findOne(discussReq.getUid())==null)
			return ResponseEnum.MSG_MISS_1.getResp();
		Comment comment=new Comment();
		comment.setCreateTime(Date.valueOf(LocalDate.now()));
		comment.setMid(discussReq.getMid());
		comment.setUid(discussReq.getUid());
		comment.setText(discussReq.getText());
		commentDao.save(comment);
		return ResponseEnum.SUCCESS.getResp();
	}

	@Override
	public Response getMatter(GetMatterReq getMatterReq) {
		// TODO Auto-generated method stub
		if(userDao.findOne(getMatterReq.getUid())==null)
			return ResponseEnum.MSG_MISS_1.getResp();
		GetMatterResq getMatterResq=new GetMatterResq();
		getMatterResq.setResultCode(0);
		getMatterResq.setResultMessage("成功");
		if(getMatterReq.getType()==0){
			List<Matter> list=matterDao.findBySender(getMatterReq.getUid());
			List<MatterWithDiscuss> matterWithDiscusses=new ArrayList<>();
			list.forEach(m->{
				MatterWithDiscuss matterWithDiscuss=(MatterWithDiscuss)m;
				matterWithDiscuss.setComments(commentDao.findByMid(m.getMid()));
				matterWithDiscusses.add(matterWithDiscuss);
			});
			getMatterResq.setMatterWithDiscusses(matterWithDiscusses);
			return getMatterResq;
		}else if (getMatterReq.getType()==1) {
			List<Matter> list=matterDao.findBySender(getMatterReq.getUid());
			List<MatterWithDiscuss> matterWithDiscusses=new ArrayList<>();
			list.forEach(m->{
				MatterWithDiscuss matterWithDiscuss=new MatterWithDiscuss();
				matterWithDiscuss.setCreateDate(m.getCreateDate());
				matterWithDiscuss.setDeadline(m.getCreateDate());
				matterWithDiscuss.setMid(m.getMid());
				String str=m.getReciver();
				List<Long> list1=new ArrayList<>();
				List<String> temp=Arrays.asList(str.split("--"));
		        for(int i=0;i<temp.size();i++){
		        	if(i==0){
		        		list1.add(Long.parseLong(temp.get(i).substring(1)));
		        	}else if (i==temp.size()-1) {
		        		list1.add(Long.parseLong(temp.get(i).substring(0,temp.get(i).indexOf("-"))));
					}else{
						list1.add(Long.parseLong(temp.get(i)));
					}
		        }			
				matterWithDiscuss.setReciver(list1.toString());
				matterWithDiscuss.setSender(m.getSender());
				matterWithDiscuss.setText(m.getText());
				matterWithDiscuss.setComments(commentDao.findByMid(m.getMid()));
				matterWithDiscusses.add(matterWithDiscuss);
			});
			getMatterResq.setMatterWithDiscusses(matterWithDiscusses);
			return getMatterResq;
		}else if (getMatterReq.getType()==2) {
			List<Matter> list=matterDao.findByReciverLike("%-"+getMatterReq.getUid()+"-%");
			List<MatterWithDiscuss> matterWithDiscusses=new ArrayList<>();
			list.forEach(m->{
				MatterWithDiscuss matterWithDiscuss=new MatterWithDiscuss();
				matterWithDiscuss.setCreateDate(m.getCreateDate());
				matterWithDiscuss.setDeadline(m.getCreateDate());
				matterWithDiscuss.setMid(m.getMid());
				String str=m.getReciver();
				List<Long> list1=new ArrayList<>();
				List<String> temp=Arrays.asList(str.split("--"));
		        for(int i=0;i<temp.size();i++){
		        	if(i==0){
		        		list1.add(Long.parseLong(temp.get(i).substring(1)));
		        	}else if (i==temp.size()-1) {
		        		list1.add(Long.parseLong(temp.get(i).substring(0,temp.get(i).indexOf("-"))));
					}else{
						list1.add(Long.parseLong(temp.get(i)));
					}
		        }			
				matterWithDiscuss.setReciver(list1.toString());
				matterWithDiscuss.setSender(m.getSender());
				matterWithDiscuss.setText(m.getText());
				matterWithDiscuss.setComments(commentDao.findByMid(m.getMid()));
				matterWithDiscusses.add(matterWithDiscuss);
			});
			getMatterResq.setMatterWithDiscusses(matterWithDiscusses);
			return getMatterResq;
		}else if (getMatterReq.getType()==3) {
			List<Comment> comments=commentDao.findByUid(getMatterReq.getUid());
			List<Matter> list=new ArrayList<>();
			comments.forEach(c->{
				list.add(matterDao.findOne(c.getMid()));
			});
			List<MatterWithDiscuss> matterWithDiscusses=new ArrayList<>();
			list.forEach(m->{
				MatterWithDiscuss matterWithDiscuss=new MatterWithDiscuss();
				matterWithDiscuss.setCreateDate(m.getCreateDate());
				matterWithDiscuss.setDeadline(m.getCreateDate());
				matterWithDiscuss.setMid(m.getMid());
				String str=m.getReciver();
				List<Long> list1=new ArrayList<>();
				List<String> temp=Arrays.asList(str.split("--"));
		        for(int i=0;i<temp.size();i++){
		        	if(i==0){
		        		list1.add(Long.parseLong(temp.get(i).substring(1)));
		        	}else if (i==temp.size()-1) {
		        		list1.add(Long.parseLong(temp.get(i).substring(0,temp.get(i).indexOf("-"))));
					}else{
						list1.add(Long.parseLong(temp.get(i)));
					}
		        }			
				matterWithDiscuss.setReciver(list1.toString());
				matterWithDiscuss.setSender(m.getSender());
				matterWithDiscuss.setText(m.getText());
				matterWithDiscuss.setComments(commentDao.findByMid(m.getMid()));
				matterWithDiscusses.add(matterWithDiscuss);
			});
			getMatterResq.setMatterWithDiscusses(matterWithDiscusses);
			return getMatterResq;
		}else{
			return ResponseEnum.FAIL.getResp();
		}
	}
}
