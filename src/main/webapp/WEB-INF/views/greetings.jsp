<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    html,body {
        margin: 0px;
        padding: 0px;
    }

    body {
        overflow-x: hidden;
    }

    .introducetitle {
        width: 100vw;
        height: 162px;
        background: url(../늘봄.jpg);
        color: #ffffff; 
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        padding: 10px;
        text-align: center;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 3rem;
        margin-bottom: 50px;
    }

    .mainmenu {
        display: flex;
        width: auto;
        margin-left: 150px;
        margin-right: 150px;
    }

    .sidebar {
        float: left;
        margin-right: 50px;
        width: 200px; 
        height: 165px;
        top: 155px; 
        left:10px; 
        border:1px solid #A6AEB7;
    }
    
    .introducemenu tr {
        border-bottom: 1px solid black;
    }

    .introducemenu th {
        background-color: #ccc;
    }

    #deepmenu {
        float: right;
        width: 80%;
        clear: right;
    }

    .mini-menu {
        margin-top: 50px;
        margin-left: 590px;
    }

    .highmenu {
        display: flex;
        justify-content: space-between;
        border-bottom: 1px solid #ccc;
        margin-bottom: 10px;    
    }

    table.eattable {
        /* border: 1px solid black; */
        width: 800px;
        height: auto;
    }

    table tr.tablehead {
        border-bottom: 1px solid black;
        border-top: 1px solid black;
        text-align: center;
        background-color: #ccc;
    }

    table tr.tablecontent {
        border-bottom: 1px solid #ccc;
    }

    table tr td.content-title {
        text-align: left;
    }

    .left-align {
    text-align: left;
    font-size: 2rem;
    }

    .right-align {
        text-align: right;
    }

    .DJpic {
        float: right;
    }
    
    .DJhistory {
        clear: both;
        text-align: right;
        margin-top: 100px;
    }

    .introducecomment {
        float: left;
        width: 400px;
        height: 100px;
        margin-left: 10px;
        margin-right: 80px;
        text-align: left;
    }


</style>

<link rel="stylesheet" href="./asset/css/bootstrap.css">
<link rel="stylesheet" href="./asset/css/footer.css">

<body>
    
    
    <div class="introducetitle">늘봄 소개</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">늘봄 소개</a>
                    <a href="#" class="list-group-item list-group-item-action">인사말</a>
                    <a href="#" class="list-group-item list-group-item-action">시설 소개</a>
                    <a href="http://localhost:8090/NeulBom/directions.do" class="list-group-item list-group-item-action">오시는 길</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">인사말</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 늘봄 소개 > 인사말
                    </div>
                </div>
            </nav>
            <hr>
            <div>
                    <div class="introducecomment">안녕하세요. 늘봄 실버타운 대표이사 이동재입니다.<br>늘봄 실버타운에 방문해주셔서 감사합니다!<br>우리 늘봄 실버타운은 2022.1.1에 어쩌구 저쩌구</div>
                    <img src="../최효종.jpg" class="DJpic">
                    <div class="DJhistory">대표이사 이동재<br><br>약력<br>쌍용 교육센터 수료 예정<br>정보처리기사 필기 취득<br>(실기 취득 예정)<br>서버 1조 마스터 출신</div>
            </div>
        </div>
    </div>
        
    </div>
    
    <footer class="footer_hee">
        <div class="container_hee">
            <div class="row_hee">
                <div class="col_hee">
                    <a class="logo_hee" href="#" aria-label="Bootstrap">
                        <img src="../logo/clover.png" class="icon" style="width:25px; height:25px;">
                        <span class="title_hee">늘봄</span>
                    </a>
                </div>
                <div class="smalltitle_hee">
                    <h5>이용약관</h5>
                    <ul class="list-unstyled_hee">
                        <li class="mb_hee1">대표 : 이동재</a></li>
                        <li class="mb_hee">서울 강남구 테헤란로132</a></li>
                    </ul>
                </div>
                <div class="smalltitle_hee">
                    <h5>개인정보처리방침</h5>
                    <ul class="list-unstyled_hee">
                        <li class="mb_hee1">전화 : 02-1234-5678</a></li>
                        <li class="mb_hee">개인정보책임관리 : 양진영</a></li>
                    </ul>
                </div>
                <div class="smalltitle_hee">
                    <h5>책임의 한계와 법적 고지</h5>
                    <ul class="list-unstyled_hee">
                        <li class="mb_hee1">이메일 : dongjae97@naver.com</li>
                    </ul>
                </div>
                <div>ⓒ2023 Company NewulBom.Allrights reserved</div>
            </div>
        </div>

    </footer>

</body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=015fae8b95c2d0f2c4d727e44d11a138"></script>
<script>
</script>
</html>










