package com.tima.admin.feign.impl;

import com.tima.admin.dto.dmSVRDTO;
import com.tima.admin.feign.ISVR;
import com.tima.admin.vo.dmSVRVO;
import org.springframework.stereotype.Component;

@Component
public class Svr implements ISVR {


	@Override
	public dmSVRVO sendMessages(dmSVRDTO dto) {
        dmSVRVO dmSVRVO = new dmSVRVO();
        dmSVRVO.setErrorMsg("调用推送消息--哑巴");
        dmSVRVO.setStatus(500);
        return dmSVRVO;
	}
}
