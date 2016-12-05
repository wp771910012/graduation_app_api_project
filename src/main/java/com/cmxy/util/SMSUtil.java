package com.cmxy.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SMSUtil {
	public static TaobaoClient client=new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23538035", "4a6746942c83012dcb742b777804bcf2");
	public static boolean send(String phone,String code){
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "毕业季" );
		req.setSmsParamString( "{code:'"+code+"'}" );
		req.setRecNum( phone );
		req.setSmsTemplateCode( "SMS_27000049" );
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			if(rsp.isSuccess()){
				return true;
			}else {
				return false;
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
