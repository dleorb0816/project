package com.exam.controller.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import com.exam.controller.Controller;
import com.exam.dao.AttachMyBatisDao;
import com.exam.dao.CommentMyBatisDao;
import com.exam.dao.FileMyBatisDao;
import com.exam.vo.AttachVo;
import com.exam.vo.FileVo;

public class FileContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileContentController......");
		
		// �Ķ���Ͱ�  num  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO ��ü �غ�
		FileMyBatisDao fileDao = FileMyBatisDao.getInstance();
		AttachMyBatisDao attachDao = AttachMyBatisDao.getInstance();
		CommentMyBatisDao commentDao = CommentMyBatisDao.getInstance();

		// ��ȸ�� 1 ����
		fileDao.updateReadcount(num);
		
		// �ڸ�Ʈ ��
		int comments= commentDao.getCommentsNum(num);

		// �� �Ѱ� ��������
		FileVo fileVo = fileDao.getNoticeByNum(num);
		// ÷������ ����Ʈ ���� ��������
		List<AttachVo> attachList = attachDao.getAttachesByNoNum(num);


		// �� ���뿡�� "\n" �ٹٲ� ���ڿ��� "<br>"�� ��ü�ϱ�
		String content = "";
		if (fileVo.getContent() != null) {
			content = fileVo.getContent().replace("\n", "<br>");
			fileVo.setContent(content);
		}	
		
//		// ��� ���
//		ArrayList<CommentVo> commentList = noticeDao.getComment(num);
//		//����� �Ѱ��� ������ request�� commentList�� ����
//		if(commentList.size() > 0) {
//			request.setAttribute("commentList", commentList);
//		}
		
		JSONArray jsonArray = (JSONArray) request.getAttribute("jsonArray");
		
		// ��(jsp)���� �ʿ��� �����͸� request ������ü�� ����

		request.setAttribute("fileVo", fileVo);
		request.setAttribute("attachList", attachList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("jsonArray", jsonArray);
		request.setAttribute("comments", comments);
		
		return "center/fileContent";
	}

}
