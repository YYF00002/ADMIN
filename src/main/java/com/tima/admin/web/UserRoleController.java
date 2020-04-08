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
import com.tima.admin.dto.UserRoleDTO;
import com.tima.admin.vo.UserRoleVO;
import com.tima.admin.service.IUserRoleService;
import com.tima.admin.entity.UserRole;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Api(tags = { "角色API" })
@RestController
@RequestMapping("/admin/userRole")
public class UserRoleController {
    
   @Autowired
   private IUserRoleService  iUserRoleService; 
   
//    @ApiOperation(value = "角色列表查询", notes = "角色API")
//	@RequestMapping(value = "/searchUserRoleList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<UserRole>> searchUserRoleList(@RequestBody UserRoleDTO dto){		
//		return (ResultVO<List<UserRole>>)iUserRoleService.searchUserRoleList(dto);
//	}
	@ApiOperation(value = "角色列表分页查询（Web）", notes = "角色Web")
	@RequestMapping(value = "/searchUserRoleListPageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<UserRole>> searchUserRoleListPageWeb(@RequestBody UserRoleDTO dto){		
		return (ResultVO<Page<UserRole>>)iUserRoleService.searchUserRoleListPage(dto);
	}
	@ApiOperation(value = "角色详细查询（Web）", notes = "角色Web")
	@RequestMapping(value = "/searchUserRoleOneWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<UserRole> searchUserRoleOneWeb(@RequestBody UserRoleDTO dto){		
		return (ResultVO<UserRole>)iUserRoleService.searchUserRoleOne(dto);
	}
	@ApiOperation(value = "添加角色（Web）", notes = "角色Web")
	@RequestMapping(value = "/addUserRoleWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addUserRoleWeb(@RequestBody UserRoleDTO dto){		
		return iUserRoleService.addUserRole(dto);
	}	
	@ApiOperation(value = "更新角色（Web）", notes = "角色Web")
	@RequestMapping(value = "/updateUserRoleWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateUserRoleWeb(@RequestBody UserRoleDTO dto){		
		return iUserRoleService.updateUserRole(dto);
	}	
	@ApiOperation(value = "删除角色（Web）", notes = "角色Web")
	@RequestMapping(value = "/deleteUserRoleWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> deleteUserRoleWeb(@RequestBody UserRoleDTO dto){		
		return iUserRoleService.deleteUserRole(dto);
	}
//	@ApiOperation(value = "角色关联查询", notes = "角色API")
//	@RequestMapping(value = "/searchUserRoleRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserRoleVO> searchUserRoleRelation(@RequestBody UserRoleDTO dto){		
//		return (ResultVO<UserRoleVO>)iUserRoleService.searchUserRoleRelation(dto);
//	}		
}

