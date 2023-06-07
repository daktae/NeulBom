<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
    taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>늘봄 관리자</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

	#registerProgram {
		position: relative;
		left: 28px;
		background-color: #EE9696;
	}
	
	#registerProgram > span {
		color: #A61123;
	}

	.detailProgram-form,
	.place {
		width: 500px;
		margin-top: 5px;
		margin-bottom: 20px;
	
	}
</style>
</head>
<body>


    <div class="main">
	    <%@ include file="/WEB-INF/views/inc/adSidemenu.jsp" %>
	    <div class="content-box">
	        <div id="inner-box">
	            <div class="semititle">
	                <div class="selected_menu" onclick="location.href='/neulbom/admin/manage/manageProgram.do';">
	                    <span id="selected_menu_text">프로그램 조회</span>
	                </div><!-- selected_menu -->
	            <div class="selected_menu" id="registerProgram" onclick="location.href='/neulbom/admin/manage/registerProgram.do'">
                    <span id="selected_menu_text">프로그램 등록</span>
                </div><!-- selected_menu -->

	            </div><!-- semi_title -->
	            <div class="main-box">
	            
            	<div>제목</div>
				<input type="text" name="title" class="form-control detailProgram-form" placeholder="프로그램 제목을 입력하세요." required maxlength="15">
            	<div>내용</div>
<!-- 				<input type="text" name="content" class="form-control registerProgram-form" placeholder="프로그램 내용을 입력하세요." required maxlength="15"> -->
				<textarea name="content" class="form-control detailProgram-form" maxlength="100" required style="resize: none" placeholder="프로그램 내용을 입력하세요."></textarea>
            	<div>프로그램 날짜</div>
				<input type="date" name="prog_date" id="register-date" class="form-control detailProgram-form" required>
            	
            	<div>강의실</div>
				<select id="place" name="place" class="place form-select">
					<option value="늘봄">늘봄</option>
					<option value="광장">광장</option>
					<option value="늘봄 식당">늘봄 식당</option>
					<option value="늘봄문화홀">늘봄문화홀</option>
				</select>
            	<div>정원</div>
				<input type="number" name="people" class="form-control detailProgram-form" min="1" max="100" value="1" required>
				<input class="btn btn-secondary" type="button" value="돌아가기" onclick="history.back();">
				<input class="btn btn-primary" type="submit" value="등록하기">
				
	
	            </div><!-- main-box -->
	        </div><!-- inner-box -->
	    </div><!-- content-box -->
	</div>

<!-- JavaScript Bundle with Popper -->
<script src="/asset/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>