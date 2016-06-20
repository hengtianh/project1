package com.maker.entity;

import java.util.Date;

public class KnowledgeEntity {
	private int id;
	private String title;
	private String content;
	private Date pubDate;
	private int cid;
	private String label;
	private int readCount;
	private int ding; 
	private int cai; 
	private int uid;
	private int state;
	private int stateUid;
	private Date stateDate;
	private String stateContent;
	
	private UserInfoEntity entity;
	private Category category;
	
	
	public KnowledgeEntity(int id, String title, String content, Date pubDate, int cid, String label, int readCount,
			int ding, int cai, int uid, int state, int stateUid, Date stateDate, String stateContent) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pubDate = pubDate;
		this.cid = cid;
		this.label = label;
		this.readCount = readCount;
		this.ding = ding;
		this.cai = cai;
		this.uid = uid;
		this.state = state;
		this.stateUid = stateUid;
		this.stateDate = stateDate;
		this.stateContent = stateContent;
	}
	public KnowledgeEntity() {
		super();
	}
	
	
	public UserInfoEntity getEntity() {
		return entity;
	}
	public void setEntity(UserInfoEntity entity) {
		this.entity = entity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getDing() {
		return ding;
	}
	public void setDing(int ding) {
		this.ding = ding;
	}
	public int getCai() {
		return cai;
	}
	public void setCai(int cai) {
		this.cai = cai;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getStateUid() {
		return stateUid;
	}
	public void setStateUid(int stateUid) {
		this.stateUid = stateUid;
	}
	public Date getStateDate() {
		return stateDate;
	}
	public void setStateDate(Date stateDate) {
		this.stateDate = stateDate;
	}
	public String getStateContent() {
		return stateContent;
	}
	public void setStateContent(String stateContent) {
		this.stateContent = stateContent;
	}
	
	
}
