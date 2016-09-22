package com.maker.service;

import java.util.List;

import com.maker.dao.CategoryDao;
import com.maker.dao.KnowledgeDao;
import com.maker.dao.UserInfoDao;
import com.maker.entity.Attachment;
import com.maker.entity.Category;
import com.maker.entity.Comments;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.OptionLogEntity;
import com.maker.entity.UserInfoEntity;
import com.maker.utils.PageResult;

public class KnowledgeService {
	KnowledgeDao dao = new KnowledgeDao();
	UserInfoDao userInfoDao = new UserInfoDao();
	CategoryDao categoryDao = new CategoryDao();
	
	public int add(KnowledgeEntity kEntity,OptionLogEntity optionLog) throws Exception{
		return dao.add(kEntity,optionLog);
	}
	
	public int update(KnowledgeEntity entity) throws Exception{
		return dao.update(entity);
	}
	
	public int delete(int id) throws Exception{
		return dao.delete(id);
	}
	
	public KnowledgeEntity getById(int id) throws Exception{
		
		KnowledgeEntity knowledgeEntity = dao.getById(id);
		//knowledgeEntity.setPubDate(new Date(Convert.DateConveret(knowledgeEntity.getPubDate(), "yyyy-MM-dd hh:mm:ss")));
		UserInfoEntity entity = userInfoDao.getUserInfoById(knowledgeEntity.getUid());
		Category category = categoryDao.getByid(knowledgeEntity.getCid());
		knowledgeEntity.setEntity(entity);
		knowledgeEntity.setCategory(category);
		return knowledgeEntity;
	}
	
	public List<KnowledgeEntity> getAll(int id) throws Exception{
		List<KnowledgeEntity> list= dao.getAll(id);
		for(KnowledgeEntity k:list){
			UserInfoEntity entity = userInfoDao.getUserInfoById(k.getUid());
			Category category = categoryDao.getByid(k.getCid());
			k.setEntity(entity);
			k.setCategory(category);
			//k.setPubDate(new Date(Convert.DateConveret(k.getPubDate(), "yyyy-MM-dd hh:mm:ss")));
		}
		return list;
	}
	
	/**
	 * 分页查询所有知识
	 * @param <T>
	 * @param pages
	 * @return
	 * @throws Exception
	 */
	public <T> List<T>  getAll(PageResult<T> pages,String where) throws Exception{
		List<KnowledgeEntity> list= dao.getAll(pages,where);
		for(KnowledgeEntity k:list){
			UserInfoEntity entity = userInfoDao.getUserInfoById(k.getUid());
			Category category = categoryDao.getByid(k.getCid());
			k.setEntity(entity);
			k.setCategory(category);
			//k.setPubDate(new Date(Convert.DateConveret(k.getPubDate(), "yyyy-MM-dd hh:mm:ss")));
		}
		return (List<T>) list;
	}
	
	/**
	 * 后台查询所有知识
	 * @param pageResult
	 * @return
	 * @throws Exception
	 */
	public List<KnowledgeEntity> getAll() throws Exception{
		List<KnowledgeEntity> list= dao.getAll();
		for(KnowledgeEntity k:list){
			UserInfoEntity entity = userInfoDao.getUserInfoById(k.getUid());
			Category category = categoryDao.getByid(k.getCid());
			k.setEntity(entity);
			k.setCategory(category);
			//k.setPubDate(new Date(Convert.DateConveret(k.getPubDate(), "yyyy-MM-dd hh:mm:ss")));
		}
		return list;
	}
	
	public List<KnowledgeEntity> getAllByKeyWord(String key) throws Exception{
		return dao.getByKeyWord(key);
	}

	public int getKnowledgeId() throws Exception  {
		// TODO 获得knowledge的总量就是当前添加的索引
		return dao.getKnowledgeId();
	}

	public int addAttachment(Attachment attachment) throws Exception  {
		return dao.addAttachment(attachment);
		
	}

	public List<Attachment> getAttachment(int kid) throws Exception{
		// TODO Auto-generated method stub
		return dao.getAttachment(kid);
	}

	/**
	 * 查询知识记录数
	 * @return
	 */
	public int getRecordCount(String where) throws Exception {
		
		return dao.getRecordCount(where);
	}

	public void deleteAll(String ids) throws Exception {
		dao.deleteAll(ids);
	}

	public void addComment(Comments c) throws Exception {
		dao.addComment(c);
	}
	
}
