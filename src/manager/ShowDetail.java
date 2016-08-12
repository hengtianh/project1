package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;

/**
 * Servlet implementation class ShowDetail
 */
@WebServlet("/showdetail")
public class ShowDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ָ����֪ʶ��id��������
				int id = Integer.valueOf(request.getParameter("id"));
				KnowledgeService service = new KnowledgeService();
				try {
					KnowledgeEntity entity = service.getById(id);
					if(entity!=null){
						//���µ��Ķ�����
						entity.setReadCount(entity.getReadCount()+1);
						service.update(entity);
						//��������ʵ��
						request.setAttribute("detail", entity);
					}
					request.getRequestDispatcher("detail.jsp").forward(request, response);
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
