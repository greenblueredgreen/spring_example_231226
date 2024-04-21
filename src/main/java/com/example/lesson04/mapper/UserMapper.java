package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	public void insertUser(String name, String yyyymmdd, 
			String email, String introduce);
}
