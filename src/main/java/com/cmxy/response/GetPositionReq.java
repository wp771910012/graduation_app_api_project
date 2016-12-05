package com.cmxy.response;

import java.util.List;

import com.cmxy.entity.Position;

public class GetPositionReq extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Position> positions;

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	

}
