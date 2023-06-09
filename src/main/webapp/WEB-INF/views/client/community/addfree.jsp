<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>늘봄 > 커뮤니티 > 자유게시판</title>

<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>
<style>
    


    #write {
        width: 100px;
        height: 40px;
        background-color: #043886;
        color: #ffffff;
        border: none;
        font-size: 20px;
        font-weight: bold;
    }

    #cancle {
        background-color: #A61123;
        color: #FFF;
        border: none;
        width: 100px;
        height: 40px;
        border: none;
        font-size: 20px;
        font-weight: bold;
    }

    #table {
        width: 100%;
        border-top: 1px solid #939393;
        border-bottom: 1px solid #939393;
    }
    

    .th {
        width: 150px;
        font-size: 23px;
        background-color: #EEE;
        padding: 20px 0px;
        border-bottom: 1px solid #DFDFDF;
    }

    .td {
        border-bottom: 1px solid #DFDFDF;
        border-bottom: 1px solid #DFDFDF;
    }

    #title {
        width: 97%;
        height: 50px;
        border: 1px solid #c7c8c9;
        color: black;
        padding: 10px;
    }

    #content {
        width: 97%;
        height: 500px;
        margin: 10px 10px;
        border: 1px solid #c7c8c9;
        padding: 10px;
        resize: none;
    }

    #pic {
        width: 97%;
        height: 50px;
        border: 1px solid #c7c8c9;
        padding: 10px;
        text-align: left;
    }



    .btn1 {
        text-align: center;
        /* margin: 0 auto; */
        margin: 40px auto;
    }
    
    #write, #cancle {
        display: inline-block;
        margin-left: 30px;
    }

    #cancle {
    	background-color: #AAA;
    }

    .term_box {
        display: inline-block;
        width: 1200px;
        margin: 30px;
        border: 1px solid black;
    }
    
    #regi_header {
        height: 50px;
        text-align: left;
        padding-left: 10px;
        background-color: #F5F5F5;
    }

    #regi_checkbox {
        height: 20px;
        display: left;
        background-color: #F5F5F5;
    }

    .regi_term {
        height: 200px;
        text-align: left;
        overflow: auto;
    }

    .regi_term > span {
        font-weight: bold;
        padding-bottom: 20px;
    }
    
    #deepmenu {
    	margin: 0 auto;
    
    }
    
    .introducetitle {
    
    	background-image: url("/neulbom/asset/image/자유게시판 사진.jpg");
    }



</style>
</head>
<body>
	<!-- free.jsp 자유게시판 -->
	
<%@ include file="/asset/css/headerclient.jsp" %>
    
    <div class="introducetitle">커뮤니티</div>

    <div class="mainmenu text-center">

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">자유게시판 <small>글 작성</small></h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 자유게시판 > 글 작성
                    </div>
                </div>
            </nav>
            
            <hr>
           
            <form method="POST" action="/client/community/addfree.do">

                <table id="table">
                    <tr>
                        <th class="th">제목</th>
                        <td class="td"><input type="text" name="title" id="title" required class="full" placeholder="제목을 입력하세요." maxlength="60"></td>
                    </tr>
                    <tr>
                        <th class="th">내용</th>
                        <td class="td"><textarea name="content" id="content" required class="full"" placeholder="내용을 입력하세요." maxlength="900"></textarea>
                    </tr>
                    <tr>
                        <th class="th">첨부파일</th>
                        <td class="td"><input type="file" name="file" id="file" class="full"></td>
                    </tr>
                    </table>
                    
                    
                    <div class="btn1">
                    <input type="submit" name="write" id="write" value="글쓰기"> 
                    <input type="button" name="cancle" id="cancle" value="취소하기" onclick="location.href='/client/community/free.do';"> 
                    </div>
                    
                    <input type="hidden" name="mode" value=${mode }>
                    <input type="hidden" name="thread" value=${thread }>
                    <input type="hidden" name="depth" value=${depth }>
                    
                    
                    <input type="hidden" name="mode" value="${mode }">
					<input type="hidden" name="thread" value="${thread }">
					<input type="hidden" name="depth" value="${depth }">
                    
            </form>

            </div>

            <hr>
            
        </div>
        
    </div>






    
<%@ include file="/asset/css/footerclient.jsp" %>    


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>

</body>
</html>