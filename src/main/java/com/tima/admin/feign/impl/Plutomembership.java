package com.tima.admin.feign.impl;

import com.tima.admin.dto.PlutomembershipDTO;
import com.tima.admin.feign.IPlutomembership;
import com.tima.admin.vo.PlutomembershipVO;
import org.springframework.stereotype.Component;

@Component
public class Plutomembership implements IPlutomembership{

	@Override
	public PlutomembershipVO addIntegralByRegistered(PlutomembershipDTO dto) {
		PlutomembershipVO pmVo=new PlutomembershipVO();
		pmVo.setMsg("注册用户调用增加积分--哑巴！！！");
		pmVo.setCode(500);
		return pmVo;
	}

	@Override
	public PlutomembershipVO searchIntegralCountList(PlutomembershipDTO dto) {
		PlutomembershipVO pmVo=new PlutomembershipVO();
		pmVo.setMsg("获取用户等级--哑巴！！！");
		pmVo.setCode(500);
		return pmVo;
	}

}
