package com.test.neulbom.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/manage/detailProgram.do")
public class DetailProgram extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DetailProgram.java

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/detailProgram.jsp");
		dispatcher.forward(req, resp);
	}

}
