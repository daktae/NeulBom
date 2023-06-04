package com.test.neulbom.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
				result.setLev(rs.getString("lv"));

				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
