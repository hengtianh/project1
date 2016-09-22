<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改头像</title>
<script type="text/javascript">
  function uploadevent(status,picUrl){
    status += '';
    switch(status){
    case '1':
	var filename162 = picUrl+'_162.jpg';
	var filename48 = picUrl+'_48.jpg';
	var filename20 = picUrl+"_20.jpg";

	document.getElementById('avatar_priview').innerHTML = "头像1 : <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename162+"'/> <br/> 头像2: <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename48+ "'/><br/> 头像3: <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename20+ "'/>" ;
	
    break;
    case '-1':
    window.location.reload();
    break;
    default:
    window.location.reload();
   } 
  }
</script>

</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="200" valign="top"><div id="avatar_priview"></div></td>
    <td>
    <div id="altContent">
	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" width="650" height="450" id="myMovieName">
	    <param name="movie" value="upload/avatar.swf"/>
	    <param name="quality" value="high"/>
	    <param name="bgcolor" value="#FFFFFF"/>
	    <param name="flashvars" value="imgUrl=upload/default.jpg&uploadUrl=upload/upfile.jsp&uploadSrc=false" />
	    <embed src="upload/avatar.swf" quality="high" bgcolor="#FFFFFF" width="650" height="450" wmode="transparent" flashVars="imgUrl=upload/default.jpg&uploadUrl=upload/upfile.jsp&uploadSrc=false" name="myMovieName" align="" type="application/x-shockwave-flash" allowScriptAccess="always" pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>
	  </object>
	</div>
	</td>
  </tr>
</table>
</body>
</html>