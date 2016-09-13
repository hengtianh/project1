package com.maker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.maker.mapper.IRowMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DBHelper {
//	private static String username;
//	private static String password;
//	private static String driver;
//	private static String url;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private ThreadLocal<Connection> th = new ThreadLocal<>();
	private static ComboPooledDataSource ds = new ComboPooledDataSource("prj1"); 
	
	
	/*static{
		InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	private Connection getConnection() throws Exception{
		conn = th.get();

		if(conn==null || conn.isClosed()){
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, username, password);
			conn = ds.getConnection();
			th.set(conn);
		}
		return conn;
	}
	
	
	/*public static void main(String[] args) {
		String sql = "SELECT * FROM u_userinfo WHERE userName='aaaa@163.com'";
		DBHelper h = new DBHelper();
		try {
			Connection c = h.getConnection();
			PreparedStatement p = c.prepareStatement(sql);
			ResultSet s = p.executeQuery();
			List<UserInfoEntity> list = new ArrayList<UserInfoEntity>();
			while(s.next()){
				UserInfoEntity e = testMapper.rowMapper(s, UserInfoEntity.class);
				list.add(e);
			}
			
			for(UserInfoEntity e : list){
				System.out.println(e.getUserName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
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
			th.remove();
			conn = null;
		}
	}
	
	public void beginTrans() throws Exception{
		conn = getConnection();
		conn.setAutoCommit(false);
	}
	
	public void commitTrans() throws Exception{
		conn = getConnection();
		conn.commit();
	}
	
	public void rollBackTrans() throws Exception{
		conn = getConnection();
		conn.rollback();
	}
	
	public int executeUpdate(String sql,Object ... params) throws Exception{
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParam(pstmt, params);
		return pstmt.executeUpdate();
	}
	
	public <T> List<T> executeQuery(IRowMapper<T> mapper, String sql, Object ... params) throws Exception{
		List<T> list = new ArrayList<T>();
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParam(pstmt, params);
		rs = pstmt.executeQuery();
		while(rs.next()){
			T t = mapper.rowMapper(rs);
			list.add(t);
		}
		return list;
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
	
	public static void main(String[] args) throws Exception {
		System.out.println(new DBHelper().getConnection());
	}
	
}
