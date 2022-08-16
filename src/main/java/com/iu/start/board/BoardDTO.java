package com.iu.start.board;

import java.sql.Date;

public class BoardDTO {
	
	private Long boardNum;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private Integer hits;
	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
}
