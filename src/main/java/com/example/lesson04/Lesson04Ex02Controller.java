package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;

	//학생 추가 화면
	//http://localhost/lesson04/ex02/add-student-view
	//주소를 치고 바로들어가는거라 GetMapping
	@GetMapping("/add-student-view") 
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// DB INSERT => 방금 가입된 학생 화면
	//http://localhost/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, //jsp form태그의 name == Student 필드명 =>매핑(연결이된다.)
			// 자동적으로 Student의 필드들과 매핑이 된다. 
			Model model) {
		
		//DB INSERT
		studentBO.addStudent(student);
		
		//DB SELECT => 방금 가입된 학생
		int id = student.getId();
		Student newStudent = studentBO.
		
		//MODEL 에 담는다.  (최근 학생을 담는다.)
		model.add
		
		//화면 이동 
		return "lesson04/afterAddStudent";
	}	
}