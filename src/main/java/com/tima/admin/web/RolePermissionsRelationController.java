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
import com.tima.admin.dto.RolePermissionsRelationDTO;
import com.tima.admin.vo.RolePermissionsRelationVO;
import com.tima.admin.vo.UserRoleVO;
import com.tima.admin.service.IRolePermissionsRelationService;
import com.tima.admin.entity.RolePermissionsRelation;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色权限关联表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Slf4j
@Api(tags = { "角色权限关联表API" })
//@RestController
@RequestMapping("/admin/rolePermissionsRelation")
public class RolePermissionsRelationController {
    
   @Autowired
   private IRolePermissionsRelationService  iRolePermissionsRelationService; 
   
//    @ApiOperation(value = "角色权限关联表列表查询", notes = "角色权限关联表API")
//	@RequestMapping(value = "/searchRolePermissionsRelationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<RolePermissionsRelation>> searchRolePermissionsRelationList(@RequestBody RolePermissionsRelationDTO dto){		
//		return (ResultVO<List<RolePermissionsRelation>>)iRolePermissionsRelationService.searchRolePermissionsRelationList(dto);
//	}
//	@ApiOperation(value = "角色权限关联表列表分页查询", notes = "角色权限关联表API")
//	@RequestMapping(value = "/searchRolePermissionsRelationListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<RolePermissionsRelation>> searchRolePermissionsRelationListPage(@RequestBody RolePermissionsRelationDTO dto){		
//		return (ResultVO<Page<RolePermissionsRelation>>)iRolePermissionsRelationService.searchRolePermissionsRelationListPage(dto);
//	}
//	@ApiOperation(value = "角色权限关联表详细查询", notes = "角色权限关联表API")
//	@RequestMapping(value = "/searchRolePermissionsRelationOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<RolePermissionsRelation> searchRolePermissionsRelationOne(@RequestBody RolePermissionsRelationDTO dto){		
//		return (ResultVO<RolePermissionsRelation>)iRolePermissionsRelationService.searchRolePermissionsRelationOne(dto);
//	}
//	@ApiOperation(value = "根据角色查权限（Web）", notes = "角色权限关联表Web")
//	@RequestMapping(value = "/selectPermissionsByRoleWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<RolePermissionsRelation> selectPermissionsByRoleWeb(@RequestBody RolePermissionsRelationDTO dto){		
//		return (ResultVO<RolePermissionsRelation>)iRolePermissionsRelationService.selectPermissionsByRole(dto);
//	}
//	@ApiOperation(value = "根据权限查角色（Web）", notes = "角色权限关联表Web")
//	@RequestMapping(value = "/selectRoleByPermissionsWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserRoleVO> selectRoleByPermissionsWeb(@RequestBody RolePermissionsRelationDTO dto){		
//		return (ResultVO<UserRoleVO>)iRolePermissionsRelationService.selectRoleByPermissions(dto);
//	}
//	@ApiOperation(value = "角色权限关联表添加（Web）", notes = "角色权限关联表Web")
//	@RequestMapping(value = "/addRolePermissionsRelationWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addRolePermissionsRelationWeb(@RequestBody RolePermissionsRelationDTO dto){		
//		return iRolePermissionsRelationService.addRolePermissionsRelation(dto);
//	}	
//	@ApiOperation(value = "角色权限关联表更新", notes = "角色权限关联表API")
//	@RequestMapping(value = "/updateRolePermissionsRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateRolePermissionsRelation(@RequestBody RolePermissionsRelationDTO dto){		
//		return iRolePermissionsRelationService.updateRolePermissionsRelation(dto);
//	}	
//	@ApiOperation(value = "角色权限关联表删除（Web）", notes = "角色权限关联表Web")
//	@RequestMapping(value = "/deleteRolePermissionsRelationWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteRolePermissionsRelationWeb(@RequestBody RolePermissionsRelationDTO dto){		
//		return iRolePermissionsRelationService.deleteRolePermissionsRelation(dto);
//	}
//	@ApiOperation(value = "角色权限关联表关联查询", notes = "角色权限关联表API")
//	@RequestMapping(value = "/searchRolePermissionsRelationRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<RolePermissionsRelationVO> searchRolePermissionsRelationRelation(@RequestBody RolePermissionsRelationDTO dto){		
//		return (ResultVO<RolePermissionsRelationVO>)iRolePermissionsRelationService.searchRolePermissionsRelationRelation(dto);
//	}		
}

