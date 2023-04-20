<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="post" action="../member/doLogin">	
			<table>
					<tr>
						<td>로그인 아이디</td>
						<td><input type="text" placeholder="아이디를 입력해주세요" id="loginId" name="loginId"/></td>
					</tr>
					<tr>
						<td>로그인 비밀번호</td>
						<td><input type="password" placeholder="비밀번호를 입력해주세요" id="loginPw" name="loginPw"/></td>
					</tr>
			</table>
		</form>
		<button onclick="btn_login()">로그인</button>
	</div>
</body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	
	
	
	function btn_login(){
		let userId = $('#loginId').val();
		let userPw = $('#loginPw').val();
		
		// 아이디 이메일 형식만 가능
	    var check_id = RegExp(/^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$/);
	  	// 비밀번호 유효성 검사 (최소 8자리, 숫자,문자,특수문자 최소 1개)
	    var check_pw = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/);
		
		if(userId == "" || userId == null){
			alert("아이디를 입력해주세요");
			$('#loginId').focus();
			return false;
		}
		// 아이디 유효성 체크
      	if (!check_id.test(userId)) {
          	alert('이메일 형식으로 입력해주세요');
          	$('#loginId').val("");
          	$('#loginId').focus();
          	return false;
      	}
		if(userPw == "" || userPw == null){
			alert("비밀번호를 입력해주세요");
			$('#loginPw').focus();
			return false;
		}
		// 비밀번호 유효성 체크
	     if (!check_pw.test(userPw)) {
	         alert('영문, 숫자, 특수문자를 포함한 비밀번호를 입력해주세요.');
	         $('#loginPw').val("");
	         $('#loginPw').focus();
	         return false;
	     }
		$.ajax({
			type : 'POST',
			url : "../member/loginCheck",
			data : {"loginId" : userId, "loginPw" : userPw},
			datatype : "json",
			success : function(cnt){
				if(cnt==1){
					$("form").submit();
				}else{
					alert("사용자정보가 없습니다.");
				}
			},
			error : function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}
</script>
</html>