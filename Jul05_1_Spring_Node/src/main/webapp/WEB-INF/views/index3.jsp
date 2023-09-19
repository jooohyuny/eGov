<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
	$(function(){

	});
</script>
</head>
<body>
	<div data-role="page" id="p1">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>1페이지</h1>
		</div>
		<div data-role="content">
			<h3>ㅋㅋㅋㅋㅋㅋ</h3>
			<a href="#p2" data-role = "button"
				data-transition = "flow">2페이지로</a>
		</div>
		<div data-role="footer" data-position="fixed">
			<h1>ㅎㅎㅎㅎ</h1>
		</div>
	</div>
	<!-- --------------------------------------------------------------------------------------- -->
	<div data-role="page" id="p2">
		<div data-role="header" data-position="fixed" data-theme="b">
			<a href="#p1" data-transition="flow"
			data-icon="arrow-l">1페이지</a>
			<h1>2페이지</h1>
		</div>
		<div data-role="content">
			<ul data-role = "listview" data-filter="true"
				data-inset="true">
				<li data-role="list-divider">과일</li>
				<li><a href="#p3">사과</a></li>
				<li>수박</li>
				<li>복숭아</li>
				<li data-role="list-divider">커피</li>
				<li>아아</li>
				<li>라떼</li>
			</ul>
			<a href="#p3" data-role = "button"
				data-transition = "flow">3페이지로</a>
		</div>
		<div data-role="footer" data-position="fixed">
			<h1>ㅎㅎㅎㅎ</h1>
		</div>
	</div>
	<!-- --------------------------------------------------------------------------------------- -->
	<div data-role="page" id="p3">
		<div data-role="header" data-position="fixed" data-theme="b">
			<a href="#p2" data-transition="flow"
			data-icon="arrow-l">2페이지</a>
			<h1>3페이지</h1>
		</div>
		<div data-role="content">
			<ul data-role = "listview" data-filter="true"
				data-inset="true">
				<li data-role="list-divider">과일</li>
				<li>사과</li>
				<li>수박</li>
				<li>복숭아</li>
				<li data-role="list-divider">커피</li>
				<li>아아</li>
				<li>라떼</li>
			</ul>
			<input>
		</div>
		<div data-role="footer" data-position="fixed">
			<h1>ㅎㅎㅎㅎ</h1>
		</div>
	</div>
</body>
</html>