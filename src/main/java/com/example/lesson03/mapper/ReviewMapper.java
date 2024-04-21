package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	public Review selectReview(int id);
	
	//파라미터 한개일때는 @Param 하지 않는다.
	//Mybatis가 성공한 행의 개수 return (int)
	public int insertReview(Review review);

	
	//@Param => 하나의 Map이 된다.
	public int insertReviewAsField(
			@Param("storeId") int storeId11, 
			@Param("menu") String menu11,
			@Param("userName") String userName11, 
			@Param("point") Double point111, 
			@Param("review") String review11);
	
	
	// return 타입은 void여도 되고, int도 가능하다.
	// mapper마음이다.
	// return은 BO 로 보내는 것이다.
	public int deleteReviewById(int id);
}
