package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

// mapper는 interface
@Mapper
public interface UserMapper {
	
	// 파람이 여러 개이기 때문에 map으로 해야한다. 
	// return은 본인 마음이다. 상과없다.
	public void insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	public User selectLatestUser(); // input없고 리턴타임 User
	
	// 0이 아닌 수 전부 참이므로 true
	// 0이면 false
	public boolean isDuplicationByName(String name);
}
