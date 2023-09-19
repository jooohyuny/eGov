<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	//AJAX (Asynchronous Javascript And Xml) : 
	//		자바스크립트로 비동기식 통신을 해서 XML 파싱하는것
	//		브라우저의 동일 출처 정책 -> 외부 데이터를 사용 불가
	
	// Cross-Domain AJAX
	//		외부 데이터 가져오는 AJAX
	//		1) 서버측에서 응답헤더(Access-Control-Allow-Origin) 설정 해놨으면 
	//		2) 안해놨으면 -> proxy 서버
	
	// $.ajax({
	//		url = "프로토콜:// ... /주소",
	//		data : {param명: 값, param명: 값, ...},
	//		beforeSend : function (요청객체){
	//			요청객체.setRequestHeader("이름", "값");
	//		}
	//		success : function (받은거){
	//			...	
	//		}
	// });
	$(function(){
		$("button").click(function(){
			$.ajax({
				url : "weather.get",
				data : {zone :1111061500},
				success : function(weatherData){
					var ar[];
					$(weatherData).find("data").each(function(i,w){
						if($(w).find("day").text()=="0"){
							ar [i] = {
									x : $(w).find("hour").text() * 1, // str -> int
									y : $(w).find("temp").text() * 1
							};
							var hourTd = $("<td></td>").text($(w).find("hour").text());
							var tempTd = $("<td></td>").text($(w).find("temp").text());
							var wfKorTd = $("<td></td>").text($(w).find("wfKor").text());
							var wdKorTd = $("<td></td>").text($(w).find("wdKor").text());
							var tr = $("<tr></tr>").append(hourTd,tempTd,wfKorTd,wdKorTd);
							$("table").append(tr);
						}
					});
					var chart = new CanvasJS.Chart("chartContainer", {
						animationEnabled: true,
						theme: "light2",
						title:{
							text: "오늘 날씨"
						},
						data: [
							{        
								type: "line",
					      		indexLabelFontSize: 16,
								dataPoints: ar
							}
							]
					});
					chart.render();
				}
			});
		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<table border="1"></table>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
</body>
</html>