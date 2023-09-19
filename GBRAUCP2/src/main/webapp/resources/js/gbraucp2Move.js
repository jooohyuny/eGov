function memberBye() {
	if (confirm("탈퇴?")) {
		location.href = "member.bye";
	}
}

function snsPageChange(page) {
	location.href = "sns.page.change?page="+page;
}

function snsDelete(no){
	if (confirm ("ㄹㅇ?")) {
		location.href = "sns.delete?gs_no="+no;
	}
}

/*function snsUpdate(no,txt,page){
	txt = prompt("수정할 내용", txt);
	if (txt != null &txt.length < 451) {
		location.href = "sns.update?gs_no="+ no + "&gs_txt=" + txt +"&page="+page;
	}
}
*/
function snsReplyDelete(no,page){
	if (confirm ("ㄹㅇ?")) {
		location.href = "sns.reply.delete?gsr_no="+no + "&page=" + page;
	}
}
function snsReplyUpdate(no,txt,page){
	txt = prompt("댓글 수정할 내용", txt)
	if (txt != null & txt.length<200) {
		location.href = "sns.reply.update?gsr_no="+no +"&gsr_txt="+ txt + "&page=" + page;
	}
}

function summonSNSUpdateArea(no,txt, page){
	// java : 다 바꾸게
	// js : 첫번째것만 바꾸게 -> 정규식
	txt = txt.replace(/<br>/g,"\r\n");
	$("#snsUpdateGsNo").val(no);
	$("#snsUpdateGsTxt").val(txt);
	$("#snsUpdatePage").val(page);
	
	$("#blackArea").css("left","0px");
	$("#blackArea").css("top","0px");
	$("#blackArea").css("opacity","1");
}














