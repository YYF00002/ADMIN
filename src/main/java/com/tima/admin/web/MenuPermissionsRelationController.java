package com.tima.admin.web;


import com.tima.admin.util.CommentUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import com.tima.admin.vo.ResultVO;
import com.alibaba.fastjson.JSONArray;
import com.tima.admin.dto.MenuPermissionsRelationDTO;
import com.tima.admin.service.IMenuPermissionsRelationService;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单权限关联表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Api(tags = {"角色菜单关联表API"})
@RestController
@RequestMapping("/admin/menuPermissionsRelation")
public class MenuPermissionsRelationController {

    @Autowired
    private IMenuPermissionsRelationService iMenuPermissionsRelationService;

    //    @ApiOperation(value = "菜单权限关联表列表查询", notes = "菜单权限关联表API")
//	@RequestMapping(value = "/searchMenuPermissionsRelationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<MenuPermissionsRelation>> searchMenuPermissionsRelationList(@RequestBody MenuPermissionsRelationDTO dto){		
//		return (ResultVO<List<MenuPermissionsRelation>>)iMenuPermissionsRelationService.searchMenuPermissionsRelationList(dto);
//	}
//	@ApiOperation(value = "菜单权限关联表列表分页查询", notes = "菜单权限关联表API")
//	@RequestMapping(value = "/searchMenuPermissionsRelationListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<MenuPermissionsRelation>> searchMenuPermissionsRelationListPage(@RequestBody MenuPermissionsRelationDTO dto){		
//		return (ResultVO<Page<MenuPermissionsRelation>>)iMenuPermissionsRelationService.searchMenuPermissionsRelationListPage(dto);
//	}
//	@ApiOperation(value = "菜单权限关联表详细查询", notes = "菜单权限关联表API")
//	@RequestMapping(value = "/searchMenuPermissionsRelationOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<MenuPermissionsRelation> searchMenuPermissionsRelationOne(@RequestBody MenuPermissionsRelationDTO dto){		
//		return (ResultVO<MenuPermissionsRelation>)iMenuPermissionsRelationService.searchMenuPermissionsRelationOne(dto);
//	}
    @ApiOperation(value = "为角色设置菜单（Web）", notes = "角色菜单关联表(web)")
    @RequestMapping(value = "/addMenuPermissionsRelationWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> addMenuPermissionsRelationWeb(@RequestBody List<MenuPermissionsRelationDTO> dto) {
        return iMenuPermissionsRelationService.addMenuPermissionsRelation(dto);
    }
//	@ApiOperation(value = "菜单权限关联表更新", notes = "菜单权限关联表API")
//	@RequestMapping(value = "/updateMenuPermissionsRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateMenuPermissionsRelation(@RequestBody MenuPermissionsRelationDTO dto){		
//		return iMenuPermissionsRelationService.updateMenuPermissionsRelation(dto);
//	}	
//	@ApiOperation(value = "角色菜单关联表删除（Web）", notes = "角色菜单关联表(web)")
//	@RequestMapping(value = "/deleteMenuPermissionsRelationWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteMenuPermissionsRelationWeb(@RequestBody MenuPermissionsRelationDTO dto){		
//		return iMenuPermissionsRelationService.deleteMenuPermissionsRelation(dto);
//	}

    @ApiOperation(value = "根据用户查菜单（Web）", notes = "角色菜单关联表(web)")
    @RequestMapping(value = "/selectMenuByUserWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<JSONArray> selectMenuByUserWeb(@RequestBody MenuPermissionsRelationDTO dto) {
        dto.setUserId(CommentUtil.getUser().getId());

        return (ResultVO<JSONArray>) iMenuPermissionsRelationService.selectMenuByPermission(dto);
    }

    @ApiOperation(value = "根据用户查菜单（Web）", notes = "角色菜单关联表(web)")
    @RequestMapping(value = "/selectMenuByUserId", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<JSONArray> selectMenuByUserId(@RequestBody MenuPermissionsRelationDTO dto) {
        return (ResultVO<JSONArray>) iMenuPermissionsRelationService.selectMenuByUserId(dto);
    }

    @ApiOperation(value = "根据角色查菜单（Web）", notes = "角色菜单关联表(web)")
    @RequestMapping(value = "/selectMenuByRoleWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<JSONArray> selectMenuByRoleWeb(@RequestBody MenuPermissionsRelationDTO dto) {
        return (ResultVO<JSONArray>) iMenuPermissionsRelationService.selectMenuByRoleWeb(dto);
    }

    @ApiOperation(value = "查出所有有权限的接口地址（Web）", notes = "角色菜单关联表(web)")
    @RequestMapping(value = "/selectAllRoleInterfaceAddress", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<JSONArray> selectAllRoleInterfaceAddress() {
        return (ResultVO<JSONArray>) iMenuPermissionsRelationService.selectAllRoleInterfaceAddress();
    }
}

