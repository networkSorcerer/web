package com.spring.client.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.client.example.domain.ExampleDTO;

import lombok.extern.slf4j.Slf4j;


// 타임리프엔진에서는 th를 사용한다. 
// th:text는 텍스트를 출력한다는 속성으로서 th:text="${속성}을 입력하면 
// 해당 속성의 값이 text로 출력이 된다는 것이다. 
// th:utext는 html태그가 있다면 태그값을 반영해서 표시
// th:value는 엘리먼트들의 value값을 지정할 수 있다. <button th:value="${hello}" />
// th:with는 변수 값을 지정해서 사용할 수 있다. <div th:with="temp=${hello}" th:text="${temp}"> 


@Controller
@RequestMapping("/example")
@Slf4j
public class ExampleController {
	
	@GetMapping(value="/exam01")
	public String examp01(Model model) {
		log.info("이그 잼플");
		model.addAttribute("data", "출력한다");
		return "client/example/exam01";// /WEB-INF/views/data/chungnamView.jsp
	}
	
	@GetMapping("/test")
	public String test (Model model) {
		log.info("test() 메서드 확인");
		
		model.addAttribute("data1", "뷰를 출력할 데이터");
		model.addAttribute("data2","뷰를 출력할 <strong>데이터</strong>");
		
		model.addAttribute("nullData",null);
		model.addAttribute("date","Spring!");
		
		model.addAttribute("number",6);
		model.addAttribute("division","admin");
		
		ExampleDTO exampleDTO = new ExampleDTO();
		exampleDTO.setName("홍길동");
		exampleDTO.setAge(38);
		exampleDTO.setEmail("javauser@naver.com");
		model.addAttribute("exampleDTO", exampleDTO);
		
		List<ExampleDTO> list = new ArrayList<>();
		list.add(new ExampleDTO("김철수", 26, "springuser@naver.com"));
		list.add(new ExampleDTO("한늘봄", 32, "jsp1234@gmail.com"));
		model.addAttribute("list", list);
		
		Map<Integer, ExampleDTO> map = new HashMap<>();
		map.put(1,  new ExampleDTO("김미숙", 30, "javauser@naver.com"));
		map.put(2,  new ExampleDTO("조한미", 23, "bootuser@naver.com"));
		model.addAttribute("map",map);
		
		model.addAttribute("locationDateTime", LocalDateTime.now());
		
		return "client/example/test";
	}
	
	@GetMapping("/exam02")
	public String exam01(Model model,
			@ModelAttribute("param1")String param1,
			@ModelAttribute("param2")String param2) {
		return "client/example/exam02";
	}
}
