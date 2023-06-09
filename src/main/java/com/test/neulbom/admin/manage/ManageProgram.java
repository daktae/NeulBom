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

import com.test.neulbom.admin.manage.repository.ProgramDAO;
import com.test.neulbom.admin.manage.repository.ProgramDTO;

@WebServlet("/admin/manage/manageProgram.do")
public class ManageProgram extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ManageProgram.java

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = "n";
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if ((column == null && word == null)
				|| (column.endsWith("") && word.equals(""))) {
			
			search = "n";
		} else {
			search = "y";
		}
		
		map.put("column", column);
		map.put("word", word);
		map.put("search", search);
		
		ProgramDAO dao = new ProgramDAO();
		
		List<ProgramDTO> progList = dao.getProgList(map);

		req.setAttribute("progList", progList);
		req.setAttribute("map", map);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/manageProgram.jsp");
		dispatcher.forward(req, resp);
	}

}
