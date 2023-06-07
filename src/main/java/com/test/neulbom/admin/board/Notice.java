package com.test.neulbom.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.board.repository.BoardDAO;
import com.test.neulbom.admin.board.repository.LifeDTO;
import com.test.neulbom.admin.board.repository.NoticeDTO;

@WebServlet("/admin/board/notice.do")
public class Notice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();

		List<NoticeDTO> list = dao.getNotice();

		for (int i = 0; i < list.size(); i++) {

			NoticeDTO dto = new NoticeDTO();
			dto = list.get(i);

			String title = dto.getTitle();

			if (title.length() >= 23)
				title = title.substring(0, 23) + " ...";
			dto.setTitle(title);

		}

		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/board/notice.jsp");
		dispatcher.forward(req, resp);

	}

}
