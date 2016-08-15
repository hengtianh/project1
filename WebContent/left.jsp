<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="leftid" width="184" border="0" align="left" cellpadding="0" cellspacing="0">
<c:if test="${sessionScope.user!=null}">
	  <tr>
	    <td height="10" bgcolor="#CCCCCC">&nbsp;</td>
    </tr>
	  <tr>
	    <td width="180" height="50" bgcolor="#CCCCCC"><div align="center"><img width="100" height="100" src="${pageContext.request.contextPath}/headerimages/${sessionScope.user.headerImage}" alt="" width="100" height="100"></div></td>
	  </tr>
	  <tr>
	    <td width="180" height="20" align="center" bgcolor="#CCCCCC">${sessionScope.user.userName}</td>
	  </tr>
	  <tr>
	    <td height="5" align="center" bgcolor="#CCCCCC"><hr></td>
	  </tr>
	  <tr>
	    <td height="0" align="center" bgcolor="#CCCCCC">&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="25" align="center" bgcolor="#CCCCCC"><a href="${pageContext.request.contextPath}/showknowledge?where=${sessionScope.user.id}" class="f14white">我的知识</a></td>
	  </tr>
	  <tr>
	    <td height="5" align="center" bgcolor="#CCCCCC"><hr></td>
	  </tr>
	  <tr>
	    <td height="25" align="center" bgcolor="#CCCCCC"><a href="${pageContext.request.contextPath}/showcollection" class="f14white">我的收藏</a></td>
	  </tr>
	  <tr>
	    <td height="5" align="center" bgcolor="#CCCCCC"><hr></td>
	  </tr>
	  <tr>
	    <td height="25" align="center" bgcolor="#CCCCCC"><a href="${pageContext.request.contextPath}/login/setting.jsp" class="f14white">个人设置</a></td>
	  </tr>
	  <tr>
	    <td height="5" align="center" bgcolor="#CCCCCC"><hr></td>
	  </tr>
	  <tr>
	    <td height="25" align="center" bgcolor="#CCCCCC"><a href="${pageContext.request.contextPath}/loadcategory" class="f14white">发表知识</a></td>
	  </tr>
	  <tr>
	    <td height="5" align="center" bgcolor="#CCCCCC"><hr></td>
	  </tr>
	  <tr>
	    <td height="45" align="center" bgcolor="#CCCCCC"><a href="logout" class="f14white">退出系统</a></td>
	  </tr>
	  <tr>
	    <td height="5" align="center"><hr></td>
	  </tr>
	
</c:if>
<c:if test="${sessionScope.user==null}">
 	<tr>
	    <td width="180" height="300" class="f14white" align="center" bgcolor="#CCCCCC">您还没有登录！<a href="${pageContext.request.contextPath }/login.jsp"  class="f14white">点此登录</a></td>
	</tr>
	
</c:if>
	</table>

</body>
</html>