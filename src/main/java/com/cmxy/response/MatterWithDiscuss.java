package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.Comment;
import com.cmxy.entity.Matter;

public class MatterWithDiscuss extends Matter{
	
	public MatterWithDiscuss() {
		super();
		// TODO Auto-generated constructor stub
	}

	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
