package com.test.neulbom.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/manage/addEquip.do")
public class AddEquip extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// AddEquip.java
		// 관리자 - 비품등록
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/addEquip.jsp");
		dispatcher.forward(req, resp);
	}

}
