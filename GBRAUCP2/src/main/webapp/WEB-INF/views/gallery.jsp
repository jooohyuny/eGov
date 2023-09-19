<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="galleryArea">
		<c:forEach var="i" items="${images }">
		<table class="anImg">
			<tr>
				<td align="center">
					<img src="resources/img/${i.yd_file }">
				</td>
			</tr>
			<tr>
			<c:choose>
				<c:when test="${i.yd_uploader == sessionScope.loginMember.gm_id }">
				
				</c:when>
			</c:choose>
		
			<td align="center">
				${i.yd_title}
			</td>
			</tr>
		</table>	
	</c:forEach>
	</div>
		<table id="dataControlArea">
		<tr>
			<td align="center">
				<form action="gallery.upload" method="post"
					enctype="multipart/form-data"
					onsubmit="return galleryUploadCheck(this)">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteArea">
						<tr>
							<td><input name="yd_title" class="textType" placeholder="제목"
								maxlength="40" autocomplete="off" style="padding: 10px;"></td>
							<td rowspan="2"><input type="image"
								src="resources/img/upload.png" style="width: 40px;"></td>
						</tr>
						<tr>
							<td style="padding: 7px;"><input type="radio"
								name="yd_category" value="E57373" checked="checked">교재
								&nbsp;&nbsp; <input type="radio" name="gd_category"
								value="81C784">예제 &nbsp;&nbsp; <input type="radio"
								name="gd_category" value="64B5F6">프로그램 &nbsp;&nbsp; <input
								type="radio" name="gd_category" value="E0E0E0">기타</td>
						</tr>
						<tr>
							<td style="padding: 7px;"><input type="file" name="gd_file">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	
	
</body>
</html>