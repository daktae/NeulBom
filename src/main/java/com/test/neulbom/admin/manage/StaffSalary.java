package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.repository.AdminDAO;
import com.test.neulbom.admin.repository.AdminDTO;

@WebServlet("/admin/manage/staffSalary.do")
public class StaffSalary extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// StaffSalary.java
		
		// 1. DB 작업 > select
		// 2. 결과 가져오기

		AdminDAO dao = new AdminDAO();
		
		List<AdminDTO> salaryList = dao.getSalaryList();
		
		req.setAttribute("salaryList", salaryList);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/staffSalary.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
