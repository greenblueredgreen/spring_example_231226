package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	
	//!!!!이번에만 bo 생략
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 다양한 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1(){
		// 1) 전체조회(기본으로 제공됨)
		//return studentRepository.findAll();
		
		// 2) id기준 내림차순 전체조회 하고 싶을 때
		//return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id기준 내림차순 3개만 조회
		//return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 뀨뀨인 데이터 조회
		//return studentRepository.findByName("뀨뀨");
		
		// 5) in문으로 일치하는 값 모두 조회
		//return studentRepository.findByNameIn(List.of("조세호", "유재석"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
		//return studentRepository.findByNameAndDreamJob("뀨뀨", "백수");
		
		// 7) 이메일 컬럼에 kakao가 포함된 데이터 조회 like %
		//return studentRepository.findByEmailContains("naver");
		
		// 8) 유로 시작하는 데이터 조회 like '유%'
		//return studentRepository.findByNameStartingWith("유");
		
		// 9) id가 2~5까지 조회 between 
		return studentRepository.findByIdBetween(2,5);
	}
}
