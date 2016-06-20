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
 * Servlet implementation class EditKnowledgeServlet
 */
@WebServlet("/EditKnowledgeServlet")
public class EditKnowledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditKnowledgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得修改后的数据
		int id = Integer.valueOf(request.getParameter("id"));
		int cid = Integer.valueOf(request.getParameter("category"));
		String title = request.getParameter("title");
		String label = request.getParameter("label");
		String content = request.getParameter("content");
		
		//不修改的数据从数据库中查询
		KnowledgeService service = new KnowledgeService();
		try {
			KnowledgeEntity entity = service.getById(id);
			entity.setCid(cid);
			entity.setTitle(title);
			entity.setLabel(label);
			entity.setContent(content);
			service.update(entity);
			response.sendRedirect("login/myknowledge.jsp");
		} catch (Exception e) {
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
