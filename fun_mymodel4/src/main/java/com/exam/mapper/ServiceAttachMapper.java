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
import com.exam.vo.ServiceAttachVo;

public interface ServiceAttachMapper {

	@Insert("INSERT INTO web.serviceattach (filename, uploadpath, image, no_num) "
			+ "VALUES (#{filename}, #{uploadpath}, #{image}, #{noNum})")
	void insertServiceAttach(ServiceAttachVo serviceAttachVo);
	
	@Select("SELECT * FROM web.serviceattach WHERE num = #{num}")
	ServiceAttachVo getServiceAttachByNum(int num);
	
	@Select("SELECT * FROM web.serviceattach WHERE no_num = #{noNum} ")
	List<ServiceAttachVo> getServiceAttachesByNoNum(int noNum);
	
	@Delete("DELETE FROM web.serviceattach where no_num = #{noNum}")
	void deleteServiceAttachesByNoNum(int noNum);
	
	@Delete("DELETE FROM web.serviceattach where num = #{num} ")
	void deleteServiceAttachByNum(int num);
	
}






