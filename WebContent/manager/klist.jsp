
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<style>
 a{ text-decoration: none;}
</style>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  
  <c:if test="${requestScope.knowledgelist!=null}">
  <c:forEach var="k" items="${requestScope.knowledgelist}">
  <tr>  
    <td colspan="3" class="f14white">&nbsp;</td>
  </tr>
  <tr>
    <td width="82" rowspan="2" align="center" bgcolor="#F3F3F3"><img src="headerimages/userdefault.gif" width="80" height="80"></td>
    <td width="800" class="f14white"><a href="${pageContext.request.contextPath}/showdetails?id=${k.id }">　　${k.title }</a></td>
  </tr>
  <tr>
    <td colspan="20">　　${k.pubDate } 由 ${k.entity.userName }  发布到  ${k.category.name}</td><td colspan="9"><c:if test="${k.state==1}"><button type="button" class="btn btn-success" disabled='disabled'>已屏蔽</button></c:if><c:if test="${k.state==0}"><a href="${pageContext.request.contextPath}/cover?id=${k.id}" class="btn btn-danger">屏蔽</a></c:if></td>
  </tr>
  </c:forEach>
  </c:if>
  <c:if test="${requestScope.knowledgelist==null}">
  <tr>
    <td height="40" class="f14white">　还没有人发布知识</td>
  </tr>
  </c:if>
</table>
</body>
</html>