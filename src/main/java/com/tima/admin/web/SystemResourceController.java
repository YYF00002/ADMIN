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
//import com.tima.admin.dto.SystemResourceDTO;
//import com.tima.admin.vo.SystemResourceVO;
//import com.tima.admin.service.ISystemResourceService;
//import com.tima.admin.entity.SystemResource;
//import java.util.List;
//import com.baomidou.mybatisplus.plugins.Page;
//
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * <p>
// * 系统资源表 前端控制器
// * </p>
// *
// * @author YYF
// * @since 2018-07-31
// */
//@Slf4j
//@Api(tags = { "系统资源表API" })
//@RestController
//@RequestMapping("/admin/systemResource")
//public class SystemResourceController {
//
//   @Autowired
//   private ISystemResourceService  iSystemResourceService;
//
//    @ApiOperation(value = "系统资源表列表查询", notes = "系统资源表API")
//	@RequestMapping(value = "/searchSystemResourceList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<SystemResource>> searchSystemResourceList(@RequestBody SystemResourceDTO dto){
//		return (ResultVO<List<SystemResource>>)iSystemResourceService.searchSystemResourceList(dto);
//	}
//	@ApiOperation(value = "系统资源表列表分页查询", notes = "系统资源表API")
//	@RequestMapping(value = "/searchSystemResourceListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<SystemResource>> searchSystemResourceListPage(@RequestBody SystemResourceDTO dto){
//		return (ResultVO<Page<SystemResource>>)iSystemResourceService.searchSystemResourceListPage(dto);
//	}
//	@ApiOperation(value = "系统资源表详细查询", notes = "系统资源表API")
//	@RequestMapping(value = "/searchSystemResourceOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SystemResource> searchSystemResourceOne(@RequestBody SystemResourceDTO dto){
//		return (ResultVO<SystemResource>)iSystemResourceService.searchSystemResourceOne(dto);
//	}
//	@ApiOperation(value = "系统资源表添加", notes = "系统资源表API")
//	@RequestMapping(value = "/addSystemResource",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addSystemResource(@RequestBody SystemResourceDTO dto){
//		return iSystemResourceService.addSystemResource(dto);
//	}
//	@ApiOperation(value = "系统资源表更新", notes = "系统资源表API")
//	@RequestMapping(value = "/updateSystemResource",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateSystemResource(@RequestBody SystemResourceDTO dto){
//		return iSystemResourceService.updateSystemResource(dto);
//	}
//	@ApiOperation(value = "系统资源表删除", notes = "系统资源表API")
//	@RequestMapping(value = "/deleteSystemResource",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteSystemResource(@RequestBody SystemResourceDTO dto){
//		return iSystemResourceService.deleteSystemResource(dto);
//	}
//	@ApiOperation(value = "系统资源表关联查询", notes = "系统资源表API")
//	@RequestMapping(value = "/searchSystemResourceRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SystemResourceVO> searchSystemResourceRelation(@RequestBody SystemResourceDTO dto){
//		return (ResultVO<SystemResourceVO>)iSystemResourceService.searchSystemResourceRelation(dto);
//	}
//}
//
