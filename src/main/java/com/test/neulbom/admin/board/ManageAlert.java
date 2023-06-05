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

@WebServlet("/admin/board/manageAlert.do")
public class ManageAlert extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminDAO dao = new AdminDAO();

//		String board = req.getParameter("board");

//		if (board != null) {
//			switch (board) {
//			case "notice":
		List<NoticeDTO> list = dao.getNotice();
		req.setAttribute("list", list);
//				break;
//			}
//		} else {
//			System.out.println("BOARD IS NULL");
//		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/board/manageAlert.jsp");
		dispatcher.forward(req, resp);

	}

}
