package com.test.neulbom.client.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.BoardWjDAO;
import com.test.neulbom.client.repository.BoardWjDTO;

@WebServlet("/client/board/resiconsult.do")
public class Resiconsult extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Resiconsult.java
		req.setCharacterEncoding("UTF-8");
		
		//jsp 에서 page 받아오기
				String page = req.getParameter("page");

				// 페이징
				int nowPage = 0; // 현재 페이지 번호
				int totalCount = 0; // 총 게시물 수
				int pageSize = 10; // 한페이지에서 출력할 게시물 수
				int totalPage = 0; // 총 페이지 수
				int begin = 0; // 시작 숫자
				int end = 0; // 끝 숫자
				int n = 0; //
				int loop = 0; //
				int blockSize = 10; // 한번에 보여질 페이지 개수

				//page값이 없으면 현재 페이지 = 1 나머지는 현재 페이지 = 페이지값
				if (page == null || page == "")
					nowPage = 1;
				else
					nowPage = Integer.parseInt(page);

				// nowPage > 현재 보려는 페이지 번호
				// board.do?page=1 > where rnum between 1 and 10
				// board.do?page=1 > where rnum between 11 and 20
				// board.do?page=1 > where rnum between 21 and 30
				begin = ((nowPage - 1) * pageSize) + 1;
				end = begin + pageSize - 1;
				
				// 2가지 용도로 호출
				// 1. 일반 목록 보기
				// 2. 검색 결과 보기

			
				HashMap<String, String> map = new HashMap<String, String>();			
				map.put("begin", begin + "");
				map.put("end", end + "");
				
				
	    
		BoardWjDAO dao = new BoardWjDAO();

		List<BoardWjDTO> list = dao.view(map);
		
		StringBuilder sb = new StringBuilder();

		// 페이징 작업
		// 총 게시물
		totalCount = dao.getTotalCount(map);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		
		loop = 1;	//루프 변수
		n = ((nowPage -1) / blockSize) * blockSize + 1; //페이지 번호
		
		// 이전 10페이지
		// "<<" 아이콘 else일때 a태그 href 경로 수정
		if (n == 1) {
		    sb.append("<nav aria-label=\"Page navigation example \"><ul class=\"pagination justify-content-center\">");
		    sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		} else {
		    sb.append(String.format("<nav aria-label=\"Page navigation example \"><ul class=\"pagination justify-content-center\"><li class=\"page-item\"><a class=\"page-link\" href=\"/neulbom/client/board/qna.do?page=%d\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>", n - 1));
		}

		// 안에 있는 숫자들 ex) << "1 2 3" >>
		// else일때 a태그 href 경로 수정
		while (!(loop > blockSize || n > totalPage)) {
		    if (n == nowPage) {
		        sb.append(String.format(" <li class=\"page-item\"><a class=\"page-link\" href=\"/neulbom/client/board/resiconsult.do?page=%d\" style='color:tomato;'>%d</a></li> ", n, n));
		    } else {
		        sb.append(String.format(" <li class=\"page-item\"><a class=\"page-link\" href=\"/neulbom/client/board/resiconsult.do?page=%d\">%d</a></li> ", n, n));
		    }
		    loop++;
		    n++;
		}

		// 다음 10페이지
		// ">>" 아이콘 else일때 a태그 href 경로 수정
		if (n > totalPage) {
		    sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li></ul></nav>");
		} else {
		    sb.append(String.format("<li class=\"page-item\"><a class=\"page-link\" href=\"/neulbom/client/board/resiconsult.do?page=%d\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li></ul></nav>", n));
		}
    	
				req.setAttribute("map", map);
				req.setAttribute("totalCount", totalCount);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("nowPage", nowPage);
				req.setAttribute("list", list);
				req.setAttribute("pagination", sb);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/resiconsult.jsp");
		dispatcher.forward(req, resp);
	}

}
