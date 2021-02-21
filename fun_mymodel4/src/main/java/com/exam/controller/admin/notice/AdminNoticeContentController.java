package com.exam.controller.admin.notice;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import com.exam.controller.Controller;
import com.exam.dao.AttachMyBatisDao;
import com.exam.dao.CommentMyBatisDao;
import com.exam.dao.FileMyBatisDao;
import com.exam.dao.NoticeAttachMyBatisDao;
import com.exam.dao.NoticeMyBatisDao;
import com.exam.vo.AttachVo;
import com.exam.vo.FileVo;
import com.exam.vo.NoticeAttachVo;
import com.exam.vo.NoticeVo;

public class AdminNoticeContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminNoticeContentController......");
		
		// �Ķ���Ͱ�  num  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO ��ü �غ�
		NoticeMyBatisDao noticeDao = NoticeMyBatisDao.getInstance();
		NoticeAttachMyBatisDao attachDao = NoticeAttachMyBatisDao.getInstance();

		// ��ȸ�� 1 ����
		noticeDao.updateReadcount(num);
		
//		// �ڸ�Ʈ ��
//		int comments= commentDao.getCommentsNum(num);

		// �� �Ѱ� ��������
		NoticeVo noticeVo = noticeDao.getNoticeByNum(num);
		// ÷������ ����Ʈ ���� ��������
		List<NoticeAttachVo> noticeAttachList = attachDao.getAttachesByNoNum(num);


		// �� ���뿡�� "\n" �ٹٲ� ���ڿ��� "<br>"�� ��ü�ϱ�
		String content = "";
		if (noticeVo.getContent() != null) {
			content = noticeVo.getContent().replace("\n", "<br>");
			noticeVo.setContent(content);
		}	
		
//		// ��� ���
//		ArrayList<CommentVo> commentList = noticeDao.getComment(num);
//		//����� �Ѱ��� ������ request�� commentList�� ����
//		if(commentList.size() > 0) {
//			request.setAttribute("commentList", commentList);
//		}
		
		JSONArray jsonArray = (JSONArray) request.getAttribute("jsonArray");
		
		// ��(jsp)���� �ʿ��� �����͸� request ������ü�� ����
		request.setAttribute("noticeVo", noticeVo);
		request.setAttribute("noticeAttachList", noticeAttachList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("jsonArray", jsonArray);
//		request.setAttribute("comments", comments);
		
		return "admin/noticeContent";
	}

}
