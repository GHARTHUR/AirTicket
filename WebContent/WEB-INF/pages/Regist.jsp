<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>飞机票监控小站-注册</title>
<%@ include file="model/head.jsp" %></head>
<script src="./js/Regist.js"></script>
</head>
<body>
<div class="container">
        <div class="well col-lg-4 col-lg-offset-4 Login col-sm-6 col-sm-offset-3">
            <form method="POST" action="./Regist" class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-3 control-label" >邮箱</label>
                    <div class="col-sm-9">
                        <input type="email" class="form-control" placeholder="Email" name="username" id="username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-3 control-label" >密码</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" placeholder="Password" name="password"></div>
                </div>
                
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-3 control-label" >验证码</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" placeholder="Check" name="check"></div>
                    <button class="btn btn-success col-ms-2" id="check" onclick="return false;">验证码</button>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-10">
                        <button type="submit" class="btn btn-default">注册</button>
                    </div>
                </div>
            </form>
        </div>
        <div>${msg}</div>
    </div>
</body>
</html>