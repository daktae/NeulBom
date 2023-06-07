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

@WebServlet("/admin/board/free.do")
public class Free extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();

		List<LifeDTO> list = dao.getLife();

		for (int i = 0; i < list.size(); i++) {

//			FreeDTO dto = new FreeDTO();
			dto = list.get(i);

			String title = dto.getTitle();

			if (title.length() >= 23)
				title = title.substring(0, 23) + " ...";
			dto.setTitle(title);

		}

		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/board/free.jsp");
		dispatcher.forward(req, resp);
	}

}