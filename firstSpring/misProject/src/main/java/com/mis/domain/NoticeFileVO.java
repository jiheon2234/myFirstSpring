package com.mis.domain;

public class NoticeFileVO {

	private int noticeFileno;
	private int noticeNo;
	private String noticeFileName;
	private String fileLocation;
	public int getNoticeFileno() {
		return noticeFileno;
	}
	public void setNoticeFileno(int noticeFileno) {
		this.noticeFileno = noticeFileno;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	@Override
	public String toString() {
		return "NoticeFileVO [noticeFileno=" + noticeFileno + ", noticeNo=" + noticeNo + ", noticeFileName="
				+ noticeFileName + ", fileLocation=" + fileLocation + "]";
	}
	
	
}
