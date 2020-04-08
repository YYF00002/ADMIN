package com.tima.admin.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.VersionRecordDTO;
import com.tima.admin.entity.VersionRecord;
import com.tima.admin.service.IVersionRecordService;
import com.tima.admin.validateInterface.IAddWeb;
import com.tima.admin.validateInterface.IDeleteWeb;
import com.tima.admin.validateInterface.IUpdateWeb;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 版本记录表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
@Slf4j
@Api(tags = { "版本记录表API" })
@RestController
@RequestMapping("/admin/versionRecord")
public class VersionRecordController {
    
   @Autowired
   private IVersionRecordService  iVersionRecordService; 
   
//    @ApiOperation(value = "版本记录表列表查询", notes = "版本记录表API")
//	@RequestMapping(value = "/searchVersionRecordList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<VersionRecord>> searchVersionRecordList(@RequestBody VersionRecordDTO dto){
//		return (ResultVO<List<VersionRecord>>)iVersionRecordService.searchVersionRecordList(dto);
//	}
	@ApiOperation(value = "版本记录表列表分页查询", notes = "版本记录表API")
	@RequestMapping(value = "/searchVersionRecordListPageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<VersionRecord>> searchVersionRecordListPageWeb(@RequestBody VersionRecordDTO dto){
		return (ResultVO<Page<VersionRecord>>)iVersionRecordService.searchVersionRecordListPage(dto);
	}

    @ApiOperation(value = "查询最新的版本信息", notes = "版本记录表API")
    @RequestMapping(value = "/selectNewVersion",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<VersionRecord> selectNewVersion(@RequestBody VersionRecordDTO dto){
        return (ResultVO<VersionRecord>)iVersionRecordService.selectNewVersion(dto);
    }



//	@ApiOperation(value = "版本记录表详细查询", notes = "版本记录表API")
//	@RequestMapping(value = "/searchVersionRecordOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<VersionRecord> searchVersionRecordOne(@RequestBody VersionRecordDTO dto){
//		return (ResultVO<VersionRecord>)iVersionRecordService.searchVersionRecordOne(dto);
//	}
	@ApiOperation(value = "版本记录表添加", notes = "版本记录表API")
	@RequestMapping(value = "/addVersionRecordWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addVersionRecordWeb(@Validated(IAddWeb.class) @RequestBody VersionRecordDTO dto){
		return iVersionRecordService.addVersionRecord(dto);
	}	
	@ApiOperation(value = "版本记录表更新", notes = "版本记录表API")
	@RequestMapping(value = "/updateVersionRecordWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateVersionRecordWeb(@Validated(IUpdateWeb.class) @RequestBody VersionRecordDTO dto){
		return iVersionRecordService.updateVersionRecord(dto);
	}	
	@ApiOperation(value = "版本记录表删除", notes = "版本记录表API")
	@RequestMapping(value = "/deleteVersionRecordWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> deleteVersionRecordWeb(@Validated(IDeleteWeb.class) @RequestBody VersionRecordDTO dto){
		return iVersionRecordService.deleteVersionRecord(dto);
	}
//	@ApiOperation(value = "版本记录表关联查询", notes = "版本记录表API")
//	@RequestMapping(value = "/searchVersionRecordRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<VersionRecordVO> searchVersionRecordRelation(@RequestBody VersionRecordDTO dto){
//		return (ResultVO<VersionRecordVO>)iVersionRecordService.searchVersionRecordRelation(dto);
//	}
}

