package com.spring.client.BoardController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.client.board.domain.Board;
import com.spring.client.board.service.BoardService;

import lombok.Setter;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_= @Autowired)
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(Board board, Model model) {
		List<Board> boardList = boardService.boardList(board);
		model.addAttribute("boardList",boardList);
		return "client/board/boardList";
	}
	
	@GetMapping("/insertForm")
	public String insertForm(Board board) {
		return "client/board/insertForm";
	}
	
	@PostMapping("/boardInsert")
	public String boardInsert(Board board) {
		boardService.boardInsert(board);
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/{no}")
	public String boardDetail(@PathVariable("no") Board board, Model model) {
		Board detail = boardService.boardDetail(board);
		model.addAttribute("detail",detail);
		
		String newLine = System.getProperty("line.separator").toString();
		model.addAttribute("newLine", newLine);
		
		return "client/board/boardDetail";
	}
	
	@PostMapping("/updateForm")
	public String updateForm(Board board, Model model) {
		Board updateData = boardService.updateForm(board);
		model.addAttribute("updateData", updateData);
		return "client/board/updateForm";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(Board board) {
		boardService.boardUpdate(board);
		return "redirect:/board/"+board.getNo();
		
	}
	
	@PostMapping("/boardDelete")
	public String boardDelete(Board board) {
		boardService.boardDelete(board);
		return "redirect:/board/boardList";
	}

}
