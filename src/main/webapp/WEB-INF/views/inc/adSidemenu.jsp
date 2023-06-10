<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="sidebox">
        <div class="profile">
        	<c:if test="${sessionScope.pic != null}">
				<img class="profile-img" src="/neulbom/asset/pic/${dto.pic}">
			</c:if>
			<c:if test="${sessionScope.pic == null}">
				<img class="profile-img" src="/neulbom/asset/images/user.png">
			</c:if>
            <h1 class="profilename">${sessionScope.name}</h1>
            <c:if test="${sessionScope.lv == '1' }">
	            <div class="profilelevel">계정관리자</div>
            </c:if>
            <c:if test="${sessionScope.lv == '2' }">
	            <div class="profilelevel">사무직원</div>
            </c:if>
            <c:if test="${sessionScope.lv == '3' || sessionScope.lv == '4' }">
	            <div class="profilelevel">실무직원</div>
            </c:if>
        </div>
                <div class="menubox">
                    <div class="menu" id="create_account" onclick="location.href='/neulbom/admin/account/selcate.do';">계정 부여</div>
                    <div class="menu" id="manage_account" onclick="location.href='/neulbom/admin/account/manage.do';">계정 관리</div>
                    <div class="menu" id="find_account" onclick="location.href='/neulbom/admin/account/find.do';">아이디/비밀번호 찾기</div>
                    <div class="menu" id="search_staff" onclick="location.href='/neulbom/admin/account/adminlist.do';">직원 정보 조회</div>
                    <div class="menu" id="staff_salary" onclick="location.href='/neulbom/admin/manage/staffSalary.do';">직원 급여 관리</div>
                    <div class="menu" id="manage_equip" onclick="location.href='/neulbom/admin/manage/manageEquip.do';">비품 관리</div>
                    <div class="menu" id="manage_money" onclick="location.href='/neulbom/admin/manage/manageMoney.do';">재무 관리</div>
                    <div class="menu" id="manage_program" onclick="location.href='/neulbom/admin/manage/manageProgram.do';">복지 프로그램 관리</div>
                    <div class="menu" id="manage_pay" onclick="location.href='/neulbom/admin/manage/pay.do';">결제 관리</div>
                    <div class="menu" id="manage_meet" onclick="location.href='/neulbom/admin/manage/meet.do';">면회 관리</div>
                    <div class="menu" id="manage_alert" onclick="location.href='/neulbom/admin/board/notice.do';">게시판 관리</div>
                    <div class="menu" id="manage_qna_consult" onclick="location.href='/neulbom/admin/manage/qna.do';">문의 및 입주상담 관리</div>
                </div>
                <div class="logout" onclick="location.href='/neulbom/client/account/logout.do';">
                        로그아웃
                </div>
    </div>