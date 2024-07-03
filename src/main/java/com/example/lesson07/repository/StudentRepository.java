package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// Spring Data JPA VS 순수 JPA
	// public StudentEntity save(StudentEntity student)
	// pulbic StudentEntity findById(int id)
	// 구현 안해도 JPA 안에 들어있어서 문제없다.
	// public void delete(StudentEntity student)
	// public List<StudentEntity> findAll()
	
	// ex02/select1 - JPQL 문법
	// 이름 틀리면 동작 안된다.
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	//변수명은 상관없다. 함수 명이 더 중요하다.
	//메소드명으로 구분한다.
	public List<StudentEntity> findByName(String name111);
	
	public List<StudentEntity> findByNameIn(List<String> namesssss);
	
	public List<StudentEntity> findByNameAndDreamJob(String name11, String dreamJob11);
	
	public List<StudentEntity> findByEmailContains(String keyword);
	
	public List<StudentEntity> findByNameStartingWith(String keyword);
	
	public List<StudentEntity> findByIdBetween(int startId, int endId);
}
