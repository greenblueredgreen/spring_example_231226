package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

//http://localhost/lesson07/ex01/create
@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C : CREATE
	@GetMapping("/create")
	public StudentEntity create() {
		
		//insert 할 값
		String name ="뀨뀨";
		String phoneNumber ="01012341561";
		String email = "naver.com";
		String dreamJob = "백수";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}
