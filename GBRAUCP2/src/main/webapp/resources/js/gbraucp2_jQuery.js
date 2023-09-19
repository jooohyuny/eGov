function connectSummonSNSControlAreaEvent(){
	var visible = false;
	var snsControlAreaHeight = $("#snsControlArea").css("height");
	if (snsControlAreaHeight != null) {
		snsControlAreaHeight = snsControlAreaHeight.replace("px","");
		snsControlAreaHeight -= 42;
		
		$("#snsControlArea").css("bottom","-"+snsControlAreaHeight +"px");
		
		$("#snsControlAreaHandle").click(function(){
			if (visible) {
				$("#snsControlArea").css("bottom","-"+snsControlAreaHeight +"px");
			} else {
				$("#snsControlArea").css("bottom","0px")
			}
			visible = !visible;
		});
	}
}


function connectCloseSNSUpdateAreaEvent(){
	$("#x").click(function(){
		$("#blackArea").css("opacity","0");
		setTimeout(function(){
			$("#blackArea").css("left","-100%");
			$("#blackArea").css("top","-100%");
		},5000);
	});
}

function connectSummonAddressSearchAreaEvent(){
	$("#memberJoinAddr1, #memberJoinAddr2").click(function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	// alert(data);
	        	// JS객체 -> 글자
	        	// alert(JSON.stringify(data));
	        	$("#memberJoinAddr1").val(data.zonecode);
	        	$("#memberJoinAddr2").val(data.roadAddress);
	        }
	    }).open();
	});
}

function connectSummonTitleAreaEvent(){
	$("#siteTitleArea").mouseenter(function(){
		$("#siteTitleArea").css("top","0px");
	});
	$("#siteTitleArea").mouseleave(function(){
		$("#siteTitleArea").css("top","-50px");
	});
}

function connectMemberIDCheckEvent(){
	$("#memberJoinID").keyup(function(e){
	//	if (e.keyCode == 65) {
			var gm_id = $(this).val();
			$.ajax({
				url : "member.get",
				data : {gm_id : gm_id},
				success : function(memberData){
					if(memberData.members[0] == null){
						$("#memberJoinID").css("color","white");
					} else{
						$("#memberJoinID").css("color","red");
					}
				}
			});
	//	}
	});
}



$(function(){
	connectCloseSNSUpdateAreaEvent();
	connectMemberIDCheckEvent();
	connectSummonAddressSearchAreaEvent();
	connectSummonSNSControlAreaEvent();
	connectSummonTitleAreaEvent();
});



















