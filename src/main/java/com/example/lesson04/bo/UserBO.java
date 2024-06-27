package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
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
	
	// input : x 
	// output : User or null (단건 리턴시, 객체 리턴이거나 비어있는 null로 리턴)
	// 한번도 새로 가입된 적이 없으면 null로 리턴, 가입이 되면 User로 리턴
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	//input : name
	//output : boolean
	public boolean isDuplicationByName(String name) {
		return userMapper.isDuplicationByName(name);
	}
}
