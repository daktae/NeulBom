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
	#addemp, #addresi {
		display: flex;
		padding: 30px;
	}
	#input-list {
		margin-top: 2rem;
	}
	#inner-list {
		position: relative;
		margin-top: 50px;
		margin-left: 5px;
	}
	.add-info {
		color: #999;
		margin-left: 10px;
		border-radius: 5px;
		border-style: none;
		height: 40px;
	}
	#lev-sel {
		margin-left: 10px;
		margin-top: 5px;
	}
	#photo-section {
		position: relative;
		text-align: center;
		margin-left: 20px;
		padding: 20px;
		background-color: white;
		height: 360px;
		top: 45px;
		
	}
	#preview {
		width: 250px;
		height: 250px;
	}
	#add-cate {
		font-size: 20px;
		font-weight: bold;
	}
	.main-box {
		background-color: rgba(221, 236, 227, 1);
		padding-top: 20px;
		padding-bottom: 20px;
		padding-left: 50px;
		padding-right: 50px;
		border-radius: 15px;
		height: 520px;
		
	}
	.detail{
		width: 600px;
		margin-left: 10px;
		border-radius: 5px;
		border-style: none;
		height: 120px;
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
	                    <span id="selected_menu_text">아이디 찾기</span>
	                </div><!-- selected_menu -->
	                
	            </div><!-- semi_title -->
	            <div class="main-box">
	                <form method="POST" action="/neulbom/admin/account/findid.do" enctype="multipart/form-data">
						<div id="addresi">
	                		<div class="emp-box">
	                			<select class="form-select" aria-label="Default select example">
								  <option value="1" selected>직원</option>
								  <option value="2">입주자</option>
								</select>
								<div id="inner-list">
									<span id="add-cate">이름:</span><input type="text" placeholder="이름" class="add-info" id="name" name="name">			
								</div>
								<div id="inner-list">
									<span id="add-cate">주민번호:</span><input type="text" placeholder="주민번호"class="add-info" id="email" name="email">			
								</div>
								<div id="inner-list">
									<span id="add-cate">이메일:</span><input type="text" placeholder="이메일" class="add-info" id="email" name="email">			
								</div>
								<div id="inner-list">
									<button class="btn btn-primary" type="submit" style="margin-left: 20px;">찾기</button>
								</div>
							</div>
						</div>
	            	</form>
	       	 	</div>
	    	</div>
		</div>
	</div>	

<!-- JavaScript Bundle with Popper -->
<script src="/neulbom/asset/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>