package com.tima.admin.web;


import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.KagaBaseInformationDTO;
import com.tima.admin.vo.KagaBaseInformationVO;
import com.tima.admin.service.IKagaBaseInformationService;
import com.tima.admin.entity.KagaBaseInformation;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 卡嘉用户表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2019-12-23
 */
@Slf4j
@Api(tags = { "卡嘉用户表API" })
@RestController
@RequestMapping("/admin/kagaBaseInformation")
public class KagaBaseInformationController {
    
   @Autowired
   private IKagaBaseInformationService  iKagaBaseInformationService; 
   
    @ApiOperation(value = "卡嘉用户表列表查询", notes = "卡嘉用户表API")
	@RequestMapping(value = "/searchKagaBaseInformationList",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<KagaBaseInformation>> searchKagaBaseInformationList(@RequestBody KagaBaseInformationDTO dto){		
		return (ResultVO<List<KagaBaseInformation>>)iKagaBaseInformationService.searchKagaBaseInformationList(dto);
	}

	@ApiOperation(value = "卡嘉用户表列表分页查询", notes = "卡嘉用户表API")
	@RequestMapping(value = "/searchKagaBaseInformationListPage",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<KagaBaseInformation>> searchKagaBaseInformationListPage(@RequestBody KagaBaseInformationDTO dto){		
		return (ResultVO<Page<KagaBaseInformation>>)iKagaBaseInformationService.searchKagaBaseInformationListPage(dto);
	}

	@ApiOperation(value = "卡嘉用户表详细查询", notes = "卡嘉用户表API")
	@RequestMapping(value = "/searchKagaBaseInformationOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<KagaBaseInformation> searchKagaBaseInformationOne(@RequestBody KagaBaseInformationDTO dto){		
		return (ResultVO<KagaBaseInformation>)iKagaBaseInformationService.searchKagaBaseInformationOne(dto);
	}

	@ApiOperation(value = "卡嘉用户表添加", notes = "卡嘉用户表API")
	@RequestMapping(value = "/addKagaBaseInformation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addKagaBaseInformation(@RequestBody KagaBaseInformationDTO dto){		
		return iKagaBaseInformationService.addKagaBaseInformation(dto);
	}

	@ApiOperation(value = "卡嘉用户表更新", notes = "卡嘉用户表API")
	@RequestMapping(value = "/updateKagaBaseInformation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateKagaBaseInformation(@RequestBody KagaBaseInformationDTO dto){		
		return iKagaBaseInformationService.updateKagaBaseInformation(dto);
	}

	@ApiOperation(value = "卡嘉用户表删除", notes = "卡嘉用户表API")
	@RequestMapping(value = "/deleteKagaBaseInformation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> deleteKagaBaseInformation(@RequestBody KagaBaseInformationDTO dto){		
		return iKagaBaseInformationService.deleteKagaBaseInformation(dto);
	}

	@ApiOperation(value = "卡嘉用户表关联查询", notes = "卡嘉用户表API")
	@RequestMapping(value = "/searchKagaBaseInformationRelation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<KagaBaseInformationVO> searchKagaBaseInformationRelation(@RequestBody KagaBaseInformationDTO dto){		
		return (ResultVO<KagaBaseInformationVO>)iKagaBaseInformationService.searchKagaBaseInformationRelation(dto);
	}

	/**
	 * 提供给重卡卡嘉调用的接口，将重卡卡嘉用户的信息包括用户名，密码，用户类型，电话号码，aaa_id,request_id插入数据表‘kaga_base_information’
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "卡嘉用户登录", notes = "卡嘉用户登录")
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<KagaBaseInformation>> login(@RequestBody KagaBaseInformationDTO dto){
		return (ResultVO<List<KagaBaseInformation>>)iKagaBaseInformationService.login(dto);
	}

	/**
	 * 提供给前台卡嘉快捷登录页面用户输入app用户名
	 * 当获取到用户名后到‘kaga_base_information’表里查询相应的卡嘉用户
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "卡嘉用户快捷登录", notes = "卡嘉用户快捷登录")
	@RequestMapping(value = "/quickLogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<KagaBaseInformation>> quickLogin(@RequestBody KagaBaseInformationDTO dto){
		return (ResultVO<List<KagaBaseInformation>>)iKagaBaseInformationService.quickLogin(dto);
	}
}

