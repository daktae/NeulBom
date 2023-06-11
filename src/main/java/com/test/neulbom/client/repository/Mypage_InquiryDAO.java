package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;

public class Mypage_InquiryDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public Mypage_InquiryDAO() {
		this.conn = DBUtil.open("180.68.11.121", "hr", "java1234");
	}

	public List<Mypage_InquiryDTO> list_pro(String seq) {
	    try {
	    	String sql = "SELECT q.*, r.name AS resi_name, p.name AS pro_name "
	    	           + "FROM tblqna q "
	    	           + "LEFT OUTER JOIN tblresident r ON q.resi_seq = r.resi_seq "
	    	           + "LEFT OUTER JOIN tblprotect p ON q.protect_seq = p.protect_seq "
	    	           + "WHERE q.protect_seq = ? "
	    	           + "ORDER BY CASE WHEN q.isreply = 'n' THEN 0 ELSE 1 END";


	        pstat = conn.prepareStatement(sql);

	        pstat.setString(1, seq);


	        rs = pstat.executeQuery();

	        List<Mypage_InquiryDTO> list = new ArrayList<Mypage_InquiryDTO>();

	        while (rs.next()) {
	            Mypage_InquiryDTO dto = new Mypage_InquiryDTO();
	            dto.setQna_seq(rs.getString("qna_seq"));
	            dto.setCategory(rs.getString("category"));
	            dto.setContent(rs.getString("content"));
	            dto.setIsreply(rs.getString("isreply"));
	            dto.setProtect_seq(rs.getString("protect_seq"));  
	            dto.setQna_date(rs.getString("qna_date"));
	            dto.setResi_seq(rs.getString("resi_seq"));
	            dto.setTitle(rs.getString("title"));
	            dto.setPro_name(rs.getString("pro_name"));
	            dto.setResi_name(rs.getString("resi_name"));
	            list.add(dto);
	        }

	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public List<Mypage_InquiryDTO> list_resi(String seq) {
		 try {
		    	String sql = "SELECT q.*, r.name AS resi_name, p.name AS pro_name "
		    	           + "FROM tblqna q "
		    	           + "LEFT OUTER JOIN tblresident r ON q.resi_seq = r.resi_seq "
		    	           + "LEFT OUTER JOIN tblprotect p ON q.protect_seq = p.protect_seq "
		    	           + "WHERE q.resi_seq = ? "
		    	           + "ORDER BY CASE WHEN q.isreply = 'n' THEN 0 ELSE 1 END";


		        pstat = conn.prepareStatement(sql);

		        pstat.setString(1, seq);
		     

		        rs = pstat.executeQuery();

		        List<Mypage_InquiryDTO> list = new ArrayList<Mypage_InquiryDTO>();

		        while (rs.next()) {
		            Mypage_InquiryDTO dto = new Mypage_InquiryDTO();
		            dto.setQna_seq(rs.getString("qna_seq"));
		            dto.setCategory(rs.getString("category"));
		            dto.setContent(rs.getString("content"));
		            dto.setIsreply(rs.getString("isreply"));
		            dto.setProtect_seq(rs.getString("protect_seq"));  
		            dto.setQna_date(rs.getString("qna_date"));
		            dto.setResi_seq(rs.getString("resi_seq"));
		            dto.setTitle(rs.getString("title"));
		            dto.setPro_name(rs.getString("pro_name"));
		            dto.setResi_name(rs.getString("resi_name"));
		            list.add(dto);
		        }

		        return list;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		return null;
	}

	
}