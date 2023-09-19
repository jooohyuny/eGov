<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<table id=infoTbl>
	<form action="MemberInfoController" method="post"
		name="memberUpdateForm"
		enctype="multipart/form-data"
		onsubmit="return memberUpdateCheck();">
			<tr>
				<th>정보페이지 접속</th>
			</tr>
			<tr>
				<th>${sessionScope.loginMember.ym_id}</th>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" placeholder="pw"
					value="${sessionScope.loginMember.ym_pw }"
					maxlength="10" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwChk" placeholder="pw확인"
					value="${sessionScope.loginMember.ym_pw }"
					maxlength="10" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="name" 
						value="${sessionScope.loginMember.ym_name }" 
						maxlength="10" placeholder="이름" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
				<fmt:formatDate value="${sessionScope.loginMember.ym_birthday }" type="date"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="addr1" value='${addr1 }' placeholder="우편번호" autocomplete="off"><br>
					<input name="addr2" value='${addr2 }' placeholder="주소" autocomplete="off"> <br> 
					<input name="addr3" value='${addr3 }' placeholder="상세주소" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td>
					프사<br>
					<img alt="" src="imgg/${sessionScope.loginMember.ym_photo }">
					<input name="photo" type="file"><br>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>정보수정</button>
		</form>
					<button onclick="bye();">회원탈퇴</button>
				</td>
			</tr>
		</table>
</body>
</html>