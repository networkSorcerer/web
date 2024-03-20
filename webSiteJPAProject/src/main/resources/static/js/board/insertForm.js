$("#boardInsertBtn").on("click",function(){
	if(!chkData("#name", "작성자명을"))return;
	else if(!chkData("#title", "제목을"))return;
	else if(!chkData("#content", "내용을"))return;
	else if(!chkData("#passwd", "비밀번호를"))return;
	else{
		actionProcess("#insertForm", "post", "/board/boardInsert");
	}
});

$("#boardCancelBtn").on("click", function(){
	$("#insertForm").each(function(){
		this.reset();
	});
});

$("#boardListBtn").on("click",function(){
	locationProcess("/board/boardList");
});