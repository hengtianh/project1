package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.Category;
import com.maker.service.CategoryService;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/addcategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单数据
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		//封装的对象
		if(name!=null && description!=null){
			Category c = new Category();
			c.setName(name);
			c.setDescription(description);
			//添加分类
			CategoryService service = new CategoryService();
			try {
				service.add(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("manager/addcategory.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
