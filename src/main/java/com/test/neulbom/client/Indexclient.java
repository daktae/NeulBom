package com.test.neulbom.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/client/index.do")
public class Indexclient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//Index.java

<<<<<<< HEAD:src/main/java/com/test/neulbom/admin/Index.java
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/index.jsp");
=======
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/views/client/indexclient.jsp");
>>>>>>> da2cc2ecfcfb6193c10b662793bb3f518cc3243c:src/main/java/com/test/neulbom/client/Indexclient.java
		dispatcher.forward(req, resp);
	}
}

