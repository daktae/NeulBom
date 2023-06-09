package com.test.neulbom.client.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.ClientDAO;
import com.test.neulbom.client.repository.ResiDTO;

public class Auth {
	
	public static boolean check(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		
		//글쓴이 본인? or 관리자?
		ClientDAO dao = new ClientDAO();
		ResiDTO dto = dao.get(seq);
		
		//다르면 너 나가 를 시전해야 하기 때문에 !session
		if(!session.getAttribute("id").equals(dto.getId())
				&& !session.getAttribute("lv").toString().equals("3"))  {
			
		  PrintWriter writer = resp.getWriter();
   		  writer.write("<script>alert('failed'); location.href='/toy/index.do';</script>");
   		  writer.close();
   		  
   		  return true;
			
		}
		
		return false;
		
	}

}
