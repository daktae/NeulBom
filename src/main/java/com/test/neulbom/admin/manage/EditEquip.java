package com.test.neulbom.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.EqDAO;

@WebServlet("/admin/manage/editEquip.do")
public class EditEquip extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// EditEquip.java
		
		String eq_seq = req.getParameter("eq_seq");
		
		EqDAO dao = new EqDAO();
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/editEquip.jsp");
		dispatcher.forward(req, resp);
	}

}
