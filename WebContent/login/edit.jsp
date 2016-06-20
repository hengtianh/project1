<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form name="form1" method="post" action="editknowledge">
<input type="hidden" name="id" value="${edit.id}">
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="40" colspan="2" align="center" class="f14white">修改知识 </td>
    </tr>
    <tr>
      <td width="25%" height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识类别</td>
      <td width="75%" height="60"><label for="category"></label>
        <select name="category" class="addinput" id="category">
        <c:forEach var="category" items="${category }">
        	<option value="${category.id}" ${category.id!=edit.cid ? '':'selected="selected"'}>${category.name}</option>
        </c:forEach>
      </select>        <label for="textfield"></label></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识标题</td>
      <td height="60"><input type="text" class="addinput" name="title" value="${edit.title}" id="title"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识标签</td>
      <td height="60"><input type="text" class="addinput" name="label" value="${edit.label}" id="lable"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识内容</td>
      <td height="60"><label for="content"></label>
      <textarea name="content" id="content" cols="45" rows="15">${edit.content}</textarea></td>
    </tr>
    <tr>
      <td height="60">&nbsp;</td>
      <td height="60"><input type="submit" name="button" class="f14white" style="width: 180px; height:30px; border:1px solid #ccc; background-color: #54b6ff;" id="button" value="提交"></td>
    </tr>
  </table>
</form>
</body>
</html>