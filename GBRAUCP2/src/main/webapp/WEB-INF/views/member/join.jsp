<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래픽 기반의 실시간 AI서비스를 활용한 cross-platform 개발자 양성과정</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<form action="member.join" method="post" 
		enctype="multipart/form-data"
		onsubmit="return memberJoinCheck(this);">
		<table id="memberJoinTbl">
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td align="center">
					<input id="memberJoinID" name="gm_id" class="textType" placeholder="ID" maxlength="10" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="gm_pw" class="textType" type="password" placeholder="PW" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="gm_pwChk" class="textType" type="password" placeholder="PW확인" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="gm_name" class="textType" placeholder="이름" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px; height: 55px;">
					주민등록번호 &nbsp;
					<input name="gm_jumin1" class="jumin1" placeholder="XXXXXX" maxlength="6" autocomplete="off"> - 
					<input name="gm_jumin2" class="jumin2" placeholder="X" maxlength="1" autocomplete="off">XXXXXX 
				</td>
			</tr>
			<tr>
				<td align="center">
					<input id="memberJoinAddr1" readonly="readonly" name="gm_address1" class="textType" placeholder="우편번호" autocomplete="off"><br>
					<input id="memberJoinAddr2" readonly="readonly" name="gm_address2" class="textType" placeholder="주소" autocomplete="off"><br>
					<input id="memberJoinAddr3" name="gm_address3" class="textType" placeholder="상세주소" maxlength="50" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px; height: 55px;">
					프사&nbsp;&nbsp;
					<input name="gm_photo" type="file">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>가입</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>