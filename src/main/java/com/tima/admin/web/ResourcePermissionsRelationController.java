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
//import com.tima.admin.dto.ResourcePermissionsRelationDTO;
//import com.tima.admin.vo.ResourcePermissionsRelationVO;
//import com.tima.admin.service.IResourcePermissionsRelationService;
//import com.tima.admin.entity.ResourcePermissionsRelation;
//import java.util.List;
//import com.baomidou.mybatisplus.plugins.Page;
//
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * <p>
// * 资源权限关联表 前端控制器
// * </p>
// *
// * @author YYF
// * @since 2018-07-31
// */
//@Slf4j
//@Api(tags = { "资源权限关联表API" })
//@RestController
//@RequestMapping("/admin/resourcePermissionsRelation")
//public class ResourcePermissionsRelationController {
//
//   @Autowired
//   private IResourcePermissionsRelationService  iResourcePermissionsRelationService;
//
//    @ApiOperation(value = "资源权限关联表列表查询", notes = "资源权限关联表API")
//	@RequestMapping(value = "/searchResourcePermissionsRelationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<ResourcePermissionsRelation>> searchResourcePermissionsRelationList(@RequestBody ResourcePermissionsRelationDTO dto){
//		return (ResultVO<List<ResourcePermissionsRelation>>)iResourcePermissionsRelationService.searchResourcePermissionsRelationList(dto);
//	}
//	@ApiOperation(value = "资源权限关联表列表分页查询", notes = "资源权限关联表API")
//	@RequestMapping(value = "/searchResourcePermissionsRelationListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<ResourcePermissionsRelation>> searchResourcePermissionsRelationListPage(@RequestBody ResourcePermissionsRelationDTO dto){
//		return (ResultVO<Page<ResourcePermissionsRelation>>)iResourcePermissionsRelationService.searchResourcePermissionsRelationListPage(dto);
//	}
//	@ApiOperation(value = "资源权限关联表详细查询", notes = "资源权限关联表API")
//	@RequestMapping(value = "/searchResourcePermissionsRelationOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<ResourcePermissionsRelation> searchResourcePermissionsRelationOne(@RequestBody ResourcePermissionsRelationDTO dto){
//		return (ResultVO<ResourcePermissionsRelation>)iResourcePermissionsRelationService.searchResourcePermissionsRelationOne(dto);
//	}
//	@ApiOperation(value = "资源权限关联表添加", notes = "资源权限关联表API")
//	@RequestMapping(value = "/addResourcePermissionsRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addResourcePermissionsRelation(@RequestBody ResourcePermissionsRelationDTO dto){
//		return iResourcePermissionsRelationService.addResourcePermissionsRelation(dto);
//	}
//	@ApiOperation(value = "资源权限关联表更新", notes = "资源权限关联表API")
//	@RequestMapping(value = "/updateResourcePermissionsRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateResourcePermissionsRelation(@RequestBody ResourcePermissionsRelationDTO dto){
//		return iResourcePermissionsRelationService.updateResourcePermissionsRelation(dto);
//	}
//	@ApiOperation(value = "资源权限关联表删除", notes = "资源权限关联表API")
//	@RequestMapping(value = "/deleteResourcePermissionsRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteResourcePermissionsRelation(@RequestBody ResourcePermissionsRelationDTO dto){
//		return iResourcePermissionsRelationService.deleteResourcePermissionsRelation(dto);
//	}
//	@ApiOperation(value = "资源权限关联表关联查询", notes = "资源权限关联表API")
//	@RequestMapping(value = "/searchResourcePermissionsRelationRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<ResourcePermissionsRelationVO> searchResourcePermissionsRelationRelation(@RequestBody ResourcePermissionsRelationDTO dto){
//		return (ResultVO<ResourcePermissionsRelationVO>)iResourcePermissionsRelationService.searchResourcePermissionsRelationRelation(dto);
//	}
//}
//
