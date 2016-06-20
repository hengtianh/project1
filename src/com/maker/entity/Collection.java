package com.maker.entity;

public class Collection {
	int id;
	int uid;
	int knowledgeid;
	public Collection(int id, int uid, int knowledgeid) {
		super();
		this.id = id;
		this.uid = uid;
		this.knowledgeid = knowledgeid;
	}
	public Collection() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getKnowledgeid() {
		return knowledgeid;
	}
	public void setKnowledgeid(int knowledgeid) {
		this.knowledgeid = knowledgeid;
	}
	
}
