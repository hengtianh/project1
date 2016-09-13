package com.maker.mapper.impl;

import java.sql.ResultSet;

import com.maker.entity.Collection;
import com.maker.mapper.IRowMapper;

public class CollectionMapper implements IRowMapper<Collection> {

	@Override
	public Collection rowMapper(ResultSet rs) {
		Collection c = new Collection();
		try{
				c.setId(rs.getInt("id"));
				c.setUid(rs.getInt("u_id"));
				c.setKnowledgeid(rs.getInt("knowledge_id"));
		}catch(Exception e){
			c = null;
		}
		return c;
	}

}
