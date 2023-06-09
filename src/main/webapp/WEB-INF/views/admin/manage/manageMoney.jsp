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
                    <span id="selected_menu_text">재무관리</span>
                </div><!-- selected_menu -->
            </div><!-- semi_title -->
            <div class="main-box">
				  <div class="container">
   					 <canvas id="myChart"></canvas>
  					</div>
            </div><!-- main-box -->
        </div><!-- inner-box -->
    </div><!-- content-box -->
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	var ctx = document.getElementById('myChart');
	
	const colors = ['red','yellow','blue','#c3e6cb','#dc3545','#6c757d'];
	var chBar = document.getElementById("myChart");
	  var chartData = {
	    labels: ["S", "M", "T", "W", "T", "F", "S"],
	    datasets: [{
	    data: [589, 445, 483, 503, 689, 692, 634],
	    backgroundColor: colors[0]
	    },
	    {
	      data: [209, 245, 383, 403, 589, 692, 580],
	      backgroundColor: colors[1]
	    },
	    {
	      data: [489, 135, 483, 290, 189, 603, 600],
	      backgroundColor: colors[2]
	    },
	    {
	      data: [639, 465, 493, 478, 589, 632, 674],
	      backgroundColor: colors[4]
	    }]
	  };
	  var myChart = new Chart(chBar, {
	    // 챠트 종류를 선택
	    type: 'bar',

	    // 챠트를 그릴 데이타
	    data: chartData,

	    // 옵션
	    options: {
	      legend: {
	        display: false
	      }
	    }
	  });
	
</script>
</body>
</html>