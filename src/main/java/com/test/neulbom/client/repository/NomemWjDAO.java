package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.neulbom.mylib.DBUtil3;

public class NomemWjDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public NomemWjDAO() {
		this.conn = DBUtil3.open();
	}

	public int add(NomemWjDTO dto) {
	    try {
	    	String sql = "INSERT INTO tblnomem (nomem_seq, name, tel) "
	    	        + "VALUES (nsequence.nextVal, ?, ?)";

	    	pstat = conn.prepareStatement(sql);
	    	pstat.setString(1, dto.getPname()); // name에 해당하는 필드
	    	pstat.setString(2, dto.getPtel()); // tel에 해당하는 필드
	        return pstat.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;  // 회원 추가 실패 시 0 반환
	}

	
}
