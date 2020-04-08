package com.tima.admin.web;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.enums.UserBaseInformationEnum;
import com.tima.admin.service.IUserBaseInformationService;
import com.tima.admin.util.JsonUtil;
import com.tima.admin.util.MD5;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.util.StringUtil;
import com.tima.admin.validateInterface.*;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.UserBaseInformationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * <p>
 * 用户基本信息表 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
@Slf4j
@Api(tags = {"用户基本信息表API"})
@RestController
@RequestMapping("/admin/userBaseInformation")
public class UserBaseInformationController {

    @Autowired
    private IUserBaseInformationService iUserBaseInformationService;



    //    @ApiOperation(value = "用户基本信息表列表查询", notes = "用户基本信息表API")
//	@RequestMapping(value = "/searchUserBaseInformationList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<UserBaseInformation>> searchUserBaseInformationList(@RequestBody UserBaseInformationDTO dto){		
//		return (ResultVO<List<UserBaseInformation>>)iUserBaseInformationService.searchUserBaseInformationList(dto);
//	}
    @ApiOperation(value = "用户基本信息表列表分页查询（Web）", notes = "用户基本信息表Web")
    @RequestMapping(value = "/searchUserBaseInformationListPageWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<Page<UserBaseInformation>> searchUserBaseInformationListPageWeb(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<Page<UserBaseInformation>>) iUserBaseInformationService.searchUserBaseInformationListPage(dto);
    }

    @ApiOperation(value = "用户基本信息详细查询", notes = "用户基本信息表API")
    @RequestMapping(value = "/searchUserBaseInformationOne", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformation> searchUserBaseInformationOne(@RequestBody UserBaseInformationDTO dto) {

        return (ResultVO<UserBaseInformation>) iUserBaseInformationService.searchUserBaseInformationOne(dto);
    }

    @ApiOperation(value = "用户基本信息详细查询（Web）", notes = "用户基本信息表Web")
    @RequestMapping(value = "/searchUserBaseInformationOneWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformation> searchUserBaseInformationOneWeb(@Validated(ISelectWeb.class) @RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<UserBaseInformation>) iUserBaseInformationService.searchUserBaseInformationOne(dto);
    }

    @ApiOperation(value = "多个用户基本信息详细查询", notes = "用户基本信息表API")
    @RequestMapping(value = "/searchUserBaseInformationMany", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<List<UserBaseInformation>> searchUserBaseInformationMany(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<List<UserBaseInformation>>) iUserBaseInformationService.searchUserBaseInformationMany(dto);
    }

    @ApiOperation(value = "用户注册", notes = "用户基本信息表API")
    @RequestMapping(value = "/addUserBaseInformation", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> addUserBaseInformation(@Validated(IAdd.class) @RequestBody UserBaseInformationDTO dto) {
        dto.setUserType(UserBaseInformationEnum.APP_USER.getCode());
        return iUserBaseInformationService.addUserBaseInformation(dto);
    }

    @ApiOperation(value = "用户注册（Web）", notes = "用户基本信息表Web")
    @RequestMapping(value = "/addUserBaseInformationWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> addUserBaseInformationWeb(@Validated(IAddWeb.class) @RequestBody UserBaseInformationDTO dto) {
        dto.setUserType(UserBaseInformationEnum.WEB_USER.getCode());
        return iUserBaseInformationService.addUserBaseInformation(dto);
    }

    @ApiOperation(value = "更改用户登录手机号", notes = "用户基本信息表API")
    @RequestMapping(value = "/updateUserCode", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> updateUserCode(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.updateUserCode(dto);
    }

    @ApiOperation(value = "用户基本信息更新", notes = "用户基本信息表API")
    @RequestMapping(value = "/updateUserBaseInformation", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> updateUserBaseInformation(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.updateUserBaseInformation(dto);
    }

    @ApiOperation(value = "用户基本信息更新(Web)", notes = "用户基本信息表Web")
    @RequestMapping(value = "/updateUserBaseInformationWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> updateUserBaseInformationWeb(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.updateUserBaseInformationWeb(dto);
    }

    @ApiOperation(value = "用户修改密码", notes = "用户修改密码API")
    @RequestMapping(value = "/updateUserPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> updateUserPassword(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.updateUserPassword(dto);
    }

    @ApiOperation(value = "用户修改密码（Web）", notes = "用户修改密码Web")
    @RequestMapping(value = "/updateUserPasswordWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> updateUserPasswordWeb(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.updateUserPasswordWeb(dto);
    }

    @ApiOperation(value = "用户登录", notes = "用户基本信息表API")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformationVO> userLogin(@Validated(ILogin.class) @RequestBody UserBaseInformationDTO dto) {
        dto.setUserType(UserBaseInformationEnum.APP_USER.getCode());
        if (null == StringUtil.getString_TrimZeroLenAsNull(dto.getUserCode()) || null == StringUtil.getString_TrimZeroLenAsNull(dto.getPassword())) {
            return (ResultVO<UserBaseInformationVO>) ResultVOUtil.returnFail(10002, "用户名或密码错误");
        }
        return (ResultVO<UserBaseInformationVO>) iUserBaseInformationService.userLogin(dto);
    }

    @ApiOperation(value = "用户登录（Web）", notes = "用户基本信息表Web")
    @RequestMapping(value = "/userLoginWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformationVO> userLoginWeb(@Validated(ILogin.class) @RequestBody UserBaseInformationDTO dto) {
        dto.setUserType(UserBaseInformationEnum.WEB_USER.getCode());
        dto.setPassword(MD5.encrypt32(dto.getPassword()));
        return (ResultVO<UserBaseInformationVO>) iUserBaseInformationService.userLogin(dto);
    }

    @ApiOperation(value = "忘记密码", notes = "用户基本信息表API")
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> forgotPassword(@RequestBody UserBaseInformationDTO dto) {
        dto.setUserType(UserBaseInformationEnum.APP_USER.getCode());
        return iUserBaseInformationService.forgotPassword(dto);
    }

    @ApiOperation(value = "用户登出", notes = "用户基本信息表API")
    @RequestMapping(value = "/userLoginOut", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> userLoginOut(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.userLoginOut(dto);
    }

    @ApiOperation(value = "用户登出(Web)", notes = "用户基本信息表Web")
    @RequestMapping(value = "/userLoginOutWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> userLoginOutWeb(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.userLoginOut(dto);
    }

    @ApiOperation(value = "用户更新token", notes = "用户基本信息表API")
    @RequestMapping(value = "/refreshUserToken", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<String> refreshUserToken(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<String>) iUserBaseInformationService.refreshUserToken(dto);
    }

    @ApiOperation(value = "用户更新token(Web)", notes = "用户基本信息表Web")
    @RequestMapping(value = "/refreshUserTokenWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<String> refreshUserTokenWeb(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<String>) iUserBaseInformationService.refreshUserToken(dto);
    }

    @ApiOperation(value = "用户验证token", notes = "用户基本信息表API")
    @RequestMapping(value = "/validateUserToken", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<String> validateUserToken(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<String>) iUserBaseInformationService.validateUserToken(dto);
    }

    @ApiOperation(value = "用户验证token(Web)", notes = "用户基本信息表Web")
    @RequestMapping(value = "/validateUserTokenWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<String> validateUserTokenWeb(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<String>) iUserBaseInformationService.validateUserToken(dto);
    }

    @ApiOperation(value = "用户基本信息表删除Web", notes = "用户基本信息表API")
    @RequestMapping(value = "/deleteUserBaseInformationWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> deleteUserBaseInformationWeb(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.deleteUserBaseInformation(dto);
    }

    @ApiOperation(value = "新增或修改紧急联系人", notes = "用户基本信息表API")
    @RequestMapping(value = "/updateEmergencyContact", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<?> insertOrUpdateEmergencyContact(@RequestBody UserBaseInformationDTO dto) {
        return iUserBaseInformationService.insertOrUpdateEmergencyContact(dto);
    }

    @ApiOperation(value = "用户基本信息表和积分总数列表分页查询（Web）", notes = "用户基本信息表Web")
    @RequestMapping(value = "/searchUserBaseInformationAndIntegralListPageWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<Page<UserBaseInformationVO>> searchUserBaseInformationAndIntegralListPageWeb(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<Page<UserBaseInformationVO>>) iUserBaseInformationService.searchUserBaseInformationAndIntegralListPageWeb(dto);
    }

    @ApiOperation(value = "车控调用同步用户信息", notes = "用户基本信息表Web")
    @RequestMapping(value = "/synchronizeUserInformation", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<Page<UserBaseInformationVO>> synchronizeUserInformation(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<Page<UserBaseInformationVO>>) iUserBaseInformationService.synchronizeUserInformation(dto);
    }

    //	@ApiOperation(value = "用户基本信息表关联查询", notes = "用户基本信息表API")
//	@RequestMapping(value = "/searchUserBaseInformationRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserBaseInformationVO> searchUserBaseInformationRelation(@RequestBody UserBaseInformationDTO dto){		
//		return (ResultVO<UserBaseInformationVO>)iUserBaseInformationService.searchUserBaseInformationRelation(dto);
//	}
    @ApiOperation(value = "生成验证码图片Web", notes = "用户基本信息表Web")
    @RequestMapping(value = "/createCodeImgWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformationVO> createCodeImgWeb(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<UserBaseInformationVO>) iUserBaseInformationService.createCodeImg(dto);
    }

    @ApiOperation(value = "刷新验证码图片Web", notes = "用户基本信息表Web")
    @RequestMapping(value = "/refreshCodeImgWeb", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformationVO> refreshCodeImgWeb(@RequestBody UserBaseInformationDTO dto) {
        return (ResultVO<UserBaseInformationVO>) iUserBaseInformationService.refreshCodeImgWeb(dto);
    }



    @ApiOperation(value = "第三方登录接口（供微信生成appToken使用）", notes = "用户基本信息表Web")
    @RequestMapping(value = "/thirdPartyLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<UserBaseInformationVO> thirdPartyLogin(@RequestBody @Validated({IThirdPartyLogin.class}) UserBaseInformationDTO dto) {
        return (ResultVO<UserBaseInformationVO>) iUserBaseInformationService.thirdPartyLogin(dto);
    }


}

