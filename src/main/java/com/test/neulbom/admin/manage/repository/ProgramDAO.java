package com.test.neulbom.admin.manage.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class ProgramDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ProgramDAO() {
		this.conn = DBUtil3.open();
	}

	public List<ProgramDTO> progList() {
		
		try {
			
			String sql = "select title, to_char(prog_date, 'yyyy-mm-dd') as prog_date, content, place, people from tblProgram order by prog_date asc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			List<ProgramDTO> progList = new ArrayList<ProgramDTO>();
			
			while (rs.next()) {
				ProgramDTO progDto = new ProgramDTO();
				
				progDto.setTitle(rs.getString("title"));
				progDto.setProg_date(rs.getString("prog_date"));
				progDto.setContent(rs.getString("content"));
				progDto.setPlace(rs.getString("place"));
				progDto.setPeople(rs.getString("people"));
				
				progList.add(progDto);
			}
			
			return progList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public int registerProgram(ProgramDTO progDto) {
		
		try {
			
			String sql = "insert into tblProgram(prog_seq, title, prog_date, content, place, people) values(?, ?, to_char(?, 'yyyy-mm-dd'), ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, progDto.getProg_seq());
			pstat.setString(2, progDto.getTitle());
			pstat.setString(3, progDto.getProg_date());
			pstat.setString(4, progDto.getContent());
			pstat.setString(5, progDto.getPlace());
			pstat.setString(6, progDto.getPeople());
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public String getProgSeq() {
		
		try {
			
			String sql = "select max(prog_seq) as prog_seq from tblProgram";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString("prog_seq");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}














