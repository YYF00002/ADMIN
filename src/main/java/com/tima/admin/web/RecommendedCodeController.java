package com.tima.admin.web;


import com.tima.admin.dto.RecommendedCodeDTO;
import com.tima.admin.entity.RecommendedCode;
import com.tima.admin.service.IRecommendedCodeService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户推荐码 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-08-29
 */
@Slf4j
@Api(tags = { "用户推荐码API" })
@RestController
@RequestMapping("/admin/recommendedCode")
public class RecommendedCodeController {
    
   @Autowired
   private IRecommendedCodeService  iRecommendedCodeService; 
   
//    @ApiOperation(value = "用户推荐码列表查询", notes = "用户推荐码API")
//	@RequestMapping(value = "/searchRecommendedCodeList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<RecommendedCode>> searchRecommendedCodeList(@RequestBody RecommendedCodeDTO dto){		
//		return (ResultVO<List<RecommendedCode>>)iRecommendedCodeService.searchRecommendedCodeList(dto);
//	}
//	@ApiOperation(value = "用户推荐码列表分页查询", notes = "用户推荐码API")
//	@RequestMapping(value = "/searchRecommendedCodeListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<RecommendedCode>> searchRecommendedCodeListPage(@RequestBody RecommendedCodeDTO dto){		
//		return (ResultVO<Page<RecommendedCode>>)iRecommendedCodeService.searchRecommendedCodeListPage(dto);
//	}
	@ApiOperation(value = "用户推荐码查询", notes = "用户推荐码API")
	@RequestMapping(value = "/searchRecommendedCodeOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<RecommendedCode> searchRecommendedCodeOne(@RequestBody RecommendedCodeDTO dto){		
		return (ResultVO<RecommendedCode>)iRecommendedCodeService.searchRecommendedCodeOne(dto);
	}
	@ApiOperation(value = "验证推荐码是否可用", notes = "用户推荐码API")
	@RequestMapping(value = "/validateCode",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> validateCode(@RequestBody RecommendedCodeDTO dto){		
		return iRecommendedCodeService.validateCode(dto);
	}	
	@ApiOperation(value = "修改推荐码分享次数", notes = "用户推荐码API")
	@RequestMapping(value = "/updateRecommendedCode",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateRecommendedCode(@RequestBody RecommendedCodeDTO dto){		
		return iRecommendedCodeService.updateRecommendedCode(dto);
	}	
//	@ApiOperation(value = "用户推荐码删除", notes = "用户推荐码API")
//	@RequestMapping(value = "/deleteRecommendedCode",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteRecommendedCode(@RequestBody RecommendedCodeDTO dto){		
//		return iRecommendedCodeService.deleteRecommendedCode(dto);
//	}
//	@ApiOperation(value = "用户推荐码关联查询", notes = "用户推荐码API")
//	@RequestMapping(value = "/searchRecommendedCodeRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<RecommendedCodeVO> searchRecommendedCodeRelation(@RequestBody RecommendedCodeDTO dto){		
//		return (ResultVO<RecommendedCodeVO>)iRecommendedCodeService.searchRecommendedCodeRelation(dto);
//	}		
}

