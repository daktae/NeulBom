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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<link rel="stylesheet" type="text/css"
	href="https://npmcdn.com/flatpickr/dist/themes/material_blue.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
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

.back {
	background-color: rgba(105, 105, 105, 0.2);
	border-radius: 30px;
	width: 72px;
	height: 30px;
}

#back_txt {
	position: relative;
	top: 3px;
	color: #474747;
}

.table tbody tr td:nth-child(8) {
	display: flex;
	justify-content: space-evenly;
}

#buttons {
	float: right;
	display: flex;
	text-align: center;
	margin-bottom: 10px;
	margin-right: 5px;
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


					<input id="meet" pattern="\d{6}" placeholder="" required
						th:field="*{birth}" type="text" name="pssn1"
						oninput="convertDateFormat(event)"
						style="width: 100px !important;">


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
	
	 var fp = flatpickr(document.getElementById("meet"), {
	       'monthSelectorType' : 'dropdown',
	       "locale": "ko" 
	    });
		
	</script>


</body>
</html>