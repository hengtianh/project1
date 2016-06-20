package com.maker.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.maker.entity.Category;

public class CategoryDao {
	DBHelper helper = new DBHelper();
	
	public int add(Category c) throws Exception{
		int i =0;
		try {
			String sql = "insert into k_category(name,description) values(?,?)";
			i = helper.executeUpdate(sql, c.getName(),c.getDescription());
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return i;
	}
	
	
	
	public Category getByid(int id) throws Exception{
		Category category = null;
		try {
			String sql = "select * from k_category where id=?";
			ResultSet rs = helper.executeQuery(sql, id);
			if(rs.next()){
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImg(rs.getString("img"));
				category.setDescription(rs.getString("description"));
			}
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return category;
	}
	
	public List<Category> getAllCategory() throws Exception {
		List<Category> list = new ArrayList<Category>();
		try{
			String sql = "select * from k_category";
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()){
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				c.setImg(rs.getString("img"));
				list.add(c);
			}
		}catch(Exception e){
			throw e;
		}finally{
			helper.release();
		}
		return list;
	}

}
