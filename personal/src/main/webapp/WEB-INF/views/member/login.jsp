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
		<table>
				<tr>
					<td>로그인 아이디</td>
					<td><input type="text" placeholder="아이디를 입력해주세요" id="userId"/></td>
				</tr>
				<tr>
					<td>로그인 비밀번호</td>
					<td><input type="password" placeholder="비밀번호를 입력해주세요" id="userPw"/></td>
				</tr>
		</table>
		<button onclick="btn_login()">로그인</button>
	</div>
</body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	function btn_login(){
		let userId = $('#userId').val();
		let userPw = $('#userPw').val();
		
		if(userId == "" || userId == null){
			alert("아이디를 입력해주세요");
			$('#userId').focus();
			return false;
		}
		if(userPw == "" || userPw == null){
			alert("비밀번호를 입력해주세요");
			$('#userPw').focus();
			return false;
		}
		$.ajax({
			type : 'POST',
			url : "../member/doLogin",
			data : {"userId" : userId, "userPw" : userPw},
			datatype : "json",
			success : function(cnt){
				if(cnt == 1){
					alert("Ddddd");
					location.href="/pe";
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