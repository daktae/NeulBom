package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.HashMap;
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
		
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = "n";
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if ((column == null && word == null)
				|| (column.endsWith("") && word.equals(""))) {
			
			search = "n";
		} else {
			search = "y";
		}
		
		map.put("column", column);
		map.put("word", word);
		map.put("search", search);
				
		AdminDAO dao = new AdminDAO();
		
		List<AdminDTO> salaryList = dao.getSalaryList(map);
		
		req.setAttribute("salaryList", salaryList);
		req.setAttribute("map", map);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/staffSalary.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	}
	

}




























