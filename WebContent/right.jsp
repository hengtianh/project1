<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://com.maker.pagetag" prefix="p" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<style>
	.page{
		width:80px;
		border-right:none;
	}
</style>
</head>
<body>
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">

	<c:if test="${requestScope.pages.list==null}">
	  <tr>
	    <td height="40" class="f14white">　还没有人发布知识，<a href="login.jsp">点击这里</a>，登录后去发布吧</td>
	  </tr>
	</c:if>
  
  <c:if test="${requestScope.pages.list!=null}">
  <c:forEach var="k" items="${requestScope.pages.list}">
  <tr>
    <td bgcolor="#CCCCCC">&nbsp;</td>
    <td colspan="3" class="f14white">&nbsp;</td>
  </tr>
  <tr>
    <td width="80" rowspan="2" align="center" bgcolor="#F3F3F3"><img src="headerimages/userdefault.gif" width="80" height="80"></td>
    <td width="657" class="f14white"><a href="showdetails?id=${k.id }">　　${k.title }</a></td>
  </tr>
  <tr>
    <td colspan="3">　　${k.pubDate } 由 ${k.entity.userName }  发布到  ${k.category.name}</td>
  </tr>
  </c:forEach>
  <tr>
  <td colspan="3">
  
  <p:page actionName="PageServlet" pageIndex="${pages.pageIndex }" pageCount="${pages.pageCount }" pages="${pages.pages }" where="${where}" />
  <%-- <form action="PageServlet<c:if test="${!empty where }">?where=${where}</c:if>" method="get">
	  <table width="100%" align="center" cellspacing="0" cellpadding="0" style="margin:5px 0 5px 0;">
	    <tr>
		    <td width="500" height="20" align="center"><a href="PageServlet?pageIndex=1<c:if test="${!empty where }">&where=${where}</c:if>">首页</a><a href="PageServlet?pageIndex=${requestScope.pages.pageIndex-1}<c:if test="${!empty where }">&where=${where}</c:if>">上一页
			    <c:forEach var="p" items="${requestScope.pages.pages}">
			    	<a href="PageServlet?pageIndex=${p}<c:if test="${!empty where }">&where=${where}</c:if>">${p}</a>
			    </c:forEach>
			    </a><a href="PageServlet?pageIndex=${requestScope.pages.pageIndex+1}<c:if test="${!empty where }">&where=${where}</c:if>">下一页</a><a href="PageServlet?pageIndex=${requestScope.pages.pageCount}<c:if test="${!empty where }">&where=${where}</c:if>">尾页</a>
		    </td>
		    <td width="331" height="20" align="center">
		    	当前第${requestScope.pages.pageIndex}页，共${requestScope.pages.pageCount}页。
		    </td>
		    <td width="80" height="20" align="right"><input type="number" class="page" name="pageIndex" value="${pages.pageIndex }"></td>
		    <td width="30" height="20" align="left"><input type="submit" value="GO"></td>
		</tr>
		</table>
	</form> --%>
	</td>
 	</tr>
  </c:if>
</table>
</body>
</html>