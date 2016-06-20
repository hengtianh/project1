package com.maker.servlet.knowledge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;

/**
 * Servlet implementation class DingCaiServlet
 */
@WebServlet("/DingCaiServlet")
public class DingCaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DingCaiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//根据传递的 id method参数确定哪条记录，顶还是踩
		int id = Integer.valueOf(request.getParameter("id"));
		String method = request.getParameter("method");
		KnowledgeService service = new KnowledgeService();
		try {
			KnowledgeEntity entity = service.getById(id);
			if(method.equals("ding")){
				//增加顶的次数1次
				entity.setDing(entity.getDing()+1);
			}else if(method.equals("cai")){
				//增加踩的次数1次
				entity.setCai(entity.getCai()+1);
			}
			service.update(entity);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
