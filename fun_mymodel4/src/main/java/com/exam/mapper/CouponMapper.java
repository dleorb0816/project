package com.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONArray;

import com.exam.vo.CouponVo;

public interface CouponMapper {

	@Insert("INSERT INTO web.coupon (c_num, c_name, c_type, c_price, c_price, h_num) "
			+ "VALUES (#{c_num}, #{c_name}, #{c_type}, #{c_price}, #{c_price}, #{h_num})")
	void makeCoupon(CouponVo couponVo);
	
//	@Insert("INSERT INTO web.have couponList "
//			+ "VALUES (#{c_num}, #{c_name}, #{c_type}, #{c_price}, #{c_price}, #{h_num})"
//			+ "WHERE h_num = ${h_num}")
//	void addCouponByNum(CouponVo couponVo);
}






