package com.tima.admin.web;


import com.tima.admin.dto.UserBindingOtherModulesDTO;
import com.tima.admin.entity.UserBindingOtherModules;
import com.tima.admin.service.IUserBindingOtherModulesService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户绑定其他模块信息表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2019-04-09
 */
@Slf4j
@Api(tags = { "用户绑定其他模块信息表API" })
@RestController
@RequestMapping("/admin/userBindingOtherModules")
public class UserBindingOtherModulesController {
    
   @Autowired
   private IUserBindingOtherModulesService  iUserBindingOtherModulesService; 
   
    @ApiOperation(value = "用户绑定其他模块信息表列表查询", notes = "用户绑定其他模块信息表API")
	@RequestMapping(value = "/searchUserBindingOtherModulesList",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<UserBindingOtherModules>> searchUserBindingOtherModulesList(@RequestBody UserBindingOtherModulesDTO dto){		
		return (ResultVO<List<UserBindingOtherModules>>)iUserBindingOtherModulesService.searchUserBindingOtherModulesList(dto);
	}
//	@ApiOperation(value = "用户绑定其他模块信息表列表分页查询", notes = "用户绑定其他模块信息表API")
//	@RequestMapping(value = "/searchUserBindingOtherModulesListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<UserBindingOtherModules>> searchUserBindingOtherModulesListPage(@RequestBody UserBindingOtherModulesDTO dto){
//		return (ResultVO<Page<UserBindingOtherModules>>)iUserBindingOtherModulesService.searchUserBindingOtherModulesListPage(dto);
//	}
	@ApiOperation(value = "用户绑定其他模块信息表详细查询", notes = "用户绑定其他模块信息表API")
	@RequestMapping(value = "/searchUserBindingOtherModulesOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<UserBindingOtherModules> searchUserBindingOtherModulesOne(@RequestBody UserBindingOtherModulesDTO dto){
		return (ResultVO<UserBindingOtherModules>)iUserBindingOtherModulesService.searchUserBindingOtherModulesOne(dto);
	}

	@ApiOperation(value = "用户绑定其他模块信息表添加", notes = "用户绑定其他模块信息表API")
	@RequestMapping(value = "/addUserBindingOtherModules",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addUserBindingOtherModules(@RequestBody UserBindingOtherModulesDTO dto){		
		return iUserBindingOtherModulesService.addUserBindingOtherModules(dto);
	}	
	@ApiOperation(value = "用户绑定其他模块信息表更新", notes = "用户绑定其他模块信息表API")
	@RequestMapping(value = "/updateUserBindingOtherModules",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateUserBindingOtherModules(@RequestBody UserBindingOtherModulesDTO dto){		
		return iUserBindingOtherModulesService.updateUserBindingOtherModules(dto);
	}	

}

