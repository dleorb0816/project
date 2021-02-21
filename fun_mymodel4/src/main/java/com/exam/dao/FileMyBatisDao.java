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
	
	
	// 주글쓰기 메서드
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
	
	// 전체글갯수 가져오기
	public int getCountAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			int count = mapper.getCountAll();
			return count;
		}
	}
	
	// 검색어를 적용한 글갯수 가져오기
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
	
	// 답글쓰기 메서드
	public boolean updateAndAddReply(FileVo fileVo) {
		SqlSession sqlSession = null;
		try {
			// 트랜잭션 단위로 처리하기 위해서 수동커밋으로 설정함
			sqlSession = sqlSessionFactory.openSession(false); // false면 수동커밋
			FileMapper mapper = sqlSession.getMapper(FileMapper.class);
			
			// 답글 insert 하기 전에 같은 글그룹 내의 순번 수정하기
			mapper.updateReSeq(fileVo.getReRef(), fileVo.getReSeq());
			
			// 답글에 알맞은 값으로 VO를 수정
			fileVo.setReLev(fileVo.getReLev() + 1);
			fileVo.setReSeq(fileVo.getReSeq() + 1);
			
			// 답글 insert 하기
			mapper.addNotice(fileVo);
			
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



