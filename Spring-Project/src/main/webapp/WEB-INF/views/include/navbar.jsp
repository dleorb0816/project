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
				<li><a href="#">도서관이용</a>
				<ul id="sub-menu">
						<li><a href="">이용시간/휴관일</a></li>
						<li><a href="">대출/반납/예약안내</a></li>
						<li><a href="">도서관이용안내</a></li>
						<li><a href="">영장정보처리방침</a></li>
					</ul>
				</li>
				<li><a href="#">도서관서비스</a>
					<ul id="sub-menu">
						<li><a href="">책이음서비스</a></li>
						<li><a href="">타관대출반납</a></li>
						<li><a href="">책바다</a></li>
						<li><a href="">다자녀더책서비스</a></li>
					</ul>
				</li>
				<li><a href="#">자료실소개</a>
					<ul id="sub-menu">
						<li><a href="">종합자료실/연속간행물실</a></li>
						<li><a href="">유아/어린이자료실</a></li>
						<li><a href="">디지털자료실</a></li>
						<li><a href="">자율학습실</a></li>
					</ul>
				</li>
				<li><a href="#">자료찾기</a>
					<ul id="sub-menu">
						<li><a href="">자료검색/예약</a></li>
						<li><a href="">도서대출베스트</a></li>
						<li><a href="">신작도서</a></li>
						<li><a href="">연속간행물실검색</a></li>
					</ul>
				</li>
				<li><a href="#">문화행사</a>
					<ul id="sub-menu">
						<li><a href="">도서관주관</a></li>
						<li><a href="">독서의달</a></li>
						<li><a href="">독서교실</a></li>
						<li><a href="">문학강좌안내</a></li>
					</ul>
				</li>
				<li><a href="#">도서관소개</a>
					<ul id="sub-menu">
						<li><a href="">조직/업무안내</a></li>
						<li><a href="">시설/자료현황</a></li>
						<li><a href="">찾아오시는 길</a></li>
					</ul>
				</li>
				<c:set var = "id" value="${id }"/>
				<c:if test="${id == \"admin\" }">
					<li><a href="">관리자페이지</a></li>
				</c:if>
			</ul>
		</nav>

</header>
