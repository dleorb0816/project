package com.exam.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.exam.mapper.UserMapper;
import com.exam.vo.UserVo;

// 실제일은 맵퍼한테 다시키고 얘는 일하는 척 ㅎㅎ
public class UserMyBatisDao {

	private static UserMyBatisDao instance = new UserMyBatisDao();
	
	// instance getter
	public static UserMyBatisDao getInstance() {
		return instance;
	}
	
	// instance setter
	public static void setInstance(UserMyBatisDao instance) {
		UserMyBatisDao.instance = instance;
	}

	/////////////////////////////////////////////////////////////////////

	private SqlSessionFactory sqlSessionFactory;
	
	private UserMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	public void addUser(UserVo userVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			mapper.addUser(userVo);
		}
	}
	
	public UserVo getUserById(String id) {
		UserVo userVo = null;
		
		// Proxy Pattern, 대리자 패턴
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			userVo = mapper.getUserById(id);
		} // 내부적으로 자동으로 finally생성하고 안에 close()까지 다 해줘서 생략가능.

//		sqlSession.close(); // 닫아줘야 커넥션풀이 다 소모되지않고 회수되지 // 닫아주기싫으면 자동으로 닫아주게끔 try()에 넣어주기
		return userVo;
	}
	
	public List<UserVo> getAllUsers() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { 
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<UserVo> list = mapper.getAllUsers();
			return list;
		}
	}
	
	// 로그인 확인.
		// check -1  없는 아이디
		// check  0  패스워드 틀림
		// check  1  아이디, 패스워드 모두 일치
	public int userCheck(String id, String pwd) {
		int check = -1; // 없는 아이디 상태값으로 초기화
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			String dbPasswd = mapper.userCheck(id, pwd);
			
			if (dbPasswd != null) {
				if (pwd.equals(dbPasswd)) {
					check = 1;
				} else {
					check = 0;
				}
			} else { // dbPasswd == null
				check = -1;
			}
		}
		return check;
	}
	
	public int getCountById(String id) {
		int count = 0;
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			count = mapper.getCountById(id);
			return count;
		}
	}
	
	public void update(UserVo userVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			mapper.update(userVo);
		}
	}
	
	public void deleteByUserId(List<Integer> checkArray) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			mapper.deleteByUserId(checkArray);
		}
	}
	
	public void deleteById(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			mapper.deleteById(id);
		}
	}
	
	public void deleteAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			mapper.deleteAll();
		}
	}
	
	public int selectAInum(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 이미 연결된 커넥션 중 하나를 가져옴 // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 메모리상에서 이 Mapper 가져오기
			int num = mapper.selectAInum(id);
			return num;
		}
	}
	
	public List<UserVo> getUsersBySearch(int startRow, int pageSize, String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			return mapper.getUsersBySearch(startRow, pageSize, category, search);
		}
	}
	
	public List<UserVo> getHavesBySearch(int startRow, int pageSize, String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			return mapper.getHavesBySearch(startRow, pageSize, category, search);
		}
	}
	
	// 검색어를 적용한 글갯수 가져오기
	public int getCountBySearch(String category, String search) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			return mapper.getCountBySearch(category, search);
		}
	}
	
//	public static void main(String[] args) {
//		UserMyBatisDao dao = UserMyBatisDao.getInstance();
//		
//		UserVo userVo = dao.getMemberById("0");
////		System.out.println(memberVo);
//		
//		System.out.println("===========================");
//		
//		List<UserVo> list = dao.getAllMembers();
//		for (UserVo vo : list) {
//			System.out.println(vo);
//		}
//	}
}
