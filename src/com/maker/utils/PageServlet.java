package com.maker.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;


@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//获得请求的参数值
//		//int pageIndex = request.getParameter("pageIndex");
//		String tempIndex = request.getParameter("pageIndex");
//		String tempWhere = request.getParameter("where");
//		int pageIndex = 1;
//		String where = null;
//		if(tempWhere!=null){
//			where = "where label like " + tempWhere; 
//		}
//		if(tempIndex!=null){
//			pageIndex = Integer.valueOf(tempIndex);
//		}
//		PageUtils pageUtils = new PageUtils();
//		PageResult<KnowledgeEntity> pages = pageUtils.getPageResult(pageIndex, where);
//		request.setAttribute("pages", pages);
//		request.setAttribute("pages", pages);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
