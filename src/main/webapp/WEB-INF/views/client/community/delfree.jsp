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
	<div class="introducetitle">커뮤니티</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">문의게시판</a>
                    <a href="/neulbom/client/community/free.do" class="list-group-item list-group-item-action">자유게시판</a>
                </div>
            </div>
        </span>
        
        
        
        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">자유게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 자유게시판
                    </div>
                </div>
            </nav>
            <hr>
            <table class="table table-bordered table-hover content-head_wj">
                <thead>
                    <tr>
                      <td id="id">게시글이 존재하지 않습니다.</td>
                    </tr>
                </thead>
            </table>
            </div>
            </div>
	
	<form method="POST" action="/neulbom/client/community/delfree.do">
	<div>
		<input type="button" onclick="history.back(); value="돌아가기">
	</div>
	
	<input type="hidden" name="free_seq" value="${free_seq }">
	
	</form>
	

<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>

</body>
</html>