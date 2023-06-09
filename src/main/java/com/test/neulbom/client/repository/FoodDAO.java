package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;

public class FoodDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public FoodDAO() {
		this.conn = DBUtil.open("180.68.11.121", "hr", "java1234");
	}

	public List<FoodDTO> list() {

		try {

			String sql = "SELECT * FROM tblfood ORDER BY food_date DESC";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<FoodDTO> list = new ArrayList<FoodDTO>();

			while (rs.next()) {

				FoodDTO dto = new FoodDTO();
				
				dto.setFood_seq(rs.getString("food_seq"));
				dto.setFood_date(rs.getString("food_date"));
				dto.setContent(rs.getString("content"));
				dto.setRead(rs.getString("read"));
				dto.setTitle(rs.getString("title"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<FoodDTO> search(String searchType, String keyword) {
		try {

			String sql = String.format("SELECT * FROM tblfood where %s like '%%%s%%' ORDER BY food_date DESC", searchType, keyword);

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<FoodDTO> list = new ArrayList<FoodDTO>();

			while (rs.next()) {

				FoodDTO dto = new FoodDTO();
				
				dto.setFood_seq(rs.getString("food_seq"));
				dto.setFood_date(rs.getString("food_date"));
				dto.setContent(rs.getString("content"));
				dto.setRead(rs.getString("read"));
				dto.setTitle(rs.getString("title"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	
	
}
