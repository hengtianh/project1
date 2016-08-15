package com.maker.servlet.knowledge;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;
import com.maker.utils.PageResult;
import com.maker.utils.PageUtils;

/**
 * Servlet implementation class ShowKnowledgeServlet
 */
@WebServlet("/showknowledge")
public class ShowKnowledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ShowKnowledgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得我的所有知识
		KnowledgeService service = new KnowledgeService();
		try {
			int id = Integer.valueOf(request.getParameter("where")); 
			String pageIndex = request.getParameter("pageIndex");
			String where = " where uid=" + id;
			
			
			PageUtils pageUtils = new PageUtils();
			PageResult<KnowledgeEntity> pages = pageUtils.getPageResult(pageIndex, where);
			
			if(pages!=null){
				request.setAttribute("pages", pages);
			}
			
			
			//List<KnowledgeEntity> list = service.getAll(id);
//			if(list.size()>0){
//				request.setAttribute("knowledgelist", list);
//			}else{
//				
//			}
			request.setAttribute("uid", id);
			request.getRequestDispatcher("logined/myknowledge.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
