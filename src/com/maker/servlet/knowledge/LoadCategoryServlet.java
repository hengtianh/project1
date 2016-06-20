package com.maker.servlet.knowledge;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.Category;
import com.maker.service.CategoryService;

/**
 * Servlet implementation class LoadCategory
 */
@WebServlet("/LoadCategory")
public class LoadCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//加载数据库中的知识类别
		CategoryService service = new CategoryService();
		try {
			List<Category> list = service.getAllCategory();
			if(list.size()>0){
				request.setAttribute("category", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login/addknowledge.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
