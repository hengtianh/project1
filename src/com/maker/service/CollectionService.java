package com.maker.service;

import java.util.ArrayList;
import java.util.List;

import com.maker.dao.CollectionDao;
import com.maker.entity.Collection;
import com.maker.entity.KnowledgeEntity;

public class CollectionService {

	CollectionDao dao = new CollectionDao();
	public int add(Collection collection) throws Exception{
		return dao.add(collection);
	}
	
	public List<KnowledgeEntity> getAll(int uid) throws Exception{
		List<Collection> cs = dao.getAll(uid);
		KnowledgeService service = new KnowledgeService();
		List<KnowledgeEntity> list = new ArrayList<KnowledgeEntity>();
		for(Collection c:cs ){
			list.add(service.getById(c.getKnowledgeid()));
		}
		return list;
	}
}
