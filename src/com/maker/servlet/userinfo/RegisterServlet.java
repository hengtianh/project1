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
		
		//1.前端验证数据的有效性，再验证用户名是否占用
		UserInfoEntity entity = new UserInfoEntity(userName, userPass);
		UserInfoService service = new UserInfoService();
		
		try {
			if(service.getUserByUserName(userName)>0){
				request.setAttribute("msg", "该邮箱已被注册，请重试");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			int i = service.add(entity);
			if(i>0){
				//注册成功，返回登录界面
				response.sendRedirect("login.jsp");
			}else{
				//注册失败，提示信息，并回显
				request.setAttribute("msg", "用户名已存在");
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
