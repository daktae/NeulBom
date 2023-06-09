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

import com.test.neulbom.client.repository.Mypage_Payment_DetailsDAO;
import com.test.neulbom.client.repository.Mypage_Payment_DetailsDTO;

@WebServlet("/client/mypage/mypage_payment_details.do")
public class Mypage_Payment_Details extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//mypage_Payment_details.java
		HttpSession session = req.getSession();
		
		//테스트용
		
		String seq = (String)session.getAttribute("resi_seq");
		System.out.println(seq);
		
		Mypage_Payment_DetailsDAO dao = new Mypage_Payment_DetailsDAO();
		
		List<Mypage_Payment_DetailsDTO> list = dao.list(seq); 
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/mypage/mypage_payment_details.jsp");
		dispatcher.forward(req, resp);
	}

}