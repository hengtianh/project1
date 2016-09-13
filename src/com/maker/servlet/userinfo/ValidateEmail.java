package com.maker.servlet.userinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.service.UserInfoService;

@WebServlet("/ValidateEmail")
public class ValidateEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		UserInfoService s = new UserInfoService();
		PrintWriter out = response.getWriter();
		try {
			if(s.getUserByUserName(userName)>0){
				System.out.println("该用户名已被占用");
				out.print("该用户名已被占用");
			}else{
				
				System.out.println("该用户名可用");
				out.println("该用户名可用");
			}
		} catch (Exception e) {

			System.out.println("内部异常");
			out.print("内部异常");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
