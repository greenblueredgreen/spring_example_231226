package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	//input : Student
	//output : x
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired  //오토와이어드는 1개만 적용된다.
	private StudentRepository studentRepository;
	
	//input : 파라미터 4개
	//output : StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}

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
