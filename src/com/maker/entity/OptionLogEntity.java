package com.maker.entity;

import java.util.Date;

public class OptionLogEntity {
	private int id;
	private Date optionDate;
	private String optionDes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOptionDate() {
		return optionDate;
	}
	public void setOptionDate(Date optionDate) {
		this.optionDate = optionDate;
	}
	public String getOptionDes() {
		return optionDes;
	}
	public void setOptionDes(String optionDes) {
		this.optionDes = optionDes;
	}
	
	
}
