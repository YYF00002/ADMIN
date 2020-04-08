package com.tima.admin.web;


import com.tima.admin.dto.LabelEntityDTO;
import com.tima.admin.service.ILabelEntityService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签实体 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
@Slf4j
@Api(tags = {"标签实体API"})
@RestController
@RequestMapping("/admin/labelEntity")
public class LabelEntityController {

    @Autowired
    private ILabelEntityService iLabelEntityService;


    //    @ApiOperation(value = "标签实体列表查询", notes = "标签实体API")
////	@RequestMapping(value = "/searchLabelEntityList",method = RequestMethod.POST)
////	@ResponseBody
////	public ResultVO<List<LabelEntity>> searchLabelEntityList(@RequestBody LabelEntityDTO dto){
////		return (ResultVO<List<LabelEntity>>)iLabelEntityService.searchLabelEntityList(dto);
////	}
////	@ApiOperation(value = "标签实体列表分页查询", notes = "标签实体API")
////	@RequestMapping(value = "/searchLabelEntityListPage",method = RequestMethod.POST)
////	@ResponseBody
////	public ResultVO<Page<LabelEntity>> searchLabelEntityListPage(@RequestBody LabelEntityDTO dto){
////		return (ResultVO<Page<LabelEntity>>)iLabelEntityService.searchLabelEntityListPage(dto);
////	}
////	@ApiOperation(value = "标签实体详细查询", notes = "标签实体API")
////	@RequestMapping(value = "/searchLabelEntityOne",method = RequestMethod.POST)
////	@ResponseBody
////	public ResultVO<LabelEntity> searchLabelEntityOne(@RequestBody LabelEntityDTO dto){
////		return (ResultVO<LabelEntity>)iLabelEntityService.searchLabelEntityOne(dto);
////	}
    @ApiOperation(value = "批量添加标签", notes = "标签实体API")
    @RequestMapping(value = "/addLabelEntityManyWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> addLabelEntityManyWeb(@RequestBody LabelEntityDTO dto) {
        return iLabelEntityService.addLabelEntityManyWeb(dto);
    }

    @ApiOperation(value = "会员等级标签更新", notes = "标签实体API")
    @RequestMapping(value = "/updateLabelEntity", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> updateLabelEntity(@RequestBody LabelEntityDTO dto) {
        return iLabelEntityService.updateLabelEntity(dto);
    }

    @ApiOperation(value = "车主标签添加或更新", notes = "标签实体API")
    @RequestMapping(value = "/setVehicleLabel", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> setVehicleLabel(@RequestBody LabelEntityDTO dto) {
        return iLabelEntityService.setVehicleLabel(dto);
    }


    @ApiOperation(value = "用户登录时为用户绑定标签", notes = "标签实体API")
    @RequestMapping(value = "/addLabelEntityToUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> addLabelEntityToUser(@RequestBody LabelEntityDTO dto) {
        return iLabelEntityService.addLabelEntityToUser(dto);
    }
////	@ApiOperation(value = "标签实体删除", notes = "标签实体API")
////	@RequestMapping(value = "/deleteLabelEntity",method = RequestMethod.POST)
////	@ResponseBody
////	public ResultVO<?> deleteLabelEntity(@RequestBody LabelEntityDTO dto){
////		return iLabelEntityService.deleteLabelEntity(dto);
////	}
////	@ApiOperation(value = "标签实体关联查询", notes = "标签实体API")
////	@RequestMapping(value = "/searchLabelEntityRelation",method = RequestMethod.POST)
////	@ResponseBody
////	public ResultVO<LabelEntityVO> searchLabelEntityRelation(@RequestBody LabelEntityDTO dto){
////		return (ResultVO<LabelEntityVO>)iLabelEntityService.searchLabelEntityRelation(dto);
////	}


}

