package com.maker.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.maker.entity.KnowledgeEntity;
import com.maker.service.KnowledgeService;

/**
 * Servlet Filter implementation class IndexFilter
 */
@WebFilter("/IndexFilter")
public class IndexFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IndexFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//使用过滤器实现访问首页是加载所有知识列表
		KnowledgeService service = new KnowledgeService();
		try {
			List<KnowledgeEntity> list =  service.getAll();
			if(list.size()>0){
				request.setAttribute("knowledgelist", list);
				//System.out.println("过滤index");
			}else{
				//request.setAttribute();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
