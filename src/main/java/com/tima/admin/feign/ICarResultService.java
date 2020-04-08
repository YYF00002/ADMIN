package com.tima.admin.feign;


import com.tima.admin.dto.C3ReqPVehicleUrgentContacts;
import com.tima.admin.dto.TSPRequestSyncVehicle;
import com.tima.admin.feign.impl.CarServiceHystrix;
import com.tima.admin.vo.ResultVOByCarControl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "jac-car-control", fallback = CarServiceHystrix.class)
@Component
public interface ICarResultService {
	/**
	 * 设置紧急联系人
	 * @param dto
	 * @param identityParam  请求头
	 * @return
	 */
	@RequestMapping(value = "vehicle/set-vehicle-urgent-contacts", method = RequestMethod.POST)
	public Object  setDefaultAddressByTSP(@RequestBody C3ReqPVehicleUrgentContacts dto, @RequestHeader(value = "identityParam") String identityParam);

	/**
	 * 查询我的车辆
	 * @param dto
	 * @param identityParam
	 * @return
	 */
	@RequestMapping(value = "vehicle/find-vehicle-list", method = RequestMethod.POST)
	public ResultVOByCarControl  findMyVehicle(@RequestBody TSPRequestSyncVehicle dto,@RequestHeader(value = "identityParam") String identityParam);

}
