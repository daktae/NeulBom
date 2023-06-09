package com.test.neulbom.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.repository.ResiDAO;

@WebServlet("/admin/manage/manageMoney.do")
public class ManageMoney extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ManageMoney.java
		
		ResiDAO dao = new ResiDAO();
		
		// 실버타운 입주자 수
		int silverCount = dao.getSilverCount();
		
		// 요양원 입주자 수 
		int centerCount = dao.getCenterCount();
		
		req.setAttribute("silverCount", silverCount);
		req.setAttribute("centerCount", centerCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/manageMoney.jsp");
		dispatcher.forward(req, resp);
	}

}
