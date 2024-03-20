$(".goDetail").click(function(){
	let no = $(this).parents("tr").data("no");
	console.log("글번호 : " + no);
	
	locationProcess("/board/" + no);
});

$("#insertFormBtn").click(function(){
	locationProcess("/board/insertForm");
})