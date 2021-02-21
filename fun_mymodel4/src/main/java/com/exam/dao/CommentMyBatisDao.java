package com.exam.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.CommentMapper;
import com.exam.vo.CommentVo;

public class CommentMyBatisDao {

	private static CommentMyBatisDao instance = new CommentMyBatisDao();
	
	public static CommentMyBatisDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private CommentMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	public void insertComment(CommentVo commentVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
			mapper.insertComment(commentVo);
		}
	}
	
	public List<CommentVo> getCommentsByNum(int bNum) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
			List<CommentVo> list = mapper.getCommentsByNum(bNum);
			return list;
		}
	}
	
	public int getCommentsNum(int bNum) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
			int count = mapper.getCommentsNum(bNum);
			return count;
		}
	}
}



