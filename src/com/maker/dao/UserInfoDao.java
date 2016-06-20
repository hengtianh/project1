package com.maker.dao;

import java.sql.ResultSet;

import com.maker.entity.KnowledgeEntity;
import com.maker.entity.UserInfoEntity;

public class UserInfoDao {
	private DBHelper helper = new DBHelper();
	
	public int add(UserInfoEntity entity) throws Exception{
		try{
			String sql = "INSERT INTO u_userinfo(userName,userPass,nickName) VALUES(?,?,?)";
			Object[] params = {entity.getUserName(),entity.getUserPass(),entity.getNickName()};
			return helper.executeUpdate(sql, params);
		}catch(Exception e){
			throw e;
		}finally{
			helper.release();
		}
	}
	
	public UserInfoEntity getUserInfo(String userName, String userPass) throws Exception{
		UserInfoEntity entity = null;
		try{
			String sql = "SELECT * FROM u_userinfo WHERE userName=? AND userPass=?";
			ResultSet rs = helper.executeQuery(sql, userName, userPass);
			if(rs.next()){
				entity = new UserInfoEntity();
				entity.setId(rs.getInt("id"));
				entity.setUserName(rs.getString("userName"));
				entity.setUserPass(rs.getString("userPass"));
				entity.setNickName(rs.getString("nickName"));
				entity.setHeaderImage(rs.getString("headerImage"));
				entity.setIntroduce(rs.getString("introduce"));
			}
		}catch(Exception e){
			throw e;
		}finally{
			helper.release();
		}
		return entity;
	}
	
	public int getUserByUserName(String userName) throws Exception{
		try{
			String sql = "SELECT count(*) FROM u_userinfo WHERE userName=?";
			return helper.executeCount(sql, userName);
		}catch(Exception e){
			throw e;
		}finally{
			helper.release();
		}
	}
	
	public UserInfoEntity getUserInfoByUserName(String userName) throws Exception{
		UserInfoEntity entity = null;
		try{
			String sql = "SELECT * FROM u_userinfo WHERE userName=?";
			ResultSet rs = helper.executeQuery(sql, userName);
			if(rs.next()){
				entity = new UserInfoEntity();
				entity.setId(rs.getInt("id"));
				entity.setUserName(rs.getString("userName"));
				entity.setUserPass(rs.getString("userPass"));
				entity.setNickName(rs.getString("nickName"));
				entity.setHeaderImage(rs.getString("headerImage"));
				entity.setIntroduce(rs.getString("introduce"));
			}
		}catch(Exception e){
			throw e;
		}finally{
			helper.release();
		}
		return entity;
	}

	public UserInfoEntity getUserInfoById(int uid) throws Exception {
		UserInfoEntity entity = null;
		try {
			String sql = "select * from u_userinfo where id=?";
			ResultSet rs = helper.executeQuery(sql, uid);
			if(rs.next()){
				entity = new UserInfoEntity();
				entity.setId(rs.getInt("id"));
				entity.setUserName(rs.getString("userName"));
				entity.setUserPass(rs.getString("userPass"));
				entity.setNickName(rs.getString("nickName"));
				entity.setHeaderImage(rs.getString("headerImage"));
				entity.setIntroduce(rs.getString("introduce"));
			}
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return entity;
	}

	public int update(UserInfoEntity entity) throws Exception {
		int i = 0;
		try {
			String sql = "update u_userinfo set userName=?,userPass=?,nickName=?,headerImage=?,introduce=? where id=?";
			Object[] params = {entity.getUserName(),entity.getUserPass(),entity.getNickName(),entity.getHeaderImage(),entity.getIntroduce(),entity.getId()};
			i = helper.executeUpdate(sql, params);
		} catch (Exception e) {
		}finally{
			helper.release();
		}
		return i;
	}
}
