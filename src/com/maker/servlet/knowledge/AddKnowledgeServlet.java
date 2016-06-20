package com.maker.servlet.knowledge;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maker.constant.Keys;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.UserInfoEntity;
import com.maker.service.KnowledgeService;

public class AddKnowledgeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int cid = Integer.valueOf(request.getParameter("category"));
		String title = request.getParameter("title");
		String label = request.getParameter("label");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		int uid = ((UserInfoEntity) session.getAttribute(Keys.USER)).getId();
		
		KnowledgeEntity keEntity = new KnowledgeEntity();
		keEntity.setTitle(title);
		keEntity.setLabel(label);
		keEntity.setContent(content.replace(" ", "&nbsp;").replace("\r\n", "<br />"));
		keEntity.setUid(uid);
		keEntity.setDing(0);
		keEntity.setCai(0);
		keEntity.setState(0);
		keEntity.setStateDate(null);
		keEntity.setStateUid(0);
		keEntity.setPubDate(new Date());
		keEntity.setReadCount(0);
		keEntity.setCid(cid);
		
		KnowledgeService service = new KnowledgeService();
		try {
			int i =  service.add(keEntity);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
