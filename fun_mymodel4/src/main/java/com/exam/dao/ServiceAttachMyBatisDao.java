package com.exam.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.ServiceAttachMapper;
import com.exam.vo.ServiceAttachVo;

public class ServiceAttachMyBatisDao {

	private static ServiceAttachMyBatisDao instance = new ServiceAttachMyBatisDao();
	
	public static ServiceAttachMyBatisDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private ServiceAttachMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	public void insertServiceAttach(ServiceAttachVo serviceAttachVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceAttachMapper mapper = sqlSession.getMapper(ServiceAttachMapper.class);
			mapper.insertServiceAttach(serviceAttachVo);
		}
	}
	
	public ServiceAttachVo getServiceAttachByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceAttachMapper mapper = sqlSession.getMapper(ServiceAttachMapper.class);
			ServiceAttachVo serviceAttachVo = mapper.getServiceAttachByNum(num);
			return serviceAttachVo;
		}
	}
	
	public List<ServiceAttachVo> getServiceAttachesByNoNum(int noNum) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceAttachMapper mapper = sqlSession.getMapper(ServiceAttachMapper.class);
			List<ServiceAttachVo> list = mapper.getServiceAttachesByNoNum(noNum);
			return list;
		}
	}
	
	public void deleteServiceAttachesByNoNum(int noNum) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceAttachMapper mapper = sqlSession.getMapper(ServiceAttachMapper.class);
			mapper.deleteServiceAttachesByNoNum(noNum);
		}
	}
	
	public void deleteServiceAttachByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceAttachMapper mapper = sqlSession.getMapper(ServiceAttachMapper.class);
			mapper.deleteServiceAttachByNum(num);
		}
	}
}



