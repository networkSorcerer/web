package com.spring.client.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	public String home() {
		
		return "프로젝트 메인 화면";
	}
	
	@GetMapping("/")
	public String main() {
		
		return "client/main";
	}
}
