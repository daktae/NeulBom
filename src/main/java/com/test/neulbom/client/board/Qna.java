package com.test.neulbom.client.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.QnaDAO;
import com.test.neulbom.client.repository.QnaDTO;

@WebServlet("/client/board/qna.do")
public class Qna extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Qna.java
		
		HttpSession session = req.getSession();
			
		QnaDTO dto = new QnaDTO();
		
		QnaDAO dao = new QnaDAO();
		
		List<QnaDTO> list = dao.list();
		
		for (QnaDTO qna : list) {
	        String qna_seq = qna.getQna_seq(); // qna_seq 추출
	        String fname = dao.getFnameByProtect(qna_seq); // name 값 가져오기
	        qna.setFname(fname); // name 값 설정
	        
	        if (fname == null) {
	        	fname = dao.getFnameByResi(qna_seq);
	        	qna.setFname(fname);
	        }
	        
	    }
		
		
		req.setAttribute("list", list);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/qna.jsp");
		dispatcher.forward(req, resp);
	}

}
