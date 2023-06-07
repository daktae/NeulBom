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



		public void qnaView(String qnaSeq, QnaDTO dto) {

	        try {
	        	
	            String sql = "SELECT * FROM tblQna WHERE qna_seq = ?";
	            pstat = conn.prepareStatement(sql);
	            
	            pstat.setString(1, qnaSeq);
	            rs = pstat.executeQuery();

	            if (rs.next()) {
	                dto.setQna_seq(rs.getString("qna_seq"));
	                dto.setTitle(rs.getString("title"));
	                dto.setContent(rs.getString("content"));
	                dto.setQna_date(rs.getString("qna_date"));
	                dto.setIsreply(rs.getString("isreply"));
	                dto.setFname(rs.getString("fname"));
	                dto.setCategory(rs.getString("category"));
	                dto.setRead(rs.getString("read"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


		public void qnaResiAdd(String title, String content, String fname, String category, String ResiSeq) {

			try {

				String sql = "insert into tblQna values (qna_seq.nextVal, ?, ?, sysdate, 'n', ?, ?, 0, thread, depth, null, ?)";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, title);
				pstat.setString(2, content);
				pstat.setString(3, fname);
				pstat.setString(4, category);
				pstat.setString(5, ResiSeq);


			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void qnaProtectAdd(String title, String content, String fname, String category, String protectSeq) {

			try {

				String sql = "insert into tblQna values (qna_seq.nextVal, ?, ?, sysdate, 'n', ?, ?, 0, thread, depth, ?, null)";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, title);
				pstat.setString(2, content);
				pstat.setString(3, fname);
				pstat.setString(4, category);
				pstat.setString(5, protectSeq);


			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}


		public String getResiSeq(String id) {

			try {

				String sql = "select name from tblResident where id = ?";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, id);

				rs = pstat.executeQuery();

				if (rs.next()) {

					return rs.getString("name");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}


		public String getProtectSeq(String id) {
			
			try {

				String sql = "select name from tblProtect where id = ?";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, id);

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
