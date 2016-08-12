package com.maker.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

   
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void sessionCreated(HttpSessionEvent se)  { 
         ServletContext app = se.getSession().getServletContext();
         Integer num = (Integer) app.getAttribute("online");
         if(num!=null){
        	 int i = num;
        	 i++;
        	 app.setAttribute("online", i);
         }else{
        	 app.setAttribute("online", 1);
         }
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext app = se.getSession().getServletContext();
        Integer num = (Integer) app.getAttribute("online");
        if(num!=null){
	       	 int i = num;
	       	 i--;
	       	 app.setAttribute("online", i);
        }
    }
	
}
