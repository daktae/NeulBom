package com.test.neulbom.admin.account;

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

import com.test.neulbom.admin.repository.AdminDAO;
import com.test.neulbom.admin.repository.AdminDTO;
import com.test.neulbom.admin.repository.ResiDAO;
import com.test.neulbom.admin.repository.ResiDTO;

@WebServlet("/admin/account/manage.do")
public class Manage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		test(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		test(req, resp);
		
	}

	private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Board.java
		
		//1. DB 작업 > select
		//2. 결과 반환
		
		HttpSession session = req.getSession();
		
		//읽음 제어
		session.setAttribute("read", "n");
		
		
		//?page=5 > null
		//?page=5&column=&word= > ""
		//?page=5&column=subject&word=자바 > "subject"
		
		//req.getParameter("column")
		
		
		
		
		
		//2가지 용도로 호출
		//1. 일반 목록 보기 > board.do
		//2. 검색 결과 보기 > board.do?column=subject&word=test
		
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = "n"; //검색중(O,X)
		
		HashMap<String, String> map
			= new HashMap<String,String>();
				
		if ((column == null && word == null)
				 || (column.endsWith("") && word.equals(""))) {
			search = "n";
		} else {
			search = "y";
		}
		
		System.out.println("search" +  search);
		
		map.put("column", column);
		map.put("word", word);
		map.put("search", search);
		
		
		AdminDAO adao = new AdminDAO();
		ResiDAO rdao = new ResiDAO();
		
		List<AdminDTO> alist = adao.alist(map);
		List<ResiDTO> rlist = rdao.rlist(map);
				
		//데이터 조작
		for (AdminDTO adto : alist) {
			
			//날짜 출력(기준: 당일)
			//- 년월일
			//- 시분초
			//System.out.println(dto.getRegdate());
			//dto.setRegdate(dto.getRegdate().substring(0, 10));
			
			String subject = adto.getName();
			
			//태그 이스케이프
			subject = subject.replace("<", "&lt;")
							 .replace(">", "&gt;");
			
			//제목에서 검색 중.. 검색어를 강조
			if (search.equals("y") && column.equals("name")) {
				subject = subject.replace(word, "<span>" + word + "</span>");
			}
			
			adto.setName(subject);
			
		}
		for (ResiDTO rdto : rlist) {
			
			//날짜 출력(기준: 당일)
			//- 년월일
			//- 시분초
			//System.out.println(dto.getRegdate());
			//dto.setRegdate(dto.getRegdate().substring(0, 10));
			
			String subject = rdto.getName();
			
			//태그 이스케이프
			subject = subject.replace("<", "&lt;")
					.replace(">", "&gt;");
			
			//제목에서 검색 중.. 검색어를 강조
			if (search.equals("y") && column.equals("name")) {
				subject = subject.replace(word, "<span>" + word + "</span>");
			}
			
			rdto.setName(subject);
			
		}
		
		req.setAttribute("alist", alist);
		req.setAttribute("rlist", rlist);
		req.setAttribute("map", map);
		
		//JSP 페이지 알 수 있는 정보
		//1. req를 통해서 전달된 정보
		//2. session/cookie
		//3. application

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/account/manage.jsp");
		dispatcher.forward(req, resp);
	}

}
