<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/NewFile.css">
</head>
<body>
	이름 : ${m.name }
	생일 : <fmt:formatDate value="${m.birthday }" pattern="yyyy/MM/dd(E)"/><p>
	나이 : ${m.age } 
</body>
</html>