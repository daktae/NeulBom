package com.test.neulbom.admin.repository;

import lombok.Data;

@Data
public class ProgramDTO {
	private String prog_seq;
	private String title;		// 제목
	private String prog_date;	// 프로그램 날짜
	private String content;		// 내용
	private String place;		// 장소
	private String people;		// 정원
}
