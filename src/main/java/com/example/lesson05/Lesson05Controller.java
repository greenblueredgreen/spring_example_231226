package com.example.lesson05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		//List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("멜론");
		fruits.add("복숭아");
		fruits.add("포도");
		fruits.add("수박");
		
		//꼭 모델에 담아서 해야한다.
		// 이러면 html에서 모델에 담겨있는걸 꺼내서 사용할 수 있다.
		model.addAttribute("fruits", fruits);
		
		//List<Map<String,Object>>
		List<Map<String,Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "강낭콩");
		user.put("age", "1");
		user.put("hobby", "명상하기");
		//List에 넣기 
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "당근이");
		user.put("age", "2");
		user.put("hobby", "노래하기");
		//List에 넣기
		users.add(user);
		
		//List로 돌려야 돌아간다.
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
		}
	
	//http://localhost/lesson05/ex03
	@GetMapping("/ex03")
	public String ex03(Model model) {
		Date date= new Date();
		model.addAttribute("date", date);
		
		//현재 시간 (new 안해도 된다.-> staic메소드여서 new안해도 가능)
		LocalDate localDate = LocalDate.now();
		model.addAttribute("localDate", localDate);
		
		LocalDateTime localDateTime= LocalDateTime.now();
		model.addAttribute("localDateTime", localDateTime);
		
		//UTC(표준시)
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		model.addAttribute("zonedDateTime", zonedDateTime);
		
		return "lesson05/ex03";
	}
}


