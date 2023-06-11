package com.test.neulbom.client.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.Mypage_InquiryDAO;
import com.test.neulbom.client.repository.Mypage_InquiryDTO;



@WebServlet("/client/mypage/mypage_inquiry.do")
public class Mypage_Inquiry extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Mypage_inquiry.java
		HttpSession session = req.getSession();
		
		Mypage_InquiryDAO dao = new Mypage_InquiryDAO();
		
		
		/*
		 * String seq = (String)session.getAttribute("protect_seq");
		 * List<Mypage_InquiryDTO> list_pro = dao.list_pro(seq);
		 * req.setAttribute("list_pro", list_pro);
		 * 
		 * if(seq == null) { seq = (String)session.getAttribute("resi_seq");
		 * List<Mypage_InquiryDTO> list_resi = dao.list_resi(seq);
		 * req.setAttribute("list_resi", list_resi); }
		 */
		String seq = (String) session.getAttribute("protect_seq");
		List<Mypage_InquiryDTO> list = null;

		if (seq == null) {
		    seq = (String) session.getAttribute("resi_seq");
		    list = dao.list_resi(seq);
		} else {
		    list = dao.list_pro(seq);
		}

		req.setAttribute("list", list);

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/mypage/mypage_inquiry.jsp");
		dispatcher.forward(req, resp);
	}

}
