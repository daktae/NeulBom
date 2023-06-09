package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.ManageDAO;
import com.test.neulbom.admin.manage.repository.PayDTO;

@WebServlet("/admin/manage/pay.do")
public class Pay extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String search = "n";
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if((name==null) || name.equals("")) search = "n";
		else search = "y";
		
		map.put("name", name);
		map.put("search", search);
		
		ManageDAO dao = new ManageDAO();
		
		List<PayDTO> list = dao.getPayRecord(map);
		
		req.setAttribute("map", map);
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/pay.jsp");
		dispatcher.forward(req, resp);
	}

}