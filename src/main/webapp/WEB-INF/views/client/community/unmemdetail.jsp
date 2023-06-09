<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>

<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>

<style>
a{
	text-decoration:none;
	color:#212529;
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	
	  <div id="consult" class="introducetitle" style="background-image: url('/neulbom/asset/mainimage/registwrite.jpg'); background-position: 50% 75%;">입주상담게시판</div>




    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush"">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="/neulbom/client/board/resiconsult.do" class="list-group-item list-group-item-action" style="background-color: #e9ecef;">입주상담게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">문의게시판</a>
                           <a href="#" class="list-group-item list-group-item-action">자유게시판</a>
                </div>
            </div>
        </span>

		<div>
		</div>
        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">입주상담게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined">
help
</span>
                        > 입주상담게시판 > 입주 문의글 > 내 문의글
                    </div>
                </div>
            </nav>
            <hr>

             <div style="display: flex; justify-content: flex-end;">
<button type="button" class="btn btn-primary btn-sm" style="width: 100px; height: 40px; margin-right: 10px; font-size: 20px;" onclick="location.href='/neulbom/client/board/unmem.do'">수정하기</button>
<button type="button" class="btn btn-primary btn-sm" style="width: 100px; height: 40px; margin-right: 10px; font-size: 20px;" onclick="location.href='/neulbom/client/board/unmem.do'">삭제하기</button>

</div>
    </div>
        </div>
    

	 
	<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script>

</script>
</body>
</html>