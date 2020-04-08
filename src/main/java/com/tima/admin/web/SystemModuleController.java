//package com.tima.admin.web;
//
//
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import lombok.extern.slf4j.Slf4j;
//import com.tima.admin.vo.ResultVO;
//import com.tima.admin.dto.SystemModuleDTO;
//import com.tima.admin.vo.SystemModuleVO;
//import com.tima.admin.service.ISystemModuleService;
//import com.tima.admin.entity.SystemModule;
//import java.util.List;
//import com.baomidou.mybatisplus.plugins.Page;
//
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * <p>
// * 系统模块表 前端控制器
// * </p>
// *
// * @author YYF
// * @since 2018-07-31
// */
//@Slf4j
//@Api(tags = { "系统模块表API" })
//@RestController
//@RequestMapping("/admin/systemModule")
//public class SystemModuleController {
//
//   @Autowired
//   private ISystemModuleService  iSystemModuleService;
//
//    @ApiOperation(value = "系统模块表列表查询", notes = "系统模块表API")
//	@RequestMapping(value = "/searchSystemModuleList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<SystemModule>> searchSystemModuleList(@RequestBody SystemModuleDTO dto){
//		return (ResultVO<List<SystemModule>>)iSystemModuleService.searchSystemModuleList(dto);
//	}
//	@ApiOperation(value = "系统模块表列表分页查询", notes = "系统模块表API")
//	@RequestMapping(value = "/searchSystemModuleListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<SystemModule>> searchSystemModuleListPage(@RequestBody SystemModuleDTO dto){
//		return (ResultVO<Page<SystemModule>>)iSystemModuleService.searchSystemModuleListPage(dto);
//	}
//	@ApiOperation(value = "系统模块表详细查询", notes = "系统模块表API")
//	@RequestMapping(value = "/searchSystemModuleOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SystemModule> searchSystemModuleOne(@RequestBody SystemModuleDTO dto){
//		return (ResultVO<SystemModule>)iSystemModuleService.searchSystemModuleOne(dto);
//	}
//	@ApiOperation(value = "系统模块表添加", notes = "系统模块表API")
//	@RequestMapping(value = "/addSystemModule",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addSystemModule(@RequestBody SystemModuleDTO dto){
//		return iSystemModuleService.addSystemModule(dto);
//	}
//	@ApiOperation(value = "系统模块表更新", notes = "系统模块表API")
//	@RequestMapping(value = "/updateSystemModule",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateSystemModule(@RequestBody SystemModuleDTO dto){
//		return iSystemModuleService.updateSystemModule(dto);
//	}
//	@ApiOperation(value = "系统模块表删除", notes = "系统模块表API")
//	@RequestMapping(value = "/deleteSystemModule",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteSystemModule(@RequestBody SystemModuleDTO dto){
//		return iSystemModuleService.deleteSystemModule(dto);
//	}
//	@ApiOperation(value = "系统模块表关联查询", notes = "系统模块表API")
//	@RequestMapping(value = "/searchSystemModuleRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SystemModuleVO> searchSystemModuleRelation(@RequestBody SystemModuleDTO dto){
//		return (ResultVO<SystemModuleVO>)iSystemModuleService.searchSystemModuleRelation(dto);
//	}
//}
//
