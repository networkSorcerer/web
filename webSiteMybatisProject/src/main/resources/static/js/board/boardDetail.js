/*수정버튼 클릭시 처리 이벤트*/

$("#updateFormBtn").click(function(){
	actionProcess("#dataForm", "get", "/board/updateForm");
});

$("#boardDeleteBtn").click(function(){
	if(confirm("정말 삭제하시겠습니까?")){
		actionProcess("#dataForm", "post","/board/boardDelete");
	}
});

$("#insertFormBtn").click(function(){
	locationProcess("/board/insertForm");
});

$("#boardListBtn").click(function(){
	locationProcess("/board/boardList");
});