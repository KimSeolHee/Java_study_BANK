package com.iu.start.board.impl;

import java.sql.Date;
import java.util.List;

public class BoardDTO {

	private String title;
	private Long hit;
	private List<BoardFileDTO> boardFileDTOs;
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
}
