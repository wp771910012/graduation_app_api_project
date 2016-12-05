package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.Team;

public class GetTeamsResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Team> teams;

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	

}
