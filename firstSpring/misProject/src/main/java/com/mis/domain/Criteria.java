package com.mis.domain;

public class Criteria {
	
	private int page; //시작할 페이지
	private int perPageNum; //화면에 보여줄 계시글 수
	
	private int startPage; // MyBatis에서 사용할 시작 페이지
	
	//default 생성자
	public Criteria() {
		
		this.page=1;
		this.perPageNum=10;
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		//페이징에 대한 예외처리
		if(page<=0) {
			this.page=1;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	// mybatis에서 사용할 method
	public int getPageEnd() {
		return this.startPage + 9;
	}
	
	public int getPageStart() {
		
		//페이징 시작 row 계산 1->1 2->11, 3->21, 4->31 ....
		this.startPage=(this.page*this.perPageNum)-9;
		
		return this.startPage;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startPage=" + startPage + "]";
	}

}
