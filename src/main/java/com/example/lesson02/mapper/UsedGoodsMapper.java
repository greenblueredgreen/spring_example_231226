package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper //mapper 어노테이션
public interface UsedGoodsMapper {
	
	
	//input : (BO로부터 받아온다) X
	//output : (BO에게 전달) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}
