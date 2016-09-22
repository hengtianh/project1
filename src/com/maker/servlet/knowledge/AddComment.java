package com.maker.servlet.knowledge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.constant.Keys;
import com.maker.entity.Comments;
import com.maker.entity.UserInfoEntity;
import com.maker.service.KnowledgeService;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/addComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int know_id = Integer.valueOf(request.getParameter("id"));
		KnowledgeService s = new KnowledgeService();
		try {
			Comments c = new Comments();
			UserInfoEntity u = (UserInfoEntity) request.getSession().getAttribute(Keys.USER);
			c.setKnow_id(know_id);
			c.setComment("这是一条评论");
			c.setUser_id(u.getId());
			s.addComment(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("showdetails?id="+know_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
