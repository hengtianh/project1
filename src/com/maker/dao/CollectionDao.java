package com.maker.dao;

import java.util.ArrayList;
import java.util.List;

import com.maker.entity.Collection;
import com.maker.mapper.impl.CollectionMapper;

public class CollectionDao {
	
	private DBHelper helper = new DBHelper();
	public int add(Collection collection) throws Exception{
		int i = 0;
		try {
			String sql = "insert into collection(u_id,knowledge_id) values(?,?)";
			i = helper.executeUpdate(sql, collection.getUid(),collection.getKnowledgeid());
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return i;
	}
	
	public List<Collection> getAll(int uid) throws Exception{
		List<Collection> list = new ArrayList<Collection>();
		try {
			String sql = "select * from collection where u_id=?";
			list = helper.executeQuery(new CollectionMapper(), sql, uid);
			/*while(rs.next()){
				c = new Collection();
				c.setId(rs.getInt("id"));
				c.setUid(rs.getInt("u_id"));
				c.setKnowledgeid(rs.getInt("knowledge_id"));
				list.add(c);
			}*/
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return list;
	}

}
