package com.spring.client.board.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*************************************
 * Object-Relational Mapping (ORM: 객체와 관계형데이터베이스 매핑, 객체와 DB의 테이블이 매핑을 이루는 것)
 * - 객체가 테이블이 되도록 매핑 시켜주는 프레임워크 이다.
 * - 프로그램의 복잡도를 줄이고 자바 객체와 쿼리를 분리할 수 있으며 트랜잭션 처리나 기타 데이터베이스 관련 작업들을 좀 더 편리하게 처리할 수 있는 방법
 
 * JPA란?
 - Java Persistence API (자바 ORM 기술에 대한 API 표준 명세)
 - 한마디로 ORM을 사용하기 위한 인터페이스를 모아둔 것이라고 볼 수 있다.
 - 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스이다.
 - ORM에 대한 자바 API 규격이며 Hibernate, OpenJPA 등이 JPA를 구현한 구현체 이다. (ORM을 사용하기 위한 인터페이스를 모아둔 것)
 - Hibernate 이외에도 EcipseLink, DataNucleus, OpenJPA, TopLink 등이 있습니다.
 ※결국 인터페이스이기 때문에 JPA를 사용하기 위해서는 JPA를 구현한 Hibernate, EclipseLink, DataNucleus 같은 ORM 프레임워크를 사용해야 한다.
 
 * Hibernate?
 - JPA를 사용하기 위해서 JPA를 구현한 ORM 프레임워크중 하나.
   (자바를 위한 오픈소스 ORM(Object-relational mapping) 프레임워크를 제공한다.)
 - Hibernate는 JPA 명세의 구현체이다. javax.persistence.EntityManager와 같은 JPA의 인터페이스를 직접 구현한 라이브러리이다.
********************************************/




@Setter
@Getter

@EqualsAndHashCode(callSuper=false)

@ToString
//JPA를 사용해서 테이블과 매핑할 클래스 
@Entity
//엔티티와 매핑할 테이블을 지정(class와 다른 테이블명 지정)
@Table(name="boot_board")
//번호가 자동으로 증가하게 하는 시퀀스 생성 //시퀀스는 오라클만 제공하는 기능이다
@SequenceGenerator(name="boot_board_generator", sequenceName = "boot_board_seq", initialValue =1, allocationSize = 1)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boot_board_generator")
	private Long no;
	
	//객체 필드를 테이블 컬럼에 매핑
	@Column(length = 15, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String title;
	
	@Lob
	private String content;
	
	@Column(length = 20, nullable = false)
	private String passwd;
	
	//하이버네이트가 제공하는 기능으로 엔티티가 생성 되거나 엡데이트 되는 
	//시점의 날짜 데이터를 기록하는 설정 
	@CreationTimestamp
	@ColumnDefault(value = "sysdate")
	private LocalDateTime regDate;
	
	@ColumnDefault(value = "0")
	private int hit;
	
	//@Transient : 필드를 매핑하지 않을 떄 사용 
}
