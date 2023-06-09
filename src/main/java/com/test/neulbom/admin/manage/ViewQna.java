package com.test.neulbom.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.ManageDAO;
import com.test.neulbom.admin.manage.repository.QnaDTO;
import com.test.neulbom.admin.manage.repository.QreplyDTO;

@WebServlet("/admin/manage/viewqna.do")
public class ViewQna extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		ManageDAO dao = new ManageDAO();
		QnaDTO dto = dao.getQna(seq);
		
		String content = dto.getContent();

		// HTML 태그 이스케이프
		content = content.replace("<", "&lt;").replace(">", "&gt;");

		// 글 내용 개행 문자 처리
		content = content.replace("\r", "<br><br>");
		content = content.replace("\r\n", "<br>");
		
		dto.setContent(content);
		
		QreplyDTO qdto = dao.getQReply(seq);
		
		System.out.println("qdto: " + qdto.getContent());
		
		req.setAttribute("dto", dto);
		req.setAttribute("qdto", qdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/viewQna.jsp");
		dispatcher.forward(req, resp);
	}

}
