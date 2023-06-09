package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.test.neulbom.mylib.DBUtil3;

public class ClientDAO {
	
	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs;
	
	public ClientDAO() {
		this.conn = DBUtil3.open();
	}

	//새 글 thread 값
	public int getMaxThread() {

		try {
			
			String sql = "select nvl(max(thread), 0) as tread from tblFree";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("tread");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	//답글 thread
	public void updateThread(HashMap<String, Integer> map) {
		
		
		
	}

	public int add(FreeDTO dto) {
		try {

			String sql = "insert into tblFree(free_seq, title, content, free_date, fname, read, thread, depth, protect_seq, resi_seq)"
								+ "values(max(free_seq) +1, ?, ?, default, ?, default, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			// 스스로는 현재 접속자의 아이디를 알아낼 수 있는 방법 X > DTO에 글 쓴 사람 id를 담아서 넘겨야 함 > Add.java가 DAO에
			// 일을 의뢰할 때 session안에 들어있는 id값도 넘겨야 함
			pstat.setString(3, dto.getId());
			
			pstat.setInt(4, dto.getThread());
			pstat.setInt(5, dto.getDepth());

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

	

	
	
	
	
	
	
	

}
