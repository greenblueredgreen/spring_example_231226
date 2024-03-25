package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring bean(객체) 등록
public class Lesson01Ex01Controller {
	// 일반 bean => new Person();
	// 스프링 bean => new 안함, 어노테이션으로
	
	//http://localhost:8080/lesson01/ex01/1
	@ResponseBody  //응답 
	//String return 값이 response Body로 들어가진다. =>HTML응답
	@RequestMapping("/lesson01/ex01/1") //요청
	public String ex01_1() {
		
		//return 값이 String
		//응답되는게 ResponseBody로 들어간다.
		//보여지는 것은 HTML 화면이리 때문에 HTML 가능
		return "<h2>문자열을 Response Body로 보내는 예제</h2>";
	}
	
	
	@ResponseBody //Map을 리턴하면 responseBody는 json으로 응답.
	@RequestMapping("/lesson01/ex01/2")
	public Map<String, Object> ex01_2(){
		Map<String, Object> map = new HashMap<>();
		map.put("사과",10);
		map.put("블루베리",100);
		map.put("딸기",5);
		map.put("샤인머스켓",50);
		
		// web starter 에 jackson 라이브러리가 있기 때문이다.
		// 스프링boot로 하면 이런 라이브러리가 있기 때문에 자동으로 된다.
		return map;  
		// {"사과" = 33}
		// JSON 으로 보여진다.
	}
}
