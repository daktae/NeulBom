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
import com.test.neulbom.admin.board.repository.FoodDTO;

@WebServlet("/admin/board/food.do")
public class Food extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();

		List<FoodDTO> list = dao.getFood();
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/board/food.jsp");
		dispatcher.forward(req, resp);
	}

}
