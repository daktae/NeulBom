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
	#pie-chart {
		display: inline-block;
		float: left;
		margin: 20px;
		
		width: 300px; 
		height: 300px;"
	}
	
	#line-chart {
		width: 800px; 
		height: 500px;
		float: left;
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
                    <span id="selected_menu_text">재무관리</span>
                </div><!-- selected_menu -->
            </div><!-- semi_title -->
            
            
            <div class="main-box">
            <table class="table table-striped table-hover table-bordered">
				<tbody>
					<c:forEach items="${latestSpendList}" var="spendDto">
					<tr>
						<th>번호</th>
						<td>${spendDto.rownum }</td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>${spendDto.sdate}</td>
					</tr>
					<tr>
						<th>지출항목</th>
						<td>${spendDto.title}</td>
					</tr>
					<tr>
						<th>분류</th>
						<td>${spendDto.category}</td>
					</tr>
					<tr>
						<th>지출금액</th>
						<td>${spendDto.money}</td>
					</tr>
					</c:forEach>
				</tbody>
				</table>
	
			<div id="pie-chart">
				<canvas id="myChartPie"></canvas>
			</div>
			<div id="line-chart">
				<!--차트가 그려질 부분-->
				<canvas id="myChart"></canvas>
			</div>
					
            </div><!-- main-box -->
        </div><!-- inner-box -->
    </div><!-- content-box -->
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.0/dist/chart.umd.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	var context = document
	.getElementById('myChartPie')
	.getContext('2d');
	var myChartPie = new Chart(context, {
	type: 'pie', // 차트의 형태
	data: { // 차트에 들어갈 데이터
	    labels: [
	        //x 축
	        '실버타운', '요양원'
	    ],
	    datasets: [
	        { //데이터
	            label: '입주자 현황', //차트 제목
	            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
	            data: [
	              	${silverCount}, ${centerCount}
	            ],
	            backgroundColor: [
	                //색상
	/*                       'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)', */
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	            ],
	            borderColor: [
	                //경계선 색상
	/*                       'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)', */
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	            ],
	            borderWidth: 1 //경계선 굵기
	        }
	    ]
	},
	options: {
		    plugins: {
		    	
		    	legend: {
		    		position: 'bottom'
		    	},
		    	
		        title: {
		          display: true,
		          text: '입주자 현황',
		          fullSize: true,
		          
		          font: {
		        	  size: 20
		          }
		        }
		      }  
		  
	}
	});
	
	

	var context = document
      .getElementById('myChart')
      .getContext('2d');
  	
	var myChart = new Chart(context, {
      type: 'bar', // 차트의 형태
      data: { // 차트에 들어갈 데이터
          labels: [
              //x 축
              '1','2','3','4','5','6','7'
          ],
          datasets: [
              { //데이터
                  label: 'test1', //차트 제목
                  fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                  data: [
                      21,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
                  ],
                  backgroundColor: [
                      //색상
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ],
                  borderColor: [
                      //경계선 색상
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'
                  ],
                  borderWidth: 1 //경계선 굵기
              }
          ]
      },
      options: {
          scales: {
              yAxes: [
                  {
                      ticks: {
                          beginAtZero: true
                      }
                  }
              ]
          }
      }
  });
	  

	  
</script>
</body>
</html>