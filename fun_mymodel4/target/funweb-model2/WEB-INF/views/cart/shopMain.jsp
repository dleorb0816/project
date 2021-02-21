<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
	<%-- head 영역 --%>
	<jsp:include page="/WEB-INF/views/include/headContent.jsp"/>

	<link rel="stylesheet" type="text/css" href="/css/style2.css">
<meta charset="UTF-8">
<title>ShopMain JSP</title>
<script type="text/javascript">
function fnCart(name, price) {
	//alert("Name : " + name + "\nPrice : " + price);
	if(confirm("장바구니에 담으시겠습니까?")) {
		location.href = "CartProcess.do?name=" + name + "&price=" + price;
	}
}

function fnView() {
	if(confirm("장바구니를 보시겠습니까?")){
		location.href = "cartView.do";
	}
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

	<div align="center" style="background-color: #f8f9fa">
		<h3 style="color:black">[Korean Food!]</h3>
		<table class="test">
			<tr align="right">
				<td colspan="3"><input type="button" value="장바구니 보기"
					onclick="fnView()" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/></td>
			</tr>

			<tr align='center'>
				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table>
						<tr align='center'>
							<td><img src='img/food/bibimbap.jpg' width='150'
								height='150' style="height: 150px;"/></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='비빔밥' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='4500' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' class="test" value='장바구니 담기'  style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" class="test"  value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" class="test"  value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
							</td>

						</tr>

					</table>
					</form>
				</div>
				</td>


				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table>
						<tr align='center'>
							<td><img src='img/food/BG.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='부대찌개' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='6500' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>

					</table>
					</form>
					</div>
				</td>



				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table >
						<tr align='center'>
							<td><img src='img/food/bgg.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='불고기' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='6000' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>

					</table>
					</form>
					</div>
				</td>
			</tr>

			<tr align='center'>

				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table >
						<tr align='center'>
							<td><img src='img/food/DDUK.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='떡볶이' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='4000' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>
					</table>
					</form>
					</div>
				</td>


				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table>
						<tr align='center'>
							<td><img src='img/food/DG.jpg' width='150'
									 style="height: 150px;"  /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='된장찌개' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='3500' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>

					</table>
					</form>
					</div>
				</td>

				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table >
						<tr align='center'>
							<td><img src='img/food/gimchi.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='김치전' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='3000' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>
					</table>
					</form>
					</div>
				</td>
			</tr>

			<tr align='center'>

				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table>
						<tr align='center'>
							<td><img src='img/food/KG.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='김치찌개' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='5000' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>

					</table>
					</form>
					</div>
				</td>


				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table>
						<tr align='center'>
							<td><img src='img/food/SG.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='순두부찌개' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='4500' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>

						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>

					</table>
					</form>
					</div>
				</td>


				<td>
					<div style="background-color: white">
					<form action="CartProcess.do" method="post" name ="frm" align = 'center'>
					<table >
						<tr align='center'>
							<td><img src='img/food/ST.jpg' width='150'
								height='150' style="height: 150px;" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' class="apple1" name="name" value='삼계탕' readonly style="border:none" /></td>
						</tr>
						<tr align='center'>
							<td><input type='text' name="price" value='7000' readonly style="border:none;width: 40px;"/>원
							<td><input type='hidden' name="pagename" value='1' />
							</td>
						</tr>
						<tr align='center'>
							<td><input type='submit' value='장바구니 담기' style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"/>
								<input type="submit" value="찜하기" formaction="WishProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px">
								<input type="submit" value="상세보기" formaction="detailProcess.do" style="background-color: #69934b;color:#fff;border:1px solid #69934b;border-radius: 5px"></td>
						</tr>

					</table>
					</form>
					</div>
				</td>
			</tr>
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