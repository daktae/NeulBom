<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/inc/assetclient.jsp"%>

<link rel="stylesheet" href="/neulbom/asset/css/mypage.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp"%>



	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="sidebox">
					<div class="profile">
						<img src="/html/images/01.jpg" id="profileimg">
						<h1 class="profilename">'${name}'님</h1>
						<h1 class="profilename_id">(${id})</h1>
						<!-- <div class="profilelevel">계정 관리자</div> -->
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
						<div class="menu" id="staff_salary">
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


			<c:choose>
				<c:when test="${lv eq '6'}">
					<div class="col-md-9">
						<div class="box">
							<div class="title">내정보</div>
							<hr>
							<div class="row justify-content-center">
								<table class="table">
									<tr>
										<th scope="row">
											<div class="subtitle">보호자 아이디:</div>
										</th>
										<td>
											<div class="content">${dto.pro_id}</div>
										</td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">이름:</div>
										</th>
										<td><div class="content">${dto.pro_name}</div></td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">생년월일:</div>
										</th>
										<td>
											<div class="content">${dto.pro_ssn.substring(0, 4)}년
												${dto.pro_ssn.substring(4, 6)}월 ${dto.pro_ssn.substring(6, 8)}일</div>
										</td>

									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">전화번호:</div>
										</th>
										<td><div class="content">${dto.pro_tel}</div></td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">이메일:</div>
										</th>
										<td><div class="content">${dto.pro_email}</div></td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">입주자와의 관계:</div>
										</th>
										<td><div class="content">${dto.pro_relation}</div></td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">입주자 아이디:</div>
										</th>
										<td><div class="content">${dto.resi_id}</div></td>
									</tr>
								</table>
								<hr>
								<br>
								<!-- <div class="d-grid gap-2 col-6 mx-auto">
                            <button class="btn btn-outline-primary" type="button">회원정보수정</button>
                        </div> -->
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${lv eq '5'}">
					<div class="col-md-9">
						<div class="box">
							<div class="title">내정보</div>
							<hr>
							<div class="row justify-content-center">
								<table class="table">
									<tr>
										<th scope="row">
											<div class="subtitle">입주자 아이디:</div>
										</th>
										<td>
											<div class="content">${dto.resi_id}</div>
										</td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">이름:</div>
										</th>
										<td><div class="content">${dto.resi_name}</div></td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">생년월일:</div>
										</th>
										<td>
											<div class="content">${dto.resi_ssn.substring(0, 4)}년
												${dto.resi_ssn.substring(4, 6)}월 ${dto.resi_ssn.substring(6, 8)}일</div>
										</td>

									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">전화번호:</div>
										</th>
										<td><div class="content">${dto.resi_tel}</div></td>
									</tr>
									<tr>
										<th scope="row">
											<div class="subtitle">이메일:</div>
										</th>
										<td><div class="content">${dto.resi_email}</div></td>
									</tr>

									<tr>
										<th scope="row">
											<div class="subtitle">주소:</div>
										</th>
										<td><div class="content">${dto.resi_address}</div></td>
									</tr>
								</table>
								<hr>
								<br>
								<!-- <div class="d-grid gap-2 col-6 mx-auto">
                            <button class="btn btn-outline-primary" type="button">회원정보수정</button>
                        </div> -->
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>



	<%@ include file="/WEB-INF/views/inc/footerclient.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script>
		
	</script>
</body>
</html>
