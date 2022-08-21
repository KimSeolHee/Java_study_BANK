package com.iu.start.board;

import java.sql.Clob;
import java.sql.Date;

public class BoardDTO {
	
	private Long num;
	private String title;
	private Clob contents;
	private String writer;
	private Date regDate;
	private Integer hit;
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Clob getContents() {
		return contents;
	}
	public void setContents(Clob contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	
}
