package com.tima.admin.feign;

import com.tima.admin.dto.PlutomembershipDTO;
import com.tima.admin.feign.impl.Plutomembership;
import com.tima.admin.vo.PlutomembershipVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(value = "pluto-membership", fallback = Plutomembership.class)
@Component
public interface IPlutomembership {

	//用户注册添加积分
	@RequestMapping(value = "plutomembership/integralCount/addIntegralCount", method = RequestMethod.POST)
	public PlutomembershipVO  addIntegralByRegistered(@RequestBody PlutomembershipDTO dto);
	
	//获取用户等级
	@RequestMapping(value = "plutomembership/integralCount/searchIntegralCountList", method = RequestMethod.POST)
	public PlutomembershipVO  searchIntegralCountList(@RequestBody PlutomembershipDTO dto);
	
}
