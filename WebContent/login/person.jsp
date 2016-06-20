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
<form id="settingform" method="post" action="${pageContext.request.contextPath}/setting">

  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="40" colspan="2" align="center" class="f14white">个人设置 </td>
    </tr>
    <tr>
      <td width="25%" height="60" align="center" bgcolor="#CCCCCC" class="f14white">用户名</td>
      <td width="75%" height="60"><label for="category"></label>
        <label for="username"></label>
      <input type="text" name="username" id="username" value="${sessionScope.user.userName}"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">昵称</td>
      <td height="60"><input type="text" onblur="checkTitle();" class="addinput" name="nickname" id="nike" value="${sessionScope.user.nickName==null?'还没有编辑昵称':sessionScope.user.nickName}"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">头像</td>
      <td height="60"><input name="headerImage" type="hidden" class="addinput" id="lable" onblur="checkLabel();" readonly="readonly"></td>
    </tr>
    <tr>
      <td height="60" align="center" bgcolor="#CCCCCC" class="f14white">自我介绍</td>
      <td height="60"><label for="introduce"></label>
      <textarea name="introduce" onblur="checkContent();" class="alltext" id="introduce" cols="45" rows="15">${sessionScope.user.introduce}</textarea></td>
    </tr>
    <tr>
      <td height="60">&nbsp;</td>
      <td height="60"><input type="submit" name="button" class="f14white" style="width: 180px; height:30px; border:1px solid #ccc; background-color:#54b6ff;" id="button" value="修改"></td>
    </tr>
  </table>
</form>

</body>
</html>