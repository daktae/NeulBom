package com.test.neulbom.client.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.ClientDAO;
import com.test.neulbom.client.repository.MyProgramDTO;

@WebServlet("/client/mypage/detailprogram.do")
public class DetailProgram extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//DetailProgram.java
		
		//등록되어있는 복지프로그램의 상세내역 받아오기
		
		String prog_seq = req.getParameter("prog_seq");
		
		MyProgramDTO dto = new MyProgramDTO();
		ClientDAO dao = new ClientDAO();
		
		dto = dao.detalProgram(prog_seq);
		
		req.setAttribute("dto", dto);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/mypage/detailprogram.jsp");
		dispatcher.forward(req, resp);

	}
	
	

}