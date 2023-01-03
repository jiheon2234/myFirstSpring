package com.mis.dto;

public class LoginDTO {
	
	private String usid;
	private String upw;
	private boolean userCookie;
	@Override
	public String toString() {
		return "LoginDTO [usid=" + usid + ", upw=" + upw + ", userCookie=" + userCookie + "]";
	}
	public String getUsid() {
		return usid;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public boolean isUserCookie() {
		return userCookie;
	}
	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}
}
