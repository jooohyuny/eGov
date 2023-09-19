<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id=loginedTbl>
		<tr>
			<td align="center" rowspan="2" class= imgTd>
			<img src="imgg/${sessionScope.loginMember.ym_photo }"></td>
			<td>${sessionScope.loginMember.ym_id }
				${sessionScope.loginMember.ym_name }</td>
		</tr>
		<tr>
			<td align="center">어서오세요</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="MemberInfoController">회원정보</a>
				<a href="LoginController">로그아웃</a>
			</td>
		</tr>
	</table>
</body>
</html>