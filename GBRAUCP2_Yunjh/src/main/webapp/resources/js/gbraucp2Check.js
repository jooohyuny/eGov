function memberJoinCheck(form) {
	var idInput = form.ym_id;
	var pwInput = form.ym_pw;
	var pwChkInput = form.ym_pwChk;
	var nameInput = form.ym_name;
	var jumin1Input = form.ym_jumin1;
	var jumin2Input = form.ym_jumin2;
	var addr1Input = form.ym_address1;
	var addr2Input = form.ym_address2;
	var addr3Input = form.ym_address3;
	var photoInput = form.ym_photo;

	if (isEmpty(idInput) || containsHS(idInput)) {
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
			|| lessWord(jumin1Input, 6) || isEmpty(jumin2Input)
			|| isNotNum(jumin2Input) || lessWord(jumin2Input, 1)) {
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
	var idInput = f.ym_id;
	var pwInput = f.ym_pw;
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
	var pwInput = form.ym_pw;
	var pwChkInput = form.ym_pwChk;
	var nameInput = form.ym_name;
	var addr1Input = form.ym_address1;
	var addr2Input = form.ym_address2;
	var addr3Input = form.ym_address3;
	var photoInput = form.ym_photo;

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
	var colorInput = ff.ys_color;
	var txtInput = ff.ys_txt;

	if (isEmpty(colorInput) || lessWord(colorInput, 6) || isEmpty(txtInput)) {
		alert("???")
		colorInput.value="";
		txtInput.value="";
		txtInput.focus();
		return false;
	}
	return true;
}
