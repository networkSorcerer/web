package com.spring.client.board.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.board.domain.Board;
import com.spring.client.board.repository.BoardRepository;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_=@Autowired)
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> boardList(Board board) {
		List<Board> boardList = null;
		boardList = (List<Board>) boardRepository.findAll();
		return boardList;
	}

	@Override
	public void boardInsert(Board board) {
		// TODO Auto-generated method stub
		boardRepository.save(board);
	}
	
	@Override
	public void boardHitUpdate(Board board) {
		Optional<Board> boardOptional = boardRepository.findById(board.getNo());
		Board dataBoard = boardOptional.get();
		dataBoard.setHit(dataBoard.getHit()+1);
		boardRepository.save(dataBoard);
	}
	
	@Override
	public Board boardDetail (Board board) {
		boardHitUpdate(board);
		Optional<Board> boardOptional = boardRepository.findById(board.getNo());
		Board detail = boardOptional.get();
		return detail;
	}
	
	@Override
	public Board updateForm(Board board) {
		Optional<Board> boardOptional = boardRepository.findById(board.getNo());
		Board updateData = boardOptional.get();
		
		return updateData;
	}
	
	@Override
	public void boardUpdate(Board board) {
		Optional <Board>boardOptional = boardRepository.findById(board.getNo());
		Board updateBoard = boardOptional.get();
		
		updateBoard.setTitle(board.getTitle());
		updateBoard.setContent(board.getContent());
		if(!board.getPasswd().isEmpty()) {
			updateBoard.setPasswd(board.getPasswd());
		}
		boardRepository.save(updateBoard);
	}

	@Override
	public void boardDelete(Board board) {
		boardRepository.deleteById(board.getNo());
		
	}

}
