package com.example.lesson04.domain;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private int id;
	private String name;
	private String yyyymmdd;
	private String email;
	private String introduce;
	private Date createdAt;   //Date는 util로 import 해야한다. 
	private Date updatedAt;

}
