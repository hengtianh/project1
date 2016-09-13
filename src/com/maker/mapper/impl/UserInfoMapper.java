package com.maker.mapper.impl;

import java.sql.ResultSet;

import com.maker.entity.UserInfoEntity;
import com.maker.mapper.IRowMapper;

public class UserInfoMapper implements IRowMapper<UserInfoEntity> {

	@Override
	public UserInfoEntity rowMapper(ResultSet rs) {
		UserInfoEntity entity = new UserInfoEntity();
		try{
				entity.setId(rs.getInt("id"));
				entity.setUserName(rs.getString("userName"));
				entity.setUserPass(rs.getString("userPass"));
				entity.setNickName(rs.getString("nickName"));
				entity.setHeaderImage(rs.getString("headerImage"));
				entity.setIntroduce(rs.getString("introduce"));
		}catch(Exception e){
			entity = null;
		}
		return entity;
	}

}
