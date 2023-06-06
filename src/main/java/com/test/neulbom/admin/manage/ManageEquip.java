package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.EqDAO;
import com.test.neulbom.admin.manage.repository.RegEqDTO;

@WebServlet("/admin/manage/manageEquip.do")
public class ManageEquip extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ManageEquip.java
		
		EqDAO dao = new EqDAO();
		
		List<RegEqDTO> regList = dao.regList();
		
		req.setAttribute("regList", regList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/manageEquip.jsp");
		dispatcher.forward(req, resp);
	}

}
