package com.maker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class DBHelper {
	private String username ="root";
	private String password = "root";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/prj1";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws Exception{
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public void setParam(PreparedStatement pstmt, Object ...params) throws Exception{
		if(params!=null){
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
		}
	}
	
	public void release() throws Exception{
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pstmt!=null){
			pstmt.close();
			pstmt = null;
		}
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
	
	public int executeUpdate(String sql,Object ... params) throws Exception{
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParam(pstmt, params);
		return pstmt.executeUpdate();
	}
	
	public ResultSet executeQuery(String sql, Object ... params) throws Exception{
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParam(pstmt, params);
		rs = pstmt.executeQuery();
		return rs;
	}
	
	public int executeCount(String sql, Object ... params) throws Exception{
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParam(pstmt, params);
		rs = pstmt.executeQuery();
		int count = 0;
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	
}
