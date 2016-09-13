package com.maker.servlet.userinfo;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maker.constant.Keys;
import com.maker.entity.UserInfoEntity;
import com.maker.service.UserInfoService;
import com.maker.utils.MD5;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserInfoService service = new UserInfoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 用户登录处理
		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		String remember = request.getParameter("remember");
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String value = (String) session.getAttribute("code");
		if (!(value.equals(code))) {
			request.setAttribute("msg", "验证码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		} else {
			session.removeAttribute("code");
			try {
				UserInfoEntity entity = service.getUserInfo(userName, MD5.createPassword(userPass));
				if (entity != null) {
					// 输入的用户名密码正确
					session.setAttribute(Keys.USER, entity);
					if (remember != null && remember.equals("true")) {
						// 勾选了自动登录,添加cookie
						Cookie cookie = new Cookie("username", userName);
						cookie.setMaxAge(60 * 60);
						response.addCookie(cookie);
					}
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					// 用户名密码不正确
					request.setAttribute("msg", "用户名或密码不正确");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
