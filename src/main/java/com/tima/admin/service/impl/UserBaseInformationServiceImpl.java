package com.tima.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.asyncTask.AsyncTask;
import com.tima.admin.dto.*;
import com.tima.admin.entity.*;
import com.tima.admin.enums.*;
import com.tima.admin.feign.IPlutomembership;
import com.tima.admin.mapper.*;
import com.tima.admin.service.ILabelEntityService;
import com.tima.admin.service.IThirdPartyRequestService;
import com.tima.admin.service.IThirdPartyUserBaseInformationService;
import com.tima.admin.service.IUserBaseInformationService;
import com.tima.admin.util.*;
import com.tima.admin.vo.PlutomembershipDataVO;
import com.tima.admin.vo.PlutomembershipVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.UserBaseInformationVO;
import com.tima.admin.web.UserBaseInformationController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */

@Slf4j
@Transactional
@Service
public class UserBaseInformationServiceImpl extends ServiceImpl<UserBaseInformationMapper, UserBaseInformation>
        implements IUserBaseInformationService {

    @Autowired
    private ImageRelationMapper imageRelationMapper;

    @Autowired
    private UserBaseInformationMapper userBaseInformationMapper;

    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;




    @Autowired
    private IThirdPartyUserBaseInformationService thirdPartyUserBaseInformation;

    @Autowired
    private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;

    @Autowired
    private IPlutomembership plutomembership;

    @Autowired
    private IThirdPartyRequestService thirdPartyRequest;



    @Autowired
    private AsyncTask asyncTask;


    @Autowired
    private JWTUtils jwtUtils;
    @Value("${jwt.config.expiration}")
    private Long expiration;

    @Value("${VerificationCode.expiration}")
    private Long expirationCode;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private UserBaseInformationController userBaseInformationController;


//    private UserBaseInformation user=CommentUtil.getUser();


    // @Override
    // public ResultVO<?> searchUserBaseInformationList(UserBaseInformationDTO dto)
    // {
    // EntityWrapper<UserBaseInformation> entityWrapper = new
    // EntityWrapper<UserBaseInformation>();
    // UserBaseInformation entity = new UserBaseInformation();
    // BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
    // entityWrapper.setEntity(entity);
    // return
    // ResultVOUtil.returnSuccess(userBaseInformationMapper.selectAll(entityWrapper));
    // }

    @Override
    public ResultVO<?> searchUserBaseInformationListPage(UserBaseInformationDTO dto) {
        Page<UserBaseInformation> page = new Page<UserBaseInformation>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
        ConvertUtil<UserBaseInformationDTO, UserBaseInformationVO> convertUtil = new ConvertUtil<UserBaseInformationDTO, UserBaseInformationVO>();
        Page<UserBaseInformationVO> result = convertUtil.pageCommon(dto, userBaseInformationVO);
        return ResultVOUtil.returnSuccess(result.setRecords(userBaseInformationMapper.selectAll(result, dto)));
    }

    @Override
    public ResultVO<?> searchUserBaseInformationAndIntegralListPageWeb(UserBaseInformationDTO dto) {
        Page<UserBaseInformation> page = new Page<UserBaseInformation>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
        ConvertUtil<UserBaseInformationDTO, UserBaseInformationVO> convertUtil = new ConvertUtil<UserBaseInformationDTO, UserBaseInformationVO>();
        Page<UserBaseInformationVO> result = convertUtil.pageCommon(dto, userBaseInformationVO);
        return ResultVOUtil.returnSuccess(result.setRecords(userBaseInformationMapper.selectUserInformationAndIntegral(result, dto)));
    }

    @Override
    public ResultVO<?> synchronizeUserInformation(UserBaseInformationDTO dto) {
        UserBaseInformation entity = new UserBaseInformation();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        Page<UserBaseInformation> page = new Page<UserBaseInformation>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
        ConvertUtil<UserBaseInformationDTO, UserBaseInformationVO> convertUtil = new ConvertUtil<UserBaseInformationDTO, UserBaseInformationVO>();
        Page<UserBaseInformationVO> result = convertUtil.pageCommon(dto, userBaseInformationVO);
        return ResultVOUtil.returnSuccess(result.setRecords(userBaseInformationMapper.synchronizeUserInformation(result, dto)));
    }

    @Override
    public ResultVO<?> createCodeImg(UserBaseInformationDTO dto) {
        UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
        Map<String, String> randomCode = VerificationCodeImgUtil.getRandomCode();
        String code = randomCode.get("code");
        System.out.println(code);
        String base64 = randomCode.get("base64");
        String codeImgId = CommentUtil.createNo();
        redisTemplate.opsForValue().set(codeImgId, code, expirationCode, TimeUnit.MILLISECONDS);
        userBaseInformationVO.setCodeImg(base64);
        userBaseInformationVO.setCodeImgId(codeImgId);
        return ResultVOUtil.returnSuccess(userBaseInformationVO);
    }

    @Override
    public ResultVO<?> refreshCodeImgWeb(UserBaseInformationDTO dto) {
        UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
        Map<String, String> randomCode = VerificationCodeImgUtil.getRandomCode();
        String code = randomCode.get("code");
        String base64 = randomCode.get("base64");
        redisTemplate.opsForValue().set(dto.getCodeImgId(), code, expirationCode, TimeUnit.MILLISECONDS);
        userBaseInformationVO.setCodeImg(base64);
        userBaseInformationVO.setCodeImgId(dto.getCodeImgId());
        return ResultVOUtil.returnSuccess(userBaseInformationVO);
    }


    @Override
    public ResultVO<?> updateUserCode(UserBaseInformationDTO dto) {
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
//        ubiRes.setId(dto.getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null != result) {
            UserBaseInformationDTO userBaseInformationDTO = new UserBaseInformationDTO();
            BeanCopyUtil.copyPropertiesIgnoreNull(result, userBaseInformationDTO);
            ThirdPartyRequestDTO tprRes = thirdPartyUserBaseInformation.forgetPassword(dto);
            if (tprRes.getErrorCode() != 200) {
                return ResultVOUtil.returnFail(tprRes.getErrorCode(), tprRes.getErrorDescription());
            }
            if (result.getUserCode().equals(dto.getUserCode())) {
                return ResultVOUtil.returnFail(500, "要更改的账号与当前账号一致");
            }
            result.setUserCode(dto.getUserCode());
            result.setPhone(dto.getUserCode());
            //调用第三方用户表更改手机号和登录名
            ThirdPartyRequestDTO thirdPartyRequestDTO = thirdPartyUserBaseInformation.updateUserCode(result);
            if (thirdPartyRequestDTO.getErrorCode() == 200) {
                userBaseInformationMapper.updateById(result);
                return ResultVOUtil.returnSuccess();
            } else {
                return ResultVOUtil.returnFail(thirdPartyRequestDTO.getErrorCode(), thirdPartyRequestDTO.getErrorDescription());
            }
        } else {
            return ResultVOUtil.returnFail(500, "该用户不存在");
        }
    }


    @Override
    public ResultVO<?> searchUserBaseInformationOne(UserBaseInformationDTO dto) {
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
        UserBaseInformation userBaseInformation = userBaseInformationMapper.selectOne(ubiRes);
        return ResultVOUtil.returnSuccess(userBaseInformationMapper.selectUserDeatil(userBaseInformation));
    }

    @Override
    public ResultVO<?> addUserBaseInformation(UserBaseInformationDTO dto) {

        ThirdPartyRequestDTO tprRon = null;
        if (dto.getUserType().equals(UserBaseInformationEnum.APP_USER.getCode())) {
            //AAA注册用户
            tprRon = thirdPartyRequest.registerUserByAAA(dto);
            if (tprRon.getErrorCode() != 200) {
                return ResultVOUtil.returnFail(tprRon.getErrorCode(), tprRon.getErrorDescription());
            }
        }

        //APP用户操作
        UserBaseInformation checkUser = null;
        UserBaseInformation entity = new UserBaseInformation();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        if (dto.getPhone() != null) {
            checkUser = new UserBaseInformation();
            checkUser.setPhone(dto.getPhone());
            if (this.userBaseInformationMapper.selectOne(checkUser) != null) {
                return ResultVOUtil.returnFail(500, "手机号已存在");
            }
//            entity.setRealPhone(CommentUtil.dealPhone(dto.getPhone()));
            entity.setPhone(dto.getPhone());
            checkUser.setPhone(null);
            checkUser.setUserCode(dto.getPhone());
            if (this.userBaseInformationMapper.selectOne(checkUser) != null) {
                return ResultVOUtil.returnFail(500, "账号已存在");
            }
            entity.setUserCode(dto.getPhone());
        }
        entity.setPassword(dto.getPassword());
        entity.setUserType(dto.getUserType());
        entity.setNo(CodeNoEnum.USER_BASE_INFORMATION.getTableNO() + CommentUtil.createNo());
        entity.setHeadUrl(dto.getHeadUrl());
        userBaseInformationMapper.insert(entity);

        if (dto.getUserType().equals(UserBaseInformationEnum.APP_USER.getCode())) {
            //第三方用户信息表插入
            thirdPartyUserBaseInformation.insertThirdPartyUserBaseInformation(tprRon, entity.getId());
            //调用积分接口添加用户数据
            PlutomembershipDTO pmsDTO = new PlutomembershipDTO();
            pmsDTO.setUid(tprRon.getAAAdto().getUserId());
            System.out.println("AAAid---:" + pmsDTO.getUid());
            PlutomembershipVO pmsVO = plutomembership.addIntegralByRegistered(pmsDTO);
            if (0 != pmsVO.getCode()) {
                log.info("用户第一次登录添加积分记录失败");
            }
        }
        return ResultVOUtil.returnSuccess(entity);
    }

    @Override
    public ResultVO<?> updateUserBaseInformation(UserBaseInformationDTO dto) {
//        String a="{\"aAAId\":209,\"authenticationStatus\":0,\"createdDate\":1545729764000,\"id\":492,\"initUser\":0,\"lastModifiedDate\":1547707838000,\"no\":\"AD022018082105134693757\",\"personalSignature\":\"我的个性签名\",\"phone\":\"15026566992\",\"sex\":1,\"userCode\":\"15026566992\",\"userName\":\"hello\",\"userStatus\":0,\"userType\":\"01\"}";
//        UserBaseInformationVO user = JsonUtil.jsonToPojo(a, new TypeReference<UserBaseInformationVO>(){});
        UserBaseInformationVO user = CommentUtil.getUser();
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(user.getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null == result) {
            return ResultVOUtil.returnFail(500, "该用户不存在");
        }
        //同步AAA的用户头像、昵称和签名
        if (result.getUserType().equals(UserBaseInformationEnum.APP_USER.getCode())) {
            if (dto.getImageUrl() != null || dto.getUserName() != null || dto.getPersonalSignature() != null) {
                dto.setId(result.getId());
                ThirdPartyRequestDTO thirdPartyRequestDTO = thirdPartyRequest.updateUserInfoByAAA(dto);
                if (thirdPartyRequestDTO.getErrorCode() != 200) {
                    return ResultVOUtil.returnFail(thirdPartyRequestDTO.getErrorCode(), thirdPartyRequestDTO.getErrorDescription());
                }
            }
        }
        // 转换
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        userBaseInformationMapper.updateById(result);

        ImageRelation irRes = new ImageRelation();
        irRes.setImageTypeId(result.getId());
        ImageRelation irRon = imageRelationMapper.selectOne(irRes);
        if (null != irRon) {
            irRon.setImageUrl(dto.getImageUrl());
            imageRelationMapper.updateById(irRon);
        } else {
            if (dto.getImageUrl() != null) {
                irRon = new ImageRelation();
                irRon.setImageUrl(dto.getImageUrl());
                irRon.setImageType(ImageEnum.HAEDURL.getCode().toString());
                irRon.setNo(CodeNoEnum.IMAGE_RELATION.getTableNO() + CommentUtil.createNo());
                irRon.setImageTypeId(result.getId());
                irRon.setImageTypeNo(result.getNo());
                imageRelationMapper.insert(irRon);
            }
        }
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateUserBaseInformationWeb(UserBaseInformationDTO dto) {
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setNo(dto.getNo());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null == result) {
            return ResultVOUtil.returnFail(500, "该用户不存在");
        }
        // 转换
        if (dto.getPhone() != null) {
            dto.setRealPhone(CommentUtil.dealPhone(dto.getPhone()));
        }
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        userBaseInformationMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteUserBaseInformation(UserBaseInformationDTO dto) {
        UserBaseInformation entity = new UserBaseInformation();
        entity.setNo(dto.getNo());
        entity.setUserType(UserBaseInformationEnum.WEB_USER.getCode());
        UserBaseInformation result = userBaseInformationMapper.selectOne(entity);
        // 删除后台用户
        if (null == result) {
            return ResultVOUtil.returnFail(500, "该后台用户不存在！");
        }
        userBaseInformationMapper.deleteById(result.getId());
        return ResultVOUtil.returnSuccess();
    }

    // @Override
    // public ResultVO<?> searchUserBaseInformationRelation(UserBaseInformationDTO
    // dto) {
    // // 自定义分页参考依据
    // // VehicleCustom vehicleCustom=new VehicleCustom();
    // // ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new
    // // ConvertUtil<VehicleRO, VehicleCustom>();
    // // Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
    // // return
    // //
    // ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result,
    // // convertUtil.entity(ro, vehicleCustom))));
    // return null;
    // }


    @Override
    public ResultVO<?> userLogin(UserBaseInformationDTO dto) {
        ThirdPartyRequestDTO tprRes = null;
        if (dto.getUserType().equals(UserBaseInformationEnum.APP_USER.getCode())) {
            //AAA接口认证
            tprRes = thirdPartyUserBaseInformation.longIn(dto);
            if (tprRes.getErrorCode() != 200) {
                log.info("AAA调用：" + tprRes.getErrorCode() + "---" + tprRes.getErrorDescription());
                return ResultVOUtil.returnFail(tprRes.getErrorCode(), "用户名或密码错误");
            }
        }else{
            //后台管理登录
            String codeImg = (String) redisTemplate.opsForValue().get(dto.getCodeImgId());
            if (StringUtils.isBlank(codeImg)) {
                return ResultVOUtil.returnFail(500, "验证码已过期");
            }
            if (!dto.getCode().equalsIgnoreCase(codeImg)) {
                return ResultVOUtil.returnFail(500, "验证码不正确");
            }
        }
        UserBaseInformation entity = new UserBaseInformation();
        entity.setUserCode(dto.getUserCode());
        entity.setPassword(dto.getPassword());
        entity.setUserType(dto.getUserType());
        UserBaseInformation result = userBaseInformationMapper.selectOne(entity);
        if (null == result) {
            return ResultVOUtil.returnFail(500, "用户名或密码错误");
        } else {
            ResultVO<?> resultVO = null;
            UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
            BeanCopyUtil.copyPropertiesIgnoreNull(result, userBaseInformationVO);
            if (dto.getUserType().equals(UserBaseInformationEnum.APP_USER.getCode())) {
                //查询第三方用户信息
                ThirdPartyUserBaseInformation thirdPartyUserBaseInformation = new ThirdPartyUserBaseInformation();
                thirdPartyUserBaseInformation.setUserId(result.getId());
                ThirdPartyUserBaseInformation tpUser = thirdPartyUserBaseInformationMapper.selectOne(thirdPartyUserBaseInformation);

                //调用积分接口添加用户数据 异步方法  积分接口判断该用户数据是否存在
                PlutomembershipDTO pmsDTO = new PlutomembershipDTO();
                pmsDTO.setUid(tpUser.getAAAId());
                UserBaseInformationVO item = userBaseInformationMapper.selectUserImg(result);
                asyncTask.userLoginAsyncInfo(item,pmsDTO);
                userBaseInformationVO.setAAAId(tpUser.getAAAId());
                userBaseInformationVO.setTSPId(tpUser.getTspId());
                userBaseInformationVO.setAaaToken(tpUser.getToken());
            }

            if (dto.getUserType().equals(UserBaseInformationEnum.WEB_USER.getCode())) {
                //web用户
                //手机号加*
                if (result.getPhone() != null && result.getPhone().length() == 11) {
                    result.setRealPhone(CommentUtil.dealPhone(result.getPhone()));
                    userBaseInformationMapper.updateById(result);
                }
                //验证图片验证码
                redisTemplate.delete(dto.getCodeImgId());
            }

            String token = jwtUtils.generateToken(userBaseInformationVO);
            userBaseInformationVO.setToken(token);
            userBaseInformationVO.setRefreshToken(token);
            redisTemplate.opsForValue().set(TokenEnum.USER_TOKEN.getToken() + userBaseInformationVO.getId(), token,
                    expiration, TimeUnit.MILLISECONDS);
            redisTemplate.opsForValue().set(TokenEnum.USER_REFRESH_TOKEN.getToken() + userBaseInformationVO.getId(),
                    token, expiration, TimeUnit.MILLISECONDS);
            return ResultVOUtil.returnSuccess(userBaseInformationVO);
        }

    }


    /*
     * (non-Javadoc)
     *
     * @see
     * com.tima.admin.service.IUserBaseInformationService#updateUserPassword(com.
     * tima.admin.dto.UserBaseInformationDTO) 修改密码
     */
    @Override
    public ResultVO<?> updateUserPassword(UserBaseInformationDTO dto) {
        UserBaseInformation entity = new UserBaseInformation();
        entity.setNo(CommentUtil.getUser().getNo());
        entity.setPassword(MD5.encrypt32(dto.getOldPassword()));
        UserBaseInformation result = userBaseInformationMapper.selectOne(entity);
        if (null != result) {
            result.setPassword(MD5.encrypt32(dto.getNewPassword()));
            userBaseInformationMapper.updateById(result);

            //调用第三方用户表更改密码
            result.setPassword(dto.getNewPassword());
            thirdPartyUserBaseInformation.updatePassword(result);

            return ResultVOUtil.returnSuccess();
        } else {
            return ResultVOUtil.returnFail(500, "用户名或密码错误");
        }
    }

    @Override
    public ResultVO<?> updateUserPasswordWeb(UserBaseInformationDTO dto) {
//        UserBaseInformation entity = new UserBaseInformation();
//        entity.setNo(dto.getNo());
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null != result) {
            result.setPassword(MD5.encrypt32(dto.getPassword()));
            userBaseInformationMapper.updateById(result);
            return ResultVOUtil.returnSuccess();
        } else {
            return ResultVOUtil.returnFail(500, "用户名或密码错误");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.tima.admin.service.IUserBaseInformationService#forgotPassword(com.tima.
     * admin.dto.UserBaseInformationDTO) 忘记密码
     */
    @Override
    public ResultVO<?> forgotPassword(UserBaseInformationDTO dto) {
        UserBaseInformation result = null;

        ThirdPartyRequestDTO tokenRon = thirdPartyRequest.getEnterpriseToken();
        AAADTO aaadto = new AAADTO();
        aaadto.setUsername(dto.getPhone());
        tokenRon.setAAAdto(aaadto);
        ThirdPartyRequestDTO thirdPartyRequestDTO = thirdPartyRequest.searchUserInfo(tokenRon);
        if (thirdPartyRequestDTO.getAAAdto() == null) {
            return ResultVOUtil.returnFail(500, "用户不存在");
        }
        dto.setAaaId(thirdPartyRequestDTO.getAAAdto().getUserId());
        ThirdPartyRequestDTO tprRes = thirdPartyUserBaseInformation.forgetPassword(dto);
        if (tprRes.getErrorCode() != 200) {
            return ResultVOUtil.returnFail(tprRes.getErrorCode(), tprRes.getErrorDescription());
        }
        UserBaseInformation entity = new UserBaseInformation();
        entity.setUserCode(dto.getPhone());
        result = userBaseInformationMapper.selectOne(entity);
        if (null != result) {
            result.setPassword(MD5.encrypt32(dto.getNewPassword()));
            userBaseInformationMapper.updateById(result);
        }
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> searchUserBaseInformationMany(UserBaseInformationDTO dto) {

        return ResultVOUtil.returnSuccess(userBaseInformationMapper.searchUserBaseInformationMany(dto));
    }

    @Override
    public ResultVO<?> userLoginOut(UserBaseInformationDTO dto) {
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null == result) {
            return ResultVOUtil.returnFail();
        } else {
            UserBaseInformationDTO resRes = new UserBaseInformationDTO();
            resRes.setId(result.getId());
            //AAA用户信息登出
            ThirdPartyRequestDTO resRon = thirdPartyUserBaseInformation.longOut(resRes);
            if (resRon.getErrorCode() != 200) {
                return ResultVOUtil.returnFail(resRon.getErrorCode(), resRon.getErrorDescription());
            }
            redisTemplate.delete(TokenEnum.USER_TOKEN.getToken() + result.getId());
            return ResultVOUtil.returnSuccess();
        }
    }

    @Override
    public ResultVO<?> refreshUserToken(UserBaseInformationDTO dto) {
//        UserBaseInformation entity = new UserBaseInformation();
//        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null == result) {
            return ResultVOUtil.returnFail();
        } else {
            String token = (String) redisTemplate.opsForValue().get(TokenEnum.USER_TOKEN.getToken() + result.getId());
            if (StringUtils.isBlank(token)) {
                return ResultVOUtil.returnFail(500, "token不存在");
            }
            String refreshToken = jwtUtils.refreshToken(token);
            redisTemplate.opsForValue().set(TokenEnum.USER_TOKEN.getToken() + result.getId(), refreshToken);
            return ResultVOUtil.returnSuccess(refreshToken);
        }

    }

    @Override
    public ResultVO<?> validateUserToken(UserBaseInformationDTO dto) {
//        UserBaseInformation entity = new UserBaseInformation();
//        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null == result) {
            return ResultVOUtil.returnFail();
        } else {
            String token = (String) redisTemplate.opsForValue().get(TokenEnum.USER_TOKEN.getToken() + result.getId());
            if (StringUtils.isBlank(token)) {
                return ResultVOUtil.returnFail(500, "token不存在");
            }
            String validateDate = DateUtil.getTime(jwtUtils.getExpirationDateFromToken(token));
            return ResultVOUtil.returnSuccess(validateDate);
        }
    }


    @Override
    public ResultVO<?> insertOrUpdateEmergencyContact(UserBaseInformationDTO dto) {
//        UserBaseInformation entity = new UserBaseInformation();
//        entity.setNo(dto.getNo());
        UserBaseInformation ubiRes = new UserBaseInformation();
        ubiRes.setId(CommentUtil.getUser().getId());
        UserBaseInformation result = userBaseInformationMapper.selectOne(ubiRes);
        if (null == result) {
            return ResultVOUtil.returnFail(500, "该用户不存在");
        }
        result.setEmergencyContactName(dto.getEmergencyContactName());
        result.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        userBaseInformationMapper.updateById(result);
        //更改TSP紧急联系人信息
        //查询是否是TSP用户

        if (false == thirdPartyRequest.setEmergencyContact(result)) {
            return ResultVOUtil.returnFail(500, "APP用户紧急联系人设置成功，TSP设置失败");
        }
        return ResultVOUtil.returnSuccess();
    }




    @Override
    public ResultVO<?> thirdPartyLogin(UserBaseInformationDTO dto) {
        ThirdPartyUserBaseInformation thirdPartyUserBaseInformation = new ThirdPartyUserBaseInformation();
        thirdPartyUserBaseInformation.setAAAId(dto.getAaaId());
        ThirdPartyUserBaseInformation thirdPartyUser = thirdPartyUserBaseInformationMapper.selectOne(thirdPartyUserBaseInformation);
        UserBaseInformationVO ubiResult = new UserBaseInformationVO();
        if(thirdPartyUser==null){
            //库中没有这个用户 调用用户登录接口为库里增加用户并返回token
            UserBaseInformationVO data = (UserBaseInformationVO) userBaseInformationController.userLogin(dto).getData();
            ubiResult.setToken(data.getToken());
            return ResultVOUtil.returnSuccess(ubiResult);
        }

        //库中有这个用户  判断用户token是否有效
        String userToken=TokenEnum.USER_TOKEN.getToken() + thirdPartyUser.getUserId();
        Object tokenObj = redisTemplate.opsForValue().get(userToken);
        if(tokenObj!=null){
            //token有效
            ubiResult.setToken(tokenObj.toString());
            return ResultVOUtil.returnSuccess(ubiResult);
        }else{
            //token无效  重新生成token
            UserBaseInformationVO data = (UserBaseInformationVO) userBaseInformationController.userLogin(dto).getData();
            ubiResult.setToken(data.getToken());
            return ResultVOUtil.returnSuccess(ubiResult);
        }
    }


}
