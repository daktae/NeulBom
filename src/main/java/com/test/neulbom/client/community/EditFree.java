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

@WebServlet("/client/community/editfree.do")
public class EditFree extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//EditFree.java
		
		String free_seq = req.getParameter("free_seq");
		System.out.println(free_seq);
		HttpSession session = req.getSession();
		
		ClientDAO dao = new ClientDAO();
		FreeDTO dto = dao.fcontent(free_seq);
		
		req.setAttribute("dto", dto);
		
		
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/editfree.jsp");
		dispatcher.forward(req, resp);

	}

}