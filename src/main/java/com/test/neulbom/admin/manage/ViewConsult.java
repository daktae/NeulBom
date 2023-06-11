package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.neulbom.admin.manage.repository.ConsultDTO;
import com.test.neulbom.admin.manage.repository.CreplyDTO;
import com.test.neulbom.admin.manage.repository.ManageDAO;

@WebServlet("/admin/manage/viewconsult.do")
public class ViewConsult extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");

		ManageDAO dao = new ManageDAO();
		ConsultDTO dto = dao.getConsult(seq);

		String content = dto.getContent();

		// HTML 태그 이스케이프
		content = content.replace("<", "&lt;").replace(">", "&gt;");

		// 글 내용 개행 문자 처리
		content = content.replace("\r", "<br><br>");
		content = content.replace("\r\n", "<br>");

		dto.setContent(content);

		CreplyDTO cdto = dao.getCReply(seq);

		req.setAttribute("dto", dto);
		req.setAttribute("cdto", cdto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/viewConsult.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			MultipartRequest multi = new MultipartRequest(

					req, req.getRealPath("/asset/creply"), 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy()

			);

			HttpSession session = req.getSession();
			
			req.setCharacterEncoding("UTF-8");

			String seq = multi.getParameter("seq");
			String title = multi.getParameter("rtitle");
			String content = multi.getParameter("rcontent");
			String fname = multi.getFilesystemName("fname");
			String admin_seq = (String)session.getAttribute("Admin_seq");
			
			ManageDAO dao = new ManageDAO();

			int result = dao.replyToConsult(seq, title, content, fname, admin_seq);

			if (result >= 1) {
				resp.sendRedirect("/neulbom/admin/manage/consult.do");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed'); history.back();</script>");
				writer.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}