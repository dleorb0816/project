package com.exam.controller.admin.user;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.controller.Controller;
import com.exam.dao.UserMyBatisDao;
import com.google.gson.Gson;

public class AdminUserDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminUserDeleteController......");
		
		// �Ķ���� user_id ��������
		String pageNum = request.getParameter("pageNum");
		String strCheckArray = request.getParameter("checkArray");
		
		Gson gson = new Gson();
		Integer[] arrInt = gson.fromJson(strCheckArray, Integer[].class);
		List<Integer> checkArray = Arrays.asList(arrInt);
		
//		int[] array = Arrays.asList(strCheckArray).stream().mapToInt(Integer::parseInt).toArray();
		
//		ArrayList<Integer> checkArray = new ArrayList<Integer>(array.length);
//		for (int i : array) checkArray.add(i);
//		
//		System.out.println("checkArray:"+checkArray);
		
		// DAO ��ü �غ�
		UserMyBatisDao userDao = UserMyBatisDao.getInstance();
		
		// ������ ������ ���� have, couponList ����
		userDao.deleteByUserId(checkArray);
		
		// �۸�� adminUserBoard.jsp �� �̵�
		response.sendRedirect("adminUserBoard.do?pageNum=" + pageNum);
		
		return null; // FrontController�� 2�ܰ� strView�� �����ؼ� �յڷ� �޾���
	}

}
