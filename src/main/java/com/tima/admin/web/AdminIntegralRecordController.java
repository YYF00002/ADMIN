package com.tima.admin.web;


import com.tima.admin.dto.AdminIntegralRecordDTO;
import com.tima.admin.service.IAdminIntegralRecordService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户模块积分记录表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2019-02-21
 */
@Slf4j
@Api(tags = { "用户模块积分记录表API" })
@RestController
@RequestMapping("/admin/adminIntegralRecord")
public class AdminIntegralRecordController {
    
   @Autowired
   private IAdminIntegralRecordService  iAdminIntegralRecordService; 
   
//    @ApiOperation(value = "用户模块积分记录表列表查询", notes = "用户模块积分记录表API")
//	@RequestMapping(value = "/searchAdminIntegralRecordList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<AdminIntegralRecord>> searchAdminIntegralRecordList(@RequestBody AdminIntegralRecordDTO dto){
//		return (ResultVO<List<AdminIntegralRecord>>)iAdminIntegralRecordService.searchAdminIntegralRecordList(dto);
//	}
//	@ApiOperation(value = "用户模块积分记录表列表分页查询", notes = "用户模块积分记录表API")
//	@RequestMapping(value = "/searchAdminIntegralRecordListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<AdminIntegralRecord>> searchAdminIntegralRecordListPage(@RequestBody AdminIntegralRecordDTO dto){
//		return (ResultVO<Page<AdminIntegralRecord>>)iAdminIntegralRecordService.searchAdminIntegralRecordListPage(dto);
//	}
//	@ApiOperation(value = "用户模块积分记录表详细查询", notes = "用户模块积分记录表API")
//	@RequestMapping(value = "/searchAdminIntegralRecordOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<AdminIntegralRecord> searchAdminIntegralRecordOne(@RequestBody AdminIntegralRecordDTO dto){
//		return (ResultVO<AdminIntegralRecord>)iAdminIntegralRecordService.searchAdminIntegralRecordOne(dto);
//	}
	@ApiOperation(value = "用户模块积分记录表添加", notes = "用户模块积分记录表API")
	@RequestMapping(value = "/addAdminIntegralRecord",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addAdminIntegralRecord(@RequestBody AdminIntegralRecordDTO dto){
		return iAdminIntegralRecordService.addAdminIntegralRecord(dto);
	}
//	@ApiOperation(value = "用户模块积分记录表更新", notes = "用户模块积分记录表API")
//	@RequestMapping(value = "/updateAdminIntegralRecord",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateAdminIntegralRecord(@RequestBody AdminIntegralRecordDTO dto){
//		return iAdminIntegralRecordService.updateAdminIntegralRecord(dto);
//	}
//	@ApiOperation(value = "用户模块积分记录表删除", notes = "用户模块积分记录表API")
//	@RequestMapping(value = "/deleteAdminIntegralRecord",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteAdminIntegralRecord(@RequestBody AdminIntegralRecordDTO dto){
//		return iAdminIntegralRecordService.deleteAdminIntegralRecord(dto);
//	}
//	@ApiOperation(value = "用户模块积分记录表关联查询", notes = "用户模块积分记录表API")
//	@RequestMapping(value = "/searchAdminIntegralRecordRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<AdminIntegralRecordVO> searchAdminIntegralRecordRelation(@RequestBody AdminIntegralRecordDTO dto){
//		return (ResultVO<AdminIntegralRecordVO>)iAdminIntegralRecordService.searchAdminIntegralRecordRelation(dto);
//	}
}

