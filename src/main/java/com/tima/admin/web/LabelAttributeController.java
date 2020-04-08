package com.tima.admin.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.LabelAttributeDTO;
import com.tima.admin.entity.LabelAttribute;
import com.tima.admin.service.ILabelAttributeService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签属性分类 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
@Slf4j
@Api(tags = { "标签属性分类API" })
@RestController
@RequestMapping("/admin/labelAttribute")
public class LabelAttributeController {

   @Autowired
   private ILabelAttributeService  iLabelAttributeService;

//    @ApiOperation(value = "标签属性分类列表查询", notes = "标签属性分类API")
//	@RequestMapping(value = "/searchLabelAttributeList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<LabelAttribute>> searchLabelAttributeList(@RequestBody LabelAttributeDTO dto){
//		return (ResultVO<List<LabelAttribute>>)iLabelAttributeService.searchLabelAttributeList(dto);
//	}
	@ApiOperation(value = "标签属性分类列表分页查询", notes = "标签属性分类API")
	@RequestMapping(value = "/searchLabelAttributeListPage",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<LabelAttribute>> searchLabelAttributeListPage(@RequestBody LabelAttributeDTO dto){
		return (ResultVO<Page<LabelAttribute>>)iLabelAttributeService.searchLabelAttributeListPage(dto);
	}
//	@ApiOperation(value = "标签属性分类详细查询", notes = "标签属性分类API")
//	@RequestMapping(value = "/searchLabelAttributeOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LabelAttribute> searchLabelAttributeOne(@RequestBody LabelAttributeDTO dto){
//		return (ResultVO<LabelAttribute>)iLabelAttributeService.searchLabelAttributeOne(dto);
//	}
//	@ApiOperation(value = "标签属性分类添加", notes = "标签属性分类API")
//	@RequestMapping(value = "/addLabelAttribute",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addLabelAttribute(@RequestBody LabelAttributeDTO dto){
//		return iLabelAttributeService.addLabelAttribute(dto);
//	}
//	@ApiOperation(value = "标签属性分类更新", notes = "标签属性分类API")
//	@RequestMapping(value = "/updateLabelAttribute",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateLabelAttribute(@RequestBody LabelAttributeDTO dto){
//		return iLabelAttributeService.updateLabelAttribute(dto);
//	}
//	@ApiOperation(value = "标签属性分类删除", notes = "标签属性分类API")
//	@RequestMapping(value = "/deleteLabelAttribute",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteLabelAttribute(@RequestBody LabelAttributeDTO dto){
//		return iLabelAttributeService.deleteLabelAttribute(dto);
//	}
//	@ApiOperation(value = "标签属性分类关联查询", notes = "标签属性分类API")
//	@RequestMapping(value = "/searchLabelAttributeRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LabelAttributeVO> searchLabelAttributeRelation(@RequestBody LabelAttributeDTO dto){
//		return (ResultVO<LabelAttributeVO>)iLabelAttributeService.searchLabelAttributeRelation(dto);
//	}
}

