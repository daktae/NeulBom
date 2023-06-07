<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
    taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>늘봄 관리자</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
.select_boards {
	width: 183px;
	height: 47px;
	position: relative;
	border-radius: 30px;
	text-align: center;
	justify-content: center;
	display: inline-block;
	padding-top: 7px;
	margin-right: 28px;
}

.select_boards>span {
	width: 144px;
	height: 31px;
	font-size: 24px;
	letter-spacing: 0;
}

.meet {
	background-color: rgba(227.37499594688416, 232.89999067783356, 255, 0.75);
}

#meet_txt {
	color: rgba(100.00000163912773, 119.00000050663948, 219.0000021457672, 1);
}

.meet_calendar {
	background-color: #EE9696;
	opacity: 0.75;
}

.meet_calendar>span {
	color: #A61123;
}

.confirm {
	background-color: rgba(39, 174, 96, 0.2);
	border-radius: 30px;
	width: 72px;
	height: 30px;
}

#confirm_txt {
	position: relative;
	top: 3px;
	color: #27AE60;
}

.reject {
	background-color: rgba(235, 87, 87, 0.2);
	border-radius: 30px;
	width: 72px;
	height: 30px;
}

#reject_txt {
	position: relative;
	top: 3px;
	color: #EB5757;
}

.table tbody tr td:nth-child(8) {
	display: flex;
	justify-content: space-evenly;
}
</style>
</head>
<body>


	<div class="main">
		<%@ include file="/WEB-INF/views/inc/adSidemenu.jsp"%>
		<div class="content-box">
			<div id="inner-box">
				<div class="semititle">

					<div class="select_boards meet movable"
						onclick="location.href='/neulbom/admin/manage/meet.do';">
						<span id="meet_txt">면회 관리</span>
					</div>
					<div class="select_boards meet_calendar movable"
						onclick="location.href='/neulbom/admin/manage/calendar.do';">
						<span>달력 보기</span>
					</div>

				</div>
				<!-- semi_title -->

				<div class="main-box">

					<table class="table table-striped">
						<colgroup>
							<col width=10%>
							<col width=12%>
							<col width=10%>
							<col width=10%>
							<col width=10%>
							<col width=10%>
							<col width=10%>
							<col width=18%>
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">면회 날짜</th>
								<th scope="col">면회 시간</th>
								<th scope="col">입주자 번호</th>
								<th scope="col">입주자 이름</th>
								<th scope="col">보호자 번호</th>
								<th scope="col">보호자 이름</th>
								<th scope="col">처리</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="dto">
								<tr>
									<td>${dto.displayed_seq}</td>
									<td>${dto.meet_date}</td>
									<td>${dto.meet_time}</td>
									<td>${dto.resi_seq}</td>
									<td>${dto.rname}</td>
									<td>${dto.protect_seq}</td>
									<td>${dto.pname}</td>
									<td><c:if test="${empty dto.confirmation}">

											<div class="confirm movable" id="confirm"
												data-bs-toggle="modal" data-bs-target="#delEquipModal"
												onclick="setSeq(${eqDto.eq_seq });">
												<span id="confirm_txt">승인</span>
											</div>
											<div class="reject movable" id="reject"
												onclick="location.href='/neulbom/admin/board/meetrejection.do?seq=${dto.meet_seq}'">
												<span id="reject_txt">반려</span>
											</div>
										</c:if> <c:if test="${not empty dto.confirmation}">

											<c:if test="${dto.confirmation eq 'y'}">
												<div class="back">
													<span id="back_txt">승인</span>
												</div>
											</c:if>

											<c:if test="${dto.confirmation eq 'n'}">
												<div class="back">
													<span id="back_txt">반려</span>
												</div>
											</c:if>
										</c:if></td>


								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- Modal -->
					<div class="modal fade" id="delEquipModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-5" id="exampleModalLabel">면회 승인</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">면회를 승인하시겠습니까?</div>
								<div class="modal-footer">
									<form method="GET" action="/neulbom/admin/manage/delEquip.do">
										<input type="submit" class="btn confirm" value="승인"
											onclick="location.href='/neulbom/admin/manage/delEquip.do'">
										<input type="button" class="btn back"
											data-bs-dismiss="modal" value="취소"> <input
											type="hidden" name="eq_seq">
									</form>
								</div>
							</div>
						</div>
					</div>


				</div>
				<!-- main-box -->
			</div>
			<!-- inner-box -->
		</div>
		<!-- content-box -->
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script>
	
	
	function setSeq(eq_seq) {
		$('input[name=eq_seq]').val(eq_seq);
	}
	
	</script>
</body>
</html>