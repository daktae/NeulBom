package com.test.neulbom.admin.manage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class ManageDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public ManageDAO() {
		this.conn = DBUtil3.open();
	}

	public List<MeetDTO> getMeet() {

		try {

			String sql = "SELECT m.*, p.name AS pname, r.name AS rname FROM tblMeet m INNER JOIN tblProtect p ON m.protect_seq = p.protect_seq INNER JOIN tblResident r ON m.resi_seq = r.resi_seq ORDER BY CASE WHEN m.CONFIRMATION IS NULL THEN 0 ELSE 1 END, CASE WHEN m.CONFIRMATION IS NULL THEN m.MEET_DATE END ASC, m.MEET_DATE DESC";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<MeetDTO> list = new ArrayList<MeetDTO>();
			int i = 1;
			while (rs.next()) {

				MeetDTO dto = new MeetDTO();

				dto.setMeet_seq(rs.getString("meet_seq"));
				dto.setDisplayed_seq(i + "");
				dto.setMeet_date(rs.getString("meet_date").substring(0, 10));
				
				String time = rs.getString("meet_time");
				
				String[] temp = time.split("~");
				String temp1 = temp[0];
				String temp2 = temp[1];
				
				dto.setMeet_time(String.format("%s:00~%s:00", temp1, temp2));

				dto.setProtect_seq(rs.getString("protect_seq"));
				dto.setResi_seq(rs.getString("resi_seq"));
				dto.setConfirmation(rs.getString("confirmation"));
				
				dto.setPname(rs.getString("pname"));
				dto.setRname(rs.getString("rname"));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
