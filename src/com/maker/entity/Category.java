package com.maker.entity;

public class Category {
	private int id;
	private String name;
	private String description;
	private String img;
	
	
	public Category() {
		super();
	}
	public Category(int id, String name, String description, String img) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
