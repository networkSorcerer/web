$("#boardUpdateBtn").on("click",function(){
	if(!chkData("#boardTitle", "제목을"))return;
	else if(!chkData("#boardContent", "내용을"))return;
	else {
		actionProcess("#updateForm", "post", "/board/boardUpdate");
	}
});

$("#boardCancelBtn").on("click", function(){
	$("#updateForm").each(function(){
		this.reset();
	});
});

$("#boardListBtn").on("click", function(){
	locationProcess("/board/boardList");
})