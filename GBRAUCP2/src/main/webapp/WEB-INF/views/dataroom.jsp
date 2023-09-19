<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataRoom</title>
</head>
<body>
	<table id="dataroomFiles">
		<tr>
			<td align="center">
			<div>
			<c:forEach var="f" items="${files1 }">
				<c:choose>
					<c:when test="${f.gd_uploader == sessionScope.loginMember.gm_id}">
						<table style="border: #${f.gd_category} solid 2px; cursor:pointer;" >
							<tr>
								<td style="background-color: #${f.gd_category}99;">${f.gd_title }</td>
							</tr>
							<tr>
								<td style="background-color: #FFFFFF99;" align="center">
									<a href="dataroom.download?gd_file=${f.gd_file}">
										<img  src="resources/img/download.png">
									</a>
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
								<table style="border:#${f.gd_category} solid 3px;">
									<tr>
										<td style="background-color: #${f.gd_category}99;">${f.gd_title }</td>
									</tr>
									<tr>
										<td style="background-color: #FFFFFF99;" align="center">
											<a href="dataroom.download?gd_file=${f.gd_file }">
												<img src="resources/img/note.png">
											</a>
										</td>
									</tr>
								</table>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
        </td>
         <td align="center">
            <div>
			<c:forEach var="f" items="${files2 }">
				<table style="border: #${f.gd_category} solid 2px;">
					<tr>
						<td style="background-color: #${f.gd_category}99;">${f.gd_title }</td>
					</tr>
					<tr>
						<td style="background-color: #FFFFFF99;" align="center">
							<a href="resources/file/${f.gd_file }">
								<img  src="resources/img/download.png">
							</a>
						</td>
					</tr>
				</table>
			</c:forEach>
			</div>
			</td>
			<td align="center">
			<div>
			<c:forEach var="f" items="${files3 }">
				<table style="border: #${f.gd_category} solid 2px;">
					<tr>
						<td style="background-color: #${f.gd_category}99;">${f.gd_title }</td>
					</tr>
					<tr>
						<td style="background-color: #FFFFFF99;" align="center">
							<a href="resources/file/${f.gd_file }">
								<img  src="resources/img/download.png">
							</a>
						</td>
					</tr>
				</table>
			</c:forEach>
			</div>
			</td>
			<td align="center">
			<div>
			<c:forEach var="f" items="${files4 }">
				<table style="border: #${f.gd_category} solid 2px;">
					<tr>
						<td style="background-color: #${f.gd_category}99;">${f.gd_title }</td>
					</tr>
					<tr>
						<td style="background-color: #FFFFFF99;" align="center">
							<a href="resources/file/${f.gd_file }">
								<img  src="resources/img/download.png">
							</a>
						</td>
					</tr>
				</table>
			</c:forEach>
			</div>
			</td>
		</tr>
	</table>
	<table id="dataControlArea">
		<tr>
			<td align="center">
				<form action="dataroom.upload" method="post"
					enctype="multipart/form-data"
					onsubmit="return dataroomUploadCheck(this)">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteArea">
						<tr>
							<td><input name="gd_title" class="textType" placeholder="제목"
								maxlength="40" autocomplete="off" style="padding: 10px;"></td>
							<td rowspan="3"><input type="image"
								src="resources/img/upload.png" style="width: 40px;"></td>
						</tr>
						<tr>
							<td style="padding: 7px;"><input type="radio"
								name="gd_category" value="E57373" checked="checked">교재
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