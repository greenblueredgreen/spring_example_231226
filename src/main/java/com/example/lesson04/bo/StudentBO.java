package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {
	
	//input : Student
	//output : x
	
	@Autowired
	private StudentMapper studentMapper;

	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
		//리턴 안한다. 
	}
	
	//input : id
	//output : Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
