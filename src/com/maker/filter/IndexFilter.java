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
import com.maker.utils.PageResult;
import com.maker.utils.PageUtils;

/**
 * Servlet Filter implementation class IndexFilter
 */
@WebFilter("/indexfilter")
public class IndexFilter implements Filter {

   
    public IndexFilter() {
    }

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//request.getRequestDispatcher("PageUtil").forward(request, response);
		String tempIndex = request.getParameter("pageIndex");
		String tempWhere = request.getParameter("where");
		request.setAttribute("where", tempWhere);
		if(tempWhere!=null && tempWhere.trim()!=""){
			tempWhere = " where label like '"+tempWhere+"'";
		}else{
			tempWhere = null;
		}
		
		
		//int pageIndex = 1;
		//String where = null;
		PageUtils pageUtils = new PageUtils();
		PageResult<KnowledgeEntity> pages = pageUtils.getPageResult(tempIndex, tempWhere);
		request.setAttribute("pages", pages);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
