package com.mis.domain;

import java.util.Date;

public class QnAVO {

	private int qnaNo;
	private String qnaTitle;
	private String qnaContents;
	private int hits;
	private Date regDate;
	private String userNo;
	private String userName;
	private int replyNo;

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContents() {
		return qnaContents;
	}

	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	@Override
	public String toString() {
		return "QnAVO [qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaContents=" + qnaContents + ", hits=" + hits
				+ ", regDate=" + regDate + ", userNo=" + userNo + ", userName=" + userName + ", replyNo=" + replyNo
				+ "]";
	}

}
