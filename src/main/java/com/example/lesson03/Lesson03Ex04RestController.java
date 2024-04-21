package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {
	
	@Autowired //BO
	private ReviewBO reviewBO;
	
	//http://localhost/lesson03/ex04?id=9
	@RequestMapping("lesson03/ex04")
	public String ex04(
			@RequestParam("id") int id) {
		
		reviewBO.deleteReviewById(id);
		return "삭제 성공"; // BO에서 void로 들어와서 
	}
}
