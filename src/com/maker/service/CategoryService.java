package com.maker.service;

import java.util.List;

import com.maker.dao.CategoryDao;
import com.maker.entity.Category;

public class CategoryService {
	
	CategoryDao dao = new CategoryDao();
	public List<Category> getAllCategory() throws Exception{
		return dao.getAllCategory();
	}
	
	public Category getByid(int id) throws Exception{
		return dao.getByid(id);
	}
	
	public int add(Category c) throws Exception{
		return dao.add(c);
	}
	

}
