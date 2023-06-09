package com.test.neulbom.client.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD:src/main/java/com/test/neulbom/admin/manage/ManageMoney.java
import com.test.neulbom.admin.manage.repository.MoneyDAO;
import com.test.neulbom.admin.manage.repository.SpendDTO;
import com.test.neulbom.admin.repository.ResiDAO;

@WebServlet("/admin/manage/manageMoney.do")
public class ManageMoney extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ManageMoney.java
		
		ResiDAO dao = new ResiDAO();
		
		// 실버타운 입주자 수
		int silverCount = dao.getSilverCount();
		
		// 요양원 입주자 수 
		int centerCount = dao.getCenterCount();
		
		req.setAttribute("silverCount", silverCount);
		req.setAttribute("centerCount", centerCount);
		
		
		MoneyDAO moneyDao = new MoneyDAO();
		
		List<SpendDTO> latestSpendList = moneyDao.getLatestSpend();
		
		req.setAttribute("latestSpendList", latestSpendList);
=======
@WebServlet("/client/detail.do")
public class Detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>>>>>>> da2cc2ecfcfb6193c10b662793bb3f518cc3243c:src/main/java/com/test/neulbom/client/community/Detail.java

		//Detail.java
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/detail.jsp");
		dispatcher.forward(req, resp);
	}

}
