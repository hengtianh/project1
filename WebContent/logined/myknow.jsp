<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://com.maker.pagetag" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  
  <c:if test="${requestScope.pages!=null}">
  <c:forEach var="k" items="${requestScope.pages.list}">
  <tr>
    <td bgcolor="#CCCCCC">&nbsp;</td>
    <td colspan="3" class="f14white">&nbsp;</td>
  </tr>
  <tr>
    <td width="80" rowspan="2" align="center" bgcolor="#F3F3F3"><img src="${pageContext.request.contextPath}/headerimages/${sessionScope.user.headerImage}" width="80" height="80"></td>
    <td width="657" class="f14white"><a href="showdetail?id=${k.id }">　　${k.title }</a></td>
    <td width="78" align="center" class="f14white"><a href="loadknowledge?id=${k.id}">编辑</a></td>
    <td width="77" align="center" class="f14white"><a href="deleteknowledge?id=${k.id}" onclick="javascript:return confirm('确认要删除吗？')">删除</a></td>
  </tr>
  <tr>
    <td colspan="3">　　${k.pubDate } 由 ${k.entity.userName }  发布到  ${k.category.name}</td>
  </tr>
  </c:forEach>
  
    <tr>
  <td colspan="3">
  <p:page pages="${pages.pages }" actionName="showknowledge" pageCount="${pages.pageCount }" pageIndex="${pages.pageIndex }" where="${uid }"/>
<%--   <form action="showknowledge?id=${uid}" method="get">
	  <table width="100%" align="center" cellspacing="0" cellpadding="0" style="margin:5px 0 5px 0;">
	    <tr>
		    <td width="500" height="20" align="center"><a href="showknowledge?pageIndex=1<c:if test="${!empty uid }">&id=${uid}</c:if>">首页</a> <a href="showknowledge?pageIndex=${requestScope.pages.pageIndex-1}<c:if test="${!empty uid }">&id=${uid}</c:if>">上一页
			    <c:forEach var="p" items="${requestScope.pages.pages}">
			    	<a href="showknowledge?pageIndex=${p}<c:if test="${!empty uid }">&id=${uid}</c:if>">${p}</a> 
			    </c:forEach>
			    </a><a href="showknowledge?pageIndex=${requestScope.pages.pageIndex+1}<c:if test="${!empty uid }">&id=${uid}</c:if>">下一页</a> <a href="showknowledge?pageIndex=${requestScope.pages.pageCount}<c:if test="${!empty uid }">&id=${uid}</c:if>">尾页</a>
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
  <c:if test="${requestScope.pages.list==null}">
  <tr>
    <td height="40" class="f14white">　你还没有发布知识，<a href="logined/addknowledge.jsp">点击这里</a>，去发布</td>
  </tr>
  

  </c:if>
</table>
</body>
</html>