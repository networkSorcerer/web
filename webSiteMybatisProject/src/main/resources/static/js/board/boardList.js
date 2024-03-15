
$(".goDetail").on("click", function(){
	let boardNumber = $(this).parents("tr").data("num");
	console.log("글번호 : " + boardNumber);
	
	locationProcess("/board/" + boardNumber);
});

$("#insertFormBtn").on("click", function(){
	locationProcess("/board/insertForm");
});

