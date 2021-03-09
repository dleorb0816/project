<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
		<div class="container">
			<div class="row">
				<div class="col-md-2 cont">
					<img width='200' src="/imgs/library.jpg" />
				</div>
				<div class="col-md-6">
					<h3 class="title"><a href="/">중앙도서관</a></h3>
				</div>
				<div class="col-md-3">
					<div class="login">

					<c:set var = "id" value="${id }"/>
					<c:if test ="${id != null }">
						<span>${id }님 어서오세요</span>
						<span>/</span>
						<span><a href="/member/logout">로그아웃</a></span>
					</c:if>
					<c:if test="${id == null }">
					<span><a href="/member/login">로그인</a></span>
						<span>/</span>
						<span><a href="/member/join">회원가입</a></span>
					</c:if>

					</div>
				</div>
			</div>
		</div>

		<nav role="navigation">
			<ul id="main-menu">
				<li><a href="#">MENU1</a></li>
				<li><a href="#">Menu2</a>
					<ul id="sub-menu">
						<li><a href="">submenu</a></li>
						<li><a href="">submenu</a></li>
						<li><a href="">submenu</a></li>
						<li><a href="">submenu</a></li>
					</ul></li>
				<li><a href="#">MENU3</a></li>
				<li><a href="#">MENU4</a></li>
				<li><a href="#">MENU5</a></li>
				<li><a href="#">MENU6</a></li>
			</ul>
		</nav>

</header>
