package com.test.neulbom.client.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.my.DBUtil;

public class MeetDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public MeetDAO() {
		this.conn = DBUtil.open("180.68.11.121", "hr", "java1234");
	}

	// 보호자 정보
	public ProtectDTO getProtect(ProtectDTO dto, String protect_seq) {

		try {

			String sql = "select * from tblProtect where protect_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, protect_seq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				ProtectDTO result = new ProtectDTO();

				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setSsn(rs.getString("ssn"));
				result.setTel(rs.getString("tel"));
				result.setEmail(rs.getString("email"));
				result.setResi_seq(rs.getString("resi_seq"));
				result.setRelation(rs.getString("relation"));
				result.setAddress(rs.getString("address"));
				result.setLv(rs.getString("lv"));

				return result;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 입주자 이름
	public String getResiName(String resi_seq) {
		try {

			String sql = "select name from tblResident where resi_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, resi_seq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int meetAdd(String meet_date, String meet_time, String protect_seq, String resi_seq) {
		try {

			String sql = "insert into tblMeet values (meet_seq.nextVal, ?, ?, ?, ?, 'n')";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, meet_date);
			pstat.setString(2, meet_time);
			pstat.setString(3, protect_seq);
			pstat.setString(4, resi_seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public List<MeetDTO> list(HashMap<String, String> map) {
		List<MeetDTO> list = new ArrayList<MeetDTO>();

		try {

			String sql = String.format("select * from (select rownum as rnum, a.* from (select * from tblMeet order by meet_seq desc) a) where rnum between %s and %s"
								, map.get("begin")
								, map.get("end"));

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				MeetDTO dto = new MeetDTO();

				dto.setMeet_seq("meet_seq");
				dto.setMeet_date("meet_date");
				dto.setMeet_time("meet_time");
				dto.setProtect_seq("protect_seq");
				dto.setResi_seq("resi_seq");
				dto.setConfirmation("confirmation");
				

				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int getTotalCount(HashMap<String, String> map) {
		try {

			String where ="";
			
			
			/*
			 * if (map.get("search").equals("y")) { where =
			 * String.format("where %s like '%%%s%%'", map.get("column"), map.get("word") );
			 * }
			 */
			

			String sql = String.format("select count(*) as cnt from tblQna %s", where);

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

}
