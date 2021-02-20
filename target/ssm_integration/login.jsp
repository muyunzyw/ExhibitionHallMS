<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Login Form</title>

<link rel="stylesheet" href="css/Login-my.css">
<link rel="stylesheet" href="css/Login-normalize.css">
<script src="js/prefixfree.min.js"></script>
</head>

<body>

<div class="login">
	<h1>Login</h1>
	<form action="${pageContext.request.contextPath}/login.do" method="post">
		<input type="text" name="username" placeholder="用户名" required="required" />
		<input type="password" name="password" placeholder="密码" required="required" />
		<button type="submit" class="btn btn-primary btn-block btn-large" id="btn_sub">登录</button>
	</form>
	<div id="errorMsg"></div>
</div>

</body>
</html>
