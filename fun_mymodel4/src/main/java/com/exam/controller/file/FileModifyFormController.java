package com.exam.controller.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exam.controller.Controller;
import com.exam.dao.AttachMyBatisDao;
import com.exam.dao.FileMyBatisDao;
import com.exam.vo.AttachVo;
import com.exam.vo.FileVo;

public class FileModifyFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileModifyFormController....");
		
		// ���� ��������
		HttpSession session = request.getSession();
		
		// �α��� ���� Ȯ��
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "redirect:/fileBoard.do";
		}
		
		// �Ķ���Ͱ�  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO �غ�
		FileMyBatisDao fileDao = FileMyBatisDao.getInstance();
		AttachMyBatisDao attachDao = AttachMyBatisDao.getInstance();

		// �۹�ȣ num�� �ش��ϴ� �۳��� VO�� ��������
		FileVo fileVo = fileDao.getNoticeByNum(num);
		// �۹�ȣ num�� �ش��ϴ� ÷������������ ����Ʈ�� ��������
		List<AttachVo> attachList = attachDao.getAttachesByNoNum(num);
		
		
		
		// ��(jsp)���� �ʿ��� ������ request ������ü�� ����
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("attachList", attachList);
		request.setAttribute("fileVo", fileVo);



		return "center/fileModifyForm";
	}

}
