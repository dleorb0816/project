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
<div align="center">
    <form action="/member/register" method="post" name="frm" onsubmit="return submitCheck();">
        <table width="800">
            <tr height="40">
                <td align="center"><b>[회원가입]</b></td>
            </tr>
        </table>
        <table width="700" height="600" cellpadding="0" style="border-collapse:collapse; font-size:9pt;">
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">회원 ID</td>
                <td><input type="text" name="id" /><span id="idDupChk"></span></td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">비밀번호</td>
                <td><input type="password" name="pw" class="pass1" id="pw" onchange="isSame()" /></td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">비밀번호 확인</td>
                <td><input type="password" name="wUserPWConfirm" class="pass2" id="pwCheck" onchange="isSame()" />&nbsp;&nbsp;<span id="msgPass"></span></td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">이 름</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">성 별</td>
                <td>
                   	<select name="gender" required>
                   		<option value="남자" id="man">남자</option>
                   		<option value="여자" id="women">여자</option>
                   	</select>
                </td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">집전화</td>
                <td><input type="text" name="tel" /></td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">휴대전화</td>
                <td><input type="text" name="tel2" /></td>
            </tr>

            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">생년월일</td>
                <td>
	                <span>
	                	<input type="text" style="width:60px" name="yy" maxlength="4" placeholder="년(4자)" required />
	                </span>
	                <span>
	                	<select name="mm" id="mm">
	                		<option value="1">1</option>
	                		<option value="2">2</option>
	                		<option value="3">2</option>
	                		<option value="4">3</option>
	                		<option value="5">4</option>
	                		<option value="6">5</option>
	                		<option value="7">6</option>
	                		<option value="8">7</option>
	                		<option value="9">8</option>
	                		<option value="10">10</option>
	                		<option value="11">11</option>
	                		<option value="12">12</option>
	                	</select>
	                </span>
	                <input type="text" placeholder="일" name="dd" id="dd" style="width : 30px"/>
                </td>
            </tr>

            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr class="register" height="30">
                <td width="5%" align="center">*</td>
                <td width="15%">이메일</td>
                <td><input type="email" name="email" /></td>
            </tr>
            <tr height="7">
                <td colspan="3"><hr /></td>
            </tr>
            <tr>
                <td width="5%" align="center">*</td>
                <td width="15%">주 소</td>
                <td>
                    <input type="text" id="sample4_postcode" name = "postcode" placeholder="우편번호">
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample4_roadAddress" name="address" placeholder="도로명주소" size="60" ><br>
					<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소"  size="60">
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" name="address2" placeholder="상세주소"  size="60"><br>
					<input type="hidden" id="sample4_extraAddress" placeholder="참고항목"  size="60">
					<input type="hidden" id="sample4_engAddress" placeholder="영문주소"  size="60" ><br>
                </td>
            </tr>

        </table>
        <br />
        <table>
            <tr height="40">
                <td><input type="submit" id="join" value="가입하기" /></td>
            </tr>
        </table>
    </form>
</div>


<script src="/script/jquery-3.5.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

                document.getElementById("sample4_engAddress").value = data.addressEnglish;

                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script type="text/javascript">

let isID=false;
let isPw=false;
let isEmail=false;

$('input[name="id"]').keyup(function () {
	let id = $(this).val();
	console.log(id);

	//id길이가 2보다 작으면 중복체크 안함
	if(id.length<2){
		return
	}

	$.ajax({
		url: '/member/ajax/dupCheck',
		data : {id : id},
		dataType : 'json',
		success : function(response) {
			if(response.idIdDup){
				$('span#idDupChk').html('이미 사용중인 아이디 입니다.').css('color', 'red');
				isId = false;
			}
			else {
				$('span#idDupChk').html('사용가능한 아이디 입니다.').css('color', 'blue');
				isId = true;
			}
		}
	});
});


	//.pass2 요소에 포커스가 해제되면
	$('.pass2').focusout(function () {
		let pass1 = $('.pass1').val();
		let pass2 = $(this).val();

		if (pass1 == pass2) {
			$('#msgPass').html('패스워드 일치함').css('color', 'green');
			isPw=true;
		} else {
			$('#msgPass').html('패스워드 불일치').css('color', 'red');
			isPw=false;
		}
	});

	$('input[id="join"]').click(function submitCheck(){
		if( isId==false){
			alert("아이디가 중복입니다.");
			return false;
		}else if(isPw==false){
			alert("비밀번호가 다릅니다!");
			return false;
		}else
			true;
	})
</script>
</body>
</html>