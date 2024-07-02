package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	//Spring Data JPA VS 순수 JPA
	// public StudentEntity save(StudentEntity student)
}
