package com.spring.client.board.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.client.board.repository.BoardRepository;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardRepositoryTests {
	@Setter(onMethod_=@Autowired)
	private BoardRepository boardRepository;
	
	//게시판 전체 레코드 수 구하기 - count() : 사용가능한 엔티티 수를 반환
//	@Test
//	public void boardCountTest() {
//		long boardCount = boardRepository.count();
//		log.info(String.valueOf(boardCount));
//	}
//	
//	@Test
//	public void boardInsertTest() {
//	    Board board = new Board();
//	    board.setName("늘한봄");
//	    board.setTitle("노력 명언");
//	    board.setContent("우리 인생은 우리들이 노력한 만큼 가치가 있다");
//	    board.setPasswd("1234");
//	    board.setRegDate(LocalDateTime.now());
//	    
//	    log.info("### board 테이블에 첫 번째 데이터 입력");
//	    boardRepository.save(board);
//	    
//	    Board board1 = new Board();
//	    board1.setName("홍길동");
//	    board1.setTitle("끈기 명언");
//	    board1.setContent("실패한자가 패배하는 것이 아니라 포기한 자가 패배하는 것이다");
//	    board1.setPasswd("1234");
//	    board1.setRegDate(LocalDateTime.now());
//	    
//	    log.info("### board 테이블에 두 번째 데이터 입력");
//	    boardRepository.save(board1);
//	    
//	    Board board2 = new Board();
//	    board2.setName("모세");
//	    board2.setTitle("십계명");
//	    board2.setContent("하나님을 사랑하고 이웃을 사랑해라");
//	    board2.setPasswd("1234");
//	    board2.setRegDate(LocalDateTime.now());
//	    
//	    log.info("### board 테이블에 세 번째 데이터 입력");
//	    boardRepository.save(board2);
//	    
//	    Board board3 = new Board();
//	    board3.setName("예수님");
//	    board3.setTitle("사랑 명언");
//	    board3.setContent("사랑할만한 사람만 사랑하면 너희에게 무슨 칭찬할 만한 것이 있겠느냐");
//	    board3.setPasswd("1234");
//	    board3.setRegDate(LocalDateTime.now());
//	    
//	    log.info("### board 테이블에 네 번째 데이터 입력");
//	    boardRepository.save(board3);
//	}

//	@Test
//	public void boardListTest() {
//		List<Board> boardList = (List<Board>)boardRepository.findAll();
//		for(Board board: boardList) {
//			log.info(board.toString());
//		}
//	}
//	@Test
//	public void boardDetailTest() {
//		Optional<Board> boardOptional = boardRepository.findById(1L);
//		if(boardOptional.isPresent()) {
//			Board board = boardOptional.get();
//			log.info(board.toString());
//		}
//	}
	
	@Test
	public void boardUpdateTest() {
		Optional<Board> boardOptional = boardRepository.findById(2L);
		
		if(boardOptional.isPresent()) {
			Board board = boardOptional.get();
			board.setTitle("힘들 때 힘이 되는 명언");
			board.setContent("조급해 하지 ㅁ라고 조바심 내짖 말고, 할 수 있는 만큼 최선을 다하자");
			
			log.info("###board 테이블에 데이터 수정");
			boardRepository.save(board);
		}
	}
}
