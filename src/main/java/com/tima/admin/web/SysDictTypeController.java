package com.tima.admin.web;


import com.tima.admin.dto.SysDictTypeDTO;
import com.tima.admin.entity.SysDictType;
import com.tima.admin.service.ISysDictTypeService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统字典类型表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
@Slf4j
@Api(tags = { "系统字典类型表API" })
@RestController
@RequestMapping("/admin/sysDictType")
public class SysDictTypeController {
    
   @Autowired
   private ISysDictTypeService  iSysDictTypeService; 
   
    @ApiOperation(value = "系统字典类型表列表查询", notes = "系统字典类型表API")
	@RequestMapping(value = "/searchSysDictTypeList",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<SysDictType>> searchSysDictTypeList(@RequestBody SysDictTypeDTO dto){		
		return (ResultVO<List<SysDictType>>)iSysDictTypeService.searchSysDictTypeList(dto);
	}
//	@ApiOperation(value = "系统字典类型表列表分页查询", notes = "系统字典类型表API")
//	@RequestMapping(value = "/searchSysDictTypeListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<SysDictType>> searchSysDictTypeListPage(@RequestBody SysDictTypeDTO dto){
//		return (ResultVO<Page<SysDictType>>)iSysDictTypeService.searchSysDictTypeListPage(dto);
//	}
//	@ApiOperation(value = "系统字典类型表详细查询", notes = "系统字典类型表API")
//	@RequestMapping(value = "/searchSysDictTypeOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SysDictType> searchSysDictTypeOne(@RequestBody SysDictTypeDTO dto){
//		return (ResultVO<SysDictType>)iSysDictTypeService.searchSysDictTypeOne(dto);
//	}
//	@ApiOperation(value = "系统字典类型表添加", notes = "系统字典类型表API")
//	@RequestMapping(value = "/addSysDictType",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addSysDictType(@RequestBody SysDictTypeDTO dto){
//		return iSysDictTypeService.addSysDictType(dto);
//	}
//	@ApiOperation(value = "系统字典类型表更新", notes = "系统字典类型表API")
//	@RequestMapping(value = "/updateSysDictType",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateSysDictType(@RequestBody SysDictTypeDTO dto){
//		return iSysDictTypeService.updateSysDictType(dto);
//	}
//	@ApiOperation(value = "系统字典类型表删除", notes = "系统字典类型表API")
//	@RequestMapping(value = "/deleteSysDictType",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteSysDictType(@RequestBody SysDictTypeDTO dto){
//		return iSysDictTypeService.deleteSysDictType(dto);
//	}
//	@ApiOperation(value = "系统字典类型表关联查询", notes = "系统字典类型表API")
//	@RequestMapping(value = "/searchSysDictTypeRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SysDictTypeVO> searchSysDictTypeRelation(@RequestBody SysDictTypeDTO dto){
//		return (ResultVO<SysDictTypeVO>)iSysDictTypeService.searchSysDictTypeRelation(dto);
//	}
}

