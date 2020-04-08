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
import com.tima.admin.dto.UserPermissionsInfoDTO;
import com.tima.admin.vo.UserPermissionsInfoVO;
import com.tima.admin.service.IUserPermissionsInfoService;
import com.tima.admin.entity.UserPermissionsInfo;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限信息表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Api(tags = { "权限信息表API" })
//@RestController
@RequestMapping("/admin/userPermissionsInfo")
public class UserPermissionsInfoController {
    
   @Autowired
   private IUserPermissionsInfoService  iUserPermissionsInfoService; 
   
//    @ApiOperation(value = "权限信息表列表查询", notes = "权限信息表API")
//	@RequestMapping(value = "/searchUserPermissionsInfoList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<UserPermissionsInfo>> searchUserPermissionsInfoList(@RequestBody UserPermissionsInfoDTO dto){		
//		return (ResultVO<List<UserPermissionsInfo>>)iUserPermissionsInfoService.searchUserPermissionsInfoList(dto);
//	}
//	@ApiOperation(value = "权限信息表列表分页查询", notes = "权限信息表API")
//	@RequestMapping(value = "/searchUserPermissionsInfoListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<UserPermissionsInfo>> searchUserPermissionsInfoListPage(@RequestBody UserPermissionsInfoDTO dto){		
//		return (ResultVO<Page<UserPermissionsInfo>>)iUserPermissionsInfoService.searchUserPermissionsInfoListPage(dto);
//	}
//	@ApiOperation(value = "权限信息表详细查询", notes = "权限信息表API")
//	@RequestMapping(value = "/searchUserPermissionsInfoOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserPermissionsInfo> searchUserPermissionsInfoOne(@RequestBody UserPermissionsInfoDTO dto){		
//		return (ResultVO<UserPermissionsInfo>)iUserPermissionsInfoService.searchUserPermissionsInfoOne(dto);
//	}
//	@ApiOperation(value = "权限信息表添加", notes = "权限信息表API")
//	@RequestMapping(value = "/addUserPermissionsInfo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addUserPermissionsInfo(@RequestBody UserPermissionsInfoDTO dto){		
//		return iUserPermissionsInfoService.addUserPermissionsInfo(dto);
//	}	
//	@ApiOperation(value = "权限信息表更新", notes = "权限信息表API")
//	@RequestMapping(value = "/updateUserPermissionsInfo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateUserPermissionsInfo(@RequestBody UserPermissionsInfoDTO dto){		
//		return iUserPermissionsInfoService.updateUserPermissionsInfo(dto);
//	}	
//	@ApiOperation(value = "权限信息表删除", notes = "权限信息表API")
//	@RequestMapping(value = "/deleteUserPermissionsInfo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteUserPermissionsInfo(@RequestBody UserPermissionsInfoDTO dto){		
//		return iUserPermissionsInfoService.deleteUserPermissionsInfo(dto);
//	}
//	@ApiOperation(value = "权限信息表关联查询", notes = "权限信息表API")
//	@RequestMapping(value = "/searchUserPermissionsInfoRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserPermissionsInfoVO> searchUserPermissionsInfoRelation(@RequestBody UserPermissionsInfoDTO dto){		
//		return (ResultVO<UserPermissionsInfoVO>)iUserPermissionsInfoService.searchUserPermissionsInfoRelation(dto);
//	}		
}

