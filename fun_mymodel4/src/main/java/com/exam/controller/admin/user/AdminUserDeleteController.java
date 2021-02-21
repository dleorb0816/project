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
		
		// 파라미터 user_id 가져오기
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
		
		// DAO 객체 준비
		UserMyBatisDao userDao = UserMyBatisDao.getInstance();
		
		// 유저와 유저에 딸린 have, couponList 삭제
		userDao.deleteByUserId(checkArray);
		
		// 글목록 adminUserBoard.jsp 로 이동
		response.sendRedirect("adminUserBoard.do?pageNum=" + pageNum);
		
		return null; // FrontController쪽 2단계 strView로 리턴해서 앞뒤로 달아줌
	}

}
