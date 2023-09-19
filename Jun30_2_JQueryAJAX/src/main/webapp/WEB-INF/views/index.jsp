<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	// $.ajax({
	//		url = "프로토콜:// ... /주소",
	//		data : {param명: 값, param명: 값, ...},
	//		beforeSend : function(요청객체){
	//			요청객체.setRequestHeader("이름","값");
	//		},
	//		success : function (받은거){
	//			...	
	//		}
	// });
$(function(){
	var s = $('.slider').bxSlider({
	      mode: 'vertical',
	      captions: true,
	      slideWidth: 120,
	      auto: true,
	      pause:3000
		});
	$("button").click(function(){
		var search = $("input").val();
		$.ajax({
			url : "https://dapi.kakao.com/v3/search/book",
			data : {query : search },
			beforeSend : function(req){
				req.setRequestHeader("Authorization", "KakaoAK b21348a9e3263c7abefcf6b76a30ee50");
			},
			success : function(bookData){
				$("table").empty();
				$(".slider").empty();
				$.each(bookData.documents, function(i,b){
					var img = $("<img>").attr("src", b.thumbnail);
					var imgTd = $("<td></td>").append(img);
					var titleTd = $("<td></td>").text(b.title);
					var priceTd = $("<td></td>").text(b.price);
					var tr = $("<tr></tr>").append(imgTd,titleTd,priceTd);
					$("table").append(tr);
					
					var img2 = $("<img>").attr("src", b.thumbnail).attr("title", b.title);
					var div = $("<div></div>").append(img2);
					$(".slider").append(div);
				});
				s.reloadSlider();
			}
		});
	});
	
	$("input").keyup(function(e){
		if (e.keyCode == 13) {
			$("button").trigger("click");
		}
	});
	
});
</script>
<style type="text/css">
div {
	width:120px;
	height:180px;
}
</style>
</head>
<body>
	<input><button>검색</button>
	<div class="slider">
		<div>I am a slide.</div>
		<div>I am another slide.</div>
	</div>
	<hr>
	<table></table>
</body>
</html>