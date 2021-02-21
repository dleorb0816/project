package com.exam.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.exam.vo.HaveVo;
import com.exam.vo.UserVo;

public interface UserMapper {

	@Insert("INSERT INTO web.user (id, pwd, name, age, gender, email, reg_date, birth_day, address, tel) "
			+ "VALUES (#{id}, #{pwd}, #{name}, #{age}, #{gender}, #{email}, #{regDate}, #{birthDay}, #{address}, #{tel})")
	void addUser(UserVo userVo);
	
	@Select("SELECT * FROM web.user WHERE id = #{id}")
	UserVo getUserById(String id);
	
	@Select("SELECT * FROM web.user")
	List<UserVo> getAllUsers();
	
	@Select("SELECT pwd FROM web.user WHERE id = #{id}")
	String userCheck(
			@Param("id") String id, 
			@Param("pwd") String pwd);
	
	@Select("SELECT COUNT(*) FROM web.user WHERE id = #{id}")
	int getCountById(String id);
	
	@Update("UPDATE web.user "
			+ "SET name = #{name}, age = #{age}, gender = #{gender}, email = #{email}, birth_day = #{birthDay}, address = #{address}, tel = #{tel} "
			+ "WHERE id = #{id} ")
	void update(UserVo userVo);
	
	@Delete("DELETE FROM web.user WHERE id = #{id}")
	void deleteById(String id);
	
	@Delete("DELETE FROM web.user")
	void deleteAll();
	
	//////////////////////////////////////////////////
	
	@Select("SELECT user_id FROM web.user WHERE id = #{id}")
	int selectAInum(String id);
	
	void deleteByUserId(
			@Param("checkArray") List<Integer> checkArray);
	
	List<UserVo> getUsersBySearch(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize, 
			@Param("category") String category,
			@Param("search") String search);
	
	List<UserVo> getHavesBySearch(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize, 
			@Param("category") String category,
			@Param("search") String search);
	
	int getCountBySearch(
			@Param("category") String category, 
			@Param("search") String search);
	
//	UserVo getNoticeAndAttaches(int num);
	
//	// 매개변수 타입이 컬렉션일 때는 @Param으로 이름을 명시해야 함!
//	List<NoticeVo> getNoticesByNums(@Param("numList") List<Integer> numList);
	
}






