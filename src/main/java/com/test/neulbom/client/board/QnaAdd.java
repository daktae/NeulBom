package com.test.neulbom.client.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.neulbom.client.repository.QnaDAO;
import com.test.neulbom.client.repository.QnaDTO;

@WebServlet("/client/board/qnaadd.do")
public class QnaAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//QnaAdd.java
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/qnaadd.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//QnaAdd.java

		QnaDAO dao = new QnaDAO();
		
		
		try {
	         
	         MultipartRequest multi = new MultipartRequest(
	        		 
	                                 req,
	                                 req.getRealPath("/asset/qna"),
	                                 1024 * 1024 * 10,
	                                 "UTF-8",
	                                 new DefaultFileRenamePolicy()
	               
	                           );
	         
	         
	         //System.out.println(req.getRealPath("/asset/place"));
	         
	         HttpSession session = req.getSession();
	         
	         String title = multi.getParameter("title");
	         String content = multi.getParameter("content");
	         String category = multi.getParameter("category");
	         String id = multi.getParameter("id");
	 		 String fname = multi.getFilesystemName("fname");
	         
	 		 QnaDTO dto = new QnaDTO();
	         
	         dto.setTitle(title);
	         dto.setContent(content);
	         dto.setCategory(category);
	         dto.setFname(fname);
	         
	         String resiSeq = dao.getResiSeq(id);
	 		
	 		 if (resiSeq != null) {
	 			dao.qnaResiAdd(title, content, fname, category, resiSeq);
	 		 } else if (resiSeq == null) {
	 			 String protectSeq = dao.getProtectSeq(id);
	 			
	 			 dao.qnaProtectAdd(title, content, fname, category, protectSeq);
	 		 }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/qnaadd.jsp");
		dispatcher.forward(req, resp);
	}

}
