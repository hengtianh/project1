package com.maker.utils;

import java.util.ArrayList;
import java.util.List;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;

public class PageUtils<T> {
	private List list = new ArrayList<>();
	private PageResult<T> pages = null;
	
	public <T> PageResult<T> getPageResult(String tempIndex, String tempWhere){
		KnowledgeService service = new KnowledgeService();
		try {
			int pageIndex;
			if(tempIndex==null){
				pageIndex = 1;
			}else{
				pageIndex = Integer.valueOf(tempIndex);
			}
//			String where = null;
//			if(tempWhere!=null){
//				where = tempWhere;
//			}
			//创建分页实体对象
			pages = new PageResult<>(); 
			//查询所有知识记录数
			int recordCount = service.getRecordCount(tempWhere);
			pages.setRecordCount(recordCount);//设置总记录数
			pages.setPageCount();//设置总页数
			
			//获得提交的分页数据
			try {
				//int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
				if(pageIndex<=1){
					pageIndex = 1;
				}
				if(pageIndex>=pages.getPageCount()){
					pageIndex = pages.getPageCount();
				}
				pages.setPageIndex(pageIndex);
			} catch (Exception e) {
				
			}
			
		
			
			
			list =  service.getAll(pages,tempWhere);
			
			if(list.size()>0){
				pages.setList(list);//设置记录的list集合
				//request.setAttribute("pages", pages);
				//System.out.println("过滤index");
				
				return (PageResult<T>) pages;
			}
			//request.getRequestDispatcher("").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
