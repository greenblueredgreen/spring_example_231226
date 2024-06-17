package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//HTML 화면으로 보내는 컨트롤러
@Controller //@ResponseBody 가 있으면 안된다.
public class Lesson01Ex02Controller {

	
	//Request
	//http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// return 되는 String 은 html의 경로이다(@Responsebody 가 없을 때)
		
		
		//response
		// return "			   lesson01/ex02";  
		// return "/templates/lesson01/ex02.html"
		return "lesson01/ex02"; //response html view 경로 
	}
}
