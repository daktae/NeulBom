package com.test.neulbom.client.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.board.repository.LifeDTO;
import com.test.neulbom.client.repository.LifeDAO;

@WebServlet("/client/board/life.do")
public class Life extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//notice.java
		 
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		 LifeDAO dao = new LifeDAO();
		 
		 List<LifeDTO> list = dao.list();
		 if (searchType == null && keyword == null) {
			 list = dao.list(); 
		 } else {
			 list = dao.search(searchType, keyword);
		 }
		 
		 

		 
		 req.setAttribute("list", list);
		 req.setAttribute("searchType", searchType);
		 req.setAttribute("keyword", keyword);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/life.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}
