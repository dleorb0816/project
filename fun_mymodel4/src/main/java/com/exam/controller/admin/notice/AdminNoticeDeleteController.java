package com.exam.controller.admin.notice;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.controller.Controller;
import com.exam.dao.NoticeAttachMyBatisDao;
import com.exam.dao.NoticeMyBatisDao;
import com.exam.vo.NoticeAttachVo;

public class AdminNoticeDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO ��ü �غ�
		NoticeMyBatisDao noticeDao = NoticeMyBatisDao.getInstance();
		NoticeAttachMyBatisDao attachDao = NoticeAttachMyBatisDao.getInstance();

		// �Խñ۹�ȣ�� ÷�ε� ÷������ ����Ʈ ��������
		List<NoticeAttachVo> noticeAttachList = attachDao.getAttachesByNoNum(num);

		String realPath = request.getRealPath("/upload1"); // ���ε� ���ذ��

		// ÷������ �����ϱ�
		for (NoticeAttachVo attachVo : noticeAttachList) {
			// ������ ������ File Ÿ�� ��ü�� �غ�
			File file = new File(realPath + "/" + attachVo.getUploadpath(), attachVo.getFilename());
			
			if (file.exists()) { // �ش� ��ο� ������ �����ϸ�
				file.delete();   // ���� �����ϱ�
			}
		} // for

		// attach ÷�����ϳ��� �����ϱ�
		attachDao.deleteAttachesByNoNum(num);

		// notice �Խñ� �����ϱ�
		noticeDao.deleteNoticeByNum(num);

		// �۸�� fileNotice.jsp �� �̵�
		response.sendRedirect("adminNoticeBoard.do?pageNum=" + pageNum);
		
		
		return null;
	}

}
