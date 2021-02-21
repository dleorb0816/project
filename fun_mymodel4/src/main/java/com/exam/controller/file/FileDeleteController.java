package com.exam.controller.file;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.controller.Controller;
import com.exam.dao.AttachMyBatisDao;
import com.exam.dao.FileMyBatisDao;
import com.exam.vo.AttachVo;

public class FileDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO ��ü �غ�
		FileMyBatisDao fileDao = FileMyBatisDao.getInstance();
		AttachMyBatisDao attachDao = AttachMyBatisDao.getInstance();

		// �Խñ۹�ȣ�� ÷�ε� ÷������ ����Ʈ ��������
		List<AttachVo> attachList = attachDao.getAttachesByNoNum(num);

		String realPath = request.getRealPath("/upload1"); // ���ε� ���ذ��

		// ÷������ �����ϱ�
		for (AttachVo attachVo : attachList) {
			// ������ ������ File Ÿ�� ��ü�� �غ�
			File file = new File(realPath + "/" + attachVo.getUploadpath(), attachVo.getFilename());
			
			if (file.exists()) { // �ش� ��ο� ������ �����ϸ�
				file.delete();   // ���� �����ϱ�
			}
		} // for

		// attach ÷�����ϳ��� �����ϱ�
		attachDao.deleteAttachesByNoNum(num);

		// notice �Խñ� �����ϱ�
		fileDao.deleteNoticeByNum(num);

		// �۸�� fileNotice.jsp �� �̵�
		response.sendRedirect("fileBoard.do?pageNum=" + pageNum);
		
		
		return null;
	}

}
