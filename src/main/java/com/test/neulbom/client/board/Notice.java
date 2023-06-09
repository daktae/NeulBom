package com.test.neulbom.client.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.NoticeDAO;
import com.test.neulbom.client.repository.NoticeDTO;

@WebServlet("/client/board/notice.do")
public class Notice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// notice.java

//		 HttpSession session = req.getSession();
//		 req.getSession().setAttribute("id", "resi001");

		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");

		NoticeDAO dao = new NoticeDAO();

		int nowPage = 0; // 현재 보려는 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지 당 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // 한 페이지 안에 보여줄 시작 rnum
		int end = 0; // 끝 rnum
		int n = 0;
		int loop = 0;
		int blockSize = 3; // 한 번에 보여질 페이지 개수(10개씩 끊어서 보여줄 것임)

		String page = req.getParameter("page"); // 값이 있을수도, 없을수도 있음

		if (page == null || page == "")
			nowPage = 1;
		else
			nowPage = Integer.parseInt(page);

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("begin", begin + "");
		map.put("end", end + "");

		List<NoticeDTO> list = null;

		if (searchType == null && keyword == null) {
			list = dao.list(map);
		} else {
			list = dao.search(searchType, keyword);
		}

		// 페이징

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= totalPage; i++) {
			if (i == nowPage) {
				sb.append(String.format(" <a href=\"#!\" style='color: tomato;'>%d</a> ", i));
			} else {
				sb.append(String.format(" <a href=\"/neulbom/client/board/notice.do?page=%d\">%d</a> ", i, i));
			}
		}

		totalCount = dao.getTotalCount(map);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		
		loop = 1; // 루프 변수(10바퀴)
		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 페이지 번호

		// 이전 10페이지
		if (n == 1) { // n=1이면 무조건 첫블럭(1페이지가 있는 곳이 첫 블럭이니까) >
			sb.append(String.format("<a href=\"#!\">[이전 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href=\"/neulbom/client/board/notice.do?page=%d\">[이전 %d페이지]</a>", n - 1,
					blockSize));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href=\"#!\" style='color: tomato;'>%d</a> ", n));
			} else {
				sb.append(String.format(" <a href=\"/neulbom/client/board/notice.do?page=%d\">%d</a> ", n, n));
			}

			loop++;
			n++;
		}

		// 다음 10페이지
		if (n > totalPage) { // 마지막 숫자가 totalPage보다 크면 아무 반응도 없도록
			sb.append(String.format("<a href=\"#!\">[다음 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href=\"/toy/board/board.do?page=%d\">[다음 %d페이지]</a>", n, blockSize));
		}

		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagination", sb);

		req.setAttribute("list", list);
		req.setAttribute("searchType", searchType);
		req.setAttribute("keyword", keyword);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/notice.jsp");
		dispatcher.forward(req, resp);

	}

}
