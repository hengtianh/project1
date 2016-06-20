<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header f18white">
<form name="form1" method="post" action="search">
  <table class="header" width="100%" height="40" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="99"><img src="${pageContext.request.contextPath}/images/logo.png" width="99" height="35"></td>
      <td width="80" align="center"><a href="${pageContext.request.contextPath}/index.jsp" class="f18white">首页</a></td>
      <c:if test="${sessionScope.user!=null }">
	      <td width="120" align="center" class="f18white"><a href="${pageContext.request.contextPath}/showknowledge?id=${sessionScope.user.id}" class="f18white">我的知识库</a></td>
	      <td width="120" align="center" class="f18white"><a href="showcollection" class="f18white">我的收藏</a></td>
	      <td width="120" align="center" class="f18white"><a href="${pageContext.request.contextPath}/login/setting.jsp" class="f18white">个人设置</a></td>
	      <td width="80" align="center" class="f18white"><a href="logout" class="f18white">退出</a></td>
      </c:if>
     
      <td width="80" align="center"><a href="${pageContext.request.contextPath}/login.jsp" class="f18white">登录</a></td>
      <td width="80" align="center"><a href="${pageContext.request.contextPath}/register.jsp" class="f18white">注册</a></td>
       <c:if test="${sessionScope.user==null }">
      <td width="120" align="center" class="f18white"><a href="#" class="f18white"></a></td>
	      <td width="120" align="center" class="f18white"><a href="#" class="f18white"></a></td>
	      <td width="120" align="center" class="f18white"><a href="#" class="f18white"></a></td>
	      <td width="80" align="center" class="f18white"><a href="logout" class="f18white"></a></td>
          </c:if>
      
      <td width="65">&nbsp;</td>
      <td width="178" align="right"><label for="search"></label>
        <input type="text" name="key" id="search"></td>
      <td width="30" align="right"><input type="image" name="imageField" id="imageField" src="${pageContext.request.contextPath}/images/search.png"></td>
    </tr>
  </table>
</form>
</div>
<div class="banner">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="center" valign="middle" class="title">知识库，你身边的业务百科全书</td>
    </tr>
  </table>
</div>
</body>
</html>