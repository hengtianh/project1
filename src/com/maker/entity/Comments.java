package com.maker.entity;

public class Comments {
	private int id;
	private int know_id;
	private String comment;
	private int user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKnow_id() {
		return know_id;
	}
	public void setKnow_id(int know_id) {
		this.know_id = know_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
