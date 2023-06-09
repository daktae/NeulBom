package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		// 답글 가져오기
		QreplyDTO qdto = dao.getQReply(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("qdto", qdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/viewQna.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		ManageDAO dao = new ManageDAO();

		String title = req.getParameter("rtitle");
		String content = req.getParameter("rcontent");
		String seq = req.getParameter("qna_seq");

		int result = dao.replyToQna(seq, title, content);

		if (result >= 1) {
			resp.sendRedirect("/neulbom/admin/manage/qna.do");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed'); history.back();</script>");
			writer.close();
		}
	
	}

}
