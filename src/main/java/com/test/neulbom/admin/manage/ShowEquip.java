package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.repository.EqDAO;
import com.test.neulbom.admin.repository.EqDTO;

@WebServlet("/admin/manage/showEquip.do")
public class ShowEquip extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ShowEquip.java
		
		EqDAO dao = new EqDAO();
		
		List<EqDTO> eqList = dao.eqList();
		
		req.setAttribute("eqList", eqList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/showEquip.jsp");
		dispatcher.forward(req, resp);
	}

}
