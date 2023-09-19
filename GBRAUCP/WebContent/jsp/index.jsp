<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>미니 프로젝트</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/sns.css">
<script type="text/javascript" src="js/yunValidChecker.js"></script>
<script type="text/javascript" src="js/ywpCheck.js"></script>
<script type="text/javascript" src="js/ywpMove.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td>
				<table id="siteTitle">
					<tr>
						<th align="center"><a href="HomeController"> Mini Project
						</a></th>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteMenu">
					<tr>
						<td align="center"><a href="SNSController">게시판</a></td>
						<td align="center"><a href="CWController">싸이월드</a></td>
						<td align="center"><a href="">메뉴</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<table id="siteLoginArea">
					<tr>
						<td align="center"><jsp:include page="${loginPage }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
			<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<div id="resultDiv">${result }</div>
</body>
</html>