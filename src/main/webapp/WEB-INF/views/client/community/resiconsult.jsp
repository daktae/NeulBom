<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>

<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>

<style>

</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	
	  <div id="consult" class="introducetitle" style="background-image: url('/neulbom/asset/mainimage/registwrite.jpg'); background-position: 50% 75%;">입주상담게시판</div>




    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush"">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="/neulbom/client/board/resiconsult.do" class="list-group-item list-group-item-action" style="background-color: #e9ecef;">입주상담게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">문의게시판</a>
                           <a href="#" class="list-group-item list-group-item-action">자유게시판</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">입주상담게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined">
help
</span>
                        > 입주상담게시판 > 입주 문의글
                    </div>
                </div>
            </nav>
            <hr>
            <div style="display: flex; justify-content: end; margin-bottom: 15px;">
                <form class="d-flex" role="search" style="max-width: 50%;">
                    <select class="form-select" aria-label="Default select example" style="margin-right: 10px;" >
                            <option value="title">제목</option>
  <option value="author">작성자</option>
  <option value="date">날짜</option>
                    </select>
        
                    <input class="form-control_wj" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-light" type="submit"
                        style="width:74px !important; height:38px !important;white-space:nowrap;">검색</button>
                </form>
            </div>

            <hr>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th style="text-align: left;">제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${list}">
                    <tr>
                        <td>${dto.con_seq}</td>
                        <td style="text-align: left;">${dto.con_title}</td>
                        <td>${dto.nomem_name }</td>
                        <td>${dto.con_date }</td>
                    </tr>
                </c:forEach>    
                </tbody>
            </table>
             <div style="display: flex; justify-content: flex-end;">
<button type="button" class="btn btn-primary btn-sm" style="width: 100px; height: 40px; margin-right: 10px; font-size: 20px;" onclick="location.href='/neulbom/client/board/unmem.do'">등록하기</button>

</div>
    </div>
        </div>
        
   
   

    <div>
    
  <div class="pagination justify-content-center" style="text-align : center; margin-bottom: 10px;">${pagination}</div>

    </div>
	 
	<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script>

</script>
</body>
</html>