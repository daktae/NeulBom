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
				result.setLv(rs.getString("lv"));

				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public int register(AdminDTO dto) {
		try {

			String sql = "insert into tblAdmin (admin_seq, id, pw, name, ssn, tel, email, pic, lv) values (admin_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getSsn());
			pstat.setString(5, dto.getTel());
			pstat.setString(6, dto.getEmail());
			pstat.setString(7, dto.getPic());
			pstat.setString(8, dto.getLv());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public List<NoticeDTO> getNotice() {

		try {

			String sql = "select * from tblnotice order by notice_date desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<NoticeDTO> list = new ArrayList<NoticeDTO>();
			int i = 1;

			while (rs.next()) {

				NoticeDTO dto = new NoticeDTO();

				dto.setNotice_seq(rs.getString("notice_seq"));
				dto.setDisplayed_seq(i + "");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNotice_date(rs.getString("notice_date").substring(0, 10));
				dto.setRead(rs.getString("read"));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<FoodDTO> getFood() {
		try {

			String sql = "select * from tblfood order by food_date desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<FoodDTO> list = new ArrayList<FoodDTO>();
			int i = 1;

			while (rs.next()) {

				FoodDTO dto = new FoodDTO();

				dto.setFood_seq(rs.getString("food_seq"));
				dto.setDisplayed_seq(i + "");

				String temp = rs.getString("food_date").substring(5, 7);
				if (temp.startsWith("0"))
					temp = temp.substring(1);

				dto.setFood_month(temp);
				dto.setFood_date(rs.getString("food_date"));
				dto.setContent(rs.getString("content"));
				dto.setFood_date(rs.getString("food_date").substring(0, 10));
				dto.setRead(rs.getString("read"));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public NoticeDTO showNotice(String seq) {

		try {

			String sql = "select * from tblnotice where notice_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();
			NoticeDTO dto = new NoticeDTO();

			while (rs.next()) {

				dto.setNotice_seq(rs.getString("notice_seq"));
				dto.setDisplayed_seq("-1");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNotice_date(rs.getString("notice_date").substring(0, 10));
				dto.setRead(rs.getString("read"));
			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
