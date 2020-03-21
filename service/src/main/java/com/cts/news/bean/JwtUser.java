package com.cts.news.bean;

public class JwtUser {
	private String userName;
	private long id;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public long getId() {
		return id;
	}



	public JwtUser(String userName, long id, String role) {
		super();
		this.userName = userName;
		this.id = id;
		this.role = role;
	}

	public JwtUser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JwtUser [userName=").append(userName).append(", id=").append(id).append(", role=").append(role)
				.append("]");
		return builder.toString();
	}

}
