<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Daily WebPage</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<script type="text/javascript" src="resources/js/yunValidChecker.js"></script>
<script type="text/javascript" src="resources/js/gbraucp2Check.js"></script>
<script type="text/javascript" src="resources/js/gbraucp2Move.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center" style="height:60px;">
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteTitle">
					<tr>
						<td><a href="index.do">Daily WebPage</a></td>
					</tr>
					<tr>
						<td align="right"><span id="resultArea">${result }</span></td>
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
</body>
</html>