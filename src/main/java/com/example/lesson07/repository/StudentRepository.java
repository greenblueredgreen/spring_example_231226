package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// Spring Data JPA VS 순수 JPA
	// public StudentEntity save(StudentEntity student)
	// pulbic StudentEntity findById(int id)
	// 구현 안해도 JPA 안에 들어있어서 문제없다.
	
}
