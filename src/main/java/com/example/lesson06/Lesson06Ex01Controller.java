package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	//회원가입 화면
	//http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUser() {
		return "lesson06/addUser";
	}
	
	// AJAX가 하는 요청 -> AJAX가 하는 응답값은 반드시 String이다.
	// AJAX가 하는 요청은 RESPONSEBODY로 내려야한다.
	@ResponseBody
	@PostMapping("/add-user")
	public String addUser(
			//필수 파라미터
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			//introduce는 null이 가능하다. 
			@RequestParam(value = "introduce", required=false) String introduce
			) {
		
		//DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		//응답값 (String) 내리기 : AJAX응답
		//responseBody에 "성공" 들어간다. 
		return "성공";
	}
	
	//회원가입 성공화면 
	//http://localhost/lesson06/ex01/after-add-user-view
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser";
	}
}
