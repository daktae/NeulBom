package com.test.neulbom.admin.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.neulbom.admin.repository.ResiDAO;
import com.test.neulbom.admin.repository.ResiDTO;

@WebServlet("/admin/account/resiacc.do")
public class ResiAcc extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//ResiAcc.java

		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/views/admin/account/resiacc.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//RegisterOk.java
		//1. 데이터 가져오기
		//2. DB 작업 > insert
		//3. 결과
		
		try {
			MultipartRequest multi = new MultipartRequest(
					
					req,
					req.getRealPath("/asset/pic"),
					1024 * 1024 * 10,
					"UTF-8",
					new DefaultFileRenamePolicy()

				);
			
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");
			String ssn = multi.getParameter("ssn");
			String tel = multi.getParameter("tel");
			String email = multi.getParameter("email");
			String detail = multi.getParameter("detail");
			String address = multi.getParameter("address");
			String lv = multi.getParameter("lv");
			System.out.println(id);
			System.out.println(pw);
			ResiDTO dto = new ResiDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setSsn(ssn);
			dto.setTel(tel);
			dto.setEmail(email);
			dto.setDetail(detail);
			dto.setAddress(address);
			dto.setLv(lv);		
			ResiDAO dao = new ResiDAO();
			
			int result = dao.register(dto);
			
			if (result == 1) {
				resp.sendRedirect("/neulbom/admin/index.do");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
				
				writer.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
