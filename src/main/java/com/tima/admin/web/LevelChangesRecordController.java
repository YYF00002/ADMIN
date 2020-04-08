package com.tima.admin.web;


import com.tima.admin.dto.LevelChangesRecordDTO;
import com.tima.admin.entity.LevelChangesRecord;
import com.tima.admin.service.ILevelChangesRecordService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 会员等级变动明细表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
@Slf4j
@Api(tags = { "会员等级变动明细表API" })
@RestController
@RequestMapping("/admin/levelChangesRecord")
public class LevelChangesRecordController {
    
   @Autowired
   private ILevelChangesRecordService  iLevelChangesRecordService; 
   
    @ApiOperation(value = "会员等级变动明细表列表查询", notes = "会员等级变动明细表API")
	@RequestMapping(value = "/searchLevelChangesRecordList",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<LevelChangesRecord>> searchLevelChangesRecordList(@RequestBody LevelChangesRecordDTO dto){
		return (ResultVO<List<LevelChangesRecord>>)iLevelChangesRecordService.searchLevelChangesRecordList(dto);
	}
//	@ApiOperation(value = "会员等级变动明细表列表分页查询", notes = "会员等级变动明细表API")
//	@RequestMapping(value = "/searchLevelChangesRecordListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<LevelChangesRecord>> searchLevelChangesRecordListPage(@RequestBody LevelChangesRecordDTO dto){
//		return (ResultVO<Page<LevelChangesRecord>>)iLevelChangesRecordService.searchLevelChangesRecordListPage(dto);
//	}
//	@ApiOperation(value = "会员等级变动明细表详细查询", notes = "会员等级变动明细表API")
//	@RequestMapping(value = "/searchLevelChangesRecordOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LevelChangesRecord> searchLevelChangesRecordOne(@RequestBody LevelChangesRecordDTO dto){
//		return (ResultVO<LevelChangesRecord>)iLevelChangesRecordService.searchLevelChangesRecordOne(dto);
//	}
//	@ApiOperation(value = "会员等级变动明细表添加", notes = "会员等级变动明细表API")
//	@RequestMapping(value = "/addLevelChangesRecord",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addLevelChangesRecord(@RequestBody LevelChangesRecordDTO dto){
//		return iLevelChangesRecordService.addLevelChangesRecord(dto);
//	}
	@ApiOperation(value = "会员等级变动明细表更新", notes = "会员等级变动明细表API")
	@RequestMapping(value = "/updateLevelChangesRecord",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateLevelChangesRecord(@RequestBody LevelChangesRecordDTO dto){
		return iLevelChangesRecordService.updateLevelChangesRecord(dto);
	}
//	@ApiOperation(value = "会员等级变动明细表删除", notes = "会员等级变动明细表API")
//	@RequestMapping(value = "/deleteLevelChangesRecord",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteLevelChangesRecord(@RequestBody LevelChangesRecordDTO dto){
//		return iLevelChangesRecordService.deleteLevelChangesRecord(dto);
//	}
//	@ApiOperation(value = "会员等级变动明细表关联查询", notes = "会员等级变动明细表API")
//	@RequestMapping(value = "/searchLevelChangesRecordRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LevelChangesRecordVO> searchLevelChangesRecordRelation(@RequestBody LevelChangesRecordDTO dto){
//		return (ResultVO<LevelChangesRecordVO>)iLevelChangesRecordService.searchLevelChangesRecordRelation(dto);
//	}
}

