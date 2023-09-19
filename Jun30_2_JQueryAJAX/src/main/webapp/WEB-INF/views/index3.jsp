<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seoul</title>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#b1").click(function(){
			$.ajax({
				url : "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/RealtimeCityAir/1/25/",
				success : function(seoulData){
					var pm10Ar=[];
					var pm25Ar=[];
					
					$.each(seoulData.RealtimeCityAir.row,function(i,a){
						pm10Ar[i] = {  y: a.PM10 , label: MSRSTE_NM};
						pm25Ar[i] = {  y: a.PM25 , label: MSRSTE_NM};
						var td1 = $("<td></td>").text(a.MSRRGN_NM);
						var td2 = $("<td></td>").text(a.MSRSTE_NM);
						var td3 = $("<td></td>").text(a.PM10);
						var td4 = $("<td></td>").text(a.PM25);
						var td5 = $("<td></td>").text(a.IDEX_NM);
						var td6 = $("<td></td>").text(a.IDEX_MVL);
						var tr = $("<tr></tr>").append(td1,td2,td3,td4,td5,td6);
						$("table").append(tr);
					});
					var chart = new CanvasJS.Chart("chartContainer", {
						title:{
							text: "서울시 미세먼지"             
						},
						data: [              
							{
							type: "stackedColumn",
							dataPoints:pm10Ar
						},	{
							type: "stackedColumn",
							dataPoints:pm25Ar
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
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<button id="b1">서울시 권역별 대기환경 받기</button>
	<hr>
	<table border="1">
		<tr>
			<td>
			</td>
		</tr>
	</table>
	
	
	
	
</body>
</html>