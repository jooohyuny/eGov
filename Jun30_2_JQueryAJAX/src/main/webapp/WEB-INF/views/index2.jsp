<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jun30_02</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		// AJAX (Asynchronous Javascript And Xml) : 
		//		자바스크립트로 비동기식 통신을 해서 XML 파싱하는것
		//		브라우저의 동일 출처 정책 -> 외부 데이터를 사용 불가
		
		// Cross-Domain AJAX
		//		외부 데이터 가져오는 AJAX
		//		1) 서버측에서 응답헤더 설정 해놨으면 
		
		// $.ajax({
		//		url = "프로토콜:// ... /주소",
		//		data : {param명: 값, param명: 값, ...},
		//		success : function (받은거){
		//			...	
		//		}
		// });
		
		$("#b1").click(function(){
			$.ajax({
				url : "https://www.kma.go.kr/wid/queryDFSRSS.jsp",
				data : {zone:1111061500},
				success : function(zxc){
					alert(zxc);
				}
			});
		});
		$("#b2").click(function(){
			$.ajax({
				url :"https://api.openweathermap.org/data/2.5/weather",
				data : {
					appid : "baff8f3c6cbc28a4024e336599de28c4",
					q : "seoul",
					units : "metric",
					lang : "kr"
				},
				success : function(weatherData){
					var src = "http://openweathermap.org/img/wn/"+weatherData.weather[0].icon+"@2x.png"
					$("img").attr("src", src);
					$("#descTd").text(weatherData.weather[0].description);
					var t = weatherData.main.temp + "(" + weatherData.main.humidity + "%)";
					$("#tempTd").text(t);
					var h = weatherData.main.humidity;
					$("#humidityTd").text(h);
				}
			});
		});
		
		
	});

</script>
</head>
<body>
	<button id="b1">기상청 날씨 받기</button>
	<hr>
	<button id="b2">openweathermap 날씨 받기</button>
	<table border="1">
		<tr>
			<td rowspan="3">
				<img>
			</td>
			<td id= "descTd"></td>
		</tr>
		<tr>
			<td id="tempTd">
				
			</td>
		</tr>
		<tr>
			<td id="humidityTd">
				
			</td>
		</tr>
	</table>
	
	
	
</body>
</html>