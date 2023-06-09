package com.test.neulbom.client.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.QnaDAO;
import com.test.neulbom.client.repository.QnaDTO;

@WebServlet("/client/board/qnadel.do")
public class QnaDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//QnaDel.java
		String qna_seq = req.getParameter("qna_seq"); // qna_seq 파라미터 가져오기

		QnaDAO dao = new QnaDAO();
        QnaDTO dto = new QnaDTO();
        
        dao.qnaView(qna_seq, dto);
        // qna_seq에 해당하는 내용 가져오기
        dao.increaseReadCount(qna_seq);
        
        String name = dao.getnameByProtect(qna_seq); // name 값 가져오기
        dto.setName(name); // name 값 설정
        
        if (name == null) {
        	name = dao.getnameByResi(qna_seq);
        	dto.setName(name);
        }
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/qnadel.jsp");
		dispatcher.forward(req, resp);
	}

}
