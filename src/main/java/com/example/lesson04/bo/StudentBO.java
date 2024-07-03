package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

import lombok.Builder;

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
	
	//update(변경)
	//input : id, dreamJob
	//output : StudentEntity or null(업데이트 대상 없음)
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		//update : select 후 save
		
		//기존 데이터 조회 => StudentEntity 
		//과거 버전
		StudentEntity student = studentRepository.findById(id).orElse(null);
		//없으면 null로 받고 있으면 StudentEntity로 받겠다는 뜻
		
		//엔티티의 데이터 값을 변경해놓는다.
		//반드시 새 거에 담아야한다.
		if(student != null) {
			student = student.toBuilder()  
				//toBuilder는 기존 필드값은 유지하고 일부만 변경하는 것
				//entity에서 @Builder(toBuilder = true)로 설정
				.dreamJob(dreamJob)
				.build(); //빌드로 뚜껑 닫기
			
			//update
			//최종 update값
			//save요청
			student = studentRepository.save(student);
		}
		return student;
	}
		
		//input : id
		//output : x
		public void deleteStudentById(int id) {
			// 방법 1)
//			StudentEntity student = studentRepository.findById(id).ofElse(null)
//			if(student != null) {
//				studentRepository.delete(student);
//			}
			
			//방법 2
			Optional<StudentEntity> studentOptional = studentRepository.findById(id);
			studentOptional.ifPresent(s-> studentRepository.delete(s));
	}
}
