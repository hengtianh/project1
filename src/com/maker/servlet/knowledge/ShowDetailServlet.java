package com.maker.servlet.knowledge;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maker.entity.Attachment;
import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;


@WebServlet("/showdetails")
public class ShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
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
				//���ݸ���ʵ��
				List<Attachment> attachments = service.getAttachment(id);
				request.setAttribute("attachment", attachments);
			}
			request.getRequestDispatcher("showdetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
