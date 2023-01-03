package com.mis.domain;

import java.util.Date;

public class ReplyVO {

	private int replyNo;
	private int qnaNo;
	private String userNo;
	private String userName;
	private String replyText;
	private Date regDate;

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", qnaNo=" + qnaNo + ", userNo=" + userNo + ", userName=" + userName
				+ ", replyText=" + replyText + ", regDate=" + regDate + "]";
	}

}
