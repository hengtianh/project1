package com.maker.service;

import com.maker.dao.UserInfoDao;
import com.maker.entity.UserInfoEntity;

public class UserInfoService {
	private UserInfoDao dao = new UserInfoDao();
	public int add(UserInfoEntity entity) throws Exception{
		return dao.add(entity);
	}
	
	public UserInfoEntity getUserInfo(String userName, String userPass) throws Exception{
		return dao.getUserInfo(userName, userPass);
	}
	
	public int getUserByUserName(String userName) throws Exception{
		return dao.getUserByUserName(userName);
	}
	
	public UserInfoEntity getUserInfoByUserName(String userName) throws Exception{
		return dao.getUserInfoByUserName(userName);
	}
	
	public UserInfoEntity getById(int id) throws Exception{
		return dao.getUserInfoById(id);
	}

	public int update(UserInfoEntity entity) throws Exception {
		return dao.update(entity);
	}

}
