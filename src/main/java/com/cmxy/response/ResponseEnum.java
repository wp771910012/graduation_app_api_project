package com.cmxy.response;

public enum ResponseEnum{
	SUCCESS("成功",0),
	SMS_ERR("手机格式错误 或已停机",1),
	REGISTER_ERR_1("验证码错误",2),
	REGISTER_ERR_2("验证码过期请重新获取",3),
	REGISTER_ERR_3("该手机号未获取过验证码",4),
	REGISTER_ERR_4("该手机号已经注册",5),
	LOGIN_ERR_1("用户名不存在",6),
	LOGIN_ERR_2("密码错误",7),
	UPIMG_ERR_1("图片为空",8),
	UPIMG_ERR_2("图片上传失败，大小不合法",9),
	CHANGEPASSWORD_ERR_1("旧密码错误",10),
	GETEMLOYMENTSIGN_ERR_1("未创建就业标签",11),
	COLLECTMSG_ERR_1("该信息不存在或与所传类型不匹配",12),
	MSG_MISS_1("入参缺失或不存在：用户id(uid)",51),
	MSG_MISS_2("入参缺失或不存在：事务id(mid)",52),
	FAIL("失败",100);
	private Response resp;
	private ResponseEnum(String msg,int code) {
		Response r=new Response();
		r.setResultCode(code);
		r.setResultMessage(msg);
		this.resp = r;
	}
	public Response getResp() {
		return resp;
	}
	public void setResp(Response resp) {
		this.resp = resp;
	}
	
	
	
    

}
