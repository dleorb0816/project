package com.exam.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONArray;

import com.exam.mapper.ServiceMapper;
import com.exam.vo.ServiceVo;

public class ServiceMyBatisDao {

	private static ServiceMyBatisDao instance = new ServiceMyBatisDao();
	
	public static ServiceMyBatisDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private ServiceMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	// 주글쓰기 메서드
	public void addService(ServiceVo serviceVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.addService(serviceVo);
		}
	}
	
	
	public ServiceVo getServiceByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			ServiceVo serviceVo = mapper.getServiceByNum(num);
			return serviceVo;
		}
	}
	
	public void updateReadcount(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.updateReadcount(num);
		}
	}
	
	// 전체글갯수 가져오기
	public int getCountAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			int count = mapper.getCountAll();
			return count;
		}
	}
	
	public List<ServiceVo> getServices(int startRow, int pageSize) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			List<ServiceVo> list = mapper.getServices(startRow, pageSize);
			return list;
		}
	}
	
	public void updateBoard(ServiceVo serviceVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.updateBoard(serviceVo);
		}
	}
	
	public void deleteServiceByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.deleteServiceByNum(num);
		}
	}
	
	public void deleteAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.deleteAll();
		}
	}
	
	// 답글쓰기 메서드
	public boolean updateAndAddReply(ServiceVo serviceVo) {
		SqlSession sqlSession = null;
		try {
			// 트랜잭션 단위로 처리하기 위해서 수동커밋으로 설정함
			sqlSession = sqlSessionFactory.openSession(false); // false면 수동커밋
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			
			// 답글 insert 하기 전에 같은 글그룹 내의 순번 수정하기
			mapper.updateReSeq(serviceVo.getReRef(), serviceVo.getReSeq());
			
			// 답글에 알맞은 값으로 VO를 수정
			serviceVo.setReLev(serviceVo.getReLev() + 1);
			serviceVo.setReSeq(serviceVo.getReSeq() + 1);
			
			// 답글 insert 하기
			mapper.addService(serviceVo);
			
			sqlSession.commit(); // 커밋하기
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); // 롤백하기
			return false;
		} finally {
			sqlSession.close(); // sqlSession 닫기
		}
	}
	
	public void updateReSeq(int reRef, int reSeq) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.updateReSeq(reRef, reSeq);
		}
	}
	
	
	// 검색어를 적용한 글갯수 가져오기
	public int getCountBySearch(String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			return mapper.getCountBySearch(category, search);
		}
	}
	
	public List<ServiceVo> getServicesBySearch(int startRow, int pageSize, String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			return mapper.getServicesBySearch(startRow, pageSize, category, search);
		}
	}
	
//	// notice 테이블과 attach 테이블 왼쪽 외부조인해서 가져오기
//	public NoticeVo getNoticeAndAttaches(int num) {
//		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
//			NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
//			return mapper.getNoticeAndAttaches(num);
//		}
//	}
	
	
	
	
//	public static void main(String[] args) {
//		NoticeMyBatisDao dao = NoticeMyBatisDao.getInstance();
//		
//		List<Integer> numList = new ArrayList<>();
//		numList.add(1014);
//		numList.add(1013);
//		numList.add(1010);
//		
//		//List<NoticeVo> noticeList = dao.getNoticesByNums(numList);
//		List<NoticeVo> noticeList = dao.getNoticesByNums(1014, 1013, 1010);
//		for (NoticeVo noticeVo : noticeList) {
//			System.out.println(noticeVo);
//		}
//		
//	}
	
}



