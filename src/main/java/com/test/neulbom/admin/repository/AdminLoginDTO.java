package com.test.neulbom.admin.repository;

import lombok.Data;

@Data
public class AdminLoginDTO {
	
	private String id;
	private String pw;
	private String name;
	private String ssn;
	private String tel;
	private String email;
	private String pic;
	private String lev;
	
	
}
