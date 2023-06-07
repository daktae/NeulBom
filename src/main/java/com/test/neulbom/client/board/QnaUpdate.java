package com.test.neulbom.client.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/client/board/qunaupdate.do")
public class QnaUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//QnaUpdate.java
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/qunaupdate.jsp");
		dispatcher.forward(req, resp);
	}

}
