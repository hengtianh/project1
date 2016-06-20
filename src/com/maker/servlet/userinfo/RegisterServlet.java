package com.maker.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.UserInfoEntity;
import com.maker.service.UserInfoService;


public class RegisterServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		String repeatPass = request.getParameter("repeatpass");
		
		//1.ǰ����֤���ݵ���Ч�ԣ�����֤�û����Ƿ�ռ��
		UserInfoEntity entity = new UserInfoEntity(userName, userPass);
		UserInfoService service = new UserInfoService();
		
		try {
			if(service.getUserByUserName(userName)>0){
				request.setAttribute("msg", "�������ѱ�ע�ᣬ������");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			int i = service.add(entity);
			if(i>0){
				//ע��ɹ������ص�¼����
				response.sendRedirect("login.jsp");
			}else{
				//ע��ʧ�ܣ���ʾ��Ϣ��������
				request.setAttribute("msg", "�û����Ѵ���");
				request.setAttribute("username", userName);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
