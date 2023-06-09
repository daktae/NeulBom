<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>
<style>

</style>
</head>
<body>
	<!-- delfree.jsp 내가 쓴 글 삭제 -->
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	
	<form method="POST" action="/neulbom/client/community/delfree.do">
	<div>
		<p>작성하신 게시글을 삭제하시겠습니까?</p>
		<input type="submit" value="삭제">
		<input type="button" value="취소" onclick="history.back();">
	</div>
	
	<input type="hidden" name="free_seq" value="${free_seq }">
	
	</form>
	

<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>

</body>
</html>