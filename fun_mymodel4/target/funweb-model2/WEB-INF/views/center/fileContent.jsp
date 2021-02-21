<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#wrap {
	width: 800px;
	margin: 0 auto 0 auto;
}

#detailBoard {
	text-align: center;
}

#title {
	height: 16;
	font-family: '돋움';
	font-size: 12;
	text-align: center;
	background-color: #F7F7F7;
}

#btn {
	font-family: '돋움';
	font-size: 14;
	text-align: center;
}
</style>

	<%-- head 영역 --%>
	<jsp:include page="/WEB-INF/views/include/headContent.jsp"/>
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

	<div id="wrap" align="center">
		<div class="clear"></div>
		<div id="sub_img_center"></div>
		<div class="clear"></div>
		<article>

			<h1>후기남기기 게시판 상세보기</h1>

			<table id="notice" border="1" class="table table-striped">
				<tr>
					<th scope="col" class="tno" style="width: 100px">글번호</th>
					<td class="left" width="500">${ fileVo.num }</td>
				</tr>
				<tr>
					<th scope="col" class="tread" style="width: 100px">조회수</th>
					<td class="left">${ fileVo.readcount }</td>
				</tr>
				<tr>
					<th scope="col" class="twrite" style="width: 100px">작성자</th>
					<td class="left">${ fileVo.id }</td>
				</tr>
				<tr>
					<th scope="col" class="tdate" style="width: 100px">작성일자</th>
					<td class="left"><fmt:formatDate value="${ fileVo.regDate }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<th scope="col" class="ttitle" style="width: 100px">글제목</th>
					<td class="left">${ fileVo.subject }</td>
				</tr>
				<tr>
					<th scope="col" class="ttitle" style="width: 100px">글내용</th>
					<td class="left">${ fileVo.content }</td>
				</tr>
				<tr>
					<th scope="col" class="ttitle" style="width: 100px">첨부파일</th>
					<td class="left"><c:if test="${ not empty attachList }">

							<c:forEach var="attach" items="${ attachList }">

								<c:choose>
									<c:when test="${ attach.image eq 'I' }">
										<p>
											<a
												href="/upload1/${ attach.uploadpath }/${ attach.filename }">
												<img
												src="/upload1/${ attach.uploadpath }/${ attach.filename }"
												width="100" height="100">
											</a>
										</p>
									</c:when>
									<c:otherwise>
										<p>
											<a
												href="/upload1/${ attach.uploadpath }/${ attach.filename }">
												${ attach.filename } </a>
										</p>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</c:if></td>
				</tr>
			</table>

			<div id="replyList"></div>

			<div id="table_CRUD">
				<%-- 로그인 했을때 --%>
				<c:if test="${ not empty id }">
					<%-- 로그인 아이디와 글작성자 아이디가 같을때 --%>
					<c:if test="${ id eq fileVo.id }">
						<input type="button" value="글수정" class="btn"
							onclick="location.href = 'fileModifyForm.do?num=${ fileVo.num }&pageNum=${ pageNum }'">
						<input type="button" value="글삭제" class="btn" onclick="remove()">
					</c:if>
				</c:if>
				<input type="button" value="목록보기" class="btn"
					onclick="location.href = 'fileboard.do?pageNum=${ pageNum }'">
			</div>

			<div class="comment_list">
				<div>
					<span><strong>Comments</strong></span> <span id="cCnt"></span>
				</div>

				<%-- 기존 존재하는 댓글들 --%>
				<div>
					<div id="commentList"></div>
				</div>

				<%-- 로그인 했을때 나오는 댓글입력창 --%>
				<c:if test="${ not empty id }">
					<form id="writeCommentForm" name="commentForm" method="post">
						<input type="hidden" id="b_num" name="b_num"
							value="${ fileVo.num }"> <input type="hidden"
							id="pageNum" name="pageNum" value="${ pageNum }"> <br>
						<br>
						<table>
							<tr>
								<td>
									<%-- 아이디 --%>
									<div>${ id }</div> <%-- 본문 작성 --%>
									<div>
										<textarea id="area_comment" name="comment_content" rows="4"
											cols="70" style="width: 800px"></textarea>
									</div> <%-- 댓글 등록 버튼 --%>
									<div>
										<a href="#" id="BtnCmt" onclick="writeCmt()">[댓글등록]</a>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</c:if>
			</div>

			<div class="clear"></div>
			<div id="page_control"></div>

		</article>

		<div class="clear"></div>

	</div>

	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script>
		function remove() {
			let isDelete = confirm('${ fileVo.num }번 글을 정말 삭제하시겠습니까?');
			if (isDelete) {
				location.href = 'fileDelete.do?num=${ fileVo.num }&pageNum=${ pageNum }';
			}
		}

		// 댓글 등록
		function writeCmt() {
			var b_num = $("#b_num").val();
			var pageNum = $("#pageNum").val();
			var c_content = $("#area_comment").val();

			$.ajax({
				url : 'jsonCommentInsert.do',
				data : {
					"b_num" : b_num,
					"c_content" : c_content,
					"pageNum" : pageNum
				},
				success : function(data) {
					getCommentList();
					$("#area_comment").val("");
				},
				error : function(request, status, error) {
					//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		}
		// 초기페이지 로딩시 댓글 불러오기
		//    	$(function() {
		getCommentList();
		//    	});

		// 댓글 불러오기
		function getCommentList() {
			//alert('getCommentList 호출됨');

			var b_num = $("#b_num").val();
			var pageNum = $("#pageNum").val();

			$.ajax({
				url : 'jsonCommentGet.do',
				data : {
					"b_num" : b_num,
					"pageNum" : pageNum
				},
				success : function(data) {
					renderComment(data);
					countComment(data);

				}
			});
		}

		// 댓글 수 세기(JSON)
		function countComment(data) {
			var commentNum = 0;
			var commentNum = data.totalCount;
			$("#cCnt").html(commentNum);
		}


		function renderComment(data) {
			var str = '';

			var commentList = data.commentList;

			if (commentList.length > 0) {
				for (var comment of commentList) {
					str += `
						<div>
							<div>
								<table class='table'>
									<tr>
										<td>
					 						<div> \${comment.c_id} </div>
					 						<div> \${comment.c_content} </div>
				 						</td>
			 						</tr>
		 							<tr>
		 								<td> \${comment.c_date} </td>
	 								</tr>
 								</table>
							</div>
						</div>
					`;
				}
			} else {
				str += `
					<div>
					   <div>
					   	<table class='table'>
					   		<tr>
					   			<td><div><p>등록된 댓글이 없습니다.</p></div></td>
					   		</tr>
				 		</table>
			 		   </div>
			 		</div>
				`;
			}
			$("#commentList").html(str);
		}


	</script>


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



