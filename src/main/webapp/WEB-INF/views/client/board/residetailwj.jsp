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


#comname {
	display: inline-block;	
	float: left;
	font-weight: bold;
}

#comcontent {
	display: inline-block;
	width: 100%;
}

#comment {
	border: 1px solid #AAA;
	width: 100%;
	margin: 30px auto;
	padding: 100px;
}

.comment {
	background-color: #DFDFDF;
	font-weight: bold;
	border: none;
	height: 40px;
	width: 100px;
	border-radius: 10%;
}

#regicom {
	width: 150px;
	padding: auto 10px;
}

#eotrmf {
	width: 70px;
	font-weight: bold;
	padding: auto 0;
}

.del, .edit {
	width: 100px;
	height: 40px;
	font-size: 18px;
	border: 1px solid #AAA;
	background-color: #AAA;
	float: right;
}




</style>
</head>
<body>
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
                      <th>${dto.con_seq }</th>
                      <th style="text-align: left;">${dto.title }</th>
                      <th>${dto.name }</th>
                      <th>${dto.con_date }</th>
                    </tr>
                </thead>
            </table>
            <div class="content_wj" style="font-size:25px; padding-left:50px;"><pre><c:out value="${dto.content}" /></pre></div>
            <hr> 
    </div>
 </div>
        
        



        <%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	

</script>
</body>
</html>




