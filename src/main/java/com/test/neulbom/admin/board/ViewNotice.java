package com.test.neulbom.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.repository.AdminDAO;
import com.test.neulbom.admin.repository.NoticeDTO;

@WebServlet("/admin/board/viewNotice.do")
public class ViewNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");

		AdminDAO dao = new AdminDAO();
		List <NoticeDTO> list = dao.showNotice(seq);
		
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/board/viewNotice.jsp");
		dispatcher.forward(req, resp);
		
	}

}
