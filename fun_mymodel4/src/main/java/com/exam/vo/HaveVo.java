package com.exam.vo;

import java.util.List;

public class HaveVo {
	
	private int hNum;  // have AI
	private String level; // ȸ�����
	private int point; // ���� ����Ʈ
	private int uNum;	  // �����ѹ��� �������� ��ȣ
	
	private List<CouponVo> couponList;

	
	public int gethNum() {
		return hNum;
	}

	public void sethNum(int hNum) {
		this.hNum = hNum;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getuNum() {
		return uNum;
	}

	public void setuNum(int uNum) {
		this.uNum = uNum;
	}

	public List<CouponVo> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<CouponVo> couponList) {
		this.couponList = couponList;
	}

}