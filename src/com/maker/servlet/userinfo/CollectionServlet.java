package com.maker.servlet.userinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.constant.Keys;
import com.maker.entity.Collection;
import com.maker.entity.UserInfoEntity;
import com.maker.service.CollectionService;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÅÐ¶ÏÊÇ·ñµÇÂ¼£¬µÇÂ½ºóÊÕ²Ø
		UserInfoEntity entity = (UserInfoEntity) request.getSession().getAttribute(Keys.USER);
		if(entity!=null){
			int id = Integer.valueOf(request.getParameter("id"));
			int uid = entity.getId();
			Collection c = new Collection();
			c.setUid(uid);
			c.setKnowledgeid(id);
			CollectionService service = new CollectionService();
			try {
				service.add(c);
				response.sendRedirect("showdetail.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			//Î´µÇÂ¼Ê±×ªµ½µÇÂ¼Ò³Ãæ
			response.sendRedirect("login.jsp");
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
