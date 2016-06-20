<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  
  <c:if test="${requestScope.collectionlist!=null}">
  <c:forEach var="k" items="${requestScope.collectionlist}">
  <tr>
    <td bgcolor="#CCCCCC">&nbsp;</td>
    <td colspan="3" class="f14white">&nbsp;</td>
  </tr>
  <tr>
    <td width="80" rowspan="2" align="center" bgcolor="#F3F3F3"><img src="headerimages/userdefault.gif" width="80" height="80"></td>
    <td width="657" class="f14white"><a href="showdetail?id=${k.id }">　　${k.title }</a></td>
  </tr>
  <tr>
    <td colspan="3">　　${k.pubDate } 由 ${k.entity.userName }  发布到  ${k.category.name}</td>
  </tr>
  </c:forEach>
  </c:if>
  <c:if test="${requestScope.collectionlist==null}">
  <tr>
    <td height="40" class="f14white">　还没有收藏知识，<a href="login.jsp">点击这里</a>，登录后去收藏吧</td>
  </tr>
  </c:if>
</table>
</body>
</html>