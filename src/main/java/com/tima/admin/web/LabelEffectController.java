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
//import com.tima.admin.dto.LabelEffectDTO;
//import com.tima.admin.vo.LabelEffectVO;
//import com.tima.admin.service.ILabelEffectService;
//import com.tima.admin.entity.LabelEffect;
//import java.util.List;
//import com.baomidou.mybatisplus.plugins.Page;
//
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * <p>
// * 标签效能状态分类分类 前端控制器
// * </p>
// *
// * @author YYF
// * @since 2018-12-10
// */
//@Slf4j
//@Api(tags = { "标签效能状态分类分类API" })
//@RestController
//@RequestMapping("/admin/labelEffect")
//public class LabelEffectController {
//
//   @Autowired
//   private ILabelEffectService  iLabelEffectService;
//
//    @ApiOperation(value = "标签效能状态分类分类列表查询", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/searchLabelEffectList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<LabelEffect>> searchLabelEffectList(@RequestBody LabelEffectDTO dto){
//		return (ResultVO<List<LabelEffect>>)iLabelEffectService.searchLabelEffectList(dto);
//	}
//	@ApiOperation(value = "标签效能状态分类分类列表分页查询", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/searchLabelEffectListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<LabelEffect>> searchLabelEffectListPage(@RequestBody LabelEffectDTO dto){
//		return (ResultVO<Page<LabelEffect>>)iLabelEffectService.searchLabelEffectListPage(dto);
//	}
//	@ApiOperation(value = "标签效能状态分类分类详细查询", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/searchLabelEffectOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LabelEffect> searchLabelEffectOne(@RequestBody LabelEffectDTO dto){
//		return (ResultVO<LabelEffect>)iLabelEffectService.searchLabelEffectOne(dto);
//	}
//	@ApiOperation(value = "标签效能状态分类分类添加", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/addLabelEffect",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addLabelEffect(@RequestBody LabelEffectDTO dto){
//		return iLabelEffectService.addLabelEffect(dto);
//	}
//	@ApiOperation(value = "标签效能状态分类分类更新", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/updateLabelEffect",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateLabelEffect(@RequestBody LabelEffectDTO dto){
//		return iLabelEffectService.updateLabelEffect(dto);
//	}
//	@ApiOperation(value = "标签效能状态分类分类删除", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/deleteLabelEffect",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteLabelEffect(@RequestBody LabelEffectDTO dto){
//		return iLabelEffectService.deleteLabelEffect(dto);
//	}
//	@ApiOperation(value = "标签效能状态分类分类关联查询", notes = "标签效能状态分类分类API")
//	@RequestMapping(value = "/searchLabelEffectRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<LabelEffectVO> searchLabelEffectRelation(@RequestBody LabelEffectDTO dto){
//		return (ResultVO<LabelEffectVO>)iLabelEffectService.searchLabelEffectRelation(dto);
//	}
//}
//
