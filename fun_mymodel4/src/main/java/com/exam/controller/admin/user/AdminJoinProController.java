package com.exam.controller.admin.user;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.controller.Controller;
import com.exam.dao.HaveMyBatisDao;
import com.exam.dao.UserMyBatisDao;
import com.exam.vo.HaveVo;
import com.exam.vo.UserVo;

public class AdminJoinProController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminJoinProController......");
		
		// VO ��ü �غ�
		UserVo userVo = new UserVo();
		String id = request.getParameter("id");
		
		// �׼��±׷� VO��ü�� �Ķ���Ͱ� ����
		userVo.setId(id);
		userVo.setPwd(request.getParameter("pwd"));
		userVo.setName(request.getParameter("name"));
		userVo.setAge(Integer.parseInt(request.getParameter("age")));
		userVo.setGender(request.getParameter("gender"));
		userVo.setEmail(request.getParameter("email"));
		userVo.setRegDate(new Timestamp(System.currentTimeMillis()));
		userVo.setBirthDay(request.getParameter("birthday"));
		userVo.setAddress(request.getParameter("address"));
		userVo.setTel(request.getParameter("tel"));
		
		// DAO ��ü �غ�
		UserMyBatisDao userDao = UserMyBatisDao.getInstance();
		HaveMyBatisDao haveDao = HaveMyBatisDao.getInstance();
		// ȸ������ �޼��� ȣ��
		userDao.addUser(userVo);
		
		//////////////////////////////////////////////////////
		
		// VO ��ü �غ�
		HaveVo haveVo = new HaveVo();
		UserVo vo = userDao.getUserById(id);
		// VO��ü�� �Ķ���Ͱ� ����
		haveVo.setLevel("������");
		haveVo.setPoint(9999999);
		haveVo.setuNum(Integer.parseInt(vo.getUserId()));
		
		haveDao.addHave(haveVo);
		
		// �α��� ȭ�� ��û��η� �����̷�Ʈ��Ű�� ���ؼ�
		// �����̷�Ʈ ������ ������
		return "redirect:/userLogin.do";
//		return "member/login";
		// �̷��������ϸ� ȸ�������� ������ �ٷ� jsp�� �����ؼ� ����ȭ���� login�ΰ�
		// �Ȱ���. ��� ���ΰ�ħ�� �߻���. �ѹ��� insert�ȴ�.
	}

}
