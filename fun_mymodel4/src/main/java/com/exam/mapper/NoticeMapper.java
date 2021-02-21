package com.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.exam.vo.NoticeVo;

public interface NoticeMapper {

	@Insert("INSERT INTO web.notice (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) "
			+ "VALUES (#{id}, #{subject}, #{content}, #{readcount}, #{regDate}, #{ip}, #{reRef}, #{reLev}, #{reSeq})")
	void addNotice(NoticeVo noticeVo);
	
	@Select("SELECT * FROM web.notice WHERE num = #{num}")
	NoticeVo getNoticeByNum(int num);
	
	@Select("UPDATE web.notice "
			+ "SET readcount = readcount + 1 "
			+ "WHERE num = #{num}")
	void updateReadcount(int num);
	
	@Select("SELECT COUNT(*) FROM web.notice")
	int getCountAll();
	
	@Select("SELECT * FROM web.notice " 
			+ "ORDER BY re_ref DESC, re_seq ASC " 
			+ "LIMIT #{startRow}, #{pageSize} ")
	List<NoticeVo> getNotices(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize);
	
	@Update("UPDATE web.notice "
			+ "SET subject = #{subject}, content = #{content} "
			+ "WHERE num = #{num} ")
	void updateBoard(NoticeVo noticeVo);
	
	@Delete("DELETE FROM web.notice WHERE num = #{num}")
	void deleteNoticeByNum(int num);
	
	@Delete("DELETE FROM web.notice")
	void deleteAll();
	
	@Update("UPDATE web.notice "
			+ "SET re_seq = re_seq + 1 "
			+ "WHERE re_ref = #{reRef} AND re_seq > #{reSeq} ")
	boolean updateAndAddReply(NoticeVo noticeVo);
	
//	// ��� ��� �޼ҵ�
//	@Select("SELECT COUNT(c_num) FROM web.bcomment WHERE b_num = #{b_num} ")
//	boolean commentIn(CommentVo commentVo);
	
//	// �Խñ� ��� �������� �޼ҵ� ���̽�
//	@Select("SELECT * FROM web.bcomment WHERE b_num = #{b_num}")
//	JSONArray getCommentsJSON();
	
//	// �亯 ���� �޼ҵ�
//	@Delete("DELETE FROM web.bcomment WHERE c_num = #{c_num} AND re_lev = #{reLev}")
//	void deleteComment(
//			@Param("num") int num,
//			@Param("reLev") int reLev);
	
	void updateReSeq(
			@Param("reRef") int reRef, 
			@Param("reSeq") int reSeq);
	
	int getCountBySearch(
			@Param("category") String category, 
			@Param("search") String search);
	
	List<NoticeVo> getNoticesBySearch(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize, 
			@Param("category") String category,
			@Param("search") String search);
	
	NoticeVo getNoticeAndAttaches(int num);
	
//	// �Ű����� Ÿ���� �÷����� ���� @Param���� �̸��� ����ؾ� ��!
//	List<NoticeVo> getNoticesByNums(@Param("numList") List<Integer> numList);
	
}






