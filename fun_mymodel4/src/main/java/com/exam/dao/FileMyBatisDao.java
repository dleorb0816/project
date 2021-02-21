package com.exam.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONArray;

import com.exam.mapper.FileMapper;
import com.exam.vo.FileVo;

public class FileMyBatisDao {

	private static FileMyBatisDao instance = new FileMyBatisDao();
	
	public static FileMyBatisDao getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private FileMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	// �ֱ۾��� �޼���
	public void addNotice(FileVo fileVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.addNotice(fileVo);
		}
	}
	
	
	public FileVo getNoticeByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			FileVo noticeVo = mapper.getNoticeByNum(num);
			return noticeVo;
		}
	}
	
	public void updateReadcount(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.updateReadcount(num);
		}
	}
	
	// ��ü�۰��� ��������
	public int getCountAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			int count = mapper.getCountAll();
			return count;
		}
	}
	
	// �˻�� ������ �۰��� ��������
	public int getCountBySearch(String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			return mapper.getCountBySearch(category, search);
		}
	}
	
	public List<FileVo> getNotices(int startRow, int pageSize) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			List<FileVo> list = mapper.getNotices(startRow, pageSize);
			return list;
		}
	}
	
	public List<FileVo> getNoticesBySearch(int startRow, int pageSize, String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			return mapper.getNoticesBySearch(startRow, pageSize, category, search);
		}
	}
	
	public void updateBoard(FileVo fileVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.updateBoard(fileVo);
		}
	}
	
	public void deleteNoticeByNum(int num) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.deleteNoticeByNum(num);
		}
	}
	
	public void deleteAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.deleteAll();
		}
	}
	
	// ��۾��� �޼���
	public boolean updateAndAddReply(FileVo fileVo) {
		SqlSession sqlSession = null;
		try {
			// Ʈ����� ������ ó���ϱ� ���ؼ� ����Ŀ������ ������
			sqlSession = sqlSessionFactory.openSession(false); // false�� ����Ŀ��
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			
			// ��� insert �ϱ� ���� ���� �۱׷� ���� ���� �����ϱ�
			mapper.updateReSeq(fileVo.getReRef(), fileVo.getReSeq());
			
			// ��ۿ� �˸��� ������ VO�� ����
			fileVo.setReLev(fileVo.getReLev() + 1);
			fileVo.setReSeq(fileVo.getReSeq() + 1);
			
			// ��� insert �ϱ�
			mapper.addNotice(fileVo);
			
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
	
	public JSONArray getCommentsJSON() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			return mapper.getCommentsJSON();
		}
	}
	
	public void deleteComment(int num, int lev) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.deleteComment(num, lev);
		}
	}
	
	public void updateReSeq(int ref, int seq) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			mapper.updateReSeq(ref, seq);
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



