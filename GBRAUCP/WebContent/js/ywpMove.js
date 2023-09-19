function bye() {
	var really = prompt("bye");
	if (really == "bye") {
		location.href = "ByeController";
	}
}
function deleteSNSMsg(no) {
	if (confirm("real?")) {
		location.href = "SNSDeleteController?no=" + no;
	}
}
function deleteSNSReply(no) {
	if (confirm("?")) {
		location.href = "SNSReplyDeleteController?no=" + no;
	}
}

function updateSNSMsg(no, txt) {
	txt = prompt("edit content :", txt);
	if (txt != null & txt.length < 251) {
		location.href = "SNSUpdateController?no=" + no + "&txt=" + txt;
	}
}



