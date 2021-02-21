<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- head 영역 --%>
    <jsp:include page="/WEB-INF/views/include/headContent.jsp"/>
    <link rel="stylesheet" type="text/css" href="/css/style1.css">
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
                        <!-- Top Search Area -->
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

                        <!-- Toggler -->
                        <div id="toggler"><img src="img/core-img/toggler.png" alt=""></div>

                        <!-- Navbar Toggler -->
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

    <%-- TreadingPost 영역 --%>
    <jsp:include page="/WEB-INF/views/include/treadingPost.jsp"/>

    <!-- ##### Search Area Start ##### -->
    <div align="center">
        <div class="container" style="padding-right: 1114px;">
            <div class="row">
                	<div class="col-3"></div>
                	<div class="col-3">
                      		<div class="form-group mb-30">
                      		<h1>유저 목록 [유저수: ${ pageDtoUser.count }]</h1>
							<table id="user" class="table table-striped">
								<tr>
									<th scope="col">check</th>
									<th scope="col">user id</th>
									<th scope="col">id</th>
									<th scope="col">name</th>
									<th scope="col">age</th>
									<th scope="col">gender</th>
									<th scope="col">email</th>
									<th scope="col">regdate</th>
									<th scope="col">birthday</th>
									<th scope="col">address</th>
									<th scope="col">tel</th>
									<th scope="col">level</th>
									<th scope="col">point</th>
								</tr>	
								
								<c:choose>
								<c:when test="${ not empty userList }"><%-- ${ pageDto.count gt 0 } --%>
									
									<c:forEach var="user" items="${ userList }">
										<tr>
											<td  style="height:60px"><input type="checkbox" class="chkUser" name="chkUser" value="${ user.userId }"></td>
											<td  style="height:60px">${ user.userId }</td>
											<td  style="height:60px">${ user.id }</td>
											<td  style="height:60px">${ user.name }</td>
											<td  style="height:60px">${ user.age }</td>
											<td  style="height:60px">${ user.gender }</td>
											<td  style="height:60px">${ user.email }</td>
											<td  style="height:60px"><fmt:formatDate value="${ user.regDate }" pattern="yyyy.MM.dd"/></td>
											<td  style="height:60px">${ user.birthDay }</td>
											<td  style="height:60px">${ user.address }</td>
											<td  style="height:60px">${ user.tel }</td>
											<td  style="height:60px">${ user.haveVo.level }</td>
											<td  style="height:60px">${ user.haveVo.point }</td>
										</tr>
									</c:forEach>
								</c:when>		
								<c:otherwise>
									<tr>
										<td colspan="5">유저목록 없음</td>
									</tr>
								</c:otherwise>
								</c:choose>									       
                            </table>
					
							<div id="table_search">
								<form action="adminUserBoard.do" method="get">
									<select name="category">
										<option value="id" ${ pageDtoUser.category eq 'id' ? 'selected' : '' }>id</option>
										<option value="name" ${ pageDtoUser.category eq 'name' ? 'selected' : '' }>name</option>
										<option value="tel" ${ pageDtoUser.category eq 'tel' ? 'selected' : '' }>tel</option>
									</select>
									<input type="text" class="input_box" name="search" value="${ pageDtoUser.search }">
									<input type="submit" value="검색" class="btn">
									
									<input type="button" value="회원삭제" class="btn" onclick="remove()">
									
									<%-- 로그인 했을때만 [글쓰기] 버튼 보이기 
									<c:if test="${ not empty sessionScope.id }">
										<input type="button" value="파일글쓰기" class="btn" onclick="location.href='fileWriteForm.do?pageNum=${ pageNum }'">
									</c:if>--%>
						
								</form>
							</div>
						
							<div class="clear"></div>
							<div id="page_control">
						
							<%-- 글갯수가 0보다 크면 페이지블록 계산해서 출력하기 --%>
							<c:if test="${ pageDtoUser.count gt 0 }">
								<%-- [이전] --%>
								<c:if test="${ pageDtoUser.startPage gt pageDtoUser.pageBlock }">
									<a href="userBoard.do?pageNum=${ pageDtoUser.startPage - pageDtoUser.pageBlock }&category=${ pageDtoUser.category }&search=${ pageDtoUser.search }">[이전]</a>
								</c:if>
								
								<%-- 시작페이지 ~ 끝페이지 --%>
								<c:forEach var="i" begin="${ pageDtoUser.startPage }" end="${ pageDtoUser.endPage }" step="1">
									
									<c:choose>
									<c:when test="${ i eq pageNum }">
										<a href="userBoard.do?pageNum=${ i }&category=${ pageDtoUser.category }&search=${ pageDtoUser.search }" class="active">[${ i }]</a>
									</c:when>
									<c:otherwise>
										<a href="userBoard.do?pageNum=${ i }&category=${ pageDtoUser.category }&search=${ pageDtoUser.search }">[${ i }]</a>
									</c:otherwise>
									</c:choose>
									
								</c:forEach>
								
								<%-- [다음] --%>
								<c:if test="${ pageDtoUser.endPage lt pageDtoUser.pageCount }">
									<a href="userBoard.do?pageNum=${ pageDtoUser.startPage + pageDtoUser.pageBlock }&category=${ pageDtoUser.category }&search=${ pageDtoUser.search }">[다음]</a>
								</c:if>
							</c:if>

                        	</div>
                      	</div>
                      </div>
                <!-- <div class="col-3"></div> -->
            </div>
        </div>
    </div>
    <!-- ##### Search Area End ##### -->

    <!-- ##### Catagory Area Start ##### -->
    <div class="post-catagory section-padding-100">
        <div class="container">
            <div class="row">

            </div>
        </div>
    </div>
    <!-- ##### Catagory Area End ##### -->

    <!-- ##### Instagram Area Start ##### -->
    <div class="instagram-feed-area d-flex flex-wrap">
        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta1.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta1.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta2.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta2.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta3.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta3.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta4.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta4.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta5.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta5.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta6.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta6.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta7.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta7.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta8.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta8.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta9.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta9.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>

        <!-- Single Instagram -->
        <div class="single-instagram">
            <img src="img/bg-img/insta10.jpg" alt="">
            <!-- Image Zoom -->
            <a href="img/bg-img/insta10.jpg" class="img-zoom" title="Instagram Image">+</a>
        </div>
    </div>
    <!-- ##### Instagram Area End ##### -->

    <%-- Footer 영역 --%>
    <jsp:include page="/WEB-INF/views/include/bottomFooter.jsp"/>

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
    <script>
	    function refreshMemList(){
			location.reload();
		}

    
	    function remove() {
			let isDelete = confirm('선택한 계정을 삭제하시겠습니까?');
			var pageNum = ${ pageNum };

			//배열 선언
            var check = 'input[name="chkUser"]:checked';
			var checkAll = document.querySelectorAll(check);
            var checkArray = [];
            
            // 선택된 목록에서 value 찾기
            checkAll.forEach((el) => {
            	checkArray.push(parseInt(el.value));
            });
            console.log('checkArray : ' + checkArray);

            var str = JSON.stringify(checkArray);
            console.log('str : ' + str);
            
            var objParams = {
                    "pageNum"   : pageNum, 	
                    "checkArray" : str 		//배열 저장
                };
			
			if (isDelete) {
// 				$.ajaxSettings.traditional = true;
				
				$.ajax({
					url : 'adminUserDelete.do',
					data : objParams,
					success : function() {
						alert('삭제 성공!');
						refreshMemList();
					}
				});
			}
		}

    </script>

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