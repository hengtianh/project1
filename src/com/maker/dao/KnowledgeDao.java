package com.maker.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.maker.entity.Attachment;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.OptionLogEntity;
import com.maker.mapper.impl.KnowledgeRowMapper;
import com.maker.utils.PageResult;

public class KnowledgeDao {
	DBHelper helper = new DBHelper();
	
	/**
	 * ���֪ʶ
	 * @param kEntity
	 * @return ��Ӱ������
	 * @throws Exception 
	 */
	public int add(KnowledgeEntity kEntity,OptionLogEntity olog) throws Exception{
		int i=0;
		helper.beginTrans();
		try{
			String sql1 = "INSERT INTO k_nowledge"
						+ "(title,content,pubDate,cid,label,readCount,ding,cai,uid,state,stateUid) "
							+ "	VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			String sql2 = "INSERT INTO optionlog(optionDate,optionDes) VALUES(?,?)";
			Object[] params1 = new Object[]{
					kEntity.getTitle(),
					kEntity.getContent(),
					kEntity.getPubDate(),
					kEntity.getCid(),
					kEntity.getLabel(),
					kEntity.getReadCount(),
					kEntity.getDing(),
					kEntity.getCai(),
					kEntity.getUid(),
					kEntity.getState(),
					kEntity.getStateUid()
					};
			i = helper.executeUpdate(sql1, params1);
			i+=helper.executeUpdate(sql2, olog.getOptionDate(),olog.getOptionDes());
			helper.commitTrans();
		}catch(Exception e){
			helper.rollBackTrans();
			throw e;
		}finally{
			helper.release();
		}
		return i;
	}
	
	public int update(KnowledgeEntity entity) throws Exception{
		int i = 0;
		try {
			String sql ="UPDATE k_nowledge SET "
					+ "title=?,content=?,pubDate=?,"
					+ "cid=?,label=?,readCount=?,ding=?,cai=?,"
					+ "uid=?,state=?,stateUid=? where id=?";
			Object[] params = new Object[]{
					entity.getTitle(),
					entity.getContent(),
					entity.getPubDate(),
					entity.getCid(),
					entity.getLabel(),
					entity.getReadCount(),
					entity.getDing(),
					entity.getCai(),
					entity.getUid(),
					entity.getState(),
					entity.getStateUid(),
					entity.getId()
					};
			i = helper.executeUpdate(sql, params);
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return i;
	}
	
	/**
	 * ����idɾ��֪ʶ
	 * @param id
	 * @return ��Ӱ������
	 */
	public int delete(int id) throws Exception{
		int i = 0;
		try {
			String sql = "delete from k_nowledge where id=?";
			i = helper.executeUpdate(sql, id);
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return i;
	}
	
	/**
	 * ����id��ѯ֪ʶ
	 * @param id
	 * @return ��ѯ����֪ʶ
	 */
	public KnowledgeEntity getById(int id) throws Exception{
		KnowledgeEntity kEntity = null;
		try{
			String sql = "select * from k_nowledge where id=?";
			List<KnowledgeEntity> list = helper.executeQuery(new KnowledgeRowMapper() ,sql , id);
			if(list.size()>0){
				kEntity = list.get(0);
			}
			
			/*while(rs.next()){
				kEntity = new KnowledgeEntity();
				kEntity.setId(rs.getInt("id"));
				kEntity.setTitle(rs.getString("title"));
				kEntity.setLabel(rs.getString("label"));
				kEntity.setContent(rs.getString("content"));
				kEntity.setDing(rs.getInt("ding"));
				kEntity.setCai(rs.getInt("cai"));
				kEntity.setReadCount(rs.getInt("readCount"));
				kEntity.setPubDate(rs.getTimestamp("pubDate"));
				kEntity.setState(rs.getInt("state"));
				kEntity.setStateContent(rs.getString("stateContent"));
				kEntity.setStateDate(rs.getTimestamp("stateDate"));
				kEntity.setStateUid(rs.getInt("stateUid"));
				kEntity.setCid(rs.getInt("cid"));
				kEntity.setUid(rs.getInt("uid"));
			}*/
		}catch(Exception e){
			throw e;
		}finally{
			helper.release();
		}
		return kEntity;
	}

	/**
	 * ��ѯ���е�֪ʶ
	 * @return ֪ʶ�ļ���
	 */
	public List<KnowledgeEntity> getAll(int id) throws Exception{
		List<KnowledgeEntity> list = new ArrayList<KnowledgeEntity>();
		try {
			String sql = "select * from k_nowledge where uid=?";
			list = helper.executeQuery(new KnowledgeRowMapper(),sql,id);
			
			
			/*while(rs.next()){
				KnowledgeEntity kEntity = new KnowledgeEntity();
				kEntity.setId(rs.getInt("id"));
				kEntity.setTitle(rs.getString("title"));
				kEntity.setLabel(rs.getString("label"));
				kEntity.setContent(rs.getString("content"));
				kEntity.setDing(rs.getInt("ding"));
				kEntity.setCai(rs.getInt("cai"));
				kEntity.setReadCount(rs.getInt("readCount"));
				kEntity.setPubDate(rs.getTimestamp("pubDate"));
				kEntity.setState(rs.getInt("state"));
				kEntity.setStateContent(rs.getString("stateContent"));
				kEntity.setStateDate(rs.getTimestamp("stateDate"));
				kEntity.setStateUid(rs.getInt("stateUid"));
				kEntity.setCid(rs.getInt("cid"));
				kEntity.setUid(rs.getInt("uid"));
				list.add(kEntity);
			}*/
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return list;
	}

	
	/**
	 * ��ҳ��ѯ���е�֪ʶ
	 * @param <T>
	 * @return ֪ʶ�ļ���
	 */
	public <T> List<KnowledgeEntity> getAll(PageResult<T> pages,String where) throws Exception{
		List<KnowledgeEntity> list = new ArrayList<KnowledgeEntity>();
		String sql = "select * from k_nowledge ";
		try {
			if(where!=null){
				sql = sql + where;
			}
			sql = sql + " limit ?,?";
			
			list = helper.executeQuery(new KnowledgeRowMapper(),sql,(pages.getPageIndex()-1)*pages.getPageSize(),pages.getPageSize());
			
			
			/*while(rs.next()){
				KnowledgeEntity kEntity = new KnowledgeEntity();
				kEntity.setId(rs.getInt("id"));
				kEntity.setTitle(rs.getString("title"));
				kEntity.setLabel(rs.getString("label"));
				kEntity.setContent(rs.getString("content"));
				kEntity.setDing(rs.getInt("ding"));
				kEntity.setCai(rs.getInt("cai"));
				kEntity.setReadCount(rs.getInt("readCount"));
				kEntity.setPubDate(rs.getTimestamp("pubDate"));
				kEntity.setState(rs.getInt("state"));
				kEntity.setStateContent(rs.getString("stateContent"));
				kEntity.setStateDate(rs.getTimestamp("stateDate"));
				kEntity.setStateUid(rs.getInt("stateUid"));
				kEntity.setCid(rs.getInt("cid"));
				kEntity.setUid(rs.getInt("uid"));
				list.add(kEntity);
			}*/
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return list;
	}
	
	/**
	 * ��ѯ���е�֪ʶ
	 * @return ֪ʶ�ļ���
	 */
	public List<KnowledgeEntity> getAll() throws Exception{
		List<KnowledgeEntity> list = new ArrayList<KnowledgeEntity>();
		try {
			String sql = "select * from k_nowledge";
			
			list = helper.executeQuery(new KnowledgeRowMapper(),sql);
			
			
			/*while(rs.next()){
				KnowledgeEntity kEntity = new KnowledgeEntity();
				kEntity.setId(rs.getInt("id"));
				kEntity.setTitle(rs.getString("title"));
				kEntity.setLabel(rs.getString("label"));
				kEntity.setContent(rs.getString("content"));
				kEntity.setDing(rs.getInt("ding"));
				kEntity.setCai(rs.getInt("cai"));
				kEntity.setReadCount(rs.getInt("readCount"));
				kEntity.setPubDate(rs.getTimestamp("pubDate"));
				kEntity.setState(rs.getInt("state"));
				kEntity.setStateContent(rs.getString("stateContent"));
				kEntity.setStateDate(rs.getTimestamp("stateDate"));
				kEntity.setStateUid(rs.getInt("stateUid"));
				kEntity.setCid(rs.getInt("cid"));
				kEntity.setUid(rs.getInt("uid"));
				list.add(kEntity);
			}*/
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return list;
	}
	
	public List<KnowledgeEntity> getByKeyWord(String key) throws Exception{
		List<KnowledgeEntity> list = new ArrayList<KnowledgeEntity>();
		try {
			String sql = "select * from k_nowledge where label like '%"+key+"%'";
			list = helper.executeQuery(new KnowledgeRowMapper(),sql);
			
			
			/*while(rs.next()){
				KnowledgeEntity entity = new KnowledgeEntity();
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
				list.add(entity);
			}*/
		} catch (Exception e) {
			throw e;
		}finally{
			helper.release();
		}
		return list;
	}

	public int getKnowledgeId() throws Exception  {
		int result = 0;
		try {
			String sql = "SELECT MAX(id) FROM k_nowledge";
			result = helper.executeCount(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			helper.release();
		}
		return result;
	}

	public int addAttachment(Attachment attachment) throws Exception {
		int result = 0;
		try {
			String sql = "INSERT INTO	k_attachment(kid,attachPath) VALUES(?,?)";
			result = helper.executeUpdate(sql, attachment.getKid(),attachment.getAttachPath());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			helper.release();
		}
		return result;
		
	}

	public List<Attachment> getAttachment(int kid) throws Exception {
		List list = new ArrayList();
		
		try {
			String sql = "SELECT * FROM k_attachment where kid=?";
			list = helper.executeQuery(new KnowledgeRowMapper(),sql, kid);
			
			
			/*while(rs.next()){
				Attachment attachment = new Attachment();
				attachment.setId(rs.getInt("id"));
				attachment.setKid(rs.getInt("kid"));
				attachment.setAttachPath(rs.getString("attachPath"));
				list.add(attachment);
			}*/
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			helper.release();
		}
		return list;
	}

	/**
	 * ��ѯ֪ʶ������
	 * @return
	 */
	public int getRecordCount(String where) throws Exception {
		int i = 0;
		try {
			String sql = "select count(*) from k_nowledge ";
			if(where!=null){
				sql +=where;
			}
			i = helper.executeCount(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			helper.release();
		}
		return i;
	}

	public void deleteAll(String ids) throws Exception {
		try {
			String sql = "delete from k_nowledge where id in("+ids+")";
			helper.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			helper.release();
		}
	}

}
