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
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	 
	 	<div class="introducetitle">알림게시판</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판</a>
                    <a href="http://localhost:8090/neulbom/client/board/qna.do?" class="list-group-item list-group-item-action">문의 게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">자유 게시판</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">문의 게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 문의 게시판
                    </div>
                </div>
            </nav>
            <hr>
            <table class="table table-bordered table-hover content-head_wj">
                <thead>
                    <tr>
                      <th>${dto.qna_seq}</th>
                      <th style="text-align: left;">${dto.title}</th>
                      <th>${dto.fname}</th>
                      <th>${dto.qna_date}</th>
                      <th>${dto.read}</th>
                    </tr>
                </thead>
            </table>
            
            <div class="content_wj">
              	${dto.content}
            </div>
     
            <hr>
            <form action="http://localhost:8090/neulbom/client/board/qna.do" style="text-align: right; margin-top: 50px; margin-bottom: 50px; margin-right: 300px;">
            <button type="submit" class="btn btn-primary btn-sm" style="width:100px; height:40px; margin-right:10px; font-size: 20px; float:left;">돌아가기</button>
			</form>
        </div>
        
<%-- <%@ include file="/WEB-INF/views/inc/footerclient.jsp" %> --%>
<script>

	

</script>
</body>
</html>






