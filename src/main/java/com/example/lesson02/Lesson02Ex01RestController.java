package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController  //@Controller + @ResponseBody (JSON)
public class Lesson02Ex01RestController {

	//요리=DTO
	
	//DI해준다.
	@Autowired
	private UsedGoodsBO usedGoodsBO; 
	
	//http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){
		
		// 리스트에 담아서 리턴
		// List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		// return usedGoodsList;
		return usedGoodsBO.getUsedGoodsList();  
		//response => List => Response JSON(String)
		// bo한테 받아온 데이터를 리턴한다.
	}
}
