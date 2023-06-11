package com.test.neulbom.client.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.NomemWjDAO;
import com.test.neulbom.client.repository.NomemWjDTO;

@WebServlet("/client/community/residetailcheck.do")
public class Residetailcheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Residetailcheck.java
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/residetailcheck.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
	    
	    String pname = req.getParameter("pname");

	    String ptel1 = req.getParameter("ptel1");
	    String ptel2 = req.getParameter("ptel2");
	    String ptel3 = req.getParameter("ptel3");
	    String ptel = ptel1 + "-" + ptel2 + "-" + ptel3;
	
	    NomemWjDAO dao = new NomemWjDAO();    	
	    NomemWjDTO dto = new NomemWjDTO();
    	dto.setPname(pname);
    	dto.setPtel(ptel);

    	int result = dao.check(dto);
    	String nomem_seq = dao.getnoseq(dto);
    	
    	
    	if (result == 1) {
    		resp.sendRedirect("/neulbom/client/board/residetailwj.do?nomem_seq=" + nomem_seq);
    	} else {
    		PrintWriter writer = resp.getWriter();
    		writer.write("<script>alert('failed'); history.back();</script>");
    		writer.close();
    	}
	

	}
	
}
