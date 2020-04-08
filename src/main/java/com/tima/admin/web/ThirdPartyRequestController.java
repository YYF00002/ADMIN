package com.tima.admin.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tima.admin.dto.ThirdPartyRequestDTO;
import com.tima.admin.service.IThirdPartyRequestService;
import com.tima.admin.validateInterface.IMessageCode;

/**
 * <p>
 * 第三方请求记录表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Slf4j
@Api(tags = { "第三方请求记录表API" })
@RestController
@RequestMapping("/admin/thirdPartyRequest")
public class ThirdPartyRequestController {
    
   @Autowired
   private IThirdPartyRequestService iThirdPartyRequestService;

//    @ApiOperation(value = "AAA用户注册接口", notes = "第三方请求记录表API")
//	@RequestMapping(value = "/testWeb",method = RequestMethod.POST)
//	@ResponseBody
//	public ThirdPartyRequestDTO searchThirdPartyRequestRelation(@RequestBody ThirdPartyRequestDTO dto){		
//		return (ThirdPartyRequestDTO)iThirdPartyRequestService.registerUserByAAA(dto);
//	}	
	

//    @ApiOperation(value = "刷新TOKEN", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/refreshToken", method = RequestMethod.POST)
//	@ResponseBody
//    public ResultVO<ThirdPartyRequestVO> refreshToken(@RequestBody ThirdPartyRequestDTO dto) {
//        return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.refreshToken(dto);
//    }
//
//    @ApiOperation(value = "验证token", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/checkToken", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> checkToken(@RequestBody ThirdPartyRequestDTO dto) {
//        return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.checkToken(dto);
//    }
//
//    @ApiOperation(value = "用户信息查询", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/searchUserInfo", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> searchUserInfo(@RequestBody ThirdPartyRequestDTO dto) {
//        return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.searchUserInfo(dto);
//    }
//
//    @ApiOperation(value = "修改用户", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/updateUserByAAA", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> updateUserByAAA(@RequestBody ThirdPartyRequestDTO dto) {
//        return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.updateUserByAAA(dto);
//    }
//
//    @ApiOperation(value = "删除用户", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/deleteUserByAAA", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> deleteUserByAAA(@RequestBody ThirdPartyRequestDTO dto) {
//        return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.deleteUserByAAA(dto);
//    }
//
    @ApiOperation(value = "发送短信验证码", notes = "第三方请求记录表API")
    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    @ResponseBody
    public boolean sendSMS(@Validated(IMessageCode.class) @RequestBody ThirdPartyRequestDTO dto) {
        return (boolean) iThirdPartyRequestService.sendSMS(dto);
    }

    @ApiOperation(value = "发送强制短信验证码", notes = "第三方请求记录表API")
    @RequestMapping(value = "/sendNewSMS", method = RequestMethod.POST)
    @ResponseBody
    public boolean sendNewSMS(@Validated(IMessageCode.class) @RequestBody ThirdPartyRequestDTO dto) {
        return (boolean) iThirdPartyRequestService.sendNewSMS(dto);
    }

//    @ApiOperation(value = "验证短信验证码", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/validateSMS", method = RequestMethod.POST)
//    @ResponseBody
//    public boolean validateSMS(@RequestBody ThirdPartyRequestDTO dto) {
//        return (boolean) iThirdPartyRequestService.validateSMS(dto);
//    }
//
//    @ApiOperation(value = "账号登出", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/logoutUserByAAA", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> logoutUserByAAA(@RequestBody ThirdPartyRequestDTO dto) {
//        return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.logoutUserByAAA(dto);
//    }
//
//    @ApiOperation(value = "用户新增系统绑定", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/bingSystemByAAA", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> bingSystemByAAA(@RequestBody ThirdPartyRequestDTO dto) {
//     return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.bingSystemByAAA(dto);
//    }
//
//    @ApiOperation(value = "用户修改系统绑定", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/updatebingSystemByAAA", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> updatebingSystemByAAA(@RequestBody ThirdPartyRequestDTO dto) {
//     return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.updatebingSystemByAAA(dto);
//    }
//
//    @ApiOperation(value = "用户删除系统绑定", notes = "第三方请求记录表API")
//    @RequestMapping(value = "/deletebingSystemByAAA", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVO<ThirdPartyRequestVO> deletebingSystemByAAA(@RequestBody ThirdPartyRequestDTO dto) {
//     return (ResultVO<ThirdPartyRequestVO>) iThirdPartyRequestService.deletebingSystemByAAA(dto);
//    }
    
//    @ApiOperation(value = "设置紧急联系人TSP", notes = "第三方用户信息表API")
//	@RequestMapping(value = "/setPerson",method = RequestMethod.POST)
//	@ResponseBody
//	public TSPDTO setPerson(@RequestBody UserBaseInformation dto){		
//		return iThirdPartyRequestService.setEmergencyContact(dto);
//	}
	
    
}

