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
	border-top-left-radius: 30px;
	border-top-right-radius: 30px;
	border-bottom-left-radius: 30px;
	border-bottom-right-radius: 30px;
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

.notice {
	background-color: rgba(227.37499594688416, 232.89999067783356, 255, 0.75);
}

#notice_txt {
	color: rgba(100.00000163912773, 119.00000050663948, 219.0000021457672, 1);
}

.food {
	background-color: #EE9696;
	opacity: 0.75;
}

#food_txt {
	color: #A61123;
}

.life {
	background-color: #EEEA96;
	opacity: 0.75;
}

#life_txt {
	color: #9D7C25;
}

.free {
	background-color: #ACACA2;
	opacity: 0.75;
}

#free_txt {
	color: #4F4F4F;
}

#selected {
	color: 4F4F4F;
	font-size: 25px;
	position: relative;
	top: 30px;
}

.table {
	position: relative;
	top: 50px;
}
</style>
</head>
<body>

	<div class="main">
		<%@ include file="/WEB-INF/views/inc/adSidemenu.jsp"%>
		<div class="content-box">
			<div id="inner-box">
				<div class="semititle">

					<div class="select_boards notice">
						<span id="notice_txt">공지사항</span>
					</div>
					<div class="select_boards food">
						<span id="food_txt">식단표</span>
					</div>

					<div class="select_boards life">
						<span id="life_txt">생활게시판</span>
					</div>

					<div class="select_boards free">
						<span id="free_txt">자유게시판</span>
					</div>

					<div id="selected">공지사항</div>

					<div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">제목</th>
									<th scope="col">등록일</th>
									<th scope="col">읽음</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td class="span2">Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
								</tr>
								<tr>
									<th scope="row">2</th>
									<td>Jacob</td>
									<td>Thornton</td>
									<td>@fat</td>
								</tr>
								<tr>
									<th scope="row">3</th>
									<td>Larry</td>
									<td>the Bird</td>
									<td>@twitter</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- semi_title -->
				<div class="main-box"></div>
				<!-- main-box -->
			</div>
			<!-- inner-box -->
		</div>
		<!-- content-box -->
	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script>
		
	</script>
</body>
</html>