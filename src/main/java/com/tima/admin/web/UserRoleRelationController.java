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
import com.tima.admin.vo.UserBaseInformationVO;
import com.tima.admin.dto.UserRoleRelationDTO;
import com.tima.admin.vo.UserRoleRelationVO;
import com.tima.admin.vo.UserRoleVO;
import com.tima.admin.service.IUserRoleRelationService;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.entity.UserRole;
import com.tima.admin.entity.UserRoleRelation;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户角色关联表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Api(tags = { "用户角色关联表API" })
@RestController
@RequestMapping("/admin/userRoleRelation")
public class UserRoleRelationController {
    
   @Autowired
   private IUserRoleRelationService  iUserRoleRelationService; 
   
//    @ApiOperation(value = "用户角色关联表列表查询", notes = "用户角色关联表API")
//	@RequestMapping(value = "/searchUserRoleRelationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<UserRoleRelation>> searchUserRoleRelationList(@RequestBody UserRoleRelationDTO dto){		
//		return (ResultVO<List<UserRoleRelation>>)iUserRoleRelationService.searchUserRoleRelationList(dto);
//	}
	@ApiOperation(value = "根据角色查用户集合（Web）", notes = "用户角色关联表Web")
	@RequestMapping(value = "/searchUserListPageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<UserBaseInformationVO>> searchUserListPageWeb(@RequestBody UserRoleRelationDTO dto){		
		return (ResultVO<Page<UserBaseInformationVO>>)iUserRoleRelationService.selectUserRoleRelationListPage(dto);
	}
	@ApiOperation(value = "根据用户查角色集合（Web）", notes = "用户角色关联表Web")
	@RequestMapping(value = "/searchUserRoleByUserWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<UserRoleVO>> searchUserRoleByUserWeb(@RequestBody UserRoleRelationDTO dto){		
		return (ResultVO<Page<UserRoleVO>>)iUserRoleRelationService.selectUserRoleByUserListPage(dto);
	}
//	@ApiOperation(value = "用户角色关联表详细查询", notes = "用户角色关联表API")
//	@RequestMapping(value = "/searchUserRoleRelationOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserRoleRelation> searchUserRoleRelationOne(@RequestBody UserRoleRelationDTO dto){		
//		return (ResultVO<UserRoleRelation>)iUserRoleRelationService.searchUserRoleRelationOne(dto);
//	}
	@ApiOperation(value = "设置用户角色关联（Web）", notes = "用户角色关联表Web")
	@RequestMapping(value = "/addUserRoleRelationWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addUserRoleRelationWeb(@RequestBody List<UserRoleRelationDTO> dto){		
		return iUserRoleRelationService.addUserRoleRelation(dto);
	}	
//	@ApiOperation(value = "用户角色关联表更新", notes = "用户角色关联表API")
//	@RequestMapping(value = "/updateUserRoleRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateUserRoleRelation(@RequestBody UserRoleRelationDTO dto){		
//		return iUserRoleRelationService.updateUserRoleRelation(dto);
//	}	
//	@ApiOperation(value = "用户角色关联表删除（Web）", notes = "用户角色关联表Web")
//	@RequestMapping(value = "/deleteUserRoleRelationWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteUserRoleRelationWeb(@RequestBody UserRoleRelationDTO dto){		
//		return iUserRoleRelationService.deleteUserRoleRelation(dto);
//	}
//	@ApiOperation(value = "用户角色关联表关联查询", notes = "用户角色关联表API")
//	@RequestMapping(value = "/searchUserRoleRelationRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserRoleRelationVO> searchUserRoleRelationRelation(@RequestBody UserRoleRelationDTO dto){		
//		return (ResultVO<UserRoleRelationVO>)iUserRoleRelationService.searchUserRoleRelationRelation(dto);
//	}		
}

