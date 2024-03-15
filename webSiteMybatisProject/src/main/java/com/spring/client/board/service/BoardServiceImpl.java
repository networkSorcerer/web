package com.spring.client.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.board.dao.BoardDAO;
import com.spring.client.board.vo.BoardVO;


import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService{
	@Setter(onMethod_=@Autowired)
	private BoardDAO boardDAO;
	
//	@Setter(onMethod_=@Autowired)
//	private ReplyDao replyDao;
	
	//글목록 구현
	@Override
	public List<BoardVO> boardList(BoardVO bvo) {
		List<BoardVO> list =null;
		list = boardDAO.boardList(bvo);
		return list;
	}
	
	//글 입력 구현
//	@Override
//	public int boardInsert(BoardVO bvo) {
//		int result = 0;
//		//예외를 발생시킬 코드 작성
////		bvo.setBoardNumber(0);
////		if(bvo.getBoardNumber() == 0)  {
////			return result;
////		}
//		result = boardDAO.boardInsert(bvo);
//		return result;
//	}
	
	
	//글입력 구현 (파일 업로드가 추가된 소스코드)
	@Override
	public int boardInsert(BoardVO bvo){
		int result = 0;
//		if(bvo.getFile().getSize() > 0) {
//			String fileName = FileUploadUtil.fileUpload(bvo.getFile(), "board");
//			bvo.setBoardFile(fileName);
//		}
		result = boardDAO.boardInsert(bvo);
		return result;
	}
	
	//상세 내용 구현
	@Override
	public BoardVO boardDetail(BoardVO bvo) {
		boardDAO.readCntUpdate(bvo);
		
		BoardVO detail = boardDAO.boardDetail(bvo);
		if(detail != null) {
			detail.setBoardContent(detail.getBoardContent().replaceAll("\n", "<br/>"));
		}
		return detail;
	}
	
	//수정 폼 구현
	@Override
	public BoardVO updateForm(BoardVO bvo) {
		BoardVO updateData = null;
		updateData = boardDAO.boardDetail(bvo);
		return updateData;
	}
	
	//게시글 수정 구현 
	@Override
	public int boardUpdate(BoardVO bvo)  {
		int result = 0;
//		if(!bvo.getFile().isEmpty()) {
//			if(!bvo.getBoardFile().isEmpty()) {
//				FileUploadUtil.fileDelete(bvo.getBoardFile());
//			}
//			String fileName = FileUploadUtil.fileUpload(bvo.getFile(), "board");
//			bvo.setBoardFile(fileName);
//		}
		result = boardDAO.boardUpdate(bvo);
		return result;
	}
	
	//해당 게시물의 댓굴 존재 여부 확인
	//댓글이 존재하면 댓글수 를 반환하고 존재하지 않으면 0을 반환
//	@Override
//	public int replyCount(int boardNumber) {
//		int result = 0;
//		result = replyDao.replyCount(boardNumber);
//		return result;
//	}
	
	//게시글 삭제 구현
	@Override
	public int boardDelete(BoardVO bvo) {
		int result = 0;
//		if(!bvo.getBoardFile().isEmpty()) {
//			FileUploadUtil.fileDelete(bvo.getBoardFile());
//		}
		result = boardDAO.boardDelete(bvo);
		return result;
	}
	
	//비밀번호 확인 구현 
	@Override
	public int pwdConfirm(BoardVO bvo) {
		int result = 0;
		result = boardDAO.pwdConfirm(bvo);
		return result;
	}
	//전체 레코드 수 구현 
	@Override
	public int boardListCnt(BoardVO bvo) {
		return boardDAO.boardListCnt(bvo);
	}
 }
