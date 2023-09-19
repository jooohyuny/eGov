<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래픽 기반의 실시간 AI서비스를 활용한 cross-platform 개발자 양성과정</title>
<link rel="stylesheet" href="resources/css/sns.css">
</head>
<body>
	<c:forEach var="sm" items="${msgs}">
		<table class="aSNSMsg" style="box-shadow: 5px 5px 5px#${sm.gs_color};">
			<tr>
				<td align="left" class="imgTd" rowspan="1">
					<img class="writeImg" src="resources/img/${sm.gm_photo }">
				</td>
				<td class="writerTd" style="text-shadow: 3px 3px 3px#${sm.gs_color};">${sm.gs_writer }</td>
			</tr>
			<tr>
				<td align="right" class="dateTd">
					<fmt:formatDate value="${sm.gs_date }" type="both" dateStyle="long" timeStyle="short" />
				</td>
			</tr>
			<tr>
				<td class="txtTd" align="center">${sm.gs_txt }</td>
			</tr>
			<tr>
				<td class="replyTd">
				<c:forEach var="sr" items="${sm.gs_reply }">
						<c:choose>
							<c:when	test="${sr.gsr_writer == sessionScope.loginMember.gm_id }">
								<div class="aSNSReply" ondblclick="snsReplyDelete(${sr.gsr_no},${page });" style="cursor:pointer;">
									<span class="writer" style="text-shadow: 0px 2px 2px#${sm.gs_color};">${sr.gsr_writer }</span>
									${sr.gsr_txt }- <span class="date">
									<fmt:formatDate	value="${sr.gsr_date }" type="date" dateStyle="short" />
									</span>
								</div>
							</c:when>
							<c:otherwise>
								<div class="aSNSReply" onclick="snsReplyUpdate(${sr.gsr_no},'${sr.gsr_txt }',${page});" style="cursor:pointer;">
									<span class="writer"style="text-shadow: 0px 2px 2px#${sm.gs_color};">${sr.gsr_writer }</span>
									${sr.gsr_txt }- <span class="date"> 
									<fmt:formatDate	value="${sr.gsr_date }" type="date" dateStyle="short" />
									</span>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach> 
					<c:if test="${sessionScope.loginMember != null }">
						<form action="sns.reply.write"
							onsubmit="return snsReplyWriterCheck(this);">
							<input name="gsr_gs_no" value="${sm.gs_no }" type="hidden">
							<input name="page" value="${page }" type="hidden"> 
							<input name="token" value="${token }" type="hidden"> 
							<span class="writer" style="text-shadow: 0px 2px 2px#${sm.gs_color};">${sr.gsr_writer }</span> 
							<input name="gsr_txt" style="border-bottom: #${sm.gs_color};"placeholder="내용" maxlength="150" autocomplete="off">
							<button style="color: #${sm.gs_color};">쓰기</button>
						</form>
					</c:if>
				</td>
			</tr>
			<c:if test="${sm.gs_writer == sessionScope.loginMember.gm_id }">
				<tr>
					<td align="right" colspan="2">
						<img onclick="summonSNSUpdateArea(${sm.gs_no},'${sm.gs_txt}',${page});"class="btnImg" src="resources/img/note.png"> 
						<img onclick="snsDelete(${sm.gs_no});" class="btnImg"src="resources/img/delete.png">
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
	<table id="snsControlArea">
		<tr>
			<td align="center">
				<form action="sns.search">
					<table style="width: 500px;">
						<tr>
							<td colspan="2" align="left">
								<img src="resources/img/menu.png" id="snsControlAreaHandle">
							</td>
						</tr>
						<tr>
							<td id="snsSearchArea1" valign="top">
								<input name="search" class="textType" placeholder="검색"
								 	maxlength="50"	autocomplete="off">
							 </td>
							<td id="snsSearchArea2">
								<input type="image"src="resources/img/search.png"
									style="width: 30px; margin-top: 10px;">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<c:if test="${sessionScope.loginMember != null }">
			<tr>
				<td align="center">
					<form action="sns.write" onsubmit="return snsWriteCheck(this)">
						<input name="token" value="${token }" type="hidden">
						<table id="snsWriteArea">
							<tr>
								<td>
									<input name="gs_color" class="textType"
										placeholder="#FFFFFF" maxlength="6" autocomplete="off">
								</td>
								<td rowspan="2">
									<input type="image" src="resources/img/pen.png" style="width: 40px;">
								</td>
							</tr>
							<tr>
								<td>
									<textarea name="gs_txt" class="textArea"placeholder="내용" maxlength="450" autocomplete="off"> 
									</textarea>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</c:if>
	</table>
	<c:if test="${page !=1 }">
		<div id="snsL" onclick="snsPageChange(${page-1 });"></div>
	</c:if>
	<c:if test="${page !=pageCount }">
		<div id="snsR" onclick="snsPageChange(${page+1 });"></div>
	</c:if>
	<table id = "blackArea">
		<tr>
			<td align="center">
				<form action="sns.update" onsubmit="return snsUpdateCheck(this);">
				<input name="gs_no" id="snsUpdateGsNo" type="hidden">
				<input name="page" id="snsUpdatePage" type="hidden">
				<table id="snsRewriteArea">
					<tr>
						<td colspan="2" align="right">
							<span id="x">X</span>
						</td>
					</tr>	
					<tr>
						<td>
							<textarea name="gs_txt" id = "snsUpdateGsTxt" class="textArea"placeholder="내용" maxlength="450" autocomplete="off"> 
							</textarea>
						</td>
						<td>
							<input type="image" class="rewriteImg" src="resources/img/pen.png" style="width: 30px;">
						</td>
					</tr>
				</table>
				</form>
			</td>		
		</tr>
	</table>
</body>
</html>












