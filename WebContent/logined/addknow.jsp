<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/my.js"></script>
</head>
<body>
<form id="knowledgeform" enctype="multipart/form-data" method="post" action="">
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="40" colspan="2" align="center" class="f14white">添加知识 </td>
    </tr>
    <tr>
      <td width="25%" height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识类别</td>
      <td width="75%" height="60"><label for="category"></label>
        <select name="category" class="allselect addinput" id="category">
        <c:forEach var="category" items="${category }">
        	<option value="${category.id}">${category.name}</option>
        </c:forEach>
      </select>        <label for="textfield"></label></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识标题</td>
      <td height="60"><input type="text" onblur="checkTitle();" class="addinput" name="title" id="title"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识标签</td>
      <td height="60"><input type="text" onblur="checkLabel();" class="addinput" name="label" id="lable"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">知识内容</td>
      <td height="60"><label for="content"></label>
      <textarea name="content" onblur="checkContent();" class="alltext" id="content" cols="45" rows="15"></textarea></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">添加附件</td>
      <td height="60"><label for="content"></label>
      <input type="file" name="attach" class="alltext" id="content"></td>
    </tr>
    <tr>
      <td height="60">&nbsp;</td>
      <td height="60"><input type="button" name="button" onclick="dosubmit();" class="f14white" style="width: 180px; height:30px; border:1px solid #ccc; background-color:#54b6ff;" id="button" value="提交"></td>
    </tr>
  </table>
</form>

</body>
</html>