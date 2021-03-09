package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.domain.MemberVo;

public interface MemberMapper {

	@Select("SELECT COUNT(*) FROM member WHERE id = #{id}")
	int getCountById(String id);

	@Insert("Insert INTO member (id, pw, name, gender, yy,mm,dd,tel,tel2,email,postcode,address,address2,regdate)"
			+ "values(#{id}, #{pw}, #{name}, #{gender}, #{yy}, #{mm}, #{dd}, #{tel}, #{tel2}, #{email}, #{postcode}, #{address}, #{address2}, CURRENT_TIMESTAMP)")
	void addMember(MemberVo memberVo);

	@Select("SELECT pw from member where id = #{id}")
	String userCheck(String id);
}
