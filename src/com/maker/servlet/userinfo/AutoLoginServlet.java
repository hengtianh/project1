package com.maker.servlet.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.maker.constant.Keys;
import com.maker.entity.KnowledgeEntity;
import com.maker.entity.UserInfoEntity;
import com.maker.service.KnowledgeService;
import com.maker.service.UserInfoService;


public class AutoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserInfoService service = new UserInfoService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�û�����cookieʱ�Զ���¼
		HttpSession session = request.getSession();
		//1.����Ƿ��ס������
		Cookie[] cookies = request.getCookies();
		
		//��������Ƿ����cookie
		if(cookies!=null && checkCookie(cookies,session)){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			//û�м�ס����
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	public boolean checkCookie(Cookie[] cookies, HttpSession session){
		boolean b = false;
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("username")){
				//����cookie
				String userName = cookie.getValue();
				try {
					UserInfoEntity entity = service.getUserInfoByUserName(userName);
					session.setAttribute(Keys.USER, entity);
					b = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
