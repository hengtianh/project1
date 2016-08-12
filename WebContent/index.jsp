<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
body{ background-color: #f5f5f5;}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" bgcolor="#333"><tr><td align="center"><%@ include file="/logined/header.jsp"%></td></tr></table>
<div class="container">
	<div class="body">
	    <div class="space"></div>
	    <div class="left"><%@include file="left.jsp" %></div>
	    <div class="right"><%@include file="right.jsp" %></div>
    </div>
</div>
	<div class="space"></div>
    <div class="footer"><%@include file="footer.jsp" %></div>
</body>
</html>