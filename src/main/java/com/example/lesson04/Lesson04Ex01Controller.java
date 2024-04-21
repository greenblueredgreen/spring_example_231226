package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lesson04/ex01")
@Controller   //jsp 화면의 경우 @ResponseBody 사용 안함
public class Lesson04Ex01Controller {

	//회원가입 화면
	//http://localhost/lesson04/ex01/add-user-view  (jsp로 보내는 것/그냥 서버 주소이다.)
	@RequestMapping(path="/add-user-view", method = RequestMethod.GET)   //오직 get만 허용하겠다는 의미
	public String addUserView() {
		return "lesson04/addUser";  //jsp의 경로 (view의 경로)
	}
	
	//http://localhost/lesson04/ex01/add-user   
	@PostMapping("/add-user")					//post만 받겠다는 것이다
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce){
		
		//DB Insert
		return "lesson04/afterAddUser";
	}
}
