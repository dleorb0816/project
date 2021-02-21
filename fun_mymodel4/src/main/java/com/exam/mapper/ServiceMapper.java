package com.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.exam.vo.ServiceVo;

public interface ServiceMapper {

	@Insert("INSERT INTO web.service (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) "
			+ "VALUES (#{id}, #{subject}, #{content}, #{readcount}, #{regDate}, #{ip}, #{reRef}, #{reLev}, #{reSeq})")
	void addService(ServiceVo serviceVo);
	
	@Select("SELECT * FROM web.service WHERE num = #{num}")
	ServiceVo getServiceByNum(int num);
	
	@Select("UPDATE web.service "
			+ "SET readcount = readcount + 1 "
			+ "WHERE num = #{num}")
	void updateReadcount(int num);
	
	@Select("SELECT COUNT(*) FROM web.service")
	int getCountAll();
	
	@Select("SELECT * FROM web.service " 
			+ "ORDER BY re_ref DESC, re_seq ASC " 
			+ "LIMIT #{startRow}, #{pageSize} ")
	List<ServiceVo> getServices(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize);
	
	@Update("UPDATE web.service "
			+ "SET subject = #{subject}, content = #{content} "
			+ "WHERE num = #{num} ")
	void updateBoard(ServiceVo serviceVo);
	
	@Delete("DELETE FROM web.service WHERE num = #{num}")
	void deleteServiceByNum(int num);
	
	@Delete("DELETE FROM web.service")
	void deleteAll();
	
	
	
	@Update("UPDATE web.service "
			+ "SET re_seq = re_seq + 1 "
			+ "WHERE re_ref = #{re_ref} AND re_seq > #{re_seq} ")
	boolean updateAndAddReply(ServiceVo serviceVo);
	
	
	
	void updateReSeq(
			@Param("reRef") int reRef, 
			@Param("reSeq") int reSeq);
	
	int getCountBySearch(
			@Param("category") String category, 
			@Param("search") String search);
	
	List<ServiceVo> getServicesBySearch(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize, 
			@Param("category") String category,
			@Param("search") String search);
	
	ServiceVo getServiceAndAttaches(int num);
	
//	// 매개변수 타입이 컬렉션일 때는 @Param으로 이름을 명시해야 함!
//	List<NoticeVo> getNoticesByNums(@Param("numList") List<Integer> numList);
	
}






