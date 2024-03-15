$("#boardInsertBtn").on("click",function(){
	if(!chkData("#boardName", "작성자명을"))return;
	else if(!chkData("#boardTitle", "제목을"))return;
	else if(!chkData("#boardContent", "내용을"))return;
	else if(!chkData("#boardPasswd", "비밀번호를"))return;
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