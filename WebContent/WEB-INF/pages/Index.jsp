<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>主页</title>
	<%@ include file="model/head.jsp" %></head>
	<script src="./js/TT.js"></script>
<body>
	<div class="container">
		<div class="well col-lg-8 col-lg-offset-2 Content">
			<form class="form-inline" method="POST" action="./Index">
				<div class="form-group">
					<input type="text" class="form-control addJob" placeholder="北京" name="airfrom" style="width: 100px;" class="col-lg-2"></div>
				<div class="form-group">
					<label for="exampleInputEmail2">飞往</label>
					<input type="text" class="form-control addJob" placeholder="重庆" name="airto" style="width: 100px;"></div>
				<div class="form-group">
					<label for="exampleInputEmail2">日期：</label>
					<input type="text" class="form-control" placeholder="2015-3-7" name="airdate"></div>
				<button type="submit" class="btn btn-success">添加监控</button>
			</form>
			<hr/>
			<h4>票价趋势</h4>
			<a hidden="true" id="userid">${userid}</a>
			<hr/>
			<div id="canvas">
				
			</div>
		</div>
		<div>${msg}</div>
	</div>
</body>
</html>