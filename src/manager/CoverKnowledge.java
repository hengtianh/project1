package manager;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;

/**
 * Servlet implementation class CoverKnowledge
 */
@WebServlet("/CoverKnowledge")
public class CoverKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoverKnowledge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得表单提交的数据，
		int id = Integer.valueOf(request.getParameter("id"));
		KnowledgeService service = new KnowledgeService();
		try {
			//根据id查到该知识
			KnowledgeEntity entity = service.getById(id);
			//对屏蔽字段置1
			entity.setState(1);
			entity.setStateDate(new Date());
			service.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("manager/klist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
