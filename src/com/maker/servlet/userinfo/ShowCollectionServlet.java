package com.maker.servlet.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.constant.Keys;
import com.maker.entity.Collection;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.UserInfoEntity;
import com.maker.service.CollectionService;

/**
 * Servlet implementation class ShowCollectionServlet
 */
@WebServlet("/ShowCollectionServlet")
public class ShowCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCollectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据登录用户的id查询所有收藏的知识i
		int uid = Integer.valueOf(((UserInfoEntity) request.getSession().getAttribute(Keys.USER)).getId());
		CollectionService service = new CollectionService();
		try {
			List<KnowledgeEntity> list = service.getAll(uid);
			request.setAttribute("collectionlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login/mycollection.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
