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
import com.tima.admin.dto.UserMenuInfoDTO;
import com.tima.admin.vo.UserMenuInfoVO;
import com.tima.admin.service.IUserMenuInfoService;
import com.tima.admin.entity.UserMenuInfo;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户菜单信息表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Api(tags = { "用户菜单信息表API" })
@RestController
@RequestMapping("/admin/userMenuInfo")
public class UserMenuInfoController {
    
   @Autowired
   private IUserMenuInfoService  iUserMenuInfoService; 
   
    @ApiOperation(value = "用户菜单信息表列表查询（Web）", notes = "用户菜单信息表Web")
	@RequestMapping(value = "/searchUserMenuInfoListWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<JSONArray> searchUserMenuInfoListWeb(@RequestBody UserMenuInfoDTO dto){		
		return (ResultVO<JSONArray>)iUserMenuInfoService.searchUserMenuInfoList(dto);
	}
//	@ApiOperation(value = "用户菜单信息表列表分页查询", notes = "用户菜单信息表API")
//	@RequestMapping(value = "/searchUserMenuInfoListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<UserMenuInfo>> searchUserMenuInfoListPage(@RequestBody UserMenuInfoDTO dto){		
//		return (ResultVO<Page<UserMenuInfo>>)iUserMenuInfoService.searchUserMenuInfoListPage(dto);
//	}
	@ApiOperation(value = "用户菜单信息表详细查询（Web）", notes = "用户菜单信息表WEB")
	@RequestMapping(value = "/searchUserMenuInfoOneWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<UserMenuInfo> searchUserMenuInfoOneWeb(@RequestBody UserMenuInfoDTO dto){		
		return (ResultVO<UserMenuInfo>)iUserMenuInfoService.searchUserMenuInfoOne(dto);
	}
	@ApiOperation(value = "用户菜单信息表添加（Web）", notes = "用户菜单信息表Web")
	@RequestMapping(value = "/addUserMenuInfoWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addUserMenuInfoWeb(@RequestBody UserMenuInfoDTO dto){		
		return iUserMenuInfoService.addUserMenuInfo(dto);
	}	
	@ApiOperation(value = "用户菜单信息表更新（Web）", notes = "用户菜单信息表Web")
	@RequestMapping(value = "/updateUserMenuInfoWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateUserMenuInfoWeb(@RequestBody UserMenuInfoDTO dto){		
		return iUserMenuInfoService.updateUserMenuInfo(dto);
	}	
	@ApiOperation(value = "用户菜单信息表删除（Web）", notes = "用户菜单信息表Web")
	@RequestMapping(value = "/deleteUserMenuInfoWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> deleteUserMenuInfoWeb(@RequestBody UserMenuInfoDTO dto){		
		return iUserMenuInfoService.deleteUserMenuInfo(dto);
	}
//	@ApiOperation(value = "用户菜单信息表关联查询", notes = "用户菜单信息表API")
//	@RequestMapping(value = "/searchUserMenuInfoRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserMenuInfoVO> searchUserMenuInfoRelation(@RequestBody UserMenuInfoDTO dto){		
//		return (ResultVO<UserMenuInfoVO>)iUserMenuInfoService.searchUserMenuInfoRelation(dto);
//	}		
}

