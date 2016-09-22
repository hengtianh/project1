package com.maker.servlet.knowledge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.dao.KnowledgeDao;
import com.maker.entity.Comments;

/**
 * Servlet implementation class LoadComment
 */
@WebServlet("/LoadComment")
public class LoadComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("know_id"));
		KnowledgeDao dao = new KnowledgeDao();
		//检验ajax效果
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<Comments> comments = dao.getCommentById(id);
			//只向页面响应评论的数量
			int count = comments.size();
			PrintWriter out = response.getWriter();
			out.println(count);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
