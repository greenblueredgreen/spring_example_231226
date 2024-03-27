package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input : int id
	// output : Review
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	//input : Review
	//output : int(성공한 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	//addReviewAsField(4, "국밥국밥",바다, 5.0, "피곤해요!")
	public int addReviewAsField(int stordId, String menu, String userName, Double point, String review  ) {
		
		return reviewMapper.insertReviewAsField(stordId, menu, userName, point, review);
	}
}
