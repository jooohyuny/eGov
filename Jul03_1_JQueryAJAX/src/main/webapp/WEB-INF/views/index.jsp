<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e38096f306538fd5954fab266598a5af"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
var map;
var marker;
var roadview;
var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

function move(lt,lg){
	// 지도, 로드뷰, 마커 옮기기
	var ll = new kakao.maps.LatLng(lt, lg);
	map.panTo(ll);
	marker.setPosition(ll);

	roadviewClient.getNearestPanoId(ll, 100, function(p) {
	    roadview.setPanoId(p); //panoId와 중심좌표를 통해 로드뷰 실행
	});
}

$(function(){
	// GPS있으면 GPS로, 없으면 IP주소로
	navigator.geolocation.getCurrentPosition(function(l){
		var lat = l.coords.latitude; // 위도(3?)
		var lng = l.coords.longitude; // 경도(13?)
		// REST API 키	:	b21348a9e3263c7abefcf6b76a30ee50
		// JavaScript 키	:	e38096f306538fd5954fab266598a5af
		// 현재위치 카카오맵
		var curLoc = new kakao.maps.LatLng(lat, lng); 
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = {	
			center: curLoc, 
			mapTypeId : kakao.maps.MapTypeId.ROADMAP,
			level: 3
		};
		// 마커설정
		map = new kakao.maps.Map(container, options);	//지도 생성 및 객체 리턴
		
		marker = new kakao.maps.Marker({ 
		    map: map,
			position: curLoc 
		});
		marker.setMap(map);
		

		var mapTypeControl = new kakao.maps.MapTypeControl();
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
		/////////////////////////////////////////////////////////////////////
		// 로드뷰
		var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
		roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
		roadviewClient.getNearestPanoId(curLoc, 50, function(panoId) {
		    roadview.setPanoId(panoId, curLoc); //panoId와 중심좌표를 통해 로드뷰 실행
		});
		
	});
	// --------------------------------- 지역명이랑 검색어 입력하면 해당 위치 출력
	$("#locSearch").keyup(function(e){
		if(e.keyCode == 13){
			var locSearch = $(this).val();
		 	$.ajax({
				url : "https://dapi.kakao.com/v2/local/search/address.json",
				data : {query : locSearch},
				beforeSend : function(req){
					req.setRequestHeader("Authorization", "KakaoAK b21348a9e3263c7abefcf6b76a30ee50");
				},
				success : function (zxc){
				    // 이동할 위도 경도 위치를 생성합니다 
				    move(zxc.documents[0].y, zxc.documents[0].x);
				}
			});  
		}
	});
	$("#search").keyup(function(e){
		if(e.keyCode == 13){
			$.ajax({
				url : "https://dapi.kakao.com/v2/local/search/keyword.json",
				data : {
					query : $(this).val(),
					x : map.getCenter().getLng(),
					y : map.getCenter().getLat(),
					radius : 5000
					},
				beforeSend : function(req){
					req.setRequestHeader("Authorization", "KakaoAK b21348a9e3263c7abefcf6b76a30ee50");
				},
				success : function (asd){
					// alert(JSON.stringify(asd));
					// $("#resultArea").empty();
					$.each(asd.documents, function(i,s){
						var nameTd = $("<td></td>").text(s.place_name);
						var addrTd = $("<td></td>").text(s.address_name);
						var phoneTd = $("<td></td>").text(s.phone);
						var tr = $("<tr></tr>").attr("onclick","move("+s.y+","+s.x+");").append(nameTd,addrTd,phoneTd);
						$("#resultArea").append(tr);
					});
				}
			});
		}
	});
});
</script>
</head>
<body>
	지역명 : <input id="locSearch"><br>
	검색어 : <input id="search"><br>
	<table style="width:100%;">
		<tr>
			<td style="width:40%" align="center">
				<div id="map" style="width:100%;height:400px;"></div>
			</td>
			<td style="width:40%" align="center">
				<div id="roadview" style="width:100%;height:400px;"></div>
			</td>
		</tr>
	</table>
	<table id="resultArea" border="1"></table>
</body>
</html>