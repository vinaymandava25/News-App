package com.cts.news.bean;

public class AuthenticationStatus {

	private boolean authenticated;
	private User user;
	private String token;
	private boolean checkEmail;
	private boolean checkUserId;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationStatus(boolean authenticated) {
		super();
		this.authenticated = authenticated;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public boolean isCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(boolean checkEmail) {
		this.checkEmail = checkEmail;
	}

	public boolean isCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(boolean checkUserId) {
		this.checkUserId = checkUserId;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + ", user=" + user + ", token=" + token
				+ ", checkEmail=" + checkEmail + ", checkUserId=" + checkUserId + ", active=" + active + "]";
	}

}
