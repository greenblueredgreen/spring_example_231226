package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Cotroller +@ResponseBody
@RequestMapping("/lesson01/ex01")
public class Lesson01Ex01RestController {
	
	//http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RequestController를 사용해서 String을 리턴한다.</h3>";
	}
	
	//http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "11");
		map.put("abb", "12");
		map.put("ccc", "13");
		return map; // map -> JSON 리턴
	}
	
	
	//http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); //일반 자바 빈
		data.setId(100);
		data.setName("강낭콩");
		
		return data; // 일반 bean객체도 JSON으로 변환됨
		//따라서 클래스(객체) 도 JSON으로 출력된다.
	}
	
	//http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6(){
		Data data = new Data();
		data.setId(1);
		data.setName("바다");
		
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
				
				
		//status code 번호
				
		// 200번대  : 성공
		// 300번대 : 302 - 리다이렉트(다른쪽으로 요청 보냄)
		// 400번대 : 서버 - 서버에 도달도 못함
		// 400 : request parameter 잘못
		// 404 : page not found 주소 매핑 확인
		// 405 : request method 불일치 (보내는게 get일때, post로 응답하는 경우 등등)
		// 500번대 : 무조건 서버 에러
		
		
	}
}
