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
	

	.table tbody tr td:nth-child(1), 
	.table tbody tr td:nth-child(3), 
	.table tbody tr td:nth-child(4),
	.table tbody tr td:nth-child(5) {
	text-align: center;
}

.table tbody tr td {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.table tbody tr td:nth-child(6) {
	display: flex;
	justify-content: space-evenly;
}


</style>
</head>
<body>


   <div class="main">
    <%@ include file="/WEB-INF/views/inc/adSidemenu.jsp" %>
    <div class="content-box">
        <div id="inner-box">
            <div class="semititle">
                <div class="selected_menu" onclick="location.href='/neulbom/admin/manage/manageProgram.do'">
                    <span id="selected_menu_text">프로그램 조회</span>
                </div><!-- selected_menu -->
                <div class="selected_menu" id="registerProgram" onclick="location.href='/neulbom/admin/manage/registerProgram.do'">
                    <span id="selected_menu_text">프로그램 등록</span>
                </div><!-- selected_menu -->

             	</div><!-- semi_title -->
            <div class="main-box">
            <table class="table table-striped table-hover table-bordered" style="table-layout: fixed">
            <colgroup>
				<col width=15%>
				<col width=25%>
				<col width=35%>
				<col width=10%>
				<col width=5%>
				<col width=20%>
			</colgroup>
            <thead>
            	<tr>	
            		<th>날짜</th>
            		<th>제목</th>
            		<th>내용</th>
            		<th>장소</th>
            		<th>정원</th>
            		<th>처리</th>
            	</tr>
            </thead>
            <tbody>
            	<c:forEach items="${progList}" var="progDto">
            	<tr>
            		<td>${progDto.prog_date }</td>
            		<td>${progDto.title}</td>
            		<td>${progDto.content }</td>
            		<td>${progDto.place }</td>
            		<td>${progDto.people }</td>
            		<td>
            			<div class="edit">
            				<span id="edit_txt">수정</span>
            			</div>
            			<div class="delete">
            				<span id="delete_txt">삭제</span>
            			</div>
            		</td>
            	</tr>
            	</c:forEach>
            </tbody>
            </table>

            </div><!-- main-box -->
        </div><!-- inner-box -->
    </div><!-- content-box -->
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>