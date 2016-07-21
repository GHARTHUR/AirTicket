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
					<input type="text" class="form-control addJob" placeholder="北京" name="airfrom" id="airfrom" style="width: 150px;" class="col-lg-2"></div>
					<div id='suggest' class="ac_results" style="top:0px;left:0px"></div>
				<div class="form-group">
					<label for="exampleInputEmail2">飞往</label>
					<input type="text" class="form-control addJob" placeholder="重庆" name="airto" id="airto" style="width: 150px;"></div>
					<div id='suggest2' class="ac_results"></div>
				<div class="form-group">
					<label for="exampleInputEmail2">日期：</label>
					<input type="text" class="form-control" style="background-color: #ffffff;" placeholder="2015-3-7" name="airdate" data-field="date" data-format="yyyy-MM-dd" readonly></div>
				<button type="submit" class="btn btn-success">添加监控</button>
			</form>
			<hr/>
			<h4>票价趋势</h4>
			<a hidden="true" id="userid">${userid}</a>
			<hr/>
			<div id="canvas">
				
			</div>
			<div id="dtBox"></div>
		</div>
		<div>${msg}</div>
	</div>
	<script type="text/javascript">
		
			$(document).ready(function()
			{
				$("#dtBox").DateTimePicker();
				$("#airfrom").suggest(citys,{hot_list:commoncitys,dataContainer:'#arrcity_3word',onSelect:function(){$("#airto").click();},attachObject:'#suggest'});
				$("#airto").suggest(citys,{hot_list:commoncitys,attachObject:"#suggest2"});
			});
			
		
		</script>
	
</body>
</html>