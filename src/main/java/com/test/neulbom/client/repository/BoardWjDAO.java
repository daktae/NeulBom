package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class BoardWjDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardWjDAO() {
		this.conn = DBUtil3.open();
	}

	public List<BoardWjDTO> view(HashMap<String, String> map) {
		 try {
	    	   String sql = String.format("select rnum, con_seq, con_title, nomem_name, TO_CHAR(con_date, 'YYYY-MM-DD') \r\n"
	    	   		+ "as con_date from (select rownum as rnum, a.* from (select * from vwconsult order by con_seq desc) a) where rnum between %s and %s"
                   , map.get("begin")
                   , map.get("end")
                   );
	        pstat = conn.prepareStatement(sql);
	        rs = pstat.executeQuery();
	        
	        List<BoardWjDTO> list = new ArrayList<>();
	        
	        while (rs.next()) {
	        	BoardWjDTO dto = new BoardWjDTO();
	            dto.setCon_seq(rs.getString("con_seq"));
	            dto.setCon_title(rs.getString("con_title"));
	            dto.setNomem_name(rs.getString("nomem_name"));
	            dto.setCon_date(rs.getString("con_date"));

	            list.add(dto);
	        }
	        return list;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 

	    return null;
	}

	public int getTotalCount(HashMap<String, String> map) {
		try {

			String sql = "select count(*) as cnt from vwconsult order by con_date desc";

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

	public int add(BoardWjDTO dto) {
	    try {
	    	String sql = "INSERT INTO tblconsult (con_seq, title, content, con_date, isreply, nomem_seq, thread, depth) "
	    	        + "VALUES (conseq.nextVal, ?, ?, sysdate, 'n', nomemseq.nextVal, '0', '0')";

	    	pstat = conn.prepareStatement(sql);
	    	pstat.setString(1, dto.getCon_title());
	    	pstat.setString(2, dto.getCon_content()); 

	    	return pstat.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;  // 회원 추가 실패 시 0 반환
	}
	

	
	
}
