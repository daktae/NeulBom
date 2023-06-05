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
	
	    <div class="introducetitle">커뮤니티</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">문의 게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">자유 게시판</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">문의 게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 문의 게시판
                    </div>
                </div>
            </nav>
            <hr>
            <div style="display: flex; justify-content: end; margin-bottom: 15px;">
                <form class="d-flex" role="search" style="max-width: 50%;">
                    <select class="form-select" aria-label="Default select example" style="margin-right: 10px;">
                        <option selected>제목</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
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
                        <th>제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
				    <c:forEach items="${list}" var="dto">
				        <tr class="qna-row" data-qna-seq="${dto.qna_seq}">
				            <td>${dto.qna_seq}</td> <!-- qna_seq -->
				            <td style="text-align: left;">${dto.title}</td> <!-- title -->
				            <td>${dto.fname}</td> <!-- fname -->
				            <td>${dto.qna_date}</td> <!-- qna_date -->
				            <td>${dto.read}</td> <!-- read -->
				        </tr>
				    </c:forEach>
				</tbody>
            </table>
        </div>
        
    </div>
	   
	<form action="http://localhost:8090/neulbom/client/board/qnaregist.do" style="text-align: right; margin-top: 50px; margin-bottom: 50px; margin-right: 300px;">
	  	<button type="submit" class="btn btn-primary">등록하기</button>
	</form>
    
    <nav aria-label="Page navigation example ">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
	 
	<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script>

	const trElements = document.querySelectorAll('.qna-row');
	trElements.forEach(tr => {
	    tr.addEventListener('click', () => {
	        const qnaSeq = tr.querySelector('td:first-child').innerText;
	        if (qnaSeq) {
	            const link = `http://localhost:8090/neulbom/client/board/qnaregist.do?qna_seq=${qnaSeq}`;
	            window.location.href = link; // 링크로 이동
	        }
	    });
	});

</script>
</body>
</html>