package com.test.neulbom.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.neulbom.mylib.DBUtil3;

public class ResiDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ResiDAO() {
		this.conn = DBUtil3.open();
	}
	public int register(ResiDTO dto) {
		try {

			String sql = "insert into tblresident (resi_seq, id, pw, name, ssn, tel, email, detail, address, lv) values (resi_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getSsn());
			pstat.setString(5, dto.getTel());
			pstat.setString(6, dto.getEmail());
			pstat.setString(7, dto.getDetail());
			pstat.setString(8, dto.getAddress());
			pstat.setString(9, dto.getLv());
			

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
