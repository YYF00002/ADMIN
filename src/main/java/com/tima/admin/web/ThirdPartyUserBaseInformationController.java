package com.tima.admin.web;


import com.tima.admin.dto.ThirdPartyRequestDTO;
import com.tima.admin.dto.ThirdPartyUserBaseInformationDTO;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.service.IThirdPartyUserBaseInformationService;
import com.tima.admin.validateInterface.ISelect;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.ThirdPartyUserBaseInformationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 第三方用户信息表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-08-30
 */
@Slf4j
@Api(tags = { "第三方用户信息表API" })
@RestController
@RequestMapping("/admin/thirdPartyUserBaseInformation")
public class ThirdPartyUserBaseInformationController {
    
   @Autowired
   private IThirdPartyUserBaseInformationService  iThirdPartyUserBaseInformationService; 
   
//    @ApiOperation(value = "第三方用户信息表列表查询", notes = "第三方用户信息表API")
//	@RequestMapping(value = "/searchThirdPartyUserBaseInformationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<ThirdPartyUserBaseInformation>> searchThirdPartyUserBaseInformationList(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
//		return (ResultVO<List<ThirdPartyUserBaseInformation>>)iThirdPartyUserBaseInformationService.searchThirdPartyUserBaseInformationList(dto);
//	}
//	@ApiOperation(value = "第三方用户信息表列表分页查询", notes = "第三方用户信息表API")
//	@RequestMapping(value = "/searchThirdPartyUserBaseInformationListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<ThirdPartyUserBaseInformation>> searchThirdPartyUserBaseInformationListPage(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
//		return (ResultVO<Page<ThirdPartyUserBaseInformation>>)iThirdPartyUserBaseInformationService.searchThirdPartyUserBaseInformationListPage(dto);
//	}
	@ApiOperation(value = "查询AAAID、tspId及token", notes = "第三方用户信息表API")
	@RequestMapping(value = "/searchThirdPartyUserBaseInformationOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyUserBaseInformation> searchThirdPartyUserBaseInformationOne(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
		return (ResultVO<ThirdPartyUserBaseInformation>)iThirdPartyUserBaseInformationService.searchThirdPartyUserBaseInformationOne(dto);
	}
	/**
	 * 根据AAAid查询用户信息，供车控调用
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "根据AAAid查询第三方用户信息", notes = "第三方用户信息表API")
	@RequestMapping(value = "/searchThirdPartyUserBaseInformationOneByAAAID",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyUserBaseInformation> searchThirdPartyUserBaseInformationOneByAAAID(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
		return (ResultVO<ThirdPartyUserBaseInformation>)iThirdPartyUserBaseInformationService.searchThirdPartyUserBaseInformationOneByAAAID(dto);
	}

	/**
	 *
	 * 供外部调用
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "根据tspID查询APP的userNo", notes = "第三方用户信息表API")
	@RequestMapping(value = "/selectuserNoByTSPID",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyUserBaseInformationVO> selectuserNoByTSPID(@Validated(ISelect.class) @RequestBody ThirdPartyUserBaseInformationDTO dto){		
		return (ResultVO<ThirdPartyUserBaseInformationVO>)iThirdPartyUserBaseInformationService.selectuserNoByTSPID(dto);
	}
	
	/**
	 * tsp调用
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "根据AAAID查询用户头像", notes = "第三方用户信息表API")
	@RequestMapping(value = "/selectuserImageByTSPID",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyUserBaseInformationVO> selectuserImageByTSPID(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
		return (ResultVO<ThirdPartyUserBaseInformationVO>)iThirdPartyUserBaseInformationService.selectuserImageByTSPID(dto);
	}
	
//	@ApiOperation(value = "第三方用户信息表添加", notes = "第三方用户信息表API")
//	@RequestMapping(value = "/addThirdPartyUserBaseInformation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addThirdPartyUserBaseInformation(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
//		return iThirdPartyUserBaseInformationService.addThirdPartyUserBaseInformation(dto);
//	}	
	
	//刷新token
	@ApiOperation(value = "刷新token", notes = "第三方用户信息表API")
	@RequestMapping(value = "/refreshToken",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyRequestDTO> refreshToken(@RequestBody UserBaseInformationDTO dto){		
		return (ResultVO<ThirdPartyRequestDTO>) iThirdPartyUserBaseInformationService.refreshToken(dto);
	}	
//	@ApiOperation(value = "第三方用户信息表更新", notes = "第三方用户信息表API")
//	@RequestMapping(value = "/updateThirdPartyUserBaseInformation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateThirdPartyUserBaseInformation(@RequestBody ThirdPartyUserBaseInformationDTO dto){		
//		return iThirdPartyUserBaseInformationService.updateThirdPartyUserBaseInformation(dto);
//	}	
}

