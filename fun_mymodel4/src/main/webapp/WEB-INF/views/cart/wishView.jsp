<%@page import="java.text.DecimalFormat"%>
<%@page import="com.exam.vo.CartDTO"%>
<%@page import="com.exam.dao.WishDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");


String id = (String) session.getAttribute("id");

ArrayList<CartDTO> wish = null;


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart View</title>

	<%-- head 영역 --%>
	<jsp:include page="/WEB-INF/views/include/headContent.jsp"/>
<script type="text/javascript">
function fnPay(){
	alert("결제 API를 발급 받으시기 바랍니다.");
}

function fnClear(){
	if(confirm("찜목록을 비우시겠습니까?")) {
		location.href = "WishClear.do";	////////////////////////////////////////////////
	}
}

function fnGo(){
		location.href = "index.do";
}
</script>
</head>
<body>
<%-- preLoader 영역 --%>
<jsp:include page="/WEB-INF/views/include/preLoader.jsp"/>

<!-- ##### Header Area Start ##### -->
<header class="header-area">

	<!-- Top Header Area -->
	<div class="top-header-area bg-img bg-overlay" style="background-image: url(img/bg-img/header.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center justify-content-between">
				<div class="col-12 col-sm-6">
					<!-- Top Social Info -->
					<div class="top-social-info">
						<a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
						<a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a>
						<a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a>
						<a href="#" data-toggle="tooltip" data-placement="bottom" title="Dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
						<a href="#" data-toggle="tooltip" data-placement="bottom" title="Behance"><i class="fa fa-behance" aria-hidden="true"></i></a>
						<a href="#" data-toggle="tooltip" data-placement="bottom" title="Linkedin"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-lg-5 col-xl-4">
					<!-- Top Search Area, 검색바 -->
					<div class="top-search-area">
						<form action="#" method="post">
							<input type="search" name="top-search" id="topSearch" placeholder="Search">
							<button type="submit" class="btn"><i class="fa fa-search"></i></button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Logo Area -->
	<div class="logo-area">
		<a href="index.do"><img src="img/core-img/logo.png" alt=""></a>
	</div>

	<!-- Navbar Area -->
	<div class="bueno-main-menu" id="sticker">
		<div class="classy-nav-container breakpoint-off">
			<div class="container">
				<!-- Menu -->
				<nav class="classy-navbar justify-content-between" id="buenoNav">

					<!-- Toggler, 삼선메뉴 -->
					<div id="toggler"><img src="img/core-img/toggler.png" alt=""></div>

					<!-- Navbar Toggler, 빈공간인듯 에바임 -->
					<div class="classy-navbar-toggler">
						<span class="navbarToggler"><span></span><span></span><span></span></span>
					</div>

					<!-- Menu -->
					<div class="classy-menu">
						<!-- Close Button -->
						<div class="classycloseIcon">
							<div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
						</div>

						<%-- Nav 영역 --%>
						<jsp:include page="/WEB-INF/views/include/classyNav.jsp"/>
					</div>
				</nav>
			</div>
		</div>
	</div>
</header>
<!-- ##### Header Area End ##### -->
    	
<div align="center" style="height: 456px">
	<h3>[찜목록 보기]</h3>
	<table border="0" style="border-spacing: 0px; width: 484px">
		<tr>
			<th style="border-bottom: 1px solid black;text-align: center;">번호</th>
			<th style="border-bottom: 1px solid black;text-align: center;">제품명</th>
			<th style="border-bottom: 1px solid black;text-align: center;">단가</th>
			<th style="border-bottom: 1px solid black;text-align: center;">주문 수량</th>
			<th style="border-bottom: 1px solid black;text-align: center;">가격</th>
		</tr>
		<%
		
		// 비회원 이면
		if(id == null){
			out.println("<tr align='center'>");
				out.println("<td colspan= '5'>");
					out.println("회원만 이용가능합니다");
					out.println("<a href= 'userLogin.do'>로그인하기</a>");
				out.println("</td>");
			out.println("</tr>");

		} // 비회원이면
		
		else { // 회원이면
			
			WishDao wishDao = WishDao.getInstance();
			// DB(cart)에서 세션id에 해당하는 컬럼들을 Array리스트에 담기 
			wish = wishDao.getItemsById(id);
			
			if(wishDao.wishCheck(id)) { // 카트안에 물품이 없으면
				out.println("<tr align='center'>");
					out.println("<td colspan= '5'>");
						out.println("찜목록에 담긴 상품이 없습니다.");
						out.println("<a href= 'index.do'>주문하기</a>");
					out.println("</td>");
				out.println("</tr>");
			} else {
				
				int totalSum = 0, total = 0;
				DecimalFormat df = new DecimalFormat("￦#,##0");
				for(int i = 0; i < wish.size(); i++) {
					CartDTO dto = wish.get(i);
					out.println("<tr align= 'center' class=\"table success\">");
						out.println("<td style=\"height:60px\">" + (i + 1) + "</td>");
						out.println("<td style=\"height:60px\">" + dto.getProduct_name() + "</td>");
						out.println("<td style=\"height:60px\">" + df.format(dto.getProduct_price()) + "</td>");
						out.println("<td style=\"height:60px\">" + dto.getProduct_count() + "</td>");
						total = dto.getProduct_price() * dto.getProduct_count();
						out.println("<td style=\"height:60px\">" + df.format(total) + "</td>");
					out.println("</tr>");
					totalSum += total;
				}
			out.println("<tr align = 'center'>");
				out.println("<td colspan= '4'>");
					out.println("<input type='button' value='찜목록 비우기' onclick='fnClear()'  style=\"width : 116px; background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px\"/>");
					out.println("<input type='button' value='쇼핑 계속하기' onclick='fnGo()'  style=\"width : 116px; background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px\"/>");
				out.println("</td>");
				out.println("<td>");
				out.println(df.format(totalSum));
				out.println("</td>");
			out.println("</tr>");
			}//if else
			
		}
		%>
	</table>
</div>

<%-- footer 영역 --%>
<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp" />
</div>

<!-- ##### All Javascript Script ##### -->
<!-- jQuery-2.2.4 js -->
<script src="js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="js/bootstrap/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins js -->
<script src="js/plugins/plugins.js"></script>
<!-- Active js -->
<script src="js/active.js"></script>

<!--Start of Tawk.to Script-->
<script type="text/javascript">
	var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
	(function(){
		var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
		s1.async=true;
		s1.src='https://embed.tawk.to/5fd03c53920fc91564ced709/default';
		s1.charset='UTF-8';
		s1.setAttribute('crossorigin','*');
		s0.parentNode.insertBefore(s1,s0);
	})();
</script>
<!--End of Tawk.to Script-->
</body>
</html>