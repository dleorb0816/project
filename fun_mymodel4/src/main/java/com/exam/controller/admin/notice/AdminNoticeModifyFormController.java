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
		
		// ���� ��������
		HttpSession session = request.getSession();
		
		// �α��� ���� Ȯ��
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "redirect:/adminNoticeBoard.do";
		}
		
		// �Ķ���Ͱ�  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO �غ�
		NoticeMyBatisDao noticeDao = NoticeMyBatisDao.getInstance();
		NoticeAttachMyBatisDao attachDao = NoticeAttachMyBatisDao.getInstance();

		// �۹�ȣ num�� �ش��ϴ� �۳��� VO�� ��������
		NoticeVo noticeVo = noticeDao.getNoticeByNum(num);
		// �۹�ȣ num�� �ش��ϴ� ÷������������ ����Ʈ�� ��������
		List<NoticeAttachVo> noticeAttachList = attachDao.getAttachesByNoNum(num);
		
		
		
		// ��(jsp)���� �ʿ��� ������ request ������ü�� ����
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("noticeAttachList", noticeAttachList);
		request.setAttribute("noticeVo", noticeVo);



		return "admin/noticeModifyForm";
	}

}
