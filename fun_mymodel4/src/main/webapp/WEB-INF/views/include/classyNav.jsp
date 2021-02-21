<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="classynav">
	<ul>
		<li><a href="index.do">Home</a></li>
		<li>
			<a href="adminNoticeBoard.do">Notice</a>
		</li>
		<li>
			<a href="fileBoard.do">File</a>
		</li>
		<li><a href="#">Products</a>
			<ul class="dropdown">
				<li><a href="shopMain.do">Korean</a></li>
				<li><a href="westernFood.do">western</a></li>
				<li><a href="chineseFood.do">Chinese</a></li>
				<li><a href="japaneseFood.do">Japanese</a></li>
			</ul></li>
		<li><a href="cartView.do">Cart</a></li>
		<li><a href="wishView.do">WishList</a></li>

		<li><a href="orderPage.do">OrderList</a></li>
		<li><a href="serviceBoard.do">Service</a></li>
		<li><a href="contact.do">Contact</a></li>

		<c:choose>
			<c:when test="${ level eq '관리자' }">
				<li><a href="#">Admin Menu</a>
					<ul class="dropdown">
						<li><a href="adminUserBoard.do">User List</a></li>
						<li><a href="#">Inventory List</a></li>
						<li><a href="#">Order List</a></li>
						<li><a href="adminNoticeBoard.do">Notice List</a></li>
						<li><a href="#">Event List</a></li>
					</ul></li>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</ul>

	<!-- Login/Register -->
	<div class="login-area">
		<c:choose>
			<c:when test="${ !empty id }">
				<a href="/userLogout.do">Logout</a>
				<c:choose>
					<c:when test="${ level eq '관리자' }">
						<a> / </a>
						<a href="/adminJoin.do">Admin Register</a>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<a href="/userLogin.do">Login</a>
				<a> / </a>
				<a href="/userJoin.do">Register</a>
			</c:otherwise>
		</c:choose>
	</div>

	<a href="MyPage.do"><img src="img/MyPageIcon.png" height="50" width="50"/></a>

</div>