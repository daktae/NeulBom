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


						<div class="menu" id="staff_salary"
							onclick="location.href='/neulbom/client/mypage/program.do';">
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
						<input type="button" class="btn-check" name="btnradio"
							id="btnradio1" autocomplete="off" checked> <label
							class="btn btn-outline-primary" for="btnradio1"
							onclick="location.href='/neulbom/client/mypage/program.do';">복지프로그램
							신청</label> <input type="button" class="btn-check" name="btnradio"
							id="btnradio3" autocomplete="off"> <label
							class="btn btn-outline-primary" for="btnradio3"
							onclick="location.href='/neulbom/client/mypage/myprogram.do?resi_seq=${resi_seq}';">내
							신청내역</label>
					</div>
					
					<!-- <form class="d-flex" role="search" style="max-width: 50%;"
		action="/neulbom/client/board/resiconsult.do" method="GET">
		
		<select class="form-select" name="search_option"
			style="width: 100px; margin-right: 10px;"
			aria-label="Default select example" onchange="toggleDateInputs(this)">
			<option value="title">제목</option>
			<option value="author">작성자</option>
			<option value="date">날짜</option>
		</select> 
		<input class="form-control_wj"
			style="width: 200px; margin-right: 10px; display: none;" type="date"
			name="start_date" placeholder="시작일" aria-label="Start Date">
		<span class="separate" style="display: none; margin-right: 10px;">~</span>
		<input class="form-control_wj" type="date"
			style="width: 200px; margin-right: 10px; display: none;"
			name="end_date" placeholder="종료일" aria-label="End Date"> <input
			class="form-control_wj" style="width: 200px; margin-right: 10px;"
			type="text" name="search_keyword" placeholder="검색"
			aria-label="Search">
		<button class="btn btn-light" type="submit"
			style="width: 74px !important; height: 38px !important; white-space: nowrap;">검색</button>
	</form> -->
					

					<br> <br>
					<div class="selec">
						<select>
							<option selected>2023-05-01 ~ 2023-06-01</option>
							<option>2023-04-01 ~ 2023-05-01</option>
							<option>2023-03-01 ~ 2023-04-01</option>
						</select>
					</div>
					<hr>

					<div id="summary">2023-05-01 ~ 2023-06-01 복지프로그램 내역이 00건이
						있습니다.</div>


					<form method="POST" action="/neulbom/client/mypage/program.do">
						<div class="row justify-content-center">
							<table class="table" style="">
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
									<c:forEach items="${plist}" var="dto">
										<tr class="tr"
											onclick="location.href='/neulbom/client/mypage/detailprogram.do?prog_seq=${dto.prog_seq}';">
											<td>${dto.prog_seq}</td>
											<td>${dto.prog_date}</td>
											<td style="text-align: justify">${dto.title}</td>
											<td style="text-align: justify">${dto.content}</td>
											<td>${dto.place}</td>
											<td>${dto.apply} / ${dto.people}</td>
											<c:if test="${dto.apply >= dto.people}">
												<td style="font-weight: bold; color: #AAA;">마감</td>
											</c:if>
											<c:if test="${dto.apply < dto.people}">

												<td style="font-weight: bold; color: blue">신청 가능</td>

											</c:if>
										</tr>

										<input type="hidden" name="prog_seq" value=${dto.prog_seq }>
										<input type="hidden" name="id" value="${id }">
										<input type="hidden" name="resi_seq" value="${dto.resi_seq}">

									</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
					<!-- 페이징 -->
					<c:if test="${plist.size() != 0 }">
						<div id="paging" class="pagination justify-content-center"
							style="text-align: center; margin-bottom: 10px;">${pagination}</div>
					</c:if>

					<br> <br> <br> <br> <br>

				</div>
			</div>
		</div>
	</div>

	



	<%@ include file="/WEB-INF/views/inc/footerclient.jsp"%>
</body>
<script>
	function myprogram(resi_seq) {

		location.href = "/neulbom/client/mypage/myprogram.do?resi_seq=${resi_seq}";

	}
	
	
	function toggleDateInputs(selectElement) {
	    const startDateInput = document.getElementsByName('start_date')[0];
	    const endDateInput = document.getElementsByName('end_date')[0];
	    const searchKeywordInput = document.getElementsByName('search_keyword')[0];
	    const separateElement = document.querySelector('.separate');

	    if (selectElement.value === 'date') {
	        startDateInput.style.display = 'inline-block';
	        endDateInput.style.display = 'inline-block';
	        separateElement.style.display = 'inline-block';
	        searchKeywordInput.style.display = 'none';
	    } else {
	        startDateInput.style.display = 'none';
	        endDateInput.style.display = 'none';
	        separateElement.style.display = 'none';
	        searchKeywordInput.style.display = 'inline-block';
	    }
	}
	
	
</script>
</html>