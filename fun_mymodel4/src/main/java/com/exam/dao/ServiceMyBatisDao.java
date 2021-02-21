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
	
	
	// �ֱ۾��� �޼���
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
	
	// ��ü�۰��� ��������
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
	
	// ��۾��� �޼���
	public boolean updateAndAddReply(ServiceVo serviceVo) {
		SqlSession sqlSession = null;
		try {
			// Ʈ����� ������ ó���ϱ� ���ؼ� ����Ŀ������ ������
			sqlSession = sqlSessionFactory.openSession(false); // false�� ����Ŀ��
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			
			// ��� insert �ϱ� ���� ���� �۱׷� ���� ���� �����ϱ�
			mapper.updateReSeq(serviceVo.getReRef(), serviceVo.getReSeq());
			
			// ��ۿ� �˸��� ������ VO�� ����
			serviceVo.setReLev(serviceVo.getReLev() + 1);
			serviceVo.setReSeq(serviceVo.getReSeq() + 1);
			
			// ��� insert �ϱ�
			mapper.addService(serviceVo);
			
			sqlSession.commit(); // Ŀ���ϱ�
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); // �ѹ��ϱ�
			return false;
		} finally {
			sqlSession.close(); // sqlSession �ݱ�
		}
	}
	
	public void updateReSeq(int reRef, int reSeq) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
			mapper.updateReSeq(reRef, reSeq);
		}
	}
	
	
	// �˻�� ������ �۰��� ��������
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
	
//	// notice ���̺�� attach ���̺� ���� �ܺ������ؼ� ��������
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



