package com.test.neulbom.admin.repository;

import lombok.Data;

@Data
public class NoticeDTO {
	
	String notice_seq;
	String displayed_seq;
	String title;
	String content;
	String notice_date;
	String read;
	
}
