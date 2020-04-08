package com.tima.admin.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.LabelInfoDTO;
import com.tima.admin.entity.LabelInfo;
import com.tima.admin.service.ILabelInfoService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签信息 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
@Slf4j
@Api(tags = { "标签信息API" })
@RestController
@RequestMapping("/admin/labelInfo")
public class LabelInfoController {
    
   @Autowired
   private ILabelInfoService  iLabelInfoService; 
   
//    @ApiOperation(value = "标签信息列表查询", notes = "标签信息API")
//	@RequestMapping(value = "/searchLabelInfoList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<LabelInfo>> searchLabelInfoList(@RequestBody LabelInfoDTO dto){
//		return (ResultVO<List<LabelInfo>>)iLabelInfoService.searchLabelInfoList(dto);
//	}
	@ApiOperation(value = "标签信息列表分页查询", notes = "标签信息API")
	@RequestMapping(value = "/searchLabelInfoListPageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<LabelInfo>> searchLabelInfoListPage(@RequestBody LabelInfoDTO dto){		
		return (ResultVO<Page<LabelInfo>>)iLabelInfoService.searchLabelInfoListPage(dto);
	}
//	@ApiOperation(value = "标签信息详细查询", notes = "标签信息API")
//	@RequestMapping(value = "/searchLabelInfoOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LabelInfo> searchLabelInfoOne(@RequestBody LabelInfoDTO dto){
//		return (ResultVO<LabelInfo>)iLabelInfoService.searchLabelInfoOne(dto);
//	}
	@ApiOperation(value = "标签信息添加", notes = "标签信息API")
	@RequestMapping(value = "/addLabelInfoWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addLabelInfoWeb(@RequestBody LabelInfoDTO dto){
		return iLabelInfoService.addLabelInfo(dto);
	}	


	@ApiOperation(value = "标签信息更新", notes = "标签信息API")
	@RequestMapping(value = "/updateLabelInfoWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateLabelInfoWeb(@RequestBody LabelInfoDTO dto){
		return iLabelInfoService.updateLabelInfo(dto);
	}
//	@ApiOperation(value = "标签信息删除", notes = "标签信息API")
//	@RequestMapping(value = "/deleteLabelInfo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteLabelInfo(@RequestBody LabelInfoDTO dto){
//		return iLabelInfoService.deleteLabelInfo(dto);
//	}
//	@ApiOperation(value = "标签信息关联查询", notes = "标签信息API")
//	@RequestMapping(value = "/searchLabelInfoRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LabelInfoVO> searchLabelInfoRelation(@RequestBody LabelInfoDTO dto){
//		return (ResultVO<LabelInfoVO>)iLabelInfoService.searchLabelInfoRelation(dto);
//	}
}

