package com.exam.vo;

import java.sql.Date;

public class CouponVo {
	
	private int c_num; // ���� AI
	private String c_key; // ���� �߱� �ڵ�
	private String c_name; // �����̸�
	private String c_type; // A: ������� B: �ۼ�Ʈ���� C: ��ۺ�����
	private int c_price; // A�� �̰���ŭ ���ְ� B�� �̰���ŭ �ۼ�Ʈ���ְ� C�� ��ۺ� �ƿ�
	private Date c_date; // ������
	private int h_num; // �غ�ѹ��� �������� ��ȣ
	
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_key() {
		return c_key;
	}
	public void setC_key(String c_key) {
		this.c_key = c_key;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public int getH_num() {
		return h_num;
	}
	public void setH_num(int h_num) {
		this.h_num = h_num;
	}
	
	@Override
	public String toString() {
		return "CouponVo [c_num=" + c_num + ", c_key=" + c_key + ", c_name=" + c_name + ", c_type=" + c_type
				+ ", c_price=" + c_price + ", c_date=" + c_date + ", h_num=" + h_num + "]";
	}
}