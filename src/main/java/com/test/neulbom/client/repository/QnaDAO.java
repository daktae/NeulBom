package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class QnaDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public QnaDAO() {
		this.conn = DBUtil3.open();
	}
	

	public List<QnaDTO> list() {
		try {
			
			String sql = "select * from tblQna";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			List<QnaDTO> list = new ArrayList<QnaDTO>();
			
			while (rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				
				dto.setQna_seq(rs.getString("qna_seq"));
		        dto.setTitle(rs.getString("title"));
		        dto.setContent(rs.getString("content"));
		        dto.setQna_date(rs.getString("qna_date"));
		        dto.setIsreply(rs.getString("isreply"));
		        dto.setCategory(rs.getString("category"));
		        dto.setRead(rs.getString("read"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public String getFnameByProtect(String qna_seq) {

		try {

			String sql = "SELECT tblprotect.name\r\n"
					+ "FROM tblqna\r\n"
					+ "inner JOIN tblcommunity ON tblqna.qna_seq = tblcommunity.qna_seq\r\n"
					+ "inner JOIN tblprotect ON tblcommunity.protect_seq = tblprotect.protect_seq\r\n"
					+ "where tblqna.qna_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, qna_seq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//어떻게 하지?
	public String getFnameByResi(String qna_seq) {

		try {

			String sql = "SELECT tblResident.name\r\n"
					+ "FROM tblqna\r\n"
					+ "inner JOIN tblcommunity ON tblqna.qna_seq = tblcommunity.qna_seq\r\n"
					+ "inner JOIN tblResident ON tblcommunity.resi_seq = tblResident.resi_seq\r\n"
					+ "where tblqna.qna_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, qna_seq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	

}
