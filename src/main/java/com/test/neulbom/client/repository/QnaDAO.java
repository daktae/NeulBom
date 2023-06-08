package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	//페이징 안했을 때 다불러오기
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
	
	//페이징 불러오기
	public List<QnaDTO> list(HashMap<String, String> map) {

		List<QnaDTO> list = new ArrayList<QnaDTO>();
		
		try {
			
			String where ="";
			
			 /* 검색할때 
			 if (map.get("search").equals("y")) {
	            where = String.format("where %s like '%%%s%%'"
	                              , map.get("column")
	                              , map.get("word"));
	         }
	         */

	         String sql = String.format("select * from (select rownum as rnum, a.* from (select * from tblqna order by qna_seq desc) a) where rnum between %s and %s"
	                              , map.get("begin")
	                              , map.get("end")
	                              );

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			
				
			while (rs.next()) {
				QnaDTO dto = new QnaDTO();

				dto.setQna_seq(rs.getString("qna_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setQna_date(rs.getString("qna_date"));
				dto.setIsreply(rs.getString("isreply"));
				dto.setFname(rs.getString("fname"));
				dto.setCategory(rs.getString("category"));
				dto.setRead(rs.getString("read"));
				dto.setResi_seq(rs.getString("resi_seq"));
				dto.setProtect_seq(rs.getString("protect_seq"));
				
				
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}

	public String getnameByProtect(String qna_seq) {

		try {

			String sql = "select tblProtect.name from tblqna inner join tblprotect on tblqna.protect_seq = tblprotect.protect_seq where tblqna.qna_seq = ?";

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
	public String getnameByResi(String qna_seq) {

		try {

			String sql = "select tblresident.name from tblqna inner join tblresident on tblqna.resi_seq = tblresident.resi_seq where tblqna.qna_seq = ?";

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
	
	public String getIdByProtect(String qna_seq) {
		
		try {
			
			String sql = "select tblProtect.id from tblqna inner join tblprotect on tblqna.protect_seq = tblprotect.protect_seq where tblqna.qna_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, qna_seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getString("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//어떻게 하지?
	public String getIdByResi(String qna_seq) {
		
		try {
			
			String sql = "select tblresident.id from tblqna inner join tblresident on tblqna.resi_seq = tblresident.resi_seq where tblqna.qna_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, qna_seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getString("id");
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


		public int qnaResiAdd(String title, String content, String fname, String category, String resi_seq) {

			
			
			try {

				String sql = "insert into tblQna values (qna_seq.nextVal, ?, ?, sysdate, 'n', ?, ?, 0, null, ?)";
				
				pstat = conn.prepareStatement(sql);

				pstat.setString(1, title);
				pstat.setString(2, content);
				pstat.setString(3, fname);
				pstat.setString(4, category);
				pstat.setInt(5, Integer.parseInt(resi_seq));

				return pstat.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 0;
			
		}
		
		public int qnaProtectAdd(String title, String content, String fname, String category, String protect_seq) {

			try {

				String sql = "insert into tblQna values (qna_seq.nextVal, ?, ?, sysdate, 'n', ?, ?, 0, ?, null)";

				pstat = conn.prepareStatement(sql);

				pstat.setString(1, title);
				pstat.setString(2, content);
				pstat.setString(3, fname);
				pstat.setString(4, category);
				pstat.setInt(5, Integer.parseInt(protect_seq));
				
				return pstat.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
			
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

		public int getTotalCount(HashMap<String, String> map) {
				
			try {

				String where ="";
				
				/* 검색할때
				if (map.get("search").equals("y")) {
					where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("word") );
				}
				*/

				String sql = "select count(*) as cnt from tblQna";

				pstat = conn.prepareStatement(sql);

				rs = pstat.executeQuery();

				if (rs.next()) {

					return rs.getInt("cnt");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 0;
		}

		public void increaseReadCount(String qna_seq) {
            try {
                String sql = "UPDATE tblqna SET read = read + 1 WHERE qna_seq = ?";
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, qna_seq);
                pstat.executeUpdate();
                
                pstat.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

	
	
	

}
