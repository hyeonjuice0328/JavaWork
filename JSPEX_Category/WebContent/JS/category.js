var MAX_DEPTH =3;

$(document).ready(function() {
	loadPage(1);
});

function loadPage(depth, parnet) {
if(parent == undefined) parent = 0;

	$.ajax({
		url : "cate_list.ajax",
		type : "POST",
		data : {
			"depth" : depth,
			"parent" : parent
		},
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				// alert("AJAX 성공: 받아쮸~");
				updateList(depth, data);

			}
		}
	});
} // end loadPage()

function updateList(depth, jsonObj) {

	if (jsonObj.status != "OK")  return;
	
	var elm = $("div#mycate span:nth-child(" + depth + ") select");
	
	elm.attr("disabled", false);
	elm.off("change"); // change 이벤트 핸들러 삭제 ? 
	elm.empty(); // 내용 지우기 - update 를 위해 
	
	var list = jsonObj.data;
	
	var result = "<option value='0'>--선택하세요--</option>";
	
	for (i = 0; i < count; i++) {
		result += "<option value='" + items[i].uid + "'>";
		result += list[i].name;
		result += "</option>"
	}
	elm.html(result);
	
	// select 의 onchange 이벤트 핸들러 작성 
	
	elm.change(function(){
		
		if(depth < MAX_DEPTH){
			for(var d = depth + 1; d <= MAX_DEPTH; d++){
				var e = $("div#mycate span:nth-child(" + d + ") select");
				e.off("change");
				e.empty();
				e.attr("disabled", true);
			}
			
			if(elm.val() > 0) {
				loadPage(depth + 1, elm.val());
			}
		}
		
	});
}
	
	/*{
		var count = jsonObj.count;
		var i;
		var items = jsonObj.data; 
		for (i = 0; i < count; i++) {
			$("#select1").attr("disabled", false);
			result += "<option value='" + items[i].uid
					+ "' data-depth='" + items[i].depth + "'>" + items[i].name
					+ "</option>";
		}
		$("#select1").html(result);

		$("#select1").change(
				function() {

					$.ajax({
						url : "cate_list.ajax",
						type : "POST",
						data : {
							depth : 2,
							parent : $(this).val()
						},
						cache : false,
						success : function(data, status) {
							if (status == "success") {
								// alert("AJAX 성공: 받아쮸~");
								updateList2(data);

							}
						}
					});

					for (i = 0; i < count; i++) {
						if ($(this).val() != 0) {
							result += "<option value='"
									+ items[i].uid + "' data-depth='"
									+ items[i].depth + "'>" + items[i].name
									+ "</option>";
						}
						;
					}
					;

					$("#select2").html(result);
					
					
				});
	};
}

function updateList2(jsonObj) {
	result = "<option>-----선택하세요------</option>";

	if (jsonObj.status == "OK") {
		var count = jsonObj.count;
		var i;
		var items = jsonObj.data; // 배열
		for (i = 0; i < count; i++) {
			$("#select2").attr("disabled", false);
			result += "<option class='opt' value='" + items[i].uid
					+ "' data-depth='" + items[i].depth + "'>" + items[i].name
					+ "</option>";
		}
		$("#select2").html(result);
	}

}

function updateList3(jsonObj) {
	result = "<option>-----선택하세요------</option>";

	if (jsonObj.status == "OK") {
		var count = jsonObj.count;
		var i;
		var items = jsonObj.data; // 배열
		for (i = 0; i < count; i++) {
			$("#select3").attr("disabled", false);
			result += "<option class='opt' value='" + items[i].uid
					+ "' data-depth='" + items[i].depth + "'>" + items[i].name
					+ "</option>";
		}
		$("#select3").html(result);
	}

}


*/