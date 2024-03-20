package com.spring.client.board.service;

import java.util.List;

import com.spring.client.board.domain.Board;

public interface BoardService {
	public List<Board> boardList(Board board);
	public void boardInsert(Board board);
	public void boardHitUpdate(Board board);
	public Board boardDetail (Board board);
	public Board updateForm (Board board);
	public void boardUpdate (Board board);
	public void boardDelete (Board board);
}
