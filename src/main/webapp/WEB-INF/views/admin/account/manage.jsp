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
		top: 60px;
	}
	#accountcate {
		background-color: cornflowerblue;
	}
	.hidden {
		display:none;
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
	                    <span id="selected_menu_text" style="font-size: 19px; padding-top:4px;">계정 관리</span>
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
						
						
					</h1>
					<button id="showAdminList">관리자 목록</button>
  					<button id="showResidentList">입주자 목록</button>
					<div id="alist">
						<table id="list" class="table" style="text-align:center;">
							<tr>
								<th style="width: 15%;">번호</th>
								<th style="width: 20%;">이름</th>
								<th style="width: 25%;">아이디</th>
								<th style="width: 25%;">비밀번호</th>
								<th style="width: auto;">삭제</th>
							</tr>
							<c:if test="${alist.size() == 0}">
							<tr>
								<td colspan="5">게시물이 없습니다.</td>
							</tr>	
							</c:if>
							<c:forEach items="${alist}" var="adto">
							<tr>
								<td>
									${adto.admin_seq}
								</td>
								<td>
									${adto.name}
								</td>
								<td>${adto.id}</td>
								<td>${adto.pw}</td>
								<td style="display:flex; justify-content: center;">
									<div class="delete movable" style="text-align: center;" onclick="location.href='/neulbom/admin/account/deladmin.do?admin_seq=${adto.admin_seq}';">
										<span id="delete_txt">삭제</span>
									</div>		
								</td>
							</tr>
							</c:forEach>
						</table>
						<form id="searchForm" action="/neulbom/admin/account/manage.do" method="GET">
							<select name="column">
								<option value="name">이름</option>
							</select>
							<input type="text" name="word" class="long" required>
							<input type="submit" value="검색하기">
						</form>
					</div>
					<div id="rlist" class="hidden">
						<table id="list" class="table" style="text-align:center;">
							<tr>
								<th style="width: 15%;">번호</th>
								<th style="width: 20%;">이름</th>
								<th style="width: 25%;">아이디</th>
								<th style="width: 25%;">비밀번호</th>
								<th style="width: auto;">삭제</th>
							</tr>
							<c:if test="${rlist.size() == 0}">
							<tr>
								<td colspan="5">게시물이 없습니다.</td>
							</tr>	
							</c:if>
							<c:forEach items="${rlist}" var="rdto">
							<tr>
								<td>
									${rdto.resi_seq}
								</td>
								<td>
									${rdto.name}
								</td>
								<td>${rdto.id}</td>
								<td>${rdto.pw}</td>
								<td style="display:flex; justify-content: center;"> 
									<div class="delete movable" style="text-align: center;">
										<span id="delete_txt" onclick="location.href='/neulbom/admin/account/delresi.do?resi_seq=${rdto.resi_seq}';">삭제</span>
									</div>		
								</td>
							</tr>
							</c:forEach>
						</table>
						<form id="searchForm" action="/neulbom/admin/account/manage.do" method="GET">
							<select name="column">
								<option value="name" id="rname">이름</option>
							</select>
							<input type="text" name="word" class="long" required>
							<input type="submit" value="검색하기">
						</form>
					</div>
				</div>
					<!-- <form method="GET"> 사용 사례 -->
		
	            </div><!-- main-box -->
	        </div><!-- inner-box -->
	    </div><!-- content-box -->

<!-- JavaScript Bundle with Popper -->
<script src="/asset/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
	    // 관리자 목록 보여주는 버튼 클릭 시
	    $("#showAdminList").click(function() {
	      $("#alist").removeClass("hidden"); // 관리자 목록 표시
	      $("#rlist").addClass("hidden"); // 입주자 목록 감춤
	    });
	
	    // 입주자 목록 보여주는 버튼 클릭 시
	    $("#showResidentList").click(function() {
	      $("#alist").addClass("hidden"); // 관리자 목록 감춤
	      $("#rlist").removeClass("hidden"); // 입주자 목록 표시
	    });
	
	});
</script>
</body>
</html>