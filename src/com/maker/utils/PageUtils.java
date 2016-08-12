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
			//������ҳʵ�����
			pages = new PageResult<>(); 
			//��ѯ����֪ʶ��¼��
			int recordCount = service.getRecordCount(tempWhere);
			pages.setRecordCount(recordCount);//�����ܼ�¼��
			pages.setPageCount();//������ҳ��
			
			//����ύ�ķ�ҳ����
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
				pages.setList(list);//���ü�¼��list����
				//request.setAttribute("pages", pages);
				//System.out.println("����index");
				
				return (PageResult<T>) pages;
			}
			//request.getRequestDispatcher("").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
