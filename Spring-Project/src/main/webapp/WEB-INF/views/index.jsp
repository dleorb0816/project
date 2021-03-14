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
       	<div class="col-md-1" style="background-color:#3E3E3E;height:100px;width:130px">
       		aaa
       	</div>
		<div class="col-md-1" style="background-color:#1A806F;height:100px;width:130px">
       		aaa
       	</div>
       	<div class="col-md-1" style="background-color:#3E3E3E;height:100px;width:130px">
       		aaa
       	</div>
		<div class="col-md-1" style="background-color:#1A806F;height:100px;width:130px">
       		aaa
       	</div>
       	<div class="col-md-1" style="background-color:#1A806F;height:100px;width:130px">
       		aaa
       	</div>
		<div class="col-md-1" style="background-color:#3E3E3E;height:100px;width:130px">
       		aaa
       	</div>
       	<div class="col-md-1" style="background-color:#1A806F;height:100px;width:130px">
       		aaa
       	</div>
		<div class="col-md-1" style="background-color:#3E3E3E;height:100px;width:130px">
       		aaa
       	</div>

      </div>


<script src="/script/jquery-3.5.1.js"></script>

<script>

</script>
</body>
</html>