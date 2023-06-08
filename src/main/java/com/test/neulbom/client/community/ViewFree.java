package com.test.neulbom.client.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.ClientDAO;
import com.test.neulbom.client.repository.FreeDTO;

@WebServlet("/client/community/viewfree.do")
public class ViewFree extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ViewFree.java
		
		String free_seq = req.getParameter("free_seq");
		
		String pageNum = req.getParameter("pageNum");
		
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = req.getParameter("search");
		
		//로그인 계정 가져오기 
		HttpSession session = req.getSession();
		
		ClientDAO dao = new ClientDAO();
		FreeDTO dto = new FreeDTO();
		
		
		dto	= dao.fcontent(free_seq);
		String content = dto.getContent();
		
		//HTML 태그 이스케이프 > 꺽쇠 처리 > 엔터 처리 보다 먼저 처리해야함
		content = content.replace("<", "&lt;").replace(">", "&gt;");
		
		//글 내용 엔터 처리
		content = content.replace("\r\n", "<br>");
		
		//내용으로 검색 시 검색어 강조
		if (search != null && column != null && search.equals("y") && column.equals("content")) {
			content = content.replace(word, "<span style=\"background-color:gold;color:tomato;\">" + word + "</span>");
		}
		
		String title = dto.getTitle();
		
		//HTML 태그 이스케이프 > 꺽쇠 처리 > 엔터 처리 보다 먼저 처리해야함
		content = content.replace("<", "&lt;").replace(">", "&gt;");
		
		dto.setContent(content);
		dto.setTitle(title);
		
		req.setAttribute("dto", dto);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/viewfree.jsp");
		dispatcher.forward(req, resp);

	}
	
	
}