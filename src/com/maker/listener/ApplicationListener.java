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
         //容器停止时，移除所有的统计数据
    	ServletContext application = sce.getServletContext();
    	application.removeAttribute("online");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         //容器初始化时，创建人数统计初始化
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("online", 0);
    }
	
}
