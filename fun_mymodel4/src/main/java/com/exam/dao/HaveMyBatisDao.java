package com.exam.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.exam.mapper.HaveMapper;
import com.exam.vo.HaveVo;

public class HaveMyBatisDao {

	private static HaveMyBatisDao instance = new HaveMyBatisDao();
	
	public static HaveMyBatisDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private HaveMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	public void addHave(HaveVo haveVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			HaveMapper mapper = sqlSession.getMapper(HaveMapper.class);
			mapper.addHave(haveVo);
		}
	}
	
	public HaveVo getHaveById(int u_num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			HaveMapper mapper = sqlSession.getMapper(HaveMapper.class);
			HaveVo vo = mapper.getHaveById(u_num);
			return vo;
		}
	}
	
	// 주글쓰기 메서드
//	public void addCouponByNum(NoticeVo noticeVo) {
//		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
//			NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
//			mapper.addNotice(noticeVo);
//		}
//	}
	
}



