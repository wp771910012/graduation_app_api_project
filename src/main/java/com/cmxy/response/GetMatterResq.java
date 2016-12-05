package com.cmxy.response;

import java.util.List;

public class GetMatterResq extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MatterWithDiscuss> matterWithDiscusses;

	public List<MatterWithDiscuss> getMatterWithDiscusses() {
		return matterWithDiscusses;
	}

	public void setMatterWithDiscusses(List<MatterWithDiscuss> matterWithDiscusses) {
		this.matterWithDiscusses = matterWithDiscusses;
	}
	

}
