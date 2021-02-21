package com.exam.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.exam.vo.HaveVo;

public interface HaveMapper {

	@Insert("INSERT INTO web.have (level, point, u_num) "
			+ "VALUES (#{level}, #{point}, #{uNum})")
	void addHave(HaveVo haveVo);
	
	@Select("SELECT * FROM web.have WHERE u_num = #{uNum}")
	HaveVo getHaveById(int u_num);
//	@Insert("INSERT INTO web.have (level, point) "
//			+ "VALUES (#{level}, #{point})")
//	void addHave(HaveVo haveVo);
}






