<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지 > 복지프로그램 신청</title>
</head>


<link rel="stylesheet" href="./css/mypage프로그램.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./javascript/mypage결제내역.js">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="/neulbom/asset/css/mypagepro.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<%@ include file="/WEB-INF/views/inc/assetclient.jsp"%>
<style>
html, body {
	height: 100vh;
	margin: 0;
}

@font-face {
	font-family: 'IBMPlexSansKR-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

html {
	font-family: 'IBMPlexSansKR-Regular';
}

body {
	margin: 0;
}

.tr:hover {
	cursor: pointer;
	background-color: #DFDFDF;
}
</style>



<body>
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp"%>

	<!-- 사이드바 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="sidebox">
					<div class="profile">
						<img src="/html/images/01.jpg" id="profileimg">
						<h1 class="profilename">'${name }'님</h1>
						<h1 class="profilename_id">(${id})</h1>
					</div>
					<div class="menubox">
						<div class="menu" id="create_account">
							<span class="material-symbols-outlined">person</span> 내정보
						</div>
						<div class="menu" id="search_staff">
							<span class="material-symbols-outlined"> credit_score </span>
							결제관리
						</div>


						<div class="menu" id="manage_account">
							<span class="material-symbols-outlined"> pending_actions </span>
							면회관리
						</div>


						<div class="menu" id="staff_salary" onclick="location.href='/neulbom/client/mypage/program.do';">
							<span class="material-symbols-outlined"> groups_2 </span>
							복지프로그램관리
						</div>
						<div class="menu" id="manage_equip">
							<span class="material-symbols-outlined"> support_agent </span> 내
							문의
						</div>

						<hr>
						<div class="menu" id="manage_qna_consult">
							<span class="material-symbols-outlined"> help </span> 늘봄
						</div>

					</div>
				</div>
			</div>



			<div class="col-md-9">
				<div class="box">
					<!-- 버튼 -->
					<div class="btn-group" role="group"
						aria-label="Basic radio toggle button group">
						<input type="radio" class="btn-check" name="btnradio"
							id="btnradio1" autocomplete="off" checked> <label
							class="btn btn-outline-primary" for="btnradio1" onclick="location.href='/neulbom/client/mypage/program.do';">복지프로그램 신청</label>

						<input type="radio" class="btn-check" name="btnradio"
							id="btnradio3" autocomplete="off"> <label
							class="btn btn-outline-primary" for="btnradio3" selected>내 신청내역</label>
					</div>

					<br> <br>
					<!-- <div class="title">면회신청내역</div> -->
					<div class="selec">
						<select>
							<option selected>2023-05-01 ~ 2023-06-01</option>
							<option>2023-04-01 ~ 2023-05-01</option>
							<option>2023-03-01 ~ 2023-04-01</option>
						</select>
					</div>
					<hr>

					<!-- <div id="summary">2023-05-01 ~ 2023-06-01 복지프로그램 내역이 00건이
						있습니다.</div> -->



					<div class="row justify-content-center">
						<form id="delprogram" method="POST" action="/neulbom/client/mypage/delprogram.do">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">날짜</th>
									<th scope="col">프로그램명</th>
									<th scope="col">프로그램 내용</th>
									<th scope="col">장소</th>
									<th scope="col">인원수</th>
									<th scope="col">신청</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${myplist}" var="dto">
									<tr class="tr">
										<td onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';">${dto.prog_seq}</td>
										<td onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';">${dto.prog_date}</td>
										<td onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';" style="text-align: justify">${dto.title}</td>
										<td onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';" style="text-align: justify">${dto.content}</td>
										<td onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';">${dto.place}</td>
										<td onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';">${dto.apply} / ${dto.people}</td>
								        <td style="padding-bottom: 0px; padding-top: 0.25rem;"><button type="button" class="btn btn-primary btn-sm" onclick="confirmCancel()">취소</button></td>
									</tr>
								        <input type="hidden" name="prog_seq" value="${dto.prog_seq }">
								        <input type="hidden" name="resi_seq" value="${resi_seq }">
								        <input type="hidden" name="papp_seq" value="${dto.papp_seq }">
								</c:forEach>

							</tbody>
						</table>
						</form>
						
						

						<!-- 페이징 -->
						<c:if test="${myplist.size() != 0 }">
							<div id="paging" class="pagination justify-content-center"
								style="text-align: center; margin-bottom: 10px;">${pagination}</div>
						</c:if>

						<br> <br> <br> <br> <br>
						<!-- 캘린더 -->
						<div class="calendar"></div>


					</div>
				</div>
			</div>
		</div>
	</div>





	<%@ include file="/WEB-INF/views/inc/footerclient.jsp"%>
</body>
<script>
  //check the console for date click event
//Fixed day highlight
//Added previous month and next month view

	function delProgram(prog_seq) {
	  
	  var resi_seq = ${resi_seq};
		
		location.href='/neulbom/client/mypage/delprogram.do?prog_seq=' + prog_seq + '&resi_seq=' + resi_seq;
		
	}
  
	function confirmCancel() {
	    var result = confirm("정말 취소하시겠습니까?");
	    if (result) {
	       document.getElementById("delprogram").submit();
	    }
	    else {
	      
	    }
	  }



   

  
</script>
</html>