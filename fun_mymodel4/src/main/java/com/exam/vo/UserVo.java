package com.exam.vo;

import java.sql.Timestamp;

public class UserVo {

	private String userId; //AI
	private String id;
	private String pwd;
	private String name;
	private Integer age;    // 나이
	private String gender;  // 성별
	private String email;   // 이메일 주소
	private Timestamp regDate;
	private String birthDay;
	private String address;
	private String tel;
	
	private HaveVo haveVo;
	
	public HaveVo getHaveVo() {
		return haveVo;
	}
	public void setHaveVo(HaveVo haveVo) {
		this.haveVo = haveVo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", email=" + email + ", regDate=" + regDate + ", birthDay=" + birthDay
				+ ", address=" + address + ", tel=" + tel + ", haveVo=" + haveVo + "]";
	}
	
	
}
