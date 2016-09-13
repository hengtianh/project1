package com.maker.mapper.impl;

import java.sql.ResultSet;

import com.maker.entity.KnowledgeEntity;
import com.maker.mapper.IRowMapper;

public class KnowledgeRowMapper implements IRowMapper<KnowledgeEntity> {

	@Override
	public KnowledgeEntity rowMapper(ResultSet rs) {
		KnowledgeEntity entity = new KnowledgeEntity();
		try{
				entity = new KnowledgeEntity();
				entity.setId(rs.getInt("id"));
				entity.setTitle(rs.getString("title"));
				entity.setLabel(rs.getString("label"));
				entity.setContent(rs.getString("content"));
				entity.setDing(rs.getInt("ding"));
				entity.setCai(rs.getInt("cai"));
				entity.setReadCount(rs.getInt("readCount"));
				entity.setPubDate(rs.getTimestamp("pubDate"));
				entity.setState(rs.getInt("state"));
				entity.setStateContent(rs.getString("stateContent"));
				entity.setStateDate(rs.getTimestamp("stateDate"));
				entity.setStateUid(rs.getInt("stateUid"));
				entity.setCid(rs.getInt("cid"));
				entity.setUid(rs.getInt("uid"));
		}catch(Exception e){
			entity = null;
		}
		return entity;
	}

}
