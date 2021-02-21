package com.exam.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.NoticeAttachMapper;
import com.exam.vo.NoticeAttachVo;

public class NoticeAttachMyBatisDao {

	private static NoticeAttachMyBatisDao instance = new NoticeAttachMyBatisDao();
	
	public static NoticeAttachMyBatisDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private NoticeAttachMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	public void insertAttach(NoticeAttachVo noticeAttachVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			NoticeAttachMapper mapper = sqlSession.getMapper(NoticeAttachMapper.class);
			mapper.insertAttach(noticeAttachVo);
		}
	}
	
	
	public NoticeAttachVo getAttachByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			NoticeAttachMapper mapper = sqlSession.getMapper(NoticeAttachMapper.class);
			NoticeAttachVo noticeAttachVo = mapper.getAttachByNum(num);
			return noticeAttachVo;
		}
	}
	
	public List<NoticeAttachVo> getAttachesByNoNum(int noNum) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			NoticeAttachMapper mapper = sqlSession.getMapper(NoticeAttachMapper.class);
			List<NoticeAttachVo> list = mapper.getAttachesByNoNum(noNum);
			return list;
		}
	}
	
	public void deleteAttachesByNoNum(int noNum) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			NoticeAttachMapper mapper = sqlSession.getMapper(NoticeAttachMapper.class);
			mapper.deleteAttachesByNoNum(noNum);
		}
	}
	
	public void deleteAttachByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			NoticeAttachMapper mapper = sqlSession.getMapper(NoticeAttachMapper.class);
			mapper.deleteAttachByNum(num);
		}
	}
}



