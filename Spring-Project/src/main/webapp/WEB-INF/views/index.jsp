<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="/css/bootstrap-theme.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="/css/index.css" rel="stylesheet" type="text/css"> -->

<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/navbar.jsp"></jsp:include>
<div style="background-color:#1A806F" class="row">
	<div class="col-md-5 col-md-offset-7">
		<select name="category" style="margin-left:-38px">
			<option value="자료검색">자료검색</option>
			<option value="표제">표제</option>
			<option value="저자">저자</option>
			<option value="발행자">발행자</option>
		</select>
		<input type="text" />
		<button>검색하기</button>
	</div>
</div>
<div class="row" style="background-color:#1A806F">
      <img src="/imgs/library.png" class="col-md-1 col-md-offset-1" style="height:200px;width:600px" alt="" />

      <div class="col-md-4 col-md-offset-2  cont">
       	<div class="col-md-1" id="div1">
       		<a href="" id="a1">도서대출<br>회원가입</a>
       	</div>
		<div class="col-md-1" id="div2" >
       		<a href="" id="a1">대출-예약<br>내역조회</a>
       	</div>
       	<div class="col-md-1" id="div1">
       		<a href="" id="a1">희망도서<br>신청</a>
       	</div>
		<div class="col-md-1" id="div2">
       		<a href="" id="a1">온라인 <br>수강신청</a>
       	</div>
       	<div class="col-md-1" id="div2">
       		<a href="" id="a1">아이맘<br>택배서비스</a>
       	</div>
		<div class="col-md-1" id="div1">
       		<a href="" id="a1" >책나래<br>장애인 택배</a>
       	</div>
       	<div class="col-md-1" id="div2">
       		<a href="" id="a1">다자녀<br>더책서비스</a>
       	</div>
		<div class="col-md-1" id="div1">
       		<a href="" id="a1">도서관<br>공식블로그</a>
       	</div>

      </div>


<script src="/script/jquery-3.5.1.js"></script>

<script>

</script>
</body>
</html>