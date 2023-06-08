<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>늘봄 > 커뮤니티 > 자유게시판 > 글 조회</title>
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






</style>
</head>
<body>
   <!-- viewsfree.jsp >  -->
   <%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
    <div class="introducetitle">커뮤니티</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판 > </a>
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
            <table class="table table-bordered table-hover content-head_wj">
                <thead>
                    <tr>
                      <th>${dto.free_seq }</th>
                      <th style="text-align: left;">${dto.title }</th>
                      <th>${dto.name }</th>
                      <th>${dto.free_date }</th>
                      <th>${dto.read }</th>
                    </tr>
                </thead>
            </table>
            <div class="content_wj">${dto.content }</div>
            <hr>
            <button type="button" class="btn btn-primary btn-sm" onclick="location.href='/neulbom/client/community/free.do';">돌아가기</button>
            <c:if test="${not empty id }">
            <button type="button" class="btn btn-primary btn-sm" 
            onclick="location.href='/client/community/addfree.do?mode=reply&thread=${dto.thread}&$depth=${dto.depth }';">답변하기</button>
            </c:if>
            <c:if test="${not empty id && (id == dto.id) }">
            <input type="submit" class="btn btn-primary btn-sm session" name="del" id="del" value="삭제하기" onclick="location.href='/neulbom/client/community/delfree.do?seq${dto.seq}'"> 
            <input type="submit" class="btn btn-primary btn-sm session" name="edit" id="edit" value="수정하기" onclick="location.href='/neulbom/client/community/editfree.do?seq=${dto.seq}';"> 
        	</c:if>
        </div>
        
        
        
    </div>
    
    <form id="editCommentForm" method="POST" action="/client/board/editcomment.do">
		<input type="hidden" name="bseq">
		<input type="hidden" name="cseq">
		<input type="hidden" name="content">
	</form>
        
        
<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>




