package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVo {

	private String id;
	private String pw;
	private String name;
	private String gender;
	private Integer yy;
	private Integer mm;
	private Integer dd;
	private String tel;
	private String tel2;
	private String email;
	private String postcode;
	private String address;
	private String address2;
	private Timestamp regDate;
}
