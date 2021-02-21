package com.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.exam.vo.CommentVo;

public interface CommentMapper {

	@Insert("INSERT INTO web.bcomment (c_id, c_content, c_date, b_num) "
			+ "VALUES (#{cId}, #{cContent}, #{cDate}, #{bNum})")
	void insertComment(CommentVo commentVo);
	
	@Select("SELECT * FROM web.bcomment WHERE b_num = #{bNum}")
	List<CommentVo> getCommentsByNum(int b_num);
	
	@Select("SELECT COUNT(*) FROM web.bcomment WHERE b_num = #{bNum} ")
	int getCommentsNum(int b_num);
	
}






