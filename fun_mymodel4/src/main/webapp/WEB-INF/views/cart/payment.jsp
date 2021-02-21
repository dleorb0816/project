<%@page import="com.exam.vo.UserVo" %>
<%@page import="com.exam.dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    // 	int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
    int tpNum = (Integer) session.getAttribute("tp");
    String id = (String) session.getAttribute("id");

    UserDao userDao = UserDao.getInstance();
    UserVo userVo = new UserVo();

    userVo = userDao.getUserById(id);

    String name = userVo.getName();
    String phone = userVo.getTel();
    String address = userVo.getAddress();
    String email = userVo.getEmail();

%>
<!DOCTYPE html>
<html>
<head>
    <%-- head 영역 --%>
    <jsp:include page="/WEB-INF/views/include/headContent.jsp"/>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i
                                class="fa fa-pinterest" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i
                                class="fa fa-facebook" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i
                                class="fa fa-twitter" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Dribbble"><i
                                class="fa fa-dribbble" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Behance"><i
                                class="fa fa-behance" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Linkedin"><i
                                class="fa fa-linkedin" aria-hidden="true"></i></a>
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

<div align="center">
    <h2>주문자 정보를 입력하세요</h2>
    <input type="radio" name="radio" id="new" value="new">새로입력
    <input type="radio" name="radio" id="get" value="get">회원정보와 동일

    <form action="kakao.do" method="post">
        <div>
            <a> 이름 </a>
            <input type="text" id="name" name="name" style="margin-left: 64px"> <br>
        </div>

        <div>
            <a> 폰번호 </a>
            <input type="text" id="phone" name="phone" style="margin-left: 48px"> <br>
        </div>

        <div>
            <a> 주소 </a>
            <input type="text" id="address" name="address" style="margin-left: 64px"> <br>
        </div>

        <div>
            <a> 이메일 </a>
            <input type="text" id="email" name="email" style="margin-left: 48px"> <br>
        </div>

        <input type="hidden" name="totalPrice" value="<%=tpNum %>">
        <Button type="submit" value="고고">진짜 결제하기</button>
    </form>
</div>

<script src="/script/jquery-3.5.1.js"></script>
<script>
    $(document).ready(function () {
        $("input:radio[name=radio]").click(function () {
            if ($("input[name=radio]:checked").val() == "new") {
                $("input:text[name=name]").val('');
                $("input:text[name=phone]").val('');
                $("input:text[name=address]").val('');
                $("input:text[name=email]").val('');
            } else if ($("input[name=radio]:checked").val() == "get") {
                $("input:text[name=name]").val('<%=name %>');
                $("input:text[name=phone]").val('<%=phone %>');
                $("input:text[name=address]").val('<%=address %>');
                $("input:text[name=email]").val('<%=email %>');
            }
        });
    });

</script>

<%-- footer 영역 --%>
<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp"/>
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