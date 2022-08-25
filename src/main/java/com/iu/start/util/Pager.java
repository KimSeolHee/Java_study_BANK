package com.iu.start.util;

public class Pager {
	/*
	 * 파라미터를 담을 변수
	 * mapper에서 꺼내서 사용할 변수
	 * jsp에서 꺼내서 사용할 변수
	 * perPage : 한 화면에 출력할 글 수
	 * perBlock : 한 화면에 출력할 페이지 수
	 * */
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private Long perPage;
	private Long perBlock;
	
	//이전블록의 유무-이전블럭이 있으면 true,없으면 false
	private boolean pre;
	//다음블록의 유무-다음블럭이 있으면 true,없으면 false
	private boolean next;
	
	public Pager() {
		// TODO Auto-generated constructor stub
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	// 1. mapper에서 사용하는 값 계산 
	public void getRowNum() throws Exception {
		this.startRow = (this.getPage()*this.getPerPage())-(this.getPerPage()-1);
		this.lastRow = this.getPage()*getPerPage();
	}
	
	// 2. jsp에서 사용하는 값 계산
	public void getNum(Long totalCount) throws Exception {
		// totalCount로 totalPage 구하기
		Long totalPage = (long) Math.ceil((double) totalCount/this.getPerPage());
		// 총 몇개의 블럭이 나오는가
		Long totalBlock = (long) Math.ceil((double) totalPage/this.getPerBlock());
		// 현재 블럭 구하기
		Long curBlock = (long) Math.ceil((double) this.getPage()/this.getPerBlock());
		// curBlock으로 startNum, lastNum 계산
		this.startNum = (curBlock*this.getPerBlock()) - 4;
		this.lastNum = curBlock*this.getPerBlock();
		
		//totalPage보다 page가 더 클경우
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		//현재블록이 마지막 블록일때(totalBlock과 같을때)
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		//이전, 다음 블럭의 유무
		if(curBlock > 1) {
			pre = true;
		}
		
		if(curBlock < totalBlock) {
			next = true;
		}
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage=10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getPerBlock() {
		if(this.perBlock == null) {
			this.perBlock=5L;
		}
		return perBlock;
	}
	
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}