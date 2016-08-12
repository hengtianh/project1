package com.maker.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
  
    public ApplicationListener() {
        
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         //����ֹͣʱ���Ƴ����е�ͳ������
    	ServletContext application = sce.getServletContext();
    	application.removeAttribute("online");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         //������ʼ��ʱ����������ͳ�Ƴ�ʼ��
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("online", 0);
    }
	
}
