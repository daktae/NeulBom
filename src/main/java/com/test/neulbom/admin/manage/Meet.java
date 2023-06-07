package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.ManageDAO;
import com.test.neulbom.admin.manage.repository.MeetDTO;

@WebServlet("/admin/manage/meet.do")
public class Meet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ManageDAO dao = new ManageDAO();
		
		List <MeetDTO> list = dao.getMeet();
				
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/meet.jsp");
		dispatcher.forward(req, resp);
	}

}
