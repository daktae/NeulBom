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

   .edit {
      width: 120px;
   }

   .table tbody tr td:nth-child(7) {
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
                   <div class="selected_menu">
                       <span id="selected_menu_text">직원급여관리</span>
                   </div><!-- selected_menu -->
                   <select class="select_search_item">
                       <option>이름</option>
                       <option>부서</option>
                   </select><!-- select_search_item -->
                   <input type="text" class="search_input" placeholder="조회할 직원 정보를 입력하세요.">
                  <input class="btn btn-primary search_button" type="button" value="검색하기">
               
               </div><!-- semi_title -->
               <div class="main-box">
            <table class="table table-striped table-bordered table-hover">
            <colgroup>
               <col width=5%>
               <col width=10%>
               <col width=10%>
               <col width=20%>
               <col width=20%>
               <col width=20%>
               <col width=15%>
            </colgroup>
            <thead>
               <tr>
                  <th scope="col">사번</th>
                  <th scope="col">이름</th>
                  <th scope="col">입금은행</th>
                  <th scope="col">계좌번호</th>
                  <th scope="col">급여(원)</th>
                  <th scope="col">연락처</th>
                  <th scope="col">처리</th>
               </tr>
            </thead>
            <tbody>
            <c:forEach items="${salaryList}" var="salaryDto">
               <tr>
                  <td>${salaryDto.admin_seq }</td>
                  <td>${salaryDto.name}</td>
                  <td>${salaryDto.bank }</td>
                  <td>${salaryDto.bank_account }</td>
                  <td>${salaryDto.salary }</td>
                  <td>${salaryDto.tel }</td>
                  <td>
                     <div class="edit movable" onclick="location.href='/neulbom/admin/manage/editBankAccount.do?admin_seq=${salaryDto.admin_seq}';" >
                        <span id="edit_txt">계좌 정보 수정</span>
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
<script src="/asset/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>