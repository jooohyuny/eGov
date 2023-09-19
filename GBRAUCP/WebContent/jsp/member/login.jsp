<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" name="loginForm" method="post"
		onsubmit="return loginCheck();">
		<table id="loginTbl">
			<tr>
				<td align="center"><input name="id" placeholder="id"
					maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input name="pw" type="password"
					maxlength="10" placeholder="pw"></td>
			</tr>
			<tr>
				<td align="center">
					<button>로그인</button> <a href="JoinController"> 회원가입 </a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>