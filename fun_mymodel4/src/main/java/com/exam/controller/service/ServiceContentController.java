package com.exam.controller.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.controller.Controller;
import com.exam.dao.ServiceAttachMyBatisDao;
import com.exam.dao.ServiceMyBatisDao;
import com.exam.vo.ServiceAttachVo;
import com.exam.vo.ServiceVo;

public class ServiceContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ServiceContentController......");
		
		// �Ķ���Ͱ�  num  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO ��ü �غ�
		ServiceMyBatisDao serviceDao = ServiceMyBatisDao.getInstance();
		ServiceAttachMyBatisDao serviceAttachDao = ServiceAttachMyBatisDao.getInstance();

		// ��ȸ�� 1 ����
		serviceDao.updateReadcount(num);

		// �� �Ѱ� ��������
		ServiceVo serviceVo = serviceDao.getServiceByNum(num);
		// ÷������ ����Ʈ ���� ��������
		List<ServiceAttachVo> serviceAttachList = serviceAttachDao.getServiceAttachesByNoNum(num);


		// �� ���뿡�� "\n" �ٹٲ� ���ڿ��� "<br>"�� ��ü�ϱ�
		String content = "";
		if (serviceVo.getContent() != null) {
			content = serviceVo.getContent().replace("\n", "<br>");
			serviceVo.setContent(content);
		}
		
		// ��(jsp)���� �ʿ��� �����͸� request ������ü�� ����
		request.setAttribute("serviceVo", serviceVo);
		request.setAttribute("serviceAttachList", serviceAttachList);
		request.setAttribute("pageNum", pageNum);
		
		return "service/serviceContent";
	}

}
