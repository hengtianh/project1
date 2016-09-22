package com.maker.mapper.impl;

import java.sql.ResultSet;

import com.maker.entity.Category;
import com.maker.entity.Comments;
import com.maker.mapper.IRowMapper;

public class CommentMapper implements IRowMapper<Comments>{

	@Override
	public Comments rowMapper(ResultSet rs) {
		Comments c = new Comments();
		try{
				c.setId(rs.getInt("id"));
				c.setKnow_id(rs.getInt("know_id"));
				c.setComment(rs.getString("comment"));
				c.setUser_id(rs.getInt("user_id"));
		}catch(Exception e){
			c = null;
		}
		return c;
	}

}
