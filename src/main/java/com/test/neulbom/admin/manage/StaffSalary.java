package com.test.neulbom.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/manage/staffsalary.do")
public class StaffSalary extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// StaffSalary.java
		
		// 1. DB 작업 > select
		// 2. 결과 가져오기

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/staffsalary.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
