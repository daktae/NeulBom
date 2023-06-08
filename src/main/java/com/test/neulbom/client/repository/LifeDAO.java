package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;
import com.test.neulbom.admin.board.repository.LifeDTO;

public class LifeDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public LifeDAO() {
		this.conn = DBUtil.open("180.68.11.121", "hr", "java1234");
	}

	public List<LifeDTO> list() {

		try {

			String sql = "select * from tblLife order by life_date desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<LifeDTO> list = new ArrayList<LifeDTO>();

			while (rs.next()) {

				LifeDTO dto = new LifeDTO();

				dto.setLife_seq(rs.getString("life_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRead(rs.getString("read"));
				dto.setLife_date(rs.getString("life_date"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<LifeDTO> search(String searchType, String keyword) {

		try {

			String sql = String.format("select * from tblLife where %s like '%%%s%%' order by life_date desc", searchType, keyword);

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<LifeDTO> list = new ArrayList<LifeDTO>();

			while (rs.next()) {

				LifeDTO dto = new LifeDTO();

				dto.setLife_seq(rs.getString("life_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRead(rs.getString("read"));
				dto.setLife_date(rs.getString("life_date"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
		

}
