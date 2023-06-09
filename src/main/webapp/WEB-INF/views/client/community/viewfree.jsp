<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>늘봄 > 커뮤니티 > 자유게시판 > 글 조회</title>
   <%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>
   
<style>

.introducetitle {
	background-image: url("/neulbom/asset/image/자유게시판 사진.jpg")

}
.content_wj {
	padding: 10px 40px;
	text-align: justify;
}

.btn, .btn-primary, .btn-sm {

	width:100px; 
	height:40px; 
	margin-right:10px; 
	font-size: 20px; 
	float:left;

}

.session {
	float: right;
	background-color: #AAA;
	border: 1px solid #AAA;
}

#addcomment {
	border: 1px solid #AAA;
	width: 100%;
	height: 30px;
	margin-bottom: 40px;
}

.full {
	float: left;
	width: 90%;
	height: 40px;
	margin: 10px;
	border: 1px solid #AAA;
}


#comname {
	display: inline-block;	
	float: left;
	font-weight: bold;
}

#comcontent {
	display: inline-block;
	width: 100%;
}

#comment {
	border: 1px solid #AAA;
	width: 100%;
	margin: 30px auto;
	padding: 100px;
}

.comment {
	background-color: #DFDFDF;
	font-weight: bold;
	border: none;
	height: 40px;
	width: 100px;
	border-radius: 10%;
}

#regicom {
	width: 150px;
	padding: auto 10px;
}

#eotrmf {
	width: 70px;
	font-weight: bold;
	padding: auto 0;
}

.del, .edit {
	width: 100px;
	height: 40px;
	font-size: 18px;
	border: 1px solid #AAA;
	background-color: #AAA;
	float: right;
}




</style>
</head>
<body>
   <!-- viewsfree.jsp >  -->
   <%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
    <div class="introducetitle">커뮤니티</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">문의게시판</a>
                    <a href="/neulbom/client/community/free.do" class="list-group-item list-group-item-action">자유게시판</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">자유게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 자유게시판
                    </div>
                </div>
            </nav>
            <hr>
            <table class="table table-bordered table-hover content-head_wj">
                <thead>
                    <tr>
                      <th>${dto.free_seq }</th>
                      <th style="text-align: left;">${dto.title }</th>
                      <th>${dto.name }</th>
                      <th>${dto.free_date }</th>
                      <th>${dto.read }</th>
                    </tr>
                </thead>
            </table>
            <div><img src="/neulbom/asset/pic/${dto.file}"></div>
            <div class="content_wj">${dto.content }</div>
            <hr>
            
            <!-- 댓글 불러오기 -->
            <table id="comment">
            	<c:forEach var="cdto" items="${clist }">
            	<tr>
            		<td>
            			<div class="comment-content">
            				<%-- <div class="comment-regdate">${cdto.regdate }</div> --%>
            			</div>
            		</td>
            		<td>
            			<div>
            				<div id="comname">${cdto.name }</div>
            				<div style="width: 500px"><c:out value="${cdto.content }" /></div>
            			<c:if test="${not empty id && (id == cdto.id)}">
            			<div>
            				<input type="button" class="del" value="삭제" onclick="delComment(${cdto.free_seq});">
            				<input type="button" class="edit" value="수정" onclick="editComment(${cdto.free_seq});">
            			</div>
            			</c:if>
            			</div>
            		</td>
            	</tr>
            	</c:forEach>
            </table>
            
            
            <!-- 댓글 작성 -->
            <c:if test="${not empty id }">
            <form method="POST" action="/neulbom/client/community/comment.do">
            
            <table id="addcomment">
            	<tr>
            		<td id="eotrmf">댓글</td>
					<td><input type="text" name="content" class="full" required style="width: 100%"></td>
					<td id="regicom">
						<button type="submit" class="comment" onclick="location.href='/neulbom/client/community/viewfree.do?free_seq=${dto.free_seq}';">등록</button>
					</td>
				</tr>
            </table>
            <input type="hidden" name="free_seq" value="${dto.free_seq }">
            
            
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 삭제</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ...
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>
            
            <c:forEach var="cdto" items="${clist }">
            <input type="hidden" name="resi_seq" value="${cdto.resi_seq }">
            <input type="hidden" name="protect_seq" value="${cdto.protect_seq }">
            </c:forEach>
            </form>
           
            </c:if>
            
            
            <button type="button" class="btn btn-primary btn-sm" onclick="location.href='/neulbom/client/community/free.do';">돌아가기</button>
            <c:if test="${not empty id && (id != dto.id)}">
            <button type="button" class="btn btn-primary btn-sm" 
            onclick="location.href='/client/community/addfree.do?mode=reply&thread=${dto.thread}&depth=${dto.depth }';">답변하기</button>
            </c:if>
            
            <c:if test="${not empty id && (id == dto.id)}">
            <div>
			<button type="button" class="btn del" onclick="delfree()">삭제하기</button>
           	<button type="button" class="btn edit" onclick="location.href='/neulbom/client/community/editfree.do?free_seq=${dto.free_seq}';">수정하기</button>
        	</div>
        	</c:if>

        </div>
        
        
    </div>
    
    <form id="editCommentForm" method="POST" action="/client/board/editcomment.do">
		<input type="hidden" name="free_seq">
		<input type="hidden" name="comment_seq">
		<input type="hidden" name="content">
	</form>
	
	<form id="editfree" method="GET" action="/neulbom/client/community/editfree.do">
		<input type="hidden" name="free_seq" value="${dto.free_seq}">
		<input type="hidden" name="content" value="${dto.content}">
	</form>
	
	
        
        



        <%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	//글 삭제
	function delfree() {
		alert();
		
		if (confirm('작성하신 글을 삭제하시겠습니까?')) {
			location.href='/neulbom/client/community/delfree.do?seq=' + ${dto.free_seq};
		}
		
	}
	
	
	
	
	

	function editComment(comment_seq) {
		
		//이전 수정중인 댓글 폼 > 전부 삭제
		$('.edit-comment').remove();
		
		const content = $(event.target).closest('tr').find('.comment-content').children().eq(0).text();
		
		$(event.target).closest('tr').after(
			`
				<tr style="background-color: #EFEFEF;" class="edit-comment">
					<td><input type="text" class="full" value="\${content}" id="editcomment"></td>
					<td>
						<input type="button" value="확인" onclick="editOkComment(\${cseq});">
						<input type="button" value="취소" onclick="cancleComment();">
					</td>
				</tr>
			`	
		);
	}
	
	function cancleComment() {
		
		$(event.target).closest('tr').remove();
	}
	
	function editOkComment(comment_seq) {
		
		//돌아올 부모 글번호
		//수정할 댓글 번호
		//수정할 댓글 내용
		
		
		/* $('#editCommentForm input[name=bseq]').val(${dto.free_seq}); */
		$('#editCommentForm input[name=comment_seq]').val(comment_seq);
		$('#editCommentForm input[name=content]').val($('#editcomment').val());
		
		$('#editCommentForm').submit();
		
	}
	
	function delComment(comment_seq) {
		
		location.href='/neulbom/client/commentfree.do?free_seq=' + ${dto.free_seq} '&comment_seq=' + comment_seq;
		
		
		
	}
	
	

</script>
</body>
</html>




