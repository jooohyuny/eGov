<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Daily WebPage</title>
<link rel="stylesheet" href="resources/css/sns.css">
</head>
<body>
	<table id="snsControlArea">
		<tr>
			<td align="center"></td>		
		</tr>
		<c:if test="${sessionScope.loginMember != null }">
		<tr>
			<td align="center">
				<form action="sns.write" onsubmit="return snsWriteCheck(this)">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteArea">
						<tr>
							<td><input name="gs_color" class="textType" placeholder="#FFFFFF" maxlength="6" autocomplete="off"></td>
							<td rowspan="2"><input type="image"
								src="resources/img/pen.png" style="width: 40px;"></td>
						</tr>
						<tr>
							<td><textarea name="gs_txt" class="textArea" placeholder="내용" maxlength="450" autocomplete="off"> </textarea></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		</c:if>
	</table>

</body>
</html>