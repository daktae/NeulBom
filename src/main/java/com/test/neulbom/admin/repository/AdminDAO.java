package com.test.neulbom.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class AdminDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public AdminDAO() {
		this.conn = DBUtil3.open();
	}
	public AdminDTO login(AdminDTO dto) {
		try {

			String sql = "select * from tblAdmin where id = ? and pw = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());			

			rs = pstat.executeQuery();

			if (rs.next()) {

				AdminDTO result = new AdminDTO();

				result.setId(rs.getString("id"));
				result.setLv(rs.getString("lv"));

				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public int register(AdminDTO dto) {
		try {

			String sql = "insert into tblAdmin (admin_seq, id, pw, name, ssn, tel, email, pic, lv) values (admin_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getSsn());
			pstat.setString(5, dto.getTel());
			pstat.setString(6, dto.getEmail());
			pstat.setString(7, dto.getPic());
			pstat.setString(8, dto.getLv());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public AdminDTO find_id(String name, String ssn) {

		try {
			
			String sql = "select * from tblAdmin where name = ? and ssn = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, ssn);
			
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				AdminDTO dto = new AdminDTO();
				
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
	public AdminDTO find_pw(String id, String name, String ssn) {

		try {
			
			String sql = "select * from tblAdmin where id = ? and name = ? and ssn = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, name);
			pstat.setString(3, ssn);
			
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				AdminDTO dto = new AdminDTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSsn(rs.getString("ssn"));
				dto.setPw(rs.getString("pw"));
				
				return dto;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

}
