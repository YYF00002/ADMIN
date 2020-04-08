package com.tima.admin.web;


import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.CountryAreaCodeDTO;
import com.tima.admin.vo.CountryAreaCodeVO;
import com.tima.admin.service.ICountryAreaCodeService;
import com.tima.admin.validateInterface.ISelect;
import com.tima.admin.validateInterface.ISelectWeb;
import com.tima.admin.entity.CountryAreaCode;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 国统局区域代码 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Slf4j
@Api(tags = { "省市查询代码API" })
@RestController
@RequestMapping("/admin/countryAreaCode")
public class CountryAreaCodeController {
    
   @Autowired
   private ICountryAreaCodeService  iCountryAreaCodeService; 
   
//    @ApiOperation(value = "国统局区域代码列表查询", notes = "国统局区域代码API")
//	@RequestMapping(value = "/searchCountryAreaCodeList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<CountryAreaCode>> searchCountryAreaCodeList(@RequestBody CountryAreaCodeDTO dto){		
//		return (ResultVO<List<CountryAreaCode>>)iCountryAreaCodeService.searchCountryAreaCodeList(dto);
//	}
	@ApiOperation(value = "省市列表分页查询", notes = "省市API")
	@RequestMapping(value = "/searchCountryAreaCodeListPage",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<CountryAreaCode>> searchCountryAreaCodeListPage(@Validated(ISelect.class) @RequestBody CountryAreaCodeDTO dto){		
		return (ResultVO<Page<CountryAreaCode>>)iCountryAreaCodeService.searchCountryAreaCodeListPage(dto);
	}
	
	@ApiOperation(value = "省市列表分页查询（Web）", notes = "省市Web")
	@RequestMapping(value = "/searchCountryAreaCodeListPageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<CountryAreaCode>> searchCountryAreaCodeListPageWeb(@Validated(ISelectWeb.class) @RequestBody CountryAreaCodeDTO dto){		
		return (ResultVO<Page<CountryAreaCode>>)iCountryAreaCodeService.searchCountryAreaCodeListPage(dto);
	}
//	@ApiOperation(value = "国统局区域代码详细查询", notes = "国统局区域代码API")
//	@RequestMapping(value = "/searchCountryAreaCodeOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<CountryAreaCode> searchCountryAreaCodeOne(@RequestBody CountryAreaCodeDTO dto){		
//		return (ResultVO<CountryAreaCode>)iCountryAreaCodeService.searchCountryAreaCodeOne(dto);
//	}
//	@ApiOperation(value = "国统局区域代码添加", notes = "国统局区域代码API")
//	@RequestMapping(value = "/addCountryAreaCode",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addCountryAreaCode(@RequestBody CountryAreaCodeDTO dto){		
//		return iCountryAreaCodeService.addCountryAreaCode(dto);
//	}	
//	@ApiOperation(value = "国统局区域代码更新", notes = "国统局区域代码API")
//	@RequestMapping(value = "/updateCountryAreaCode",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateCountryAreaCode(@RequestBody CountryAreaCodeDTO dto){		
//		return iCountryAreaCodeService.updateCountryAreaCode(dto);
//	}	
//	@ApiOperation(value = "国统局区域代码删除", notes = "国统局区域代码API")
//	@RequestMapping(value = "/deleteCountryAreaCode",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteCountryAreaCode(@RequestBody CountryAreaCodeDTO dto){		
//		return iCountryAreaCodeService.deleteCountryAreaCode(dto);
//	}
//	@ApiOperation(value = "国统局区域代码关联查询", notes = "国统局区域代码API")
//	@RequestMapping(value = "/searchCountryAreaCodeRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<CountryAreaCodeVO> searchCountryAreaCodeRelation(@RequestBody CountryAreaCodeDTO dto){		
//		return (ResultVO<CountryAreaCodeVO>)iCountryAreaCodeService.searchCountryAreaCodeRelation(dto);
//	}		
}

