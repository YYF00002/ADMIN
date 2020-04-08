package com.tima.admin.web;


import com.tima.admin.dto.ThirdPartyUserLoginDTO;
import com.tima.admin.entity.ThirdPartyUserLogin;
import com.tima.admin.service.IThirdPartyUserLoginService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 第三方登录信息表  前端控制器
 * </p>
 *
 * @author YYF
 * @since 2020-03-23
 */
@Slf4j
@Api(tags = { "第三方登录信息表 API" })
@RestController
@RequestMapping("/admin/thirdPartyUserLogin")
public class ThirdPartyUserLoginController {
    
   @Autowired
   private IThirdPartyUserLoginService  iThirdPartyUserLoginService; 
   
//    @ApiOperation(value = "第三方登录信息表 列表查询", notes = "第三方登录信息表 API")
//	@RequestMapping(value = "/searchThirdPartyUserLoginList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<ThirdPartyUserLogin>> searchThirdPartyUserLoginList(@RequestBody ThirdPartyUserLoginDTO dto){
//		return (ResultVO<List<ThirdPartyUserLogin>>)iThirdPartyUserLoginService.searchThirdPartyUserLoginList(dto);
//	}
//	@ApiOperation(value = "第三方登录信息表 列表分页查询", notes = "第三方登录信息表 API")
//	@RequestMapping(value = "/searchThirdPartyUserLoginListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<ThirdPartyUserLogin>> searchThirdPartyUserLoginListPage(@RequestBody ThirdPartyUserLoginDTO dto){
//		return (ResultVO<Page<ThirdPartyUserLogin>>)iThirdPartyUserLoginService.searchThirdPartyUserLoginListPage(dto);
//	}
	@ApiOperation(value = "查询微信", notes = "第三方登录信息表 API")
	@RequestMapping(value = "/searchBindingForWechat",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyUserLogin> searchBindingForWechat(@RequestBody ThirdPartyUserLoginDTO dto) throws Exception {
		return (ResultVO<ThirdPartyUserLogin>)iThirdPartyUserLoginService.searchBindingForWechat(dto);
	}
	@ApiOperation(value = "查询QQ", notes = "第三方登录信息表 API")
	@RequestMapping(value = "/searchBindingForQQ",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<ThirdPartyUserLogin> searchBindingForQQ(@RequestBody ThirdPartyUserLoginDTO dto) throws Exception {
		return (ResultVO<ThirdPartyUserLogin>)iThirdPartyUserLoginService.searchBindingForQQ(dto);
	}


	@ApiOperation(value = "绑定手机号", notes = "第三方登录信息表 API")
	@RequestMapping(value = "/bindPhone",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> bindPhone(@RequestBody ThirdPartyUserLoginDTO dto) throws Exception {
		return iThirdPartyUserLoginService.bindPhone(dto);
	}



}

