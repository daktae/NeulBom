<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<h1>관리자 로그인</h1>
	<main id="main">
		<h1 class="sub">회원 <small>로그인</small></h1>
		
		<form method="POST" action="/neulbom/admin/login.do">
		<table id="login" class="vertical">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" required class="short"></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="pw" id="pw" required class="short"></td>
			</tr>
		</table>
		<div>
			<button type="button" class="back"
					onclick="location.href='/neulbom/admin/index.do';">돌아가기</button>
			<button type="submit" class="login primary">로그인</button>
		</div>
		</form>
		<div id="temp-login">
		<form method="POST" action="/neulbom/admin/login.do">
			<input type="hidden" name="id" value="admin01">
			<input type="hidden" name="pw" value="admin">
			<input type="submit" value=" 오소수 ">
		</form>
		</div>
	</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>










