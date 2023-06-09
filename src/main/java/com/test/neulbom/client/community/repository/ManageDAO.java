package com.test.neulbom.admin.manage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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

	// 면회 신청 조회
	public List<MeetDTO> getMeet() {

		try {

			String sql = "SELECT m.*, p.name AS pname, r.name AS rname FROM tblMeet m INNER JOIN tblProtect p ON m.protect_seq = p.protect_seq INNER JOIN tblResident r ON m.resi_seq = r.resi_seq ORDER BY CASE WHEN m.CONFIRMATION IS NULL THEN 0 ELSE 1 END, CASE WHEN m.CONFIRMATION IS NULL THEN m.MEET_DATE END ASC, CASE WHEN m.CONFIRMATION IS NOT NULL AND m.MEET_DATE > TRUNC(SYSDATE) THEN m.MEET_DATE ELSE TO_DATE('9999-12-31', 'YYYY-MM-DD') END ASC, m.MEET_DATE DESC";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<MeetDTO> list = new ArrayList<MeetDTO>();
			int i = 1;
			while (rs.next()) {

				MeetDTO dto = new MeetDTO();

				dto.setMeet_seq(rs.getString("meet_seq"));
				dto.setDisplayed_seq(i + "");

				String date = rs.getString("meet_date").substring(0, 10);
				dto.setMeet_date(date);

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

				// 현재보다 미래 시점인지 날짜 비교

				String[] dateTemp = date.trim().split("-");
				int year = Integer.parseInt(dateTemp[0]);
				int month = Integer.parseInt(dateTemp[1]);
				int day = Integer.parseInt(dateTemp[2]);

				LocalDate mdate = LocalDate.of(year, month, day);
				LocalDate now = LocalDate.now();

				if (mdate.isAfter(now))
					dto.setIsRevisable(1);
				else
					dto.setIsRevisable(0);

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 면회 승인
	public int confirmMeeting(String seq) {

		try {

			String sql = "UPDATE tblMeet SET confirmation = 'y' where meet_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}

	// 면회 반려
	public int rejectMeeting(String seq) {
		try {

			String sql = "UPDATE tblMeet SET confirmation = 'n' where meet_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}

	// 결제 기록 조회
	public List<PayDTO> getPayRecord(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("search").equals("y"))
				where = String.format("WHERE r.name LIKE '%%%s%%'", map.get("name"));

			String sql = "SELECT p.pay_seq, p.resi_seq, p.ispay, p.pay_date, r.id, r.name, m.kind, p.price, r.tel From tblPay p INNER JOIN tblResident r ON p.resi_seq = r.resi_seq INNER JOIN tblMove m ON p.resi_seq = m.resi_seq "
					+ where + "ORDER BY CASE WHEN p.ispay = 'n' THEN 0 ELSE 1 END, p.pay_date DESC";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<PayDTO> list = new ArrayList<PayDTO>();

			int i = 1;

			while (rs.next()) {

				PayDTO dto = new PayDTO();

				dto.setPay_seq(rs.getString("pay_seq"));
				dto.setResi_seq(rs.getString("resi_seq"));
				dto.setIsPay(rs.getString("isPay"));
				dto.setPay_date(rs.getString("pay_date").substring(0, 10));

				dto.setDisplayed_seq(i + "");

				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setKind(rs.getString("kind"));

				int price = rs.getInt("price");
				dto.setPrice(price);

				dto.setTel(rs.getString("tel"));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	// 일반 문의 전체 조회
	public List<QnaDTO> getQna() {

		try {

			String sql = "SELECT q.*, r.name AS rname, p.name AS pname FROM tblQna q LEFT OUTER JOIN tblResident r ON r.resi_seq = q.resi_seq LEFT OUTER JOIN tblProtect p ON p.protect_seq = q.protect_seq ORDER BY CASE WHEN q.isReply = 'n' THEN q.qna_date END ASC, CASE WHEN q.isReply = 'y' THEN q.qna_date END DESC";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<QnaDTO> list = new ArrayList<QnaDTO>();
			int i = 1;

			while (rs.next()) {

				QnaDTO dto = new QnaDTO();

				dto.setQna_seq(rs.getString("qna_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setQna_date(rs.getString("qna_date").substring(0, 10));
				dto.setIsReply(rs.getString("isReply"));
				dto.setFname(rs.getString("fname"));
				dto.setCategory(rs.getString("category"));
				dto.setRead(rs.getString("read"));

				dto.setDisplayed_seq(i + "");

				if (rs.getString("rname") != null) {
					dto.setType("입주자");
					dto.setRname(rs.getString("rname"));
				} else if (rs.getString("pname") != null) {
					dto.setType("보호자");
					dto.setPname(rs.getString("pname"));
				}

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public QnaDTO getQna(String seq) {

		try {

			String sql = "SELECT q.*, r.name AS rname, p.name AS pname FROM tblQna q LEFT OUTER JOIN tblResident r ON r.resi_seq = q.resi_seq LEFT OUTER JOIN tblProtect p ON p.protect_seq = q.protect_seq WHERE q.qna_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();

			QnaDTO dto = new QnaDTO();

			while (rs.next()) {

				dto.setQna_seq(rs.getString("qna_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setQna_date(rs.getString("qna_date").substring(0, 10));
				dto.setIsReply(rs.getString("isReply"));
				dto.setFname(rs.getString("fname"));
				dto.setCategory(rs.getString("category"));
				dto.setRead(rs.getString("read"));

				if (rs.getString("rname") != null) {
					dto.setType("입주자");
					dto.setRname(rs.getString("rname"));
				} else if (rs.getString("pname") != null) {
					dto.setType("보호자");
					dto.setPname(rs.getString("pname"));
				}
			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public QreplyDTO getQReply(String seq) {

		try {

			String sql = "SELECT * FROM tblQreply where qna_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();

			QreplyDTO dto = new QreplyDTO();

			while (rs.next()) {

				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setFname(rs.getString("fname"));
				String admin_seq = rs.getString("admin_seq");
				dto.setAdmin_seq(admin_seq);
				dto.setQna_seq(rs.getString("qna_seq"));
				dto.setRead(rs.getString("read"));		
				
				String replier = getReplier(admin_seq);
				dto.setReplier(replier);			
			}
			
			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private String getReplier(String admin_seq) {
		try {
			
			String sql = "SELECT name FROM tblAdmin WHERE admin_seq = " + admin_seq;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString("name");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

	public int replyToQna(String seq, String title, String content) {
		
		try {
			
			String sql = "INSERT INTO tblQreply VALUES (qReplySeq.nextVal, ?, ?, null, 5, ?, 0, 0, 0)"; //이후 첨부파일 filename, admin_Seq 등 처리 필요
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, title);
			pstat.setString(2, content);
			pstat.setString(3, seq);
			
			if(updateIsReply(seq)==1) 
				return pstat.executeUpdate();
			else return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	private int updateIsReply(String seq) {
		
		
		try {

			String sql = "UPDATE tblqna SET isReply = 'y' WHERE qna_seq = ?";
			
			PreparedStatement pstat2;
		
			pstat2 = conn.prepareStatement(sql);
			pstat2.setString(1, seq);
			
			return pstat2.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
}
