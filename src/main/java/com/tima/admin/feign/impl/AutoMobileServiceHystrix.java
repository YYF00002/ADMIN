package com.tima.admin.feign.impl;


import com.tima.admin.dto.VehicleBrandDTO;
import com.tima.admin.feign.IAutoMobileService;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.VehicleBrandVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AutoMobileServiceHystrix implements IAutoMobileService {




	@Override
	public ResultVO<VehicleBrandVO> selectBrandInfor(VehicleBrandDTO vehicleBrandDTO) {
        ResultVO<VehicleBrandVO> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(500);
        objectResultVO.setMsg("feign调用autoMobile哑巴");
        log.info("feign调用autoMobile哑巴");
        return objectResultVO;
	}

    @Override
    public ResultVO<List<VehicleBrandVO>> selectBrandList(VehicleBrandDTO vehicleBrandDTO) {
        ResultVO<List<VehicleBrandVO>> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(500);
        objectResultVO.setMsg("feign调用autoMobile哑巴");
        objectResultVO.setData(new ArrayList<VehicleBrandVO>());
        log.info("feign调用autoMobile 品牌列表哑巴");
        return objectResultVO;
    }
}
