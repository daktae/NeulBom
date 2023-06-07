package com.test.neulbom.client.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.ClientDAO;
import com.test.neulbom.client.repository.FreeDTO;

@WebServlet("/client/community/free.do")
public class Free extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Free.java
		//자유게시판 글 목록 조회
		//자유게시판에 글 쓸 수 있는 회원은 입주자(lv=5, 6), 보호자(lv=7)
		
		
		//조회수 제어
		HttpSession session = req.getSession();
		session.setAttribute("read", "n");
		
		
		//글 가져오기
		FreeDTO dto = new FreeDTO();
		ClientDAO dao = new ClientDAO();
		
		List<FreeDTO> list = dao.list();
		
		req.setAttribute("list", list);
		
		
		//페이징
		int nowPage = 0;	//현재 보려는 페이지
		int begin = 0;		//시작 글
		int end = 0;		//끝 글
		int blocksize = 10;	//한 번에 보여줄 페이지 수
		int pageSize = 10;	//한 페이지 당 보여줄 게시물 수
		
		//페이지 넘길 때
		//free.do?page=1 > 기본값
		//free.do?page=2 > 페이지 넘길 시
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			nowPage = 1;	//페이지가 지정되지 않은 경우 첫 번째 페이지를 보여줌
		} else {
			nowPage = Integer.parseInt(page);	//그렇지 않은 경우 page를 정수로 변환해서 저장
		}
		
		//nowPage > 현재 보려는 페이지 번호
		//free.do?page=1 > where rnum between 1 and 10
		//free.do?page=2 > where rnum between 11 and 20
		//between begin and end
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		
		
		
				

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/free.jsp");
		dispatcher.forward(req, resp);

	}

}