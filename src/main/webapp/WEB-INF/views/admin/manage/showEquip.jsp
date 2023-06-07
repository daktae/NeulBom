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
	#showEquip {
		position: relative;
		left: 28px;
		background-color: #EE9696;
	}
	
	#showEquip > span {
		color: #A61123;
	}
	
	#registerEquip {
		position: relative;
		left: 56px;
		background-color: #EEEA96;
	}
	
	#registerEquip > span {
		color: #4F4F4F;
	}
	
	thead {
		text-align: center;
	}
	
	table{
		position:relative;
		top: 50px;
	}
	
	table td {
		text-align: center;
	}
	
	.table tbody tr td:nth-child(4) {
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
                <div class="selected_menu" id="manageEquip" onclick="location.href='/neulbom/admin/manage/manageEquip.do'">
                    <span id="selected_menu_text">비품신청내역</span>
                </div><!-- selected_menu -->
                <div class="selected_menu" id="showEquip" onclick="location.href='/neulbom/admin/manage/showEquip.do'">
                    <span id="selected_menu_text">비품현황</span>
                </div><!-- selected_menu -->
                <div class="selected_menu" id="registerEquip" onclick="location.href='/neulbom/admin/manage/registerEquip.do'">
                    <span id="selected_menu_text">비품등록</span>
                </div><!-- selected_menu -->
            </div><!-- semi_title -->
            <div class="main-box">
          	<table class="table table-striped table-bordered table-hover">
				<colgroup>
					<col width=10%>
					<col width=60%>
					<col width=10%>
					<col width=20%>
				</colgroup>
				<thead>
					<tr>
						<th scope="col">비품번호</th>
						<th scope="col">비품명</th>
						<th scope="col">수량</th>
						<th scope="col"'>처리</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${eqList}" var="eqDto">
					<tr>
						<td>${eqDto.eq_seq }</td>
						<td>${eqDto.name}</td>
						<td>${eqDto.quantity }</td>
						<td>
            				<div class="edit movable">
            					<span id="edit_txt">수정</span>
            				</div>
            				<div class="delete movable"  data-bs-toggle="modal" data-bs-target="#delEquipModal" onclick="setSeq(${eqDto.eq_seq });">
            					<span id="delete_txt">삭제</span>
            				</div>
            			</td>
					</tr>
				</c:forEach>
				</tbody>
				</table>
					<!-- Modal -->
<div class="modal fade" id="delEquipModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">경고!</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        해당 비품을 정말 삭제하시겠습니까?
      </div>
      <div class="modal-footer">
      <form method="GET" action="/neulbom/admin/manage/delEquip.do">
        <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="취소">
        <input type="submit" class="btn btn-primary" value="삭제" onclick="location.href='/neulbom/admin/manage/delEquip.do'">
        <input type="hidden" name="eq_seq">
        </form>
      </div>
    </div>
  </div>
</div>
            </div><!-- main-box -->
        </div><!-- inner-box -->
    </div><!-- content-box -->
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	function setSeq(eq_seq) {
		$('input[name=eq_seq]').val(eq_seq);
	}
</script>
</body>
</html>