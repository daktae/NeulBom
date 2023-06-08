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

			if (dto.getLv() == 5 || dto.getLv() == 6) {

				sql = "insert into tblFree(free_seq, title, content, free_date, fname, read, thread, depth, protect_seq, resi_seq) values(max(free_seq) +1, ?, ?, default, ?, default, ?, ?, null, ?)";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, dto.getTitle());
				pstat.setString(2, dto.getContent());
				// 스스로는 현재 접속자의 아이디를 알아낼 수 있는 방법 X > DTO에 글 쓴 사람 id를 담아서 넘겨야 함 > Add.java가 DAO에
				// 일을 의뢰할 때 session안에 들어있는 id값도 넘겨야 함
				pstat.setString(3, dto.getFile());

				pstat.setInt(4, dto.getThread());
				pstat.setInt(5, dto.getDepth());

				// 가져온 아이디가 insert할 tblFree 테이블의 protect_seq 혹은 resi_seq와 일치하는 회원의 id면 삽입
				pstat.setString(6, dto.getResident_seq());
				pstat.setInt(getMaxThread(), getMaxThread());

			} else if (dto.getLv() == 7) {

				sql = "insert into tblFree(free_seq, title, content, free_date, fname, read, thread, depth, protect_seq, resi_seq) values(max(free_seq) +1, ?, ?, default, ?, default, ?, ?, ?, null)";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, dto.getTitle());
				pstat.setString(2, dto.getContent());
				// 스스로는 현재 접속자의 아이디를 알아낼 수 있는 방법 X > DTO에 글 쓴 사람 id를 담아서 넘겨야 함 > Add.java가 DAO에
				// 일을 의뢰할 때 session안에 들어있는 id값도 넘겨야 함
				pstat.setString(3, dto.getFile());

				pstat.setInt(4, dto.getThread());
				pstat.setInt(5, dto.getDepth());

				// 가져온 아이디가 insert할 tblFree 테이블의 protect_seq 혹은 resi_seq와 일치하는 회원의 id면 삽입
				pstat.setString(6, dto.getProtect_seq());
				pstat.setInt(getMaxThread(), getMaxThread());

			}

			return pstat.executeUpdate();

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
			System.out.println(dto.getLv());
			if (dto.getLv() == 5 || dto.getLv() == 6) {

				String sql = "select free_seq, title, resident as name, free_date, read from vwFree";

				stat = conn.createStatement();
				rs = stat.executeQuery(sql);

			} else if (dto.getLv() == 7) {

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
			String sql = "select tblFree.*, case when (select name from tblResident where resi_seq = tblFree.resi_seq) is not null then (select name from tblResident where resi_seq = tblFree.resi_seq) else (select name from tblProtect where protect_seq = tblFree.protect_seq) end as name from tblFree where free_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, free_seq);
			rs = pstat.executeQuery();

			if (rs.next()) {

				FreeDTO dto = new FreeDTO();

				dto.setFree_seq(rs.getString("free_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setFree_date(rs.getString("free_date").substring(0, 10));
				dto.setRead(rs.getString("read"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
