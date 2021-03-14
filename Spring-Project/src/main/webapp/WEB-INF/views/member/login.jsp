<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>

<link href="/css/login.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom2.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/navbar.jsp"></jsp:include>

	<form id="login-form" action="/member/login" method="post">
		<h3>LOGIN</h3>
		<br />
		<label class="legend">아이디</label>
		<input name="id" type="text" placeholder="아이디를 입력하세요.">

		<label class="legend">패스워드</label>
		<input name="pw"type="password" placeholder="비밀번호를 입력하세요.">
		<input type="submit" id="button" class="btn btn-info" value="로그인 하기" />

	</form>

</body>
</html>