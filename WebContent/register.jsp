<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style>
	body{ background-color:#CCC;}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/my.js"></script>
</head>
<body>
<div class="regcontainer">
	<div class="space"></div>
  <div class="topspace">
  <table width="700" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40" bgcolor="#FF0000">&nbsp;</td>
    <td height="40" bgcolor="#FF9900">&nbsp;</td>
    <td height="40" bgcolor="#FFFF00">&nbsp;</td>
  </tr>
</table>
  </div>
    <div class="reg">
      <form id="registerform" method="post" action="">
        <table width="649" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="150" height="45" align="right">邮箱：</td>
            <td width="280" height="45"><label for="username"></label>
              <input type="text" name="username" value="${requestScope.username}" onBlur="checkEmail();" id="username" class="textinput"></td>
            <td width="280" height="45"><span id="emaillabel" style="color: red">${requestScope.msg }</span></td>
          </tr>
          <tr>
            <td width="150" height="45" align="right">密码：</td>
            <td width="280" height="45"><label for="userpass"></label>
              <input type="password" name="userpass" onblur="checkPass();" id="userpass" class="textinput"></td>
            <td width="280" height="45"><span id="passlabel" style="color: red"></span></td>
          </tr>
          <tr>
            <td width="150" height="45" align="right">确认密码：</td>
            <td width="280" height="45"><label for="repeatpass"></label>
              <input type="password" name="repeatpass" onblur="checkRepeatPass();" id="repeatpass" class="textinput"></td>
            <td width="280" height="45"><span id="repeatpasslabel" style="color: red"></span></td>
          </tr>
          <tr>
            <td width="150" height="40" align="right">&nbsp;</td>
            <td width="280"><input type="checkbox" onClick="agreeRegister(this)" name="agree" value="true" id="agree">
              <label for="agree"></label>
              我已阅读并同意相关协议 </td>
            <td width="280">&nbsp;</td>
          </tr>
          <tr>
            <td width="150" height="40" align="right">&nbsp;</td>
            <td width="280"><input type="image" name="imageField" onclick="javascript:return submitform();" id="imageField" disabled="disabled" onMouseOver="this.src='images/btn-reg2.png'" onMouseOut="this.src='images/btn-reg1.png'" src="images/btn-reg1.png"></td>
            <td width="280">&nbsp;</td>
          </tr>
        </table>
      </form>
    </div>
</div>

</body>
</html>