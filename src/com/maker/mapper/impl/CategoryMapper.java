package com.maker.mapper.impl;

import java.sql.ResultSet;

import com.maker.entity.Category;
import com.maker.mapper.IRowMapper;

public class CategoryMapper implements IRowMapper<Category>{

	@Override
	public Category rowMapper(ResultSet rs) {
		Category c = new Category();
		try{
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				c.setImg(rs.getString("img"));
		}catch(Exception e){
			c = null;
		}
		return c;
	}

}
