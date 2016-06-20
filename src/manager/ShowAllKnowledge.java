package manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;

/**
 * Servlet implementation class ShowAllKnowledge
 */
@WebServlet("/ShowAllKnowledge")
public class ShowAllKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllKnowledge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得我的所有知识
				KnowledgeService service = new KnowledgeService();
				try {
					//int id = Integer.valueOf(request.getParameter("id")); 
					List<KnowledgeEntity> list = service.getAll();
					if(list.size()>0){
						request.setAttribute("knowledgelist", list);
					}else{
						
					}
					request.getRequestDispatcher("manager/klist.jsp").forward(request, response);
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
