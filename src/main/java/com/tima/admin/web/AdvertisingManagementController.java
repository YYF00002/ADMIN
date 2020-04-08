package com.tima.admin.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.AdvertisingManagementDTO;
import com.tima.admin.entity.AdvertisingManagement;
import com.tima.admin.service.IAdvertisingManagementService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 广告页管理 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2020-02-18
 */
@Slf4j
@Api(tags = { "广告页管理API" })
@RestController
@RequestMapping("/admin/advertisingManagement")
public class AdvertisingManagementController {
    
   @Autowired
   private IAdvertisingManagementService  iAdvertisingManagementService; 
   
	@ApiOperation(value = "广告页管理列表分页查询", notes = "广告页管理API")
	@RequestMapping(value = "/searchAdvertisingManagementListPage",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<AdvertisingManagement>> searchAdvertisingManagementListPage(@RequestBody AdvertisingManagementDTO dto){		
		return (ResultVO<Page<AdvertisingManagement>>)iAdvertisingManagementService.searchAdvertisingManagementListPage(dto);
	}
	@ApiOperation(value = "广告页管理详细查询", notes = "广告页管理API")
	@RequestMapping(value = "/searchAdvertisingManagementOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<AdvertisingManagement> searchAdvertisingManagementOne(@RequestBody AdvertisingManagementDTO dto){		
		return (ResultVO<AdvertisingManagement>)iAdvertisingManagementService.searchAdvertisingManagementOne(dto);
	}
	@ApiOperation(value = "广告页管理添加", notes = "广告页管理API")
	@RequestMapping(value = "/addAdvertisingManagement",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addAdvertisingManagement(@RequestBody AdvertisingManagementDTO dto){		
		return iAdvertisingManagementService.addAdvertisingManagement(dto);
	}	
	@ApiOperation(value = "广告页管理更新", notes = "广告页管理API")
	@RequestMapping(value = "/updateAdvertisingManagement",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateAdvertisingManagement(@RequestBody AdvertisingManagementDTO dto){		
		return iAdvertisingManagementService.updateAdvertisingManagement(dto);
	}	
	@ApiOperation(value = "广告页管理删除", notes = "广告页管理API")
	@RequestMapping(value = "/deleteAdvertisingManagement",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> deleteAdvertisingManagement(@RequestBody AdvertisingManagementDTO dto){		
		return iAdvertisingManagementService.deleteAdvertisingManagement(dto);
	}

}

