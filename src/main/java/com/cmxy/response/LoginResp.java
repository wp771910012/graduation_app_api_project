package com.cmxy.response;

import com.cmxy.entity.User;

public class LoginResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
