<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
</head>
<body>
<script type="text/javascript">
	function checkEmail(){
		var temp = document.getElementById("email");
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!myreg.test(temp.value))
        {
            alert('提示\n\n请输入有效的E_mail！');
            return false;
        }
	} 
</script>
<h3>${msg}</h3>
<form method="POST" action="./Regist">
	<input type="text" name="username" id="email"/>
	<input type="password" name="password" />
	<button type="submit" onClick="return checkEmail()">注册</button>
</form>
</body>
</html>