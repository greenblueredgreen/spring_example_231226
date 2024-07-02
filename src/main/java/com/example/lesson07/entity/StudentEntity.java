package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;  //entity라고 알려주는 것이다.
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//JPA는 domain을 entity로 부른다.
@ToString  //내용물이 보인다. 객체 출력시 필드 값들이 보인다.
@AllArgsConstructor //모든 파라미터 있는 생성자
@NoArgsConstructor //파라미터가 없는 생성자
@Builder //setter대신 builder 사용하는 추세, setter대신 내용을 담는다.
@Getter
@Table(name="new_student") //자카르타 선택
@Entity // 이 객체는 entity다. 라고 알려준다. BO - JPA - DB 
public class StudentEntity {
	@Id //자카르타 import //pk 식별자 등록
	@GeneratedValue(strategy = GenerationType.IDENTITY) //insert시 방금 들어간 id 가져옴
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")  //카멜 변수명은 @Column 어노테이션 붙여야한다.
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@CreationTimestamp  // 시간 값이 null 이어도 현재 시간으로 들어간다. update시 변경 x
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // update시 시간 변경 된다. 
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
}
