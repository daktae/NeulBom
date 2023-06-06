package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.ProgramDAO;
import com.test.neulbom.admin.manage.repository.ProgramDTO;

@WebServlet("/admin/manage/manageProgram.do")
public class ManageProgram extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ManageProgram.java
		
		ProgramDAO dao = new ProgramDAO();
		
		List<ProgramDTO> progList = dao.progList();
		
		req.setAttribute("progList", progList);
		
		System.out.println(progList.get(0));

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/manageProgram.jsp");
		dispatcher.forward(req, resp);
	}

}
