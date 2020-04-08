package com.tima.admin.feign.impl;


import com.tima.admin.dto.C3ReqPVehicleUrgentContacts;
import com.tima.admin.dto.TSPRequestSyncVehicle;
import com.tima.admin.feign.ICarResultService;
import com.tima.admin.vo.ResultVOByCarControl;
import org.springframework.stereotype.Component;

@Component
public class CarServiceHystrix implements ICarResultService{

	@Override
	public Object setDefaultAddressByTSP(C3ReqPVehicleUrgentContacts dto, String identityParam) {
		
		return "修改紧急联系人---哑巴！";
	}

	@Override
	public ResultVOByCarControl findMyVehicle(TSPRequestSyncVehicle dto,String identityParam) {
		ResultVOByCarControl carControl=new ResultVOByCarControl<>();
		carControl.setReturnErrMsg("请求我的车辆--哑巴");
		carControl.setStatus("500");
		return carControl;
	}





}
