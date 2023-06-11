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
	.main-box {
		background-color: rgba(221, 236, 227, 1);
		padding-left: 50px;
		padding-right: 50px;
		border-radius: 15px;
		width: 900px;
		height: 520px;
		display: block;
		text-align: center;
		
	}
	#inner-header {
		height: 300px;
	}
	#inner-content {
		display:flex;
		justify-content: space-around;
		padding: 20px;
	}
	#inner-menu {
		background-color: white;
		width: 150px;
		height: 100px;
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
					<div id="inner-header">
						<h1>관리자</h1>
						<div id="inner-content">
							<div id="inner-menu" onclick="location.href='/neulbom/admin/account/searchadid.do'">관리자 아이디 찾기</div>
							<div id="inner-menu" onclick="location.href='/neulbom/admin/account/searchadpw.do'">관리자 비밀번호 찾기</div>
						</div>
					</div>
					<div id="inner-header">
						<h1>입주자</h1>
						<div id="inner-content">
							<div id="inner-menu" onclick="location.href='/neulbom/admin/account/searchreid.do'">입주자 아이디 찾기</div>
							<div id="inner-menu" onclick="location.href='/neulbom/admin/account/searchrepw.do'">입주자 비밀번호 찾기</div>
						</div>
					</div>
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