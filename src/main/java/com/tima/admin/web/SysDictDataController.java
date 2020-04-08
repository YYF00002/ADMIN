package com.tima.admin.web;


import com.tima.admin.service.ISysDictDataService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
@Slf4j
@Api(tags = { "字典数据表API" })
@RestController
@RequestMapping("/admin/sysDictData")
public class SysDictDataController {
    
   @Autowired
   private ISysDictDataService  iSysDictDataService; 
   
//    @ApiOperation(value = "字典数据表列表查询", notes = "字典数据表API")
//	@RequestMapping(value = "/searchSysDictDataList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<SysDictData>> searchSysDictDataList(@RequestBody SysDictDataDTO dto){
//		return (ResultVO<List<SysDictData>>)iSysDictDataService.searchSysDictDataList(dto);
//	}
//	@ApiOperation(value = "字典数据表列表分页查询", notes = "字典数据表API")
//	@RequestMapping(value = "/searchSysDictDataListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<SysDictData>> searchSysDictDataListPage(@RequestBody SysDictDataDTO dto){
//		return (ResultVO<Page<SysDictData>>)iSysDictDataService.searchSysDictDataListPage(dto);
//	}
//	@ApiOperation(value = "字典数据表详细查询", notes = "字典数据表API")
//	@RequestMapping(value = "/searchSysDictDataOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SysDictData> searchSysDictDataOne(@RequestBody SysDictDataDTO dto){
//		return (ResultVO<SysDictData>)iSysDictDataService.searchSysDictDataOne(dto);
//	}
//	@ApiOperation(value = "字典数据表添加", notes = "字典数据表API")
//	@RequestMapping(value = "/addSysDictData",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addSysDictData(@RequestBody SysDictDataDTO dto){
//		return iSysDictDataService.addSysDictData(dto);
//	}
//	@ApiOperation(value = "字典数据表更新", notes = "字典数据表API")
//	@RequestMapping(value = "/updateSysDictData",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateSysDictData(@RequestBody SysDictDataDTO dto){
//		return iSysDictDataService.updateSysDictData(dto);
//	}
//	@ApiOperation(value = "字典数据表删除", notes = "字典数据表API")
//	@RequestMapping(value = "/deleteSysDictData",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteSysDictData(@RequestBody SysDictDataDTO dto){
//		return iSysDictDataService.deleteSysDictData(dto);
//	}
//	@ApiOperation(value = "字典数据表关联查询", notes = "字典数据表API")
//	@RequestMapping(value = "/searchSysDictDataRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SysDictDataVO> searchSysDictDataRelation(@RequestBody SysDictDataDTO dto){
//		return (ResultVO<SysDictDataVO>)iSysDictDataService.searchSysDictDataRelation(dto);
//	}
}

