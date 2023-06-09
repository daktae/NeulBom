<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/assetclient.jsp"%>
<style>
.introducetitle {
	background-image: url("/neulbom/asset/image/자유게시판 사진.jpg")
}

.content_wj {
	padding: 10px 40px;
	text-align: justify;
}

.btn, .btn-primary, .btn-sm {
	width: 100px;
	height: 40px;
	margin-right: 10px;
	font-size: 20px;
	float: left;
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

.th {
	width: 150px;
	font-size: 23px;
	background-color: #EEE;
	padding: 20px 0px;
	border-bottom: 1px solid #DFDFDF;
}

.td {
	border-bottom: 1px solid #DFDFDF;
	border-bottom: 1px solid #DFDFDF;
}

#title {
	width: 97%;
	height: 50px;
	border: 1px solid #c7c8c9;
	color: black;
	padding: 10px;
}

#content {
	width: 97%;
	height: 500px;
	margin: 10px 10px;
	border: 1px solid #c7c8c9;
	padding: 10px;
	resize: none;
}

#pic {
	width: 97%;
	height: 50px;
	border: 1px solid #c7c8c9;
	padding: 10px;
	text-align: left;
}
</style>
</head>
<body>
	<!-- editfree.jsp 내가 쓴 글 수정 -->
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp"%>

	<div class="introducetitle">커뮤니티</div>


	<div class="mainmenu text-center">
		<span class="sidebar">
			<div class="bg-light border-right">
				<div class="list-group list-group-flush">
					<a href="#" class="list-group-item list-group-item-action active"
						style="background-color: #043886;">커뮤니티</a> <a href="#"
						class="list-group-item list-group-item-action">입주상담 게시판</a> <a
						href="#" class="list-group-item list-group-item-action">문의게시판</a>
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
							home </span> > 커뮤니티 > 자유게시판
					</div>
				</div>
			</nav>
			<hr>
			<form method="POST" action="/neulbom/client/community/editfree.do">

				<table class="table table-bordered content-head_wj">
					<tr>
						<th class="th">제목</th>
						<td class="td"><input type="text" name="title" id="title"
							class="full" maxlength="60" required value="${dto.title }"></td>
					</tr>
					<tr>
						<th class="th">내용</th>
						<td class="td"><input type="textarea" name="content"
							id="content" maxlength="900" required value="${dto.content}"></td>
					</tr>
					<tr>
						<th class="th">첨부파일</th>
						<td class="td"><input type="file" name="file" id="file"
							class="full" value="${dto.file }"></td>
					</tr>
				</table>

				<hr>

				<div>
					<button type="submit" class="edit primary">수정하기</button>
					<button type="button" class="back" onclick="history.back();">취소하기</button>
				</div>
				<input type="hidden" name="free_seq" value="${dto.free_seq }">
			</form>
		</div>






	</div>





	<%@ include file="/WEB-INF/views/inc/footerclient.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script>
		
	</script>

</body>
</html>