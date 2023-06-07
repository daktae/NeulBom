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
	#searchForm {
		position: relative;
		margin-bottom: 15px;
		text-align: center;
		top: 100px;
	}
</style>
</head>
<body>


    <div class="main">	
	    <%@ include file="/WEB-INF/views/inc/adSidemenu.jsp" %>
	    <div class="content-box">
	        <div id="inner-box">
	            <div class="semititle">
	                <div class="selected_menu">
	                    <span id="selected_menu_text" style="font-size: 19px; padding-top:4px;">아이디/비밀번호 찾기</span>
	                </div><!-- selected_menu -->
	            </div><!-- semi_title -->
	            <div class="main-box">
					<h1 class="sub">
						계정 
						<c:if test="${map.search == 'n'}">
						<small>목록</small>
						</c:if>
						<c:if test="${map.search == 'y'}">
						<small>검색</small>
						</c:if>
						
						<%-- 
						<span id="pagebar" style="float: right;margin-top:-5px;">
							<input type="number" id="page" class="short" min="1" max="${totalPage}" value="${nowPage}">
							<input type="button" value="이동" onclick="location.href='/toy/board/board.do?page=' + $('#page').val() + '&column=${map.column}&word=${map.word}';">
						</span> 
						--%>
						
						
						
						<span id="pagebar" style="float: right;">
							<select onchange="location.href='/neulbom/admin/account/manage.do?page=' + $(this).val() + '&column=${map.column}&word=${map.word}';">
								<c:forEach var="i" begin="1" end="${totalPage}">
								<option value="${i}" <c:if test="${i == nowPage}">selected</c:if>>${i}페이지</option>
								</c:forEach>
							</select>
						</span>
						
					</h1>
					
					<div>
					<table id="list" class="table">
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>아이디</th>
							<th>비밀번호</th>
						</tr>
						<c:if test="${list.size() == 0}">
						<tr>
							<td colspan="5">게시물이 없습니다.</td>
						</tr>	
						</c:if>
						<c:forEach items="${list}" var="dto">
						<tr>
							<th>
								${dto.admin_seq}
							</th>
							<th>
								${dto.name}
							</th>
							<th>${dto.id}</th>
							<th>${dto.pw}</th>
						</tr>
						</c:forEach>
					</table>
					</div>
					
					
					<!-- <form method="GET"> 사용 사례 -->
					<form id="searchForm" action="/neulbom/admin/account/manage.do" method="GET">
						<select name="column">
							<option value="name">이름</option>
							<option value="subject">아이디</option>
						</select>
						<input type="text" name="word" class="long" required>
						<input type="submit" value="검색하기">
					</form>
		
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