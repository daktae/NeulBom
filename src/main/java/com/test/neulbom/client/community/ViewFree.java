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
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		String free_date = req.getParameter("free_date");
		String read = req.getParameter("read");
		
		//로그인 계정 가져오기 
		HttpSession session = req.getSession();
		
		ClientDAO dao = new ClientDAO();
		FreeDTO dto = new FreeDTO();
		
		
		dto	= dao.fcontent(seq);
		
		
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/viewfree.jsp");
		dispatcher.forward(req, resp);

	}
	
	
}