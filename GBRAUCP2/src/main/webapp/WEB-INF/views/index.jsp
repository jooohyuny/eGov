<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xml>
<head>
<meta charset="UTF-8">
<title>그래픽 기반의 실시간 AI서비스를 활용한 cross-platform 개발자 양성과정</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/dataroom.css">
<link rel="stylesheet" href="resources/css/gallery.css">
<script type="text/javascript" src="resources/js/kwonValidChecker.js"></script>
<script type="text/javascript" src="resources/js/gbraucp2Check.js"></script>
<script type="text/javascript" src="resources/js/gbraucp2Move.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/gbraucp2_jQuery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
						<td><a href="index.do">그래픽 기반의 실시간 AI서비스를 활용한 cross-platform 개발자 양성과정</a></td>
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