package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.ConsultDTO;
import com.test.neulbom.admin.manage.repository.ManageDAO;

@WebServlet("/admin/manage/consult.do")
public class Consult extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ManageDAO dao = new ManageDAO();
		List <ConsultDTO> list = dao.getConsult();
		
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/consult.jsp");
		dispatcher.forward(req, resp);
	}

}