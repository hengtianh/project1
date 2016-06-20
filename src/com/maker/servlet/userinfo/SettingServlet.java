package com.maker.servlet.userinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.constant.Keys;
import com.maker.entity.UserInfoEntity;
import com.maker.service.UserInfoService;

/**
 * Servlet implementation class SettingServlet
 */
@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得修改后的个人信息，更新数据
		int id = ((UserInfoEntity)request.getSession().getAttribute(Keys.USER)).getId();
		String userName = request.getParameter("username");
		String nickName = request.getParameter("nickname");
		String introduce = request.getParameter("introduce");
		UserInfoEntity entity = null;
		UserInfoService service = new UserInfoService();
		try {
			entity = service.getById(id);
			if(userName!=null && nickName!=null && introduce!=null){
				entity.setUserName(userName);
				entity.setNickName(nickName);
				entity.setIntroduce(introduce);
			}
			service.update(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//更新后跳转到重新登录
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
