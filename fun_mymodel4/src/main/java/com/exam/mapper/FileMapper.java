package com.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONArray;
import com.exam.vo.FileVo;

public interface FileMapper {

	@Insert("INSERT INTO web.bnotice (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) "
			+ "VALUES (#{id}, #{subject}, #{content}, #{readcount}, #{regDate}, #{ip}, #{reRef}, #{reLev}, #{reSeq})")
	void addNotice(FileVo noticeVo);
	
	@Select("SELECT * FROM web.bnotice WHERE num = #{num}")
	FileVo getNoticeByNum(int num);
	
	@Select("UPDATE web.bnotice "
			+ "SET readcount = readcount + 1 "
			+ "WHERE num = #{num}")
	void updateReadcount(int num);
	
	@Select("SELECT COUNT(*) FROM web.bnotice")
	int getCountAll();
	
	@Select("SELECT * FROM web.bnotice " 
			+ "ORDER BY re_ref DESC, re_seq ASC " 
			+ "LIMIT #{startRow}, #{pageSize} ")
	List<FileVo> getNotices(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize);
	
	@Update("UPDATE web.bnotice "
			+ "SET subject = #{subject}, content = #{content} "
			+ "WHERE num = #{num} ")
	void updateBoard(FileVo noticeVo);
	
	@Delete("DELETE FROM web.bnotice WHERE num = #{num}")
	void deleteNoticeByNum(int num);
	
	@Delete("DELETE FROM web.bnotice")
	void deleteAll();
	
	@Update("UPDATE web.bnotice "
			+ "SET re_seq = re_seq + 1 "
			+ "WHERE re_ref = #{reRef} AND re_seq > #{reSeq} ")
	boolean updateAndAddReply(FileVo noticeVo);
	
//	// 댓글 등록 메소드
//	@Select("SELECT COUNT(c_num) FROM web.bcomment WHERE b_num = #{b_num} ")
//	boolean commentIn(CommentVo commentVo);
	
	// 게시글 댓글 가져오는 메소드 제이슨
	@Select("SELECT * FROM web.bcomment WHERE b_num = #{b_num}")
	JSONArray getCommentsJSON();
	
	// 답변 삭제 메소드
	@Delete("DELETE FROM web.bcomment WHERE c_num = #{c_num} AND re_lev = #{reLev}")
	void deleteComment(
			@Param("num") int num,
			@Param("reLev") int reLev);
	
	void updateReSeq(
			@Param("reRef") int reRef, 
			@Param("reSeq") int reSeq);
	
	int getCountBySearch(
			@Param("category") String category, 
			@Param("search") String search);
	
	List<FileVo> getNoticesBySearch(
			@Param("startRow") int startRow, 
			@Param("pageSize") int pageSize, 
			@Param("category") String category,
			@Param("search") String search);
	
	FileVo getNoticeAndAttaches(int num);
	
//	// 매개변수 타입이 컬렉션일 때는 @Param으로 이름을 명시해야 함!
//	List<NoticeVo> getNoticesByNums(@Param("numList") List<Integer> numList);
	
}






