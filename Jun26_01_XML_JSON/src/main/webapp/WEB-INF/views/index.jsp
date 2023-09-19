<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url : "http://localhost/jun2601/snack.get",
				success : function(zxc){
					$(zxc).find("snack").each(function(i,s){
						alert($(s).find("s_name").text());
						alert($(s).find("s_price").text());
					});
				}
			});
		});
		$("input").click(function(){
			$.ajax({
				url : "menu.get",
				data : {page : 1},
				success : function(asd){
					$.each(asd.menu,function(i,m){
						alert($(m).find("m_name").text());
						alert($(m).find("m_price").text());
					});
				}
			});u
		}); 
	});
</script>
</head>
<body>
	<input>
	<button>버튼</button>

<!-- 
	<c:forEach var="s" items="${snacks}">
		${s.s_name } : ${s.s_price }<br>
	</c:forEach>
	<c:forEach var="m" items="${menus}">
		${m.m_name } : ${m.m_price }<br>
	</c:forEach>
 -->
</body>
</html>