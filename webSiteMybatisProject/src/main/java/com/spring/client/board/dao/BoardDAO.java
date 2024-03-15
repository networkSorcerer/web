package com.spring.client.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.client.board.vo.BoardVO;

@Mapper
public interface BoardDAO {
	public List<BoardVO> boardList(BoardVO bvo);
	public int boardInsert(BoardVO bvo);
	public BoardVO boardDetail(BoardVO bvo);
	public int readCntUpdate(BoardVO bvo);
	public int pwdConfirm(BoardVO bvo);
	public int boardUpdate(BoardVO bvo);
	public int boardDelete(BoardVO bvo);
	public int boardListCnt(BoardVO bvo); //board테이블의 전체 레코드 수
	
}
 