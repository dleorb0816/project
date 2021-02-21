package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONArray;
import com.exam.vo.NoticeAttachVo;

public interface NoticeAttachMapper {

	@Insert("INSERT INTO web.attach (filename, uploadpath, image, no_num) "
			+ "VALUES (#{filename}, #{uploadpath}, #{image}, #{noNum})")
	void insertAttach(NoticeAttachVo noticeAttachVo);
	
	@Select("SELECT * FROM web.attach WHERE num = #{num}")
	NoticeAttachVo getAttachByNum(int num);
	
	@Select("SELECT * FROM web.attach WHERE no_num = #{noNum} ")
	List<NoticeAttachVo> getAttachesByNoNum(int noNum);
	
	@Delete("DELETE FROM web.attach where no_num = #{noNum}")
	void deleteAttachesByNoNum(int noNum);
	
	@Delete("DELETE FROM web.attach where num = #{num} ")
	void deleteAttachByNum(int num);
	
}






