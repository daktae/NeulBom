package com.test.neulbom.client.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.ProgramDAO;

@WebServlet("/client/mypage/delprogram.do")
public class DelProgram extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //DelProgram.java
      
      String papp_seq = req.getParameter("papp_seq");
      
      ProgramDAO dao = new ProgramDAO();
      
      System.out.println(papp_seq);
      
      int result = 0;
      
      result = dao.delProgram(papp_seq);
      
      
      if (result == 1) {
         resp.sendRedirect("/neulbom/client/mypage/program.do");
         
      } else if (result == 0) {
    	
    	  PrintWriter writer = resp.getWriter();
		writer.print("<script>alert('failed');history.back();</script>");
		writer.close();
      }
      
      

   }

}