package com.exam.controller.admin.notice;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exam.controller.Controller;
import com.exam.dao.NoticeAttachMyBatisDao;
import com.exam.dao.NoticeMyBatisDao;
import com.exam.vo.NoticeAttachVo;
import com.exam.vo.NoticeVo;

public class AdminNoticeModifyFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminNoticeModifyFormController....");
		
		// 세션 가져오기
		HttpSession session = request.getSession();
		
		// 로그인 여부 확인
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "redirect:/adminNoticeBoard.do";
		}
		
		// 파라미터값  pageNum  가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO 준비
		NoticeMyBatisDao noticeDao = NoticeMyBatisDao.getInstance();
		NoticeAttachMyBatisDao attachDao = NoticeAttachMyBatisDao.getInstance();

		// 글번호 num에 해당하는 글내용 VO로 가져오기
		NoticeVo noticeVo = noticeDao.getNoticeByNum(num);
		// 글번호 num에 해당하는 첨부파일정보를 리스트로 가져오기
		List<NoticeAttachVo> noticeAttachList = attachDao.getAttachesByNoNum(num);
		
		
		
		// 뷰(jsp)에서 필요한 정보를 request 영역객체에 저장
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("noticeAttachList", noticeAttachList);
		request.setAttribute("noticeVo", noticeVo);



		return "admin/noticeModifyForm";
	}

}
