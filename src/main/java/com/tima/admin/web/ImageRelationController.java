package com.tima.admin.web;


import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.ImageRelationDTO;
import com.tima.admin.vo.ImageRelationVO;
import com.tima.admin.service.IImageRelationService;
import com.tima.admin.entity.ImageRelation;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 图片关联表 前端控制器
 * </p>
 *
 * @author zwh
 * @since 2018-07-17
 */
@Slf4j
@Api(tags = { "图片关联表API" })
@RestController
@RequestMapping("/admin/imageRelation")
public class ImageRelationController {
    
   @Autowired
   private IImageRelationService  iImageRelationService; 
   
//    @ApiOperation(value = "图片关联表列表查询", notes = "图片关联表API")
//	@RequestMapping(value = "/searchImageRelationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<ImageRelation>> searchImageRelationList(@RequestBody ImageRelationDTO dto){		
//		return (ResultVO<List<ImageRelation>>)iImageRelationService.searchImageRelationList(dto);
//	}
//	@ApiOperation(value = "图片关联表列表分页查询", notes = "图片关联表API")
//	@RequestMapping(value = "/searchImageRelationListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<ImageRelation>> searchImageRelationListPage(@RequestBody ImageRelationDTO dto){		
//		return (ResultVO<Page<ImageRelation>>)iImageRelationService.searchImageRelationListPage(dto);
//	}
//	@ApiOperation(value = "图片关联表详细查询", notes = "图片关联表API")
//	@RequestMapping(value = "/searchImageRelationOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<ImageRelation> searchImageRelationOne(@RequestBody ImageRelationDTO dto){		
//		return (ResultVO<ImageRelation>)iImageRelationService.searchImageRelationOne(dto);
//	}
	@ApiOperation(value = "添加图片关联表（Web）", notes = "图片关联表Web")
	@RequestMapping(value = "/addImageRelationWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addImageRelationWeb(@RequestBody ImageRelationDTO dto){		
		return iImageRelationService.addImageRelation(dto);
	}	
	@ApiOperation(value = "添加图片关联表", notes = "图片关联表API")
	@RequestMapping(value = "/addImageRelation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addImageRelation(@RequestBody ImageRelationDTO dto){		
		return iImageRelationService.addImageRelation(dto);
	}	
	@ApiOperation(value = "图片关联表更新（Web）", notes = "图片关联表Web")
	@RequestMapping(value = "/updateImageRelationWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateImageRelationWeb(@RequestBody ImageRelationDTO dto){		
		return iImageRelationService.updateImageRelation(dto);
	}	
	@ApiOperation(value = "图片关联表更新", notes = "图片关联表API")
	@RequestMapping(value = "/updateImageRelation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateImageRelation(@RequestBody ImageRelationDTO dto){		
		return iImageRelationService.updateImageRelation(dto);
	}	
//	@ApiOperation(value = "图片关联表删除", notes = "图片关联表API")
//	@RequestMapping(value = "/deleteImageRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteImageRelation(@RequestBody ImageRelationDTO dto){		
//		return iImageRelationService.deleteImageRelation(dto);
//	}
//	@ApiOperation(value = "图片关联表关联查询", notes = "图片关联表API")
//	@RequestMapping(value = "/searchImageRelationRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<ImageRelationVO> searchImageRelationRelation(@RequestBody ImageRelationDTO dto){		
//		return (ResultVO<ImageRelationVO>)iImageRelationService.searchImageRelationRelation(dto);
//	}		
}

