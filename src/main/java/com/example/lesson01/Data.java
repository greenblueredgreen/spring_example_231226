package com.example.lesson01;


//일반 java bean
public class Data {
	
	//필드
	private int id;
	private String name;
	//private로 은닉화 되어있어서 이 필드를 쓰거나 수정할 수 없다.
	// 따라서 getter, setter을 이용해서 해결한다.
	
	
	
	//메소드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
