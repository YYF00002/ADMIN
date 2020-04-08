package com.tima.admin.feign;


import com.tima.admin.dto.VehicleBrandDTO;
import com.tima.admin.feign.impl.AutoMobileServiceHystrix;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.VehicleBrandVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jac-automobile-manage",fallback = AutoMobileServiceHystrix.class)
@Component
public interface IAutoMobileService {

	//查询品牌信息
	@RequestMapping(value="/automobilemanage/vehicleBrand/searchVehicleBrandOne",method= RequestMethod.POST)
	ResultVO<VehicleBrandVO> selectBrandInfor(@RequestBody VehicleBrandDTO vehicleBrandDTO);

	//查询品牌列表
	@RequestMapping(value="/automobilemanage/vehicleBrand/searchVehicleBrandList",method= RequestMethod.POST)
	ResultVO<List<VehicleBrandVO>> selectBrandList(@RequestBody VehicleBrandDTO vehicleBrandDTO);

}
