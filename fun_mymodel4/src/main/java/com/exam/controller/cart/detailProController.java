package com.exam.controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;

public class detailProController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("detailProController...");

		HttpSession session = request.getSession();

		String id = (String)session.getAttribute("id");
		String name = (String)request.getParameter("name");
		String price = (String)request.getParameter("price");
		String pagename = (String)request.getParameter("pagename");

		session.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("pagename", pagename);


		return "cart/detailView";
	}

}
