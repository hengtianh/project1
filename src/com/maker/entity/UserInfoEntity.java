package com.maker.entity;

public class UserInfoEntity {
	private int id;
	private String userName;
	private String userPass;
	private String nickName;
	private String headerImage;
	private String introduce;
	
	
	public UserInfoEntity() {
		super();
	}
	public UserInfoEntity(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}
	public UserInfoEntity(int id, String userName, String userPass, String nickName, String headerImage,
			String introduce) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPass = userPass;
		this.nickName = nickName;
		this.headerImage = headerImage;
		this.introduce = introduce;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeaderImage() {
		return headerImage;
	}
	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
}
