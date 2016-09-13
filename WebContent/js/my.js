//JavaScript Document
function agreeRegister(check){
	var register = document.getElementById('imageField');
	if(check.value=='true'){
		//alert(check.value);
		register.removeAttribute('disabled');
	}
}

function checkEmail(){
	var value = document.getElementById('username').value;
	var msg = document.getElementById('emaillabel');
	if(!value.match(/^\w+\@\w+(\.\w+)+$/)){
		msg.innerHTML='邮箱填写错误';
		return false;
	}else{
		msg.innerHTML='';
		return true;
	}
}

function validateUser(){
	var value = document.getElementById('username').value;
	//获得ajax核心对象
	var req = new XMLHttpRequest();
	//设置请求的方式和url
	req.open("post", "ValidateEmail", true);
	//post方式需要设置请求头
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//发送请求
	req.send("username="+value);
	//设置响应的回调方法
	//req.onreadystatechange();
	req.onreadystatechange=function (){
		HandleResp(req);
	}
}

function HandleResp(req){
	if(req.readyState==4){
		var retValue = req.responseText;
		var msg = document.getElementById('emaillabel').innerHTML=retValue;
	}
}

function checkPass(){
	var value = document.getElementById('userpass').value;
	var msg = document.getElementById('passlabel');
	if(value.length<=0){
		msg.innerHTML='密码不能为空';
	}else{
		msg.innerHTML='';
		return true;
	}
}

function checkRepeatPass(){
	var value = document.getElementById('repeatpass').value;
	var temp = document.getElementById('userpass').value;
	var msg = document.getElementById('repeatpasslabel');
	if(value.length<=0){
		msg.innerHTML='确认密码不能为空';
		return false;
	}
	if(value!=temp){
		msg.innerHTML='两次输入的密码不一致';
		return false;
	}else{
		msg.innerHTML='';
		return true;
	}
}

function submitform(){
	var repeat = false;
	var a = checkEmail();
	var b = checkPass();
	var c = checkRepeatPass();
	//var register = document.getElementById('imageField');
	//var v = document.getElementById('username').value;
	//alert(v);
	if(a & b & c & !repeat){
		//register.removeAttribute('disabled');
		repeat = true;
		var form = document.getElementById('registerform');
		form.action='register';
		form.submit();
	}else{
		alert('请将注册信息填写完整');
		//register.setAttribute('disabled', 'disabled');
		//username.value=v;
		return false;
	}
}

function checkTitle(){
	var value = document.getElementById('title').value;
	var msg = document.getElementById('titlelabel');
	if(value.length<=0){
		alert('标题不能为空');
		return false;
		//msg.innerHTML='标题不能为空';
	}else{
		return true;
		//msg.innerHTML='';
	}
}

function checkLabel(){
	var value = document.getElementById('lable').value;
	var msg = document.getElementById('lablelabel');
	if(value.length<=0){
		alert('标签不能为空');
		return false;
		//msg.innerHTML='标签不能为空';
	}else{
		return true;
		//msg.innerHTML='';
	}
}

function checkContent(){
	var value = document.getElementById('content').value;
	var msg = document.getElementById('contentlabel');
	if(value.length<=0){
		alert('内容不能为空');
		return false;
		//msg.innerHTML='内容不能为空';
	}else{
		return true;
		//msg.innerHTML='';
	}
}

function dosubmit(){
	var repeat = false;
	var a = checkTitle();
	var b = checkLabel();
	var c = checkContent();
	if(a&b&c& !repeat){
		repeat = true;
		var form = document.getElementById('knowledgeform');
		form.action = 'addknowledge';
		//alert(form);
		form.submit();
	}else{
		alert('请将信息填写完整');
		
		return false;
	}
}


