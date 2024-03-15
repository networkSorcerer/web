package com.spring.client.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
	@Setter(onMethod_=@Autowired)
	private BoardService boardService;
	
//	@GetMapping("/boardList")
//	public String boardList(@ModelAttribute BoardVO bvo, Model model) {
//		log.info("boardList 호출 성공");
//		
//		//전체 레코드 조회
//		List<BoardVO> boardList = boardService.boardList(bvo);
//		model.addAttribute("boardList", boardList);
//		
//		return "client/board/boardList"; // /WEB-INF/views/client/board/boardList.jsp
//		
//	}
	
	@GetMapping("/boardList")
	public String boardList(@ModelAttribute BoardVO boardVO, Model model) {
		log.info("boardList 호출 성공");
		
		List<BoardVO> boardList = boardService.boardList(boardVO);
		model.addAttribute("boardList", boardList);
		
//		int total = boardService.boardListCnt(bvo);
//		model.addAttribute("pageMaker", new PageDTO(bvo, total));
		
		return "client/board/boardList";
	}
	
	@GetMapping(value="/insertForm")
	public String insertForm(BoardVO boardVO) {
		log.info("writeForm 호출 성공");
		
		return "client/board/insertForm"; //  /WEB-INF/views/client/board/writeForm.jsp
	}
	
//	@PostMapping("/boardInsert")
//	public String boardInsert(BoardVO bvo, RedirectAttributes ras) {
//		log.info("boardInsert 호출 성공");
//		
//		int result = 0;
//		String url = "";
//		
//		result = boardService.boardInsert(bvo);
//		if(result == 1) {
//			url = "/board/boardList";
//			
//		} else {
//			ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요");
//			url = "/board/writeForm";
//		}
//		
//		return "redirect:"+url;
//	}
	
	@PostMapping("/boardInsert")
	public String boardInsert(BoardVO boardVO) throws Exception {
		log.info("boardInsert 호출 성공 ");
		boardService.boardInsert(boardVO);
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/{boardNumber}")
	public String boardDetail(@PathVariable ("boardNumber") int boardNumber,BoardVO boardVO, Model model) {
		log.info("boardDetail 호출 성공");
		boardVO.setBoardNumber(boardNumber);
		BoardVO detail = boardService.boardDetail(boardVO);
		model.addAttribute("detail", detail);
		
		return "client/board/boardDetail";
	}
	
	@GetMapping(value="/updateForm")
	public String updateForm(@ModelAttribute BoardVO bvo, Model model) {
		log.info("updateForm 호출 성공");
		log.info("boardNumber = " + bvo.getBoardNumber());
		
		BoardVO updateData = boardService.updateForm(bvo);
		
		model.addAttribute("updateData", updateData);
		return "client/board/updateForm";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(@ModelAttribute BoardVO boardVO)throws Exception{
		log.info("boardUpdate 호출 성공");
		boardService.boardUpdate(boardVO);
		return "redirect:/board/"+boardVO.getBoardNumber();
	}
	//?????????????????????????????
//	@PostMapping(value="/boardDelete")
//	public String boardDelete(@ModelAttribute BoardVO bvo, RedirectAttributes ras) throws Exception{
//		log.info("boardDelete 호출 성공");
//		
//		int result = 0;
//		String url = "";
//		result = boardService.boardDelete(bvo);
//		
//		if(result == 1) {
//			url ="/board/boardList";
//		}else {
//			ras.addFlashAttribute("errorMsg", "삭제에 문제가 있어 다시 진행해 주세요");
//			url="/board/boardDetail?boardNumber="+bvo.getBoardNumber();
//		}
//		return "redirect:"+url;
//	}
	
	
	@PostMapping(value="/boardDelete")
	public String boardDelete(@ModelAttribute BoardVO boardVO) throws Exception {
		log.info("boardDelete 호출 성공");
		boardService.boardDelete(boardVO);
		return "redirect:/board/boardList";
	}
	
	@ResponseBody
	@PostMapping(value="/pwdConfirm", produces = "text/plain; charset=UTF-8")
	public String pwdConfirm(BoardVO boardVO) {
		log.info("pwdConfirm 호출 성공");
		int result = boardService.pwdConfirm(boardVO);
		return (result==1) ? "일치" : "불일치";
	}
	
//	@ResponseBody
//	@PostMapping(value="/pwdConfirm", produces = "text/plain; charset=UTF-8")
//	public String pwdConfirm(BoardVO bvo) {
//		int result = boardService.pwdConfirm(bvo);
//		return(result==1) ? "일치" : "불일치";
//	}
	
	//글 삭제 전 댓글 개수 구현하기
	//@Param int
//	@ResponseBody
//	@PostMapping(value="/replyCount", produces = MediaType.TEXT_PLAIN_VALUE)
//	public String replyCount(@RequestParam("boardNumber") int boardNumber) {
//		log.info("replyCount 호출 성공");
//		
//		int result = 0;
//		result = boardService.replyCount(boardNumber);
//		
//		return String.valueOf(result);
//	}
	
}
