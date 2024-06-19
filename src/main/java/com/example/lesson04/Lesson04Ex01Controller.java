package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller   //jsp 화면의 경우 @ResponseBody 사용 안함
			// html 화면의 경우 @ResponseBody 사용 안함
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;  //private는 관례적으로 붙인다. 
	

	//회원가입 화면 (jsp로 만든 화면 -> submit -> postMapping으로 이동)
	//http://localhost/lesson04/ex01/add-user-view  (jsp로 보내는 것/그냥 서버 주소이다.)
	@RequestMapping(path="/add-user-view", method = RequestMethod.GET)   
	//오직 get만 허용하겠다는 의미 //method = RequestMethod.GET
	public String addUserView() {
		return "lesson04/addUser";  //jsp의 경로 (view의 경로)
									//html의 경로
	}
	
	//회원가입 진행 => DB저장 => 결과화면 
	
	
	// 서버에 파라미터 전송, DB에 넣기 -> 결과 출력 (입력 성공 return lesson04/afterAddUser ) 
	//http://localhost/lesson04/ex01/add-user   
	@PostMapping("/add-user")//post만 받겠다는 것이다
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce){
		
		//DB Insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser"; //결과 화면 (입력 성공)
	}
	
	
	// 최근에 가입된 한 명의 유저를 보는 화면
	// http://localhost/lesson04/ex01/latest-user-view
	// get 매핑으로, /반드시 붙이기
	@GetMapping("/latest-user-view")
	public String latesetUserView(Model model) {
		//MODEL : view화면에 데이터를 넘겨주는 객체 
		
		// DB select
		User user = userBO.getLatestUser();  // User은 domain이다. 
		
		// MODEL 주머니에 담기! -> jsp에서 꺼내서 쓴다.  //String latesetUserView(Model model)
		model.addAttribute("result", user);  //user객체를 model에 넣는다. 
		model.addAttribute("title", "최근에 가입된 유저의 정보"); 
		// result와 title은 키다. 키로 접근을 해서 데이터를 꺼내는 것이다. 
		
		return "lesson04/latestUser"; // 결과 화면 JSP
	}
	
	// #mvc (model, view, controller(서버역할))
	// model은 model역학, view 는 view 역할, controller는 controller 역할을 할 수 있도록 도와준다. 
	// model (data를 담은 공간)
	
}
