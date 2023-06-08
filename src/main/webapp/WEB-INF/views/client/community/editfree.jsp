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

.introducetitle {
	background-image: url("/neulbom/asset/image/자유게시판 사진.jpg")

}
.content_wj {
	padding: 10px 40px;
	text-align: justify;
}

.btn, .btn-primary, .btn-sm {

	width:100px; 
	height:40px; 
	margin-right:10px; 
	font-size: 20px; 
	float:left;

}

.session {
	float: right;
	background-color: #AAA;
	border: 1px solid #AAA;
}

#addcomment {
	border: 1px solid #AAA;
	width: 100%;
	height: 30px;
	margin-bottom: 40px;
}

.full {
	float: left;
	width: 90%;
	height: 40px;
	margin: 10px;
	border: 1px solid #AAA;
}

</style>
</head>
<body>
	<!-- editfree.jsp 내가 쓴 글 수정 -->
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	
	<div class="introducetitle">커뮤니티</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">문의게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">자유게시판</a>
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
            <form method="POST" action="/neulbom/client/community/editfree.do">
            <table class="table table-bordered table-hover content-head_wj">
                <thead>
                    <tr>
                      <th>${dto.free_seq }</th>
                      <th style="text-align: left;" required>${dto.title }</th>
                      <th>${dto.name }</th>
                      <th>${dto.free_date }</th>
                      <th>${dto.read }</th>
                    </tr>
                </thead>
            </table>
            <div class="content_wj" required>${dto.content }</div>
            <hr>
            <div>
			<button type="submit" class="edit primary">수정하기</button>
			<button type="button" class="back" onclick="history.back();">취소하기</button>
		</div>
            </div>
            
        </div>
		</form>
	
	
	
	

<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>

</body>
</html>