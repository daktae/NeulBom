package com.test.neulbom.client.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.QnaDAO;
import com.test.neulbom.client.repository.QnaDTO;

@WebServlet("/client/board/qnaview.do")
public class QnaView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//QnaView.java

		String qna_seq = req.getParameter("qna_seq"); // qna_seq 파라미터 가져오기
		
        QnaDTO dto = new QnaDTO();
        QnaDAO dao = new QnaDAO();
        
        // qna_seq에 해당하는 내용 가져오기
        dao.qnaView(qna_seq, dto);
        
        String fname = dao.getFnameByProtect(qna_seq); // name 값 가져오기
        dto.setFname(fname); // name 값 설정
        
        if (fname == null) {
        	fname = dao.getFnameByResi(qna_seq);
        	dto.setFname(fname);
        }
        
        
        req.setAttribute("dto", dto);
        
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/qnaview.jsp");
		dispatcher.forward(req, resp);
	}

}
