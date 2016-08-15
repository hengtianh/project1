package com.maker.tag;

import java.io.PrintWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {
	
	private String actionName;
	private int pageIndex = 1;
	private String where;
	private int pageCount;
	private int[] pages;
	
	

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String formAction = actionName;
		String aAction = actionName;
		if(where!=null){
			formAction += "?where="+where;
		}
		if(where!=null){
			aAction+="?where="+where+"&";
		}else{
			aAction+="?";
		}
		
		try{
		out.print("<form action=\""+formAction+"\" method=\"post\">");//<c:if test='${!empty "+where+" }'>?where="+where+"</c:if>
		  out.print("<table width=\"100%\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin:5px 0 5px 0;\">");
		    out.print("<tr>");
			    out.print("<td width=\"500\" height=\"20\" align=\"center\"><a href=\""+aAction+"pageIndex="+1+"\">首页</a><a href=\""+aAction+"pageIndex="+(pageIndex-1)+"\">上一页");
				  
			    //遍历数组
			    for(int i=0; i<pages.length; i++){
				    //out.print("<c:forEach var='p' items='"+pages+"'>");
			    	out.print("<a href=\""+aAction+"pageIndex="+pages[i]+"\">"+pages[i]+"</a>");
					   // out.print("</c:forEach>");
			    }
				   
				    
				    out.print("</a><a href=\""+aAction+"pageIndex="+(pageIndex+1)+"\">下一页</a><a href=\""+aAction+"pageIndex="+pageCount+"\">尾页</a>");
			    out.print("</td>");
			    out.print("<td width=\"331\" height=\"20\" align=\"center\">");
			    	out.print("当前第"+pageIndex+"页，共"+pageCount+"页。");
			    out.print("</td>");
			    out.print("<td width=\"80\" height=\"20\" align=\"right\"><input type=\"number\" class=\"page\" name=\"pageIndex\" value=\""+pageIndex+"\"></td>");
			    out.print("<td width=\"30\" height=\"20\" align=\"left\"><input type=\"submit\" value=\"GO\"></td>");
			out.print("</tr>");
			out.print("</table>");
		out.print("</form>");
		}catch(Exception e){
			
		}
		
		return SKIP_BODY;
	}



	public String getActionName() {
		return actionName;
	}



	public void setActionName(String actionName) {
		this.actionName = actionName;
	}



	public int getPageIndex() {
		return pageIndex;
	}



	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}



	public String getWhere() {
		return where;
	}



	public void setWhere(String where) {
		this.where = where;
	}



	public int getPageCount() {
		return pageCount;
	}



	public void setPageCount(int pageCount) {
		
		this.pageCount = pageCount;
	}



	public int[] getPages() {
		return pages;
	}



	public void setPages(int[] pages) {
		this.pages = pages;
	}
	
	
	
}
