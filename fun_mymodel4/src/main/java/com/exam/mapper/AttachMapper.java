package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONArray;

import com.exam.vo.AttachVo;
import com.exam.vo.FileVo;

public interface AttachMapper {

	@Insert("INSERT INTO web.battach (filename, uploadpath, image, no_num) "
			+ "VALUES (#{filename}, #{uploadpath}, #{image}, #{noNum})")
	void insertAttach(AttachVo attachVo);
	
	@Select("SELECT * FROM web.battach WHERE num = #{num}")
	AttachVo getAttachByNum(int num);
	
	@Select("SELECT * FROM web.battach WHERE no_num = #{noNum} ")
	List<AttachVo> getAttachesByNoNum(int noNum);
	
	@Delete("DELETE FROM web.battach where no_num = #{noNum}")
	void deleteAttachesByNoNum(int noNum);
	
	@Delete("DELETE FROM web.battach where num = #{num} ")
	void deleteAttachByNum(int num);
	
}






