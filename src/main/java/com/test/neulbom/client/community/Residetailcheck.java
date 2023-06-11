package com.test.neulbom.client.community;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.net.URLEncoder;
=======
>>>>>>> d4c4c6cd2db6db2e3eff526b5906c20d3438c751

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.test.neulbom.client.repository.ConsultDTOWj;
=======
>>>>>>> d4c4c6cd2db6db2e3eff526b5906c20d3438c751
import com.test.neulbom.client.repository.NomemWjDAO;
import com.test.neulbom.client.repository.NomemWjDTO;

@WebServlet("/client/community/residetailcheck.do")
public class Residetailcheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Residetailcheck.java
<<<<<<< HEAD
		String con_seq = req.getParameter("con_seq");
		
		 req.setAttribute("con_seq", con_seq);
			
=======
		

>>>>>>> d4c4c6cd2db6db2e3eff526b5906c20d3438c751
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/residetailcheck.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
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
		   
		    
		    if (result == 1) {
		        String con_seq = req.getParameter("con_seq"); // con_seq 가져오기
				req.setAttribute("pname", pname);
		        String url = "/neulbom/client/board/residetailwj.do?con_seq=" + con_seq + "&pname=" + URLEncoder.encode(pname, "UTF-8");
		        resp.sendRedirect(url);

		    } else {
		    	resp.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정
		    	
		    	resp.setContentType("text/html; charset=UTF-8");
		        PrintWriter writer = resp.getWriter();
		        writer.write("<script>alert('잘못된 정보입니다 다시 시도하세요'); history.back();</script>");
		        writer.close();
		    }
=======
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
	

>>>>>>> d4c4c6cd2db6db2e3eff526b5906c20d3438c751
	}
	
}
