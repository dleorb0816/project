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
		
		// VO 객체 준비
		UserVo userVo = new UserVo();
		String id = request.getParameter("id");
		
		// 액션태그로 VO객체에 파라미터값 저장
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
		
		// DAO 객체 준비
		UserMyBatisDao userDao = UserMyBatisDao.getInstance();
		HaveMyBatisDao haveDao = HaveMyBatisDao.getInstance();
		// 회원가입 메서드 호출
		userDao.addUser(userVo);
		
		//////////////////////////////////////////////////////
		
		// VO 객체 준비
		HaveVo haveVo = new HaveVo();
		UserVo vo = userDao.getUserById(id);
		// VO객체에 파라미터값 저장
		haveVo.setLevel("관리자");
		haveVo.setPoint(9999999);
		haveVo.setuNum(Integer.parseInt(vo.getUserId()));
		
		haveDao.addHave(haveVo);
		
		// 로그인 화면 요청경로로 리다이렉트시키기 위해서
		// 리다이렉트 정보를 리턴함
		return "redirect:/userLogin.do";
//		return "member/login";
		// 이런식으로하면 회원가입이 끝나고 바로 jsp를 실행해서 보는화면이 login인건
		// 똑같음. 대신 새로고침이 발생함. 한번더 insert된다.
	}

}
