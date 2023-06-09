package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class ClientDAO {

	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs;

	public ClientDAO() {
		this.conn = DBUtil3.open();
	}

	// 새 글 thread 값
	public int getMaxThread() {

		try {

			String sql = "select nvl(max(thread), 0) as tread from tblFree";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt("tread");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 답글 thread
	public void updateThread(HashMap<String, Integer> map) {

	}

	// 게시판에 쓴 글을 DB에 넣기
	public int add(FreeDTO dto) {
		try {

			String sql = "";
			int nextFreeSeq = getMaxFreeSeq();

			if (dto.getLv().equals("5") || dto.getLv().equals("6")) {

				sql = "insert into tblFree(free_seq, title, content, free_date, fname, read, thread, depth, protect_seq, resi_seq) values(?, ?, ?, default, ?, default, ?, ?, null, ?)";

				pstat = conn.prepareStatement(sql);

				pstat.setInt(1, nextFreeSeq);
				pstat.setString(2, dto.getTitle());
				pstat.setString(3, dto.getContent());
				// 스스로는 현재 접속자의 아이디를 알아낼 수 있는 방법 X > DTO에 글 쓴 사람 id를 담아서 넘겨야 함 > Add.java가 DAO에
				// 일을 의뢰할 때 session안에 들어있는 id값도 넘겨야 함
				pstat.setString(4, dto.getFile());

				pstat.setInt(5, dto.getThread());
				pstat.setInt(6, dto.getDepth());

				// 가져온 아이디가 insert할 tblFree 테이블의 protect_seq 혹은 resi_seq와 일치하는 회원의 id면 삽입
				pstat.setString(7, dto.getResi_seq());
//				pstat.setInt(getMaxThread(), getMaxThread());

			} else if (dto.getLv().equals("7")) {

				sql = "insert into tblFree(free_seq, title, content, free_date, fname, read, thread, depth, protect_seq, resi_seq) values(?, ?, ?, default, ?, default, ?, ?, ?, null)";

				pstat = conn.prepareStatement(sql);

				pstat.setInt(1, nextFreeSeq);
				pstat.setString(2, dto.getTitle());
				pstat.setString(3, dto.getContent());
				// 스스로는 현재 접속자의 아이디를 알아낼 수 있는 방법 X > DTO에 글 쓴 사람 id를 담아서 넘겨야 함 > Add.java가 DAO에
				// 일을 의뢰할 때 session안에 들어있는 id값도 넘겨야 함
				pstat.setString(4, dto.getFile());

				pstat.setInt(5, dto.getThread());
				pstat.setInt(6, dto.getDepth());

				// 가져온 아이디가 insert할 tblFree 테이블의 protect_seq 혹은 resi_seq와 일치하는 회원의 id면 삽입
				pstat.setString(7, dto.getProtect_seq());
//				pstat.setInt(getMaxThread(), getMaxThread());

			}

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	private int getMaxFreeSeq() {

		try {
			
			String sql = "select max(free_seq) + 1 from tblFree";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				return rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public AccountDTO find_id(String name, String ssn) {

		try {

			String sql = "select * from tblProtect where name = ? and ssn = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, ssn);

			rs = pstat.executeQuery();

			if (rs.next()) {

				AccountDTO dto = new AccountDTO();

				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSsn(rs.getString("ssn"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public AccountDTO find_pw(String name, String id) {

		try {

			String sql = "select * from tblProtect where name = ? and id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, id);

			rs = pstat.executeQuery();

			if (rs.next()) {

				AccountDTO dto = new AccountDTO();

				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 자유게시판 전체 글 목록
	public List<FreeDTO> list(FreeDTO dto) {

		List<FreeDTO> list = new ArrayList<FreeDTO>();

		try {
			if (dto.getLv().equals("5") || dto.getLv().equals("6")) {

				String sql = "select free_seq, title, resident as name, free_date, read from vwFree";

				stat = conn.createStatement();
				rs = stat.executeQuery(sql);

			} else if (dto.getLv().equals("7")) {

				String sql = "select free_seq, title, protect as name, free_date, read from vwFree";

				stat = conn.createStatement();
				rs = stat.executeQuery(sql);

			}

			while (rs.next()) {

				FreeDTO fdto = new FreeDTO();
				
				fdto.setFree_seq(rs.getString("free_seq"));
				fdto.setTitle(rs.getString("title"));
				fdto.setName(rs.getString("name"));
				fdto.setFree_date(rs.getString("free_date"));
				fdto.setRead(rs.getString("read"));

				list.add(fdto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 전체 글 목록 조회
	public List<FreeDTO> list() {

		try {

			String sql = "select tblFree.*, case when (select name from tblResident where resi_seq = tblFree.resi_seq) is not null then (select name 							from tblResident where resi_seq = tblFree.resi_seq) else (select name from tblProtect where protect_seq = 							tblFree.protect_seq) end as name from tblFree order by free_seq desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<FreeDTO> list = new ArrayList<FreeDTO>();

			while (rs.next()) {

				FreeDTO dto = new FreeDTO();

				dto.setFree_seq(rs.getString("free_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setFree_date(rs.getString("free_date").substring(0, 10));
				dto.setRead(rs.getString("read"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public FreeDTO fcontent(String free_seq) {

		try {
			String sql = "select tblFree.*, case when (select name from tblResident where resi_seq = tblFree.resi_seq) is not null then (select name from tblResident where resi_seq = tblFree.resi_seq) else (select name from tblProtect where protect_seq = tblFree.protect_seq) end as name, case when (select id from tblResident where resi_seq = tblFree.resi_seq) is not null then (select id from tblResident where resi_seq = tblFree.resi_seq) else (select id from tblProtect where protect_seq = tblFree.protect_seq) end as id from tblFree where free_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, free_seq);
			rs = pstat.executeQuery();
			
			

			if (rs.next()) {

				FreeDTO dto = new FreeDTO();
				
				dto.setId(rs.getString("id"));	//글쓴이의 id를 받아오기
				dto.setFree_seq(rs.getString("free_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setFree_date(rs.getString("free_date").substring(0, 10));
				dto.setRead(rs.getString("read"));
				dto.setFile(rs.getString("fname"));
				
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));

				
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//DB의 seq를 가져와서 +1씩 시켜주기
	public String addSeq() {

		try {
			
			String sql = "select max(free_seq) + 1 as free_seq from tblFree";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getString("free_seq");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public ResiDTO get(String seq) {

		
		
		return null;
	}

	//댓글 목록 가져오기
	public List<CommentDTO> clist(String free_seq) {

		try {
			
			String sql = "select tblComment.*, case when (select id from tblResident where resi_seq = tblComment.resi_seq) is not null then (select id from tblResident where resi_seq = tblComment.resi_seq) else (select id from tblProtect where protect_seq = tblComment.protect_seq) end as id, case when (select name from tblResident where resi_seq = tblComment.resi_seq) is not null then (select name from tblResident where resi_seq = tblComment.resi_seq) else (select name from tblProtect where protect_seq = tblComment.protect_seq) end as name from tblComment where free_seq = ? order by comment_seq asc";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, free_seq);
			rs = pstat.executeQuery();
			
			List<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				
				CommentDTO cdto = new CommentDTO();
				
				cdto.setComment_seq(rs.getString("comment_seq"));
				cdto.setContent(rs.getString("content"));
				cdto.setName(rs.getString("name"));
				cdto.setId(rs.getString("id"));
				cdto.setResi_seq(rs.getString("resi_seq"));
				cdto.setProtect_seq(rs.getString("protect_seq"));
			
				clist.add(cdto);
			}
			
			return clist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//자유게시판 > 댓글 작성
	public int addComment(CommentDTO cdto) {
		
		String sql = "";
		int nextCommentSeq = getNextCommnetSeq();	//max(comment_seq) + 1;
		
		try {
			
			if (cdto.getLv().equals("5") || cdto.getLv().equals("6")) {

				sql = "insert into tblComment(comment_seq, content, free_seq, resi_seq, protect_seq) values(?, ?, ?, ?, null)";

				
				pstat = conn.prepareStatement(sql);
				
				pstat.setInt(1, nextCommentSeq);
				pstat.setString(2, cdto.getContent());
				pstat.setString(3, cdto.getFree_seq());
				pstat.setString(4, cdto.getResi_seq());

				return pstat.executeUpdate();

			} else if (cdto.getLv().equals("7")) {

				sql = "insert into tblComment(comment_seq, content, free_seq, resi_seq, protect_seq) values(?, ?, ?, null, ?)";

				pstat = conn.prepareStatement(sql);

				pstat.setInt(1, nextCommentSeq);
				pstat.setString(2, cdto.getContent());
				pstat.setString(3, cdto.getFree_seq());
				pstat.setString(4, cdto.getProtect_seq());
				
				return pstat.executeUpdate();

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	private int getNextCommnetSeq() {

		try {
			String sql = "select max(comment_seq) + 1 from tblComment";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delFree(String free_seq) {

		try {
			
			String sql = "delete from tblFree where free_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, free_seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public int defComment(String free_seq) {

		try {
			
			String sql = "delete from tblComment where free_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, free_seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	
	//조회수 증가
	public void increaseReadCount(String free_seq) {
		
	            try {
	            	
	                String sql = "update tblfree set read = read + 1 where free_seq = ?";
	                
	                pstat = conn.prepareStatement(sql);
	                pstat.setString(1, free_seq);
	                pstat.executeUpdate();
	                
	                pstat.close();
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	public int editFree(FreeDTO dto) {

		try {
			
			String sql = "update tblFree set title = ?, content = ?, fname = ? where free_seq = ?";
			System.out.println( dto.getFree_seq());
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getFile());
			pstat.setString(4, dto.getFree_seq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}
		
		
		return 0;
	}

}
