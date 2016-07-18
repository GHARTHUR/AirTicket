<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
</head>
<body>
<h3>${msg}</h3>
<form method="POST" action="./Index">
	<input type="text" name="airfrom" />
	<input type="text" name="airto" />
	<input type="text" name="airdate" />
	<button type="submit">添加</button>
</form>
</body>
</html>