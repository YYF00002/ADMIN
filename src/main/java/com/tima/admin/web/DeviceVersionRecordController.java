package com.tima.admin.web;


import com.tima.admin.dto.DeviceVersionRecordDTO;
import com.tima.admin.entity.DeviceVersionRecord;
import com.tima.admin.service.IDeviceVersionRecordService;
import com.tima.admin.validateInterface.ISelect;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备版本记录表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
@Slf4j
@Api(tags = { "设备版本记录表API" })
@RestController
@RequestMapping("/admin/deviceVersionRecord")
public class DeviceVersionRecordController {
    
   @Autowired
   private IDeviceVersionRecordService  iDeviceVersionRecordService; 
   
//    @ApiOperation(value = "设备版本记录表列表查询", notes = "设备版本记录表API")
//	@RequestMapping(value = "/searchDeviceVersionRecordList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<DeviceVersionRecord>> searchDeviceVersionRecordList(@RequestBody DeviceVersionRecordDTO dto){
//		return (ResultVO<List<DeviceVersionRecord>>)iDeviceVersionRecordService.searchDeviceVersionRecordList(dto);
//	}
//	@ApiOperation(value = "设备版本记录表列表分页查询", notes = "设备版本记录表API")
//	@RequestMapping(value = "/searchDeviceVersionRecordListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<DeviceVersionRecord>> searchDeviceVersionRecordListPage(@RequestBody DeviceVersionRecordDTO dto){
//		return (ResultVO<Page<DeviceVersionRecord>>)iDeviceVersionRecordService.searchDeviceVersionRecordListPage(dto);
//	}
	@ApiOperation(value = "设备版本记录详细查询", notes = "设备版本记录表API")
	@RequestMapping(value = "/searchDeviceVersionRecordOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<DeviceVersionRecord> searchDeviceVersionRecordOne(@Validated(ISelect.class) @RequestBody DeviceVersionRecordDTO dto){
		return (ResultVO<DeviceVersionRecord>)iDeviceVersionRecordService.searchDeviceVersionRecordOne(dto);
	}
//	@ApiOperation(value = "设备版本记录表添加", notes = "设备版本记录表API")
//	@RequestMapping(value = "/addDeviceVersionRecord",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addDeviceVersionRecord(@RequestBody DeviceVersionRecordDTO dto){
//		return iDeviceVersionRecordService.addDeviceVersionRecord(dto);
//	}
	@ApiOperation(value = "设备版本记录表更新", notes = "设备版本记录表API")
	@RequestMapping(value = "/updateDeviceVersionRecord",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateDeviceVersionRecord(@RequestBody DeviceVersionRecordDTO dto){
		return iDeviceVersionRecordService.updateDeviceVersionRecord(dto);
	}
//	@ApiOperation(value = "设备版本记录表删除", notes = "设备版本记录表API")
//	@RequestMapping(value = "/deleteDeviceVersionRecord",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteDeviceVersionRecord(@RequestBody DeviceVersionRecordDTO dto){
//		return iDeviceVersionRecordService.deleteDeviceVersionRecord(dto);
//	}
//	@ApiOperation(value = "设备版本记录表关联查询", notes = "设备版本记录表API")
//	@RequestMapping(value = "/searchDeviceVersionRecordRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<DeviceVersionRecordVO> searchDeviceVersionRecordRelation(@RequestBody DeviceVersionRecordDTO dto){
//		return (ResultVO<DeviceVersionRecordVO>)iDeviceVersionRecordService.searchDeviceVersionRecordRelation(dto);
//	}
}

