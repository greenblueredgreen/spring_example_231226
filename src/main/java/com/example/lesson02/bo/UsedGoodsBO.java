package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service //Spring bean으로 등록하겠다.
public class UsedGoodsBO {
	
	// Spring bean을 autowired를 통해서 가져온다.
	@Autowired  
	//DI (Dependency Injection) : 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; //Spring bean을 가져온다.

	
	// input: x (컨트롤러부터 들어온 요청 받아온다. 그러나 아무것도 안받아옴, input 없음)
	// output: (Repository 한테 받은 것을 컨트롤러에게 준다.)  List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList(){
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList;
		// controller에게 반환
		// return usedGoodsMapper.selectUsedGoodsList();
	}
}
