// 웹 유효성검사 라이브러리
//		최대한 다양한 상황에서 쓸수있게
//		긍정/부정 컨셉은 통일되어야 함
// input을 넣었을때
// 안썼으면 true, 썼으면 false

function isEmpty(input) {
	return !input.value;
}

// input, 글자수를 넣었을때
// 짧으면 true, 아니면 false
function lessWord(input, len) {
	return input.value.length < len;
}

// input넣었을때
// 한글/특수문자가 있으면 true, 없으면 false
//	-_@.은 괜찮고
function containsHS(input) {
	var hs = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890-_.@";
	for (var i = 0; i < input.value.length; i++) {
		if (hs.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
	return false;
}
// input x 2 넣었을때
// 입력한게 다르면 true, 같으면 false
function notEquals(input1, input2) {
	return input1.value != input2.value;
}

// 비번조합 - 영문,숫자,특수문자포함 5자 ~ 15자 : 사이트마다 다르니깐
// input, 문자열세트 넣었을때
// 그거 안들어있으면 true, 들어있으면 false
function notContains(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

// input넣었을때
// 숫자가 아니면 true, 숫자면 false
function isNotNum(input) {
	return input.value.indexOf(" ") != -1 || isNaN(input.value);
}

// input, 확장자
// 그 파일이 아니면 true, 그거 맞으면 fasle

// 너무 무책임
//		1) 확장자 : 애초에 허상
//		2) 
function isNotType(input, type) {
	type = "." + type;
	return input.value.toLowerCase().indexOf(type) == -1;
}


