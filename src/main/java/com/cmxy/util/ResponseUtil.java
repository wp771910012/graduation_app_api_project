package com.cmxy.util;

import com.cmxy.response.Response;
import com.cmxy.response.ResponseEnum;

public class ResponseUtil {
	public static Response CreateSuccessResp(){
		return ResponseEnum.SUCCESS.getResp();
	}

}
