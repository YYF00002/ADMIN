package com.tima.admin.feign;

import com.tima.admin.dto.dmSVRDTO;
import com.tima.admin.feign.impl.Plutomembership;
import com.tima.admin.feign.impl.Svr;
import com.tima.admin.vo.dmSVRVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "dk-dm-svr", fallback = Svr.class)
@Component
public interface ISVR {

	/**
	* @Description:	   推送消息 调用SVR
	* @Author:         YYF
	* @CreateDate:     2018/12/11 16:58
	* @Version:        1.0
	*/
	@RequestMapping(value = "sendMessage/sendMessageToPeople", method = RequestMethod.POST)
	public dmSVRVO sendMessages(@RequestBody dmSVRDTO dto);
	
	
	
}
