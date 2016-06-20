<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

<style>

</style>
</head>
<body>
<div class="detail">
  <form name="form1" method="post" action="">
    <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="4" bgcolor="#FFFFFF">&nbsp;</td>
      </tr>
      <c:if test="${requestScope.detail.state==0 }">
      <tr>
        <td height="30" colspan="4" bgcolor="#FFFFFF"><span class="f14white">${requestScope.detail.title }</span></td>
      </tr>
      <tr>
        <td colspan="4" bgcolor="#FFFFFF"><hr></td>
      </tr>
      <tr>
        <td height="30" colspan="4" bgcolor="#FFFFFF"><span class="f14white">${requestScope.detail.label }</span></td>
      </tr>
      <tr>
        <td colspan="4" bgcolor="#FFFFFF"><hr></td>
      </tr>
      <tr>
        <td height="30" colspan="4" align="right" bgcolor="#FFFFFF">${requestScope.detail.pubDate } 阅读(${requestScope.detail.readCount}),评论(0) <a href="collection?id=${requestScope.detail.id }">收藏</a></td>
      </tr>
      <tr>
        <td colspan="4" align="right" bgcolor="#FFFFFF"><hr></td>
      </tr>
      <tr>
        <td height="30" colspan="4" align="right" bgcolor="#FFFFFF">　　该文章已收录于 ${requestScope.detail.category.name }</td>
      </tr>
      <tr>
        <td colspan="4" bgcolor="#FFFFFF"><hr></td>
      </tr>
      <tr>
        <td colspan="4" rowspan="1" bgcolor="#FFFFFF">
        <p>
        ${requestScope.detail.content }
        </p>
        </td>
      </tr>
      <tr>
        <td width="40%" align="right" bgcolor="#FFFFFF"></td>
        <td width="10%" align="right" bgcolor="#FFFFFF">
        <div class="ding fontP"><a href="dingorcai?id=${requestScope.detail.id}&method=ding" style="font:25px 微软雅黑; color:white;">顶</a></div>
  		<div class="num"><span style="color:white;">(${requestScope.detail.ding})</span></div></td>
        <td width="3%" align="right" bgcolor="#FFFFFF"></td>
        <td width="47%" height="40" align="left" bgcolor="#FFFFFF">
        <div class="ding fontP"><a href="dingorcai?id=${requestScope.detail.id}&method=cai" style="font:25px 微软雅黑; color:white;">踩</a></div>
  		<div class="num"><span style="color:white;">(${requestScope.detail.cai})</span></div></td>
      </tr>
      </c:if>
      <c:if test="${requestScope.detail.state==1 }">
      <tr>
        <td colspan="4" bgcolor="#FFFFFF">根据相关规定，该文章已被屏蔽<hr></td>
      </tr>
      </c:if>
    </table>
  </form>
</div>
</body>
</html>