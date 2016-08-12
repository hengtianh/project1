package com.maker.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/encoding")
public class EncodingFilter implements Filter {
	private String encoding = "UTF-8";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		if(req.getMethod().equalsIgnoreCase("POST")){
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
		}else{
			Map maps = req.getParameterMap();
			Set<Map.Entry<String, String[]>> sets = maps.entrySet();
			for(Map.Entry<String, String[]> set : sets){
				String[] value = set.getValue();
				for(String s : value){
					s = new String(s.getBytes("ISO-8859-1"),"UTF-8");
				}
			}
		}
		
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		try{
			encoding = arg0.getInitParameter("encode");
		}catch(Exception e){
			encoding = "utf-8";
		}
		
	}

}
