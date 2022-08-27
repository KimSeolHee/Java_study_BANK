package com.iu.start.board;

public class Pager{
	
	private Long page;//현재 페이지
	private Long pageStartNum; //페이지 목록글 수
	private Long pageLastNum; // 마지막목록글
	private Long firstBlockNum;// 아래 페이지네이션 첫번째
	private Long lastBlockNum;
	private Long perPage;//5페이지씩 목록글뿌리기
	private Long perBlock;//5개씩 페이지 네이션보이기
	
	private boolean pre; //앞으로 넘길건지??유무
	private boolean next;
	
	//생성자로 perBlock, perPage 정해주기
	public Pager() {
		this.perBlock = 5L;
		this.perPage = 5L;
	}
	
	public void getRowNum() throws Exception {
		this.pageStartNum = (this.getPage()*this.getPerPage())-(this.getPerPage()-1);
		this.pageLastNum = this.getPage()*getPerPage();
	}
	
	public void getNum(Long totalCount) throws Exception {
		// totalCount로 totalPage 구하기
		Long totalPage = (long) Math.ceil((double) totalCount/this.getPerPage());
		// 총 몇개의 블럭이 나오는가
		Long totalBlock = (long) Math.ceil((double) totalPage/this.getPerBlock());
		// 현재 블럭 구하기
		Long curBlock = (long) Math.ceil((double) this.getPage()/this.getPerBlock());
		// curBlock으로 startNum, lastNum 계산
		this.firstBlockNum = (curBlock*this.getPerBlock()) - 4;
		this.lastBlockNum = curBlock*this.getPerBlock();
		
		//totalPage보다 page가 더 클경우
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		//현재블록이 마지막 블록일때(totalBlock과 같을때)
		if(curBlock == totalBlock) {
			this.lastBlockNum = totalPage;
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
		if(this.page == null) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPageStartNum() {
		return pageStartNum;
	}

	public void setPageStartNum(Long pageStartNum) {
		this.pageStartNum = pageStartNum;
	}

	public Long getPageLastNum() {
		return pageLastNum;
	}

	public void setPageLastNum(Long pageLastNum) {
		this.pageLastNum = pageLastNum;
	}

	public Long getFirstBlockNum() {
		return firstBlockNum;
	}

	public void setFirstBlockNum(Long firstBlockNum) {
		this.firstBlockNum = firstBlockNum;
	}

	public Long getLastBlockNum() {
		return lastBlockNum;
	}

	public void setLastBlockNum(Long lastBlockNum) {
		this.lastBlockNum = lastBlockNum;
	}

	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage =5L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		if(this.perBlock == null) {
			this.perBlock = 5L;
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
