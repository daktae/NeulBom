package com.test.neulbom.client.community;

import java.io.IOException;
import java.util.HashMap;
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
		
		
		
		
		//페이징
		int nowPage = 0;	//현재 보려는 페이지
		int totalCount = 0;	//총 게시물 수
		int pageSize = 10;	//한 페이지 당 보여줄 게시물 수
		int totalPage = 0;	//총 페이지 수
		int begin = 0;		//시작 글
		int end = 0;		//끝 글
		int n = 0;
		int loop = 0;		//루프
		int blocksize = 10;	//한 번에 보여줄 페이지 수
		
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
		
		
		//2가지 용도로 호출
		//1. 일반 목록 보기
		//2. 검색 결과 보기
		
		//1. 
		//검색
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = "n";	//검색중 n / y
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if((column == null && word == null) || (column.endsWith("") && word.equals(""))) {
			search = "n";
		} else {
			search = "y";
		}
		
		//검색
		map.put("column", column);
		map.put("word", word);
		map.put("search", search);
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		//글 가져오기
		FreeDTO dto = new FreeDTO();
		ClientDAO dao = new ClientDAO();
		
		List<FreeDTO> list = dao.list();
		
		for (FreeDTO free : list) {
			String free_seq = free.getFree_seq();	//free_seq 추출
			
			String name = dao.getnameByProtect(free_seq);	//name 값 가져오기
			String id = dao.getIdByProtect(free_seq);	//id값 가져오기
			
			free.setName(name); //name 값 설정
			free.setId(id); 	//ID 값 설정
			
			if (name == null) {
				name = dao.getnameByResi(free_seq);
				id = dao.getIdByResi(free_seq);
				
				free.setName(name);
				free.setId(id);
				
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		//페이징 작업
		//총 게시물
		totalCount = dao.getTotalCount(map);
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		loop = 1;	//루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1;	//페이지 번호
		
		
		
		
		
		
		
		
		
		
		
		req.setAttribute("list", list);
		
				

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/free.jsp");
		dispatcher.forward(req, resp);

	}

}