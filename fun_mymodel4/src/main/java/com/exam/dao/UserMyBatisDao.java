package com.exam.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.exam.mapper.UserMapper;
import com.exam.vo.UserVo;

// �������� �������� �ٽ�Ű�� ��� ���ϴ� ô ����
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
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			mapper.addUser(userVo);
		}
	}
	
	public UserVo getUserById(String id) {
		UserVo userVo = null;
		
		// Proxy Pattern, �븮�� ����
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			userVo = mapper.getUserById(id);
		} // ���������� �ڵ����� finally�����ϰ� �ȿ� close()���� �� ���༭ ��������.

//		sqlSession.close(); // �ݾ���� Ŀ�ؼ�Ǯ�� �� �Ҹ�����ʰ� ȸ������ // �ݾ��ֱ������ �ڵ����� �ݾ��ְԲ� try()�� �־��ֱ�
		return userVo;
	}
	
	public List<UserVo> getAllUsers() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { 
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<UserVo> list = mapper.getAllUsers();
			return list;
		}
	}
	
	// �α��� Ȯ��.
		// check -1  ���� ���̵�
		// check  0  �н����� Ʋ��
		// check  1  ���̵�, �н����� ��� ��ġ
	public int userCheck(String id, String pwd) {
		int check = -1; // ���� ���̵� ���°����� �ʱ�ȭ
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
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
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			count = mapper.getCountById(id);
			return count;
		}
	}
	
	public void update(UserVo userVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			mapper.update(userVo);
		}
	}
	
	public void deleteByUserId(List<Integer> checkArray) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			mapper.deleteByUserId(checkArray);
		}
	}
	
	public void deleteById(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			mapper.deleteById(id);
		}
	}
	
	public void deleteAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
			mapper.deleteAll();
		}
	}
	
	public int selectAInum(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // �̹� ����� Ŀ�ؼ� �� �ϳ��� ������ // autocommit => true
			UserMapper mapper = sqlSession.getMapper(UserMapper.class); // �޸𸮻󿡼� �� Mapper ��������
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
	
	// �˻�� ������ �۰��� ��������
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
