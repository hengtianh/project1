package com.maker.service;

import java.util.List;

import com.maker.dao.CategoryDao;
import com.maker.dao.KnowledgeDao;
import com.maker.dao.UserInfoDao;
import com.maker.entity.Category;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.UserInfoEntity;

public class KnowledgeService {
	KnowledgeDao dao = new KnowledgeDao();
	UserInfoDao userInfoDao = new UserInfoDao();
	CategoryDao categoryDao = new CategoryDao();
	
	public int add(KnowledgeEntity kEntity) throws Exception{
		return dao.add(kEntity);
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
	
}
