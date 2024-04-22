package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.mapper.UserMapper;

//스프링 빈 등록
@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	//input : 4개 파라미터
	// output : x
	public void addUser(String name, String yyyymmdd, 
			String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
}