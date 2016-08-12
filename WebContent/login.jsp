
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>


<style type="text/css">
body {
	background-color: #00aaef;
}
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
				<td height="273">&nbsp;</td>
				<td><form name="form1" method="post" action="${pageContext.request.contextPath }/login">
						<div id="borderdiv">
							<table id="logintbl" width="305" border="0" align="center"
								cellpadding="0" cellspacing="0">
								<tr>
									<td height="40" colspan="2" align="left"><label
										for="username"></label> <input type="text" name="username"
										id="username" class="logininput" placeholder="请输入用户名"></td>
								</tr>
								<tr>
									<td height="40" colspan="2" align="left"><input
										type="password" name="userpass" id="userpass"
										class="logininput" placeholder="请输入密码"></td>
								</tr>
								<tr>
									<td><input class="codevalue" type="text" name="code"
										width="50" required="required"></td>
									<td width="172"><img  id="codeaaa" src="${pageContext.request.contextPath }/codeServlet" class="code"></td>
								</tr>
								<tr>
									<td><a class="codestyle"
										href="javascript:void(0)" onclick="change()">看不清，换一张</a></td>
								</tr>

								<tr>
									<td height="20" colspan="2" align="center">${requestScope.msg}</td>
								</tr>
								<tr>
									<td width="172" height="20" align="center"><input
										type="checkbox" value="true" name="remember" id="remeber">
										<label for="remeber">下次自动登录</label></td>
									<td width="128" height="20" align="center"><a
										href="javascript:void(0);">忘记密码</a>&nbsp;<a
										href="register.jsp">注册</a></td>
								</tr>
								<tr>
									<td height="50" colspan="2" align="center"><input
										type="image" name="imageField" id="imageField"
										src="images/btn-login.png"></td>
								</tr>
							</table>
						</div>
					</form></td>
			</tr>
		</table>
	</div>
	<script>
	function change() {
		document.getElementById("codeaaa").src = "codeServlet?time="
				+ new Date().getTime();
		//alert(code);
	}
</script>
</body>
</html>