package com.spring.common.vo;



import com.spring.client.board.vo.BoardVO;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private CommonVO cvo;
	
	public PageDTO(CommonVO cvo, int total) {
		this.cvo = cvo;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cvo.getPageNum() / 10.0)) * 10;
		
		//페이징의 시작 번호 구하기 시작번호는 무조건 끝번호에서 9를 빼주면 된다
		this.startPage =this.endPage - 9;
		
		int realEnd = (int) (Math.ceil((total * 1.0) / cvo.getAmount()));
		
		if (realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}
}
