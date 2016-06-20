package com.maker.servlet.knowledge;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.Category;
import com.maker.entity.KnowledgeEntity;
import com.maker.service.CategoryService;
import com.maker.service.KnowledgeService;

/**
 * Servlet implementation class LoadKnowledgeServlet
 */
@WebServlet("/LoadKnowledgeServlet")
public class LoadKnowledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadKnowledgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//将所有的类别获取到
			CategoryService categoryService = new CategoryService();
			List<Category> list = categoryService.getAllCategory();
			if(list.size()>0){
				request.setAttribute("category", list);
			}
			//根据id，加载要编辑的知识
			int id = Integer.valueOf(request.getParameter("id"));
			KnowledgeService service = new KnowledgeService();
			KnowledgeEntity entity = service.getById(id);
			entity.setContent(entity.getContent().replace("<br />", "\r\n").replace(" ", "&nbsp"));
			if(entity!=null){
				request.setAttribute("edit", entity);
			}
			request.getRequestDispatcher("login/editknowledge.jsp").forward(request, response);
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
