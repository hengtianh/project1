<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>

<style type="text/css">
body{ background-color:#00aaef;}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="logincontainer">
  <table width="865" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="517" height="83">&nbsp;</td>
      <td width="342">&nbsp;</td>
    </tr>
    <tr>
      <td height="262">&nbsp;</td>
      <td><form name="form1" method="post" action="login">
      <div id="borderdiv">
      	<table id="logintbl" width="305" border="0" align="center" cellpadding="0" cellspacing="0">
      	  <tr>
      	    <td height="50" colspan="2" align="left"><label for="username"></label>
      	      <input type="text" name="username" id="username" class="logininput"></td>
    	    </tr>
      	  <tr>
      	    <td height="50" colspan="2" align="left"><input type="password" name="userpass" id="userpass" class="logininput"></td>
    	    </tr>
      	  <tr>
      	    <td height="20" colspan="2" align="center">显示提示信息</td>
    	    </tr>
      	  <tr>
      	    <td width="170" height="50" align="center"><input type="checkbox" value="true" name="remember" id="remeber">
      	      <label for="remeber">下次自动登录</label></td>
      	    <td width="156" height="50" align="center"><a href="javascript:void(0);">忘记密码</a>&nbsp;<a href="register.jsp">注册</a></td>
    	    </tr>
      	  <tr>
      	    <td height="50" colspan="2" align="center"><input type="image" name="imageField" id="imageField" src="images/btn-login.png"></td>
    	    </tr>
    	  </table>
      </div>
      </form></td>
    </tr>
  </table>
</div>
</body>
</html>