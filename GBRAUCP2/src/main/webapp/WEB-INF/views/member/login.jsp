<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래픽 기반의 실시간 AI서비스를 활용한 cross-platform 개발자 양성과정</title>
</head>
<body>
	<form action="member.login" method="post" 
		onsubmit="return memberLoginCheck(this);">
		<table id="loginTbl">
			<tr>
				<td>
					<input name="gm_id" placeholder="id" maxlength="10" autocomplete="off">
					<input name="gm_pw" type="password" placeholder="pw" maxlength="10">&nbsp;&nbsp;
					<button>로그인</button>&nbsp;&nbsp;
					<a href="member.join.go">회원가입</a>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>