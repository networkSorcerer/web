package com.spring.client.board.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.client.board.domain.Board;


/** CrudRepository 인터페이스 
 * public interface CrudRepository<T, ID> extends Repository<T, ID> {
 * 	<S extends T> S save(S entity);      주어진 엔터티를 저장.
 * 	Optional<T> findById(ID primaryKey); 주어진 ID로 식별되는 엔티티를 반환
 * 	Iterable<T> findAll();               모든 엔터티를 반환
 * 	long count();                        엔터티 수를 반환
 * 	void deleteById(ID id);              주어진 ID를 기준으로 레코드 삭제
 * 	// … more functionality omitted.
 * }
*/

public interface BoardRepository extends CrudRepository<Board, Long> {
	
}
