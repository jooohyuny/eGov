<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{
	width: 150px;	height:150px;
	
}
</style>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	function getShopping(start){
		var search = $("input").val();
		search = encodeURIComponent(search);
		$.ajax({
			url : "shopping.get",
			data: {q : search, s : start},
			beforeSend : function(req){
				req.setRequestHeader("ni","P3qqr6A33BZP7naZRPUV");
				req.setRequestHeader("ns","xg_TyVqLlS");
			},
			success : function(shoppingData){
				if (start==1) {
					$("table").empty();
				}
				$(shoppingData).find("item").each(function(i,item){
					var img = $("<img>").attr("src",$(item).find("image").text());
					var imgTd = $("<td></td>").append(img);
					var titleTd = $("<td></td>").html($(item).find("title").text());
					var lpriceTd = $("<td></td>").text($(item).find("lprice").text());
					var makerTd = $("<td></td>").text($(item).find("maker").text());
					var category1Td = $("<td></td>").text($(item).find("category1").text());
					var category2Td = $("<td></td>").text($(item).find("category2").text());
					var category3Td = $("<td></td>").text($(item).find("category3").text());
					var tr = $("<tr></tr>").append(imgTd,titleTd,lpriceTd,makerTd,category1Td,category2Td,category3Td);
					$("table").append(tr); 
				});
			}
		});
	}
	
	$(function(){
		var start = 0;
		$("button").click(function(){
			start = 1;
			getShopping(start);
		});
		var get = true;
		$(window).scroll(function(){
			var htmlHeight = $(document).height();
			var browserHeight = $(window).height();
			var browserOffsetTop = $(window).scrollTop();
			var browserOffsetBottom = browserOffsetTop+browserHeight;
			if(browserOffsetBottom >= htmlHeight-10 && get){
				start +=10;
				getShopping(start);
				get = false;
			} else{
				get = true;
			}
		});
		
		$("input").keyup(function(e){
				$("button").trigger("click");
		});
	});
</script>
</head>
<body>
	<input><button>검색</button>
	<table border="1"></table>
</body>
</html>