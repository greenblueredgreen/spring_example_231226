package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// jsp 화면으로 보내는 컨트롤러
@Controller //@ResponseBody가 있으면 안된다.
//@RestController x
public class Lesson01Ex03Controller {
	
	//http://localhost/lesson01/ex03
	@RequestMapping("/lesson01/ex03") //요청
	public String ex03() {
		// return 되는 String 은 jsp의 경로이다.
		//(@ResponseBody 없을때)
		
		//  /WEB-INF/jsp           .jsp 
		//  return "/WEB-INF/jsp/lesson01/ex03.jsp";
		return "/lesson01/ex03"; //응답
		//response jsp view 경로
	}
}
