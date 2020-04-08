package com.tima.admin.web;


import com.tima.admin.dto.DemoDTO;
import com.tima.admin.dto.PlutomembershipDTO;
import com.tima.admin.feign.IPlutomembership;
import com.tima.admin.service.IDemoService;
import com.tima.admin.vo.DemoVO;
import com.tima.admin.vo.PlutomembershipVO;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>
 * demo表 前端控制器
 * </p>
 *
 * @author zwh
 * @since 2018-07-12
 */
@Slf4j
@Api(tags = { "demo表API" })
@RestController
@RequestMapping("/admin/demo")
public class DemoController {
    
   @Autowired
   private IDemoService  iDemoService; 
   
   @Autowired
   private IPlutomembership  i; 
   
    @ApiOperation(value = "demo表列表查询", notes = "demo表API")
	@RequestMapping(value = "/test",method = RequestMethod.POST)
	@ResponseBody
	public PlutomembershipVO searchDemoList(@RequestBody PlutomembershipDTO dto){
        PlutomembershipVO plutomembershipVO = i.searchIntegralCountList(dto);
        return plutomembershipVO;
	}
//	@ApiOperation(value = "demo表列表分页查询", notes = "demo表API")
//	@RequestMapping(value = "/searchDemoListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<Demo>> searchDemoListPage(@RequestBody DemoDTO dto){
//		return (ResultVO<Page<Demo>>)iDemoService.searchDemoListPage(dto);
//	}
//	@ApiOperation(value = "demo表详细查询", notes = "demo表API")
//	@RequestMapping(value = "/searchDemoOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Demo> searchDemoOne(@RequestBody DemoDTO dto){		
//		return (ResultVO<Demo>)iDemoService.searchDemoOne(dto);
//	}
//	@ApiOperation(value = "demo表添加", notes = "demo表API")
//	@RequestMapping(value = "/addDemo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> addDemo(@RequestBody DemoDTO dto){		
//		return iDemoService.addDemo(dto);
//	}	
//	@ApiOperation(value = "demo表更新", notes = "demo表API")
//	@RequestMapping(value = "/updateDemo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateDemo(@RequestBody DemoDTO dto){		
//		return iDemoService.updateDemo(dto);
//	}	
//	@ApiOperation(value = "demo表删除", notes = "demo表API")
//	@RequestMapping(value = "/deleteDemo",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteDemo(@RequestBody DemoDTO dto){		
//		return iDemoService.deleteDemo(dto);
//	}



	@ApiOperation(value = "demo表关联查询", notes = "demo表API")
	@RequestMapping(value = "/searchDemoRelation",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<DemoVO> searchDemoRelation(@RequestBody DemoDTO dto){
        String userNo=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getHeader("userNo");

        System.out.println(userNo);

		return null;
	}
}

