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
                
                <!-- <form method="GET" action="/neulbom/admin/manage/staffsalary.do"> -->
                <select class="select_search_item">
                    <option>이름</option>
                    <option>부서</option>
                </select><!-- select_search_item -->
                <input type="text" class="search_input" value="조회할 직원 정보">
                <!-- </form> -->
                
            </div><!-- semi_title -->
            <div class="main-box">
				<table>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>부서</th>
					<th>은행</th>
					<th>계좌번호</th>
					<th>급여(원)</th>
					<th>이번달 지급여부</th>
				</tr>
				<tr>
					<td>1</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>2</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>3</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>4</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>5</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>6</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>7</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>8</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>9</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				<tr>
					<td>10</td>
					<td>오소엽</td>
					<td>계정관리</td>
					<td>우리은행</td>
					<td>1002-452-948604</td>
					<td>5000000</td>
					<td>N</td>
				</tr>
				</table>
            </div><!-- main-box -->
        </div><!-- inner-box -->
    </div><!-- content-box -->
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>