function memberJoinCheck(form) {
	var idInput = form.gm_id;
	var pwInput = form.gm_pw;
	var pwChkInput = form.gm_pwChk;
	var nameInput = form.gm_name;
	var jumin1Input = form.gm_jumin1;
	var jumin2Input = form.gm_jumin2;
	var addr1Input = form.gm_address1;
	var addr2Input = form.gm_address2;
	var addr3Input = form.gm_address3;
	var photoInput = form.gm_photo;

	if (isEmpty(idInput) || containsHS(idInput)
			|| $("#memberJoinID").css("color") == "rgb(255, 0, 0)") {
		alert("ID?");
		idInput.value = "";
		idInput.focus();
		return false;
	}
	if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	}
	if (isEmpty(nameInput)) {
		alert("이름?");
		nameInput.focus();
		return false;
	}
	if (isEmpty(jumin1Input) || isNotNum(jumin1Input)
			|| lessThan(jumin1Input, 6) || isEmpty(jumin2Input)
			|| isNotNum(jumin2Input) || lessThan(jumin2Input, 1)) {
		alert("주민번호?");
		jumin1Input.value = "";
		jumin2Input.value = "";
		jumin1Input.focus();
		return false;
	}
	if (isEmpty(addr1Input) || isEmpty(addr2Input) || isEmpty(addr3Input)) {
		alert("주소?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr3Input.focus();
		return false;
	}
	if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("프사?")
		return false;
	}
	return true;
}

function memberLoginCheck(f) {
	var idInput = f.gm_id;
	var pwInput = f.gm_pw;
	if (isEmpty(idInput) || isEmpty(pwInput)) {
		alert("?");
		idInput.value = "";
		pwInput.value = "";
		idInput.focus();
		return false;
	}
	return true;
}

function memberUpdateCheck(form) {
	var pwInput = form.gm_pw;
	var pwChkInput = form.gm_pwChk;
	var nameInput = form.gm_name;
	var addr1Input = form.gm_address1;
	var addr2Input = form.gm_address2;
	var addr3Input = form.gm_address3;
	var photoInput = form.gm_photo;

	if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	}
	if (isEmpty(nameInput)) {
		alert("이름?");
		nameInput.focus();
		return false;
	}
	if (isEmpty(addr1Input) || isEmpty(addr2Input) || isEmpty(addr3Input)) {
		alert("주소?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr3Input.focus();
		return false;
	}
	if (isEmpty(photoInput)) {
		return true;
	}
	if (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
			&& isNotType(photoInput, "jpg") && isNotType(photoInput, "bmp")) {
		alert("프사?");
		return false;
	}
	return true;
}

function snsWriteCheck(ff) {
	var colorInput = ff.gs_color;
	var txtInput = ff.gs_txt;

	if (isEmpty(colorInput) || lessThan(colorInput, 6) || isEmpty(txtInput)) {
		alert("???")
		colorInput.value="";
		txtInput.value="";
		txtInput.focus();
		return false;
	}
	return true;
}
function snsUpdateCheck(ff) {
	var txtInput = ff.gs_txt;
	
	if (isEmpty(txtInput)) {
		alert("???")
		txtInput.value="";
		txtInput.focus();
		return false;
	}
	return true;
}

function snsReplyWriteCheck(fff) {
	var txtInput = fff.gsr_txt;
	if (isEmpty(txtInput)) {
		alert("???");
		txtInput.value="";
		txtInput.focus();
		return false;
	}
	return true;
}

function dataroomUploadCheck(d){
	var titleInput = d.gd_title;
	var fileInput = d.gd_file;
//	var categoryInput = d.gd_category;
	
	if (isEmpty(titleInput)) {
		alert("제목?");
		titleInput.value="";
		titleInput.focus();
		return false;
	}
	if (isEmpty(fileInput)
			|| (isNotType(fileInput, "png") && isNotType(fileInput, "gif")
					&& isNotType(fileInput, "jpg") && isNotType(fileInput,
					"bmp"))) {
		alert("파일?")
		return false;
	}
	return true;
}



















