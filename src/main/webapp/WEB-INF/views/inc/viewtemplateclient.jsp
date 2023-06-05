<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>
<style>

</style>
</head>
<body>
	<!--  -->
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	 <div class="introducetitle">알림게시판</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">알림게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">메뉴 2</a>
                    <a href="#" class="list-group-item list-group-item-action">메뉴 3</a>
                    <a href="#" class="list-group-item list-group-item-action">메뉴 4</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">공지사항</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 알림게시판 > 공지사항
                    </div>
                </div>
            </nav>
            <hr>
            <table class="table table-bordered table-hover content-head_wj">
                <thead>
                    <tr>
                      <th>1</th>
                      <th style="text-align: left;">[실버타운]공지사항</th>
                      <th>관리자4</th>
                      <th>2023.06.03</th>
                      <th>46</th>
                    </tr>
                </thead>
            </table>
            <div class="content_wj">
              안녕하세요, 실버타운 이웃 여러분!
            </div>
            <hr>
            <button type="button" class="btn btn-primary btn-sm" style="width:100px; height:40px; margin-right:10px; font-size: 20px; float:left;">돌아가기</button>
        </div>
        
<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






