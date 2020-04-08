package com.tima.admin.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.dto.*;
import com.tima.admin.entity.ThirdPartyRequest;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.RedisEnum;
import com.tima.admin.enums.ThirdPartyEnum;
import com.tima.admin.feign.ICarResultService;
import com.tima.admin.mapper.ThirdPartyRequestMapper;
import com.tima.admin.mapper.ThirdPartyUserBaseInformationMapper;
import com.tima.admin.service.IThirdPartyRequestService;
import com.tima.admin.util.*;
import com.tima.admin.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 第三方请求记录表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Slf4j
@Transactional
@Service
@SuppressWarnings("all")

public class ThirdPartyRequestServiceImpl extends ServiceImpl<ThirdPartyRequestMapper, ThirdPartyRequest>
        implements IThirdPartyRequestService {
    @Value("${AAA.requestURL}")
    private String requestURL;

    @Value("${AAA.grantTypeByEnterprise}")
    private String grantTypeByEnterprise;

    @Value("${AAA.grantTypeByUser}")
    private String grantTypeByUser;

    @Value("${AAA.grantTypeByRefresh}")
    private String grantTypeByRefresh;

    @Value("${AAA.authorization}")
    private String authorization;

    @Value("${AAA.scope}")
    private String scope;

    @Autowired
    private ThirdPartyRequestMapper thirdPartyRequestMapper;

    @Autowired
    private ICarResultService iCarResultService;

    @Autowired
    private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;



    @Value("${VerificationCode.smsExpiration}")
    private Long smsExpiration;

    // @Override
    // public ResultVO<?> searchThirdPartyRequestListPage(ThirdPartyRequestDTO dto)
    // {
    // Page<ThirdPartyRequest> page = new Page<ThirdPartyRequest>();
    // page.setSize(dto.getSize());
    // page.setCurrent(dto.getCurrent());
    // EntityWrapper<ThirdPartyRequest> entityWrapper = new
    // EntityWrapper<ThirdPartyRequest>();
    // ThirdPartyRequest entity = new ThirdPartyRequest();
    // BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
    // entityWrapper.setEntity(entity);
    // return
    // ResultVOUtil.returnSuccess(page.setRecords(thirdPartyRequestMapper.selectPage(page,
    // entityWrapper)));
    // }

    // 获得企业token
    @Override
    public ThirdPartyRequestDTO getEnterpriseToken() {
        String mehord = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        ThirdPartyRequest trqRes = null;
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", grantTypeByEnterprise);
        map.put("scope", scope);
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.LOGIN_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BASIC_BY_AAA.getThirdPartyName()
                        + Base64.getEncoder().encodeToString(authorization.getBytes()),
                new Object(), 0);
        ThirdPartyRequest tprEntity = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(mehord);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }


    @Override
    public ThirdPartyRequestDTO registerUserByAAA(UserBaseInformationDTO param) {
        ThirdPartyRequestDTO dto = new ThirdPartyRequestDTO();
        AAADTO aaaDTO = new AAADTO();
        aaaDTO.setPhone(param.getPhone());
        aaaDTO.setPassword(param.getPassword());
        aaaDTO.setCode(param.getCode());
        dto.setAAAdto(aaaDTO);
        String mehord = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        ThirdPartyRequest trqRes = null;
        // 获取企业token
        String enterprise = this.getEnterpriseToken().getToken();
        dto.getAAAdto().setSendSmsType(ThirdPartyEnum.REGISTER_CODE_TYPE.getThirdPartyName());
        dto.getAAAdto().setUsername(dto.getAAAdto().getPhone());
        dto.setToken(enterprise);
        ResultVO<?> resultVO = this.validateSMS(dto);
        if (resultVO.getCode()!=0) {
            dto.setAAAdto(null);
            dto.setErrorCode(resultVO.getCode());
            dto.setErrorDescription(resultVO.getMsg());
            return dto;
        }
        ThirdPartyRequest tprEntity = null;
        AAADTO dtoRes = null;
        ThirdPartyRequestDTO systemDTO = null;

        // 保存用户信息
        ThirdPartyRequestDTO responseMap2 = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.REGISTER_BY_AAA.getThirdPartyName(), JsonUtil.pojoToMap(dto.getAAAdto()),
                null, ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + enterprise, new Object(), 0);
        if (200 != responseMap2.getErrorCode()) {
            return responseMap2;
        }

        if (null != responseMap2) {
            responseMap2.setRequestMethod(mehord);
            responseMap2.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap2, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
            //绑定APP系统
            dtoRes = responseMap2.getAAAdto();
            userBindSystemDTO ubsDTO = new userBindSystemDTO();
            ubsDTO.setOriginalSystemUserId(dtoRes.getUserId().toString());
            ubsDTO.setUserBindSystemName(ThirdPartyEnum.JHQCHKHSJ_APP.getThirdPartyName());
            ubsDTO.setUserId(dtoRes.getUserId());
            List<userBindSystemDTO> item = new ArrayList<userBindSystemDTO>();
            item.add(ubsDTO);
            dtoRes.setUserBindSystems(item);
            systemDTO = new ThirdPartyRequestDTO();
            systemDTO.setAAAdto(dtoRes);
            systemDTO.setToken(responseMap2.getAuthorization());
            systemDTO.setRequestMethod(responseMap2.getRefreshToken());
        }
        return this.bingSystemByAAA(systemDTO);
    }

    @Override
    public ThirdPartyRequestDTO loginUserByAAA(ThirdPartyRequestDTO dto) {
        //调用aaa的登录接口
        String mehord = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        dto.getAAAdto().setScope(scope);
        dto.getAAAdto().setGrant_type(grantTypeByUser);
        dto.getAAAdto().setPassword(dto.getAAAdto().getPassword());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.LOGIN_BY_AAA.getThirdPartyName(), JsonUtil.pojoToMap(dto.getAAAdto()), null,
                ThirdPartyEnum.AUTHORIZATION_BASIC_BY_AAA.getThirdPartyName()
                        + Base64.getEncoder().encodeToString(authorization.getBytes()),
                new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        //将AAA的返回的信息入库 存到第三方用户信息表里
        String token = responseMap.getAAAdto().getAccess_token();
        String refreshToken = responseMap.getAAAdto().getRefresh_token();
        String expiresIn = responseMap.getAAAdto().getExpires_in();
        responseMap.setRequestMethod(mehord);
        responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
        // 查询该用户的信息
        responseMap.setAAAdto(dto.getAAAdto());
        // 查询AAA用户详细信息  根据用户绑定的系统判断是否绑定了TSP系统、是否绑定了APP系统
        ThirdPartyRequestDTO userInfo = this.searchUserInfo(responseMap);
        ThirdPartyRequestDTO systemDTO = null;
        if (userInfo.getErrorCode() != 200) {
            return userInfo;
        }
        ThirdPartyRequestDTO resultRon = userInfo;
        AAADTO dtoRes = userInfo.getAAAdto();
        List<userBindSystemDTO> list = dtoRes.getUserBindSystems();
        //判断用户是否有APP权限
        boolean falgAAA = false;
        boolean falgTSP = false;
        Long tspId = null;
        if (null != list) {
            for (userBindSystemDTO userBindSystemDTO : list) {
                if (userBindSystemDTO.getUserBindSystemName()
                        .equals(ThirdPartyEnum.JHQCHKHSJ_APP.getThirdPartyName())) {
                    falgAAA = true;
                }
                if (userBindSystemDTO.getUserBindSystemName().contains(ThirdPartyEnum.TSP_ALL.getThirdPartyName())) {
                    falgTSP = true;
                    tspId = userBindSystemDTO.getUserId();
                }
            }
        }

        if (falgAAA == false) {
            // 该用户没有APP权限，为该用户绑定权限
            userBindSystemDTO ubsDTO = new userBindSystemDTO();
            ubsDTO.setOriginalSystemUserId(dtoRes.getUserId().toString());
            ubsDTO.setUserBindSystemName(ThirdPartyEnum.JHQCHKHSJ_APP.getThirdPartyName());
            ubsDTO.setUserId(dtoRes.getUserId());
            List<userBindSystemDTO> item = new ArrayList<userBindSystemDTO>();
            item.add(ubsDTO);
            dtoRes.setUserBindSystems(item);
            systemDTO = new ThirdPartyRequestDTO();
            systemDTO.setAAAdto(dtoRes);
            systemDTO.setToken(ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + responseMap.getToken());
            resultRon = this.bingSystemByAAA(systemDTO);
        }
        //判断用户是否有TSP权限
        if (falgTSP == true) {
            resultRon.getAAAdto().setTspId(tspId);
        }
        resultRon.getAAAdto().setAccess_token(token);
        resultRon.getAAAdto().setRefresh_token(refreshToken);
        resultRon.getAAAdto().setExpires_in(expiresIn);
        resultRon.setToken(responseMap.getToken());
        resultRon.setRefreshToken(refreshToken);
        return resultRon;
    }

    @Override
    public ThirdPartyRequestDTO refreshToken(ThirdPartyUserBaseInformation param) {
        String mehord = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        AAADTO aaaDTORes = JsonUtil.jsonToPojo(param.getUserBindSystems(), new TypeReference<AAADTO>() {
        });
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", grantTypeByRefresh);
        map.put("refresh_token", aaaDTORes.getRefresh_token());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.REFRESHTOKEN_BY_AAA.getThirdPartyName(),
                map, null, ThirdPartyEnum.AUTHORIZATION_BASIC_BY_AAA.getThirdPartyName()
                        + Base64.getEncoder().encodeToString(authorization.getBytes()),
                new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(mehord);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    /**
     * 验证TOKEN
     *
     * @param dto
     * @return
     */
    @Override
    public ThirdPartyRequestDTO checkToken(ThirdPartyRequestDTO dto) {
        if (StringUtils.isEmpty(dto.getToken())) {
            dto.setErrorCode(500);
            dto.setErrorDescription("token不能为空");
            return dto;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", dto.getToken());
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.CHECKTOKEN_BY_AAA.getThirdPartyName(), map, dto.getToken(), null,
                new Object(), 1);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    /**
     * 用户信息查询
     *
     * @param dto
     * @return
     */
    @Override
    public ThirdPartyRequestDTO searchUserInfo(ThirdPartyRequestDTO dto) {
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        Map<String, Object> map = new HashMap<>();
        map.put("username", dto.getAAAdto().getUsername());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.SEARCHUSER_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    /**
     * 修改密码
     *
     * @param dto
     * @return
     */
    @Override
    public ThirdPartyRequestDTO updatePasswordByAAA(ThirdPartyUserBaseInformation param) {
        ThirdPartyRequestDTO dto = new ThirdPartyRequestDTO();
        AAADTO aaaDTO = new AAADTO();
        aaaDTO.setUserId(param.getAAAId());
        aaaDTO.setUsername(param.getUsername());
        aaaDTO.setPassword(param.getPassword());
        dto.setAAAdto(aaaDTO);
        dto.setToken(param.getToken());
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        Map<String, Object> map = JsonUtil.pojoToMap(dto.getAAAdto());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.UPDATEUSER_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }


    /**
     * 修改用户信息（昵称、头像、签名）
     *
     * @param param
     * @return
     */
    @Override
    public ThirdPartyRequestDTO updateUserInfoByAAA(UserBaseInformationDTO param) {
        ThirdPartyUserBaseInformation tUbiRes = new ThirdPartyUserBaseInformation();
        tUbiRes.setUserId(param.getId());
        ThirdPartyUserBaseInformation tUbiRon = thirdPartyUserBaseInformationMapper.selectOne(tUbiRes);
        ThirdPartyRequestDTO dto = new ThirdPartyRequestDTO();
        AAADTO aaaDTO = new AAADTO();
        aaaDTO.setUserId(tUbiRon.getAAAId());
        aaaDTO.setUsername(param.getUserCode());
        if (param.getHeadUrl() != null) {
            aaaDTO.setHeadiconurl(param.getHeadUrl());
        }
        if (param.getUserName() != null) {
            aaaDTO.setNickname(param.getUserName());
        }
        if (param.getPersonalSignature() != null) {
            aaaDTO.setSignature(param.getPersonalSignature());
        }
        dto.setAAAdto(aaaDTO);
        dto.setToken(tUbiRon.getToken());
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        Map<String, Object> map = JsonUtil.pojoToMap(dto.getAAAdto());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.UPDATEUSER_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    @Override
    public ThirdPartyRequestDTO updateUserCode(ThirdPartyUserBaseInformation param) {
        ThirdPartyRequestDTO dto = new ThirdPartyRequestDTO();
        AAADTO aaaDTO = new AAADTO();
        aaaDTO.setUserId(param.getAAAId());
        aaaDTO.setUsername(param.getUsername());
        aaaDTO.setPhone(param.getPhone());
        dto.setAAAdto(aaaDTO);
        dto.setToken(param.getToken());
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        Map<String, Object> map = JsonUtil.pojoToMap(dto.getAAAdto());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.UPDATEUSER_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    /**
     * 删除用户
     *
     * @param dto
     * @return
     */
    @Override
    public ThirdPartyRequestDTO deleteUserByAAA(ThirdPartyRequestDTO dto) {
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        Map<String, Object> map = JsonUtil.pojoToMap(dto.getAAAdto());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.DELETEUSER_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        ThirdPartyRequest trqRes = null;
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    //

    /**
     * 发送短信验证码
     *
     * @param dto
     * @return
     */
    @Override
    public boolean sendSMS(ThirdPartyRequestDTO dto) {
//        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        AAADTO item = new AAADTO();
        item.setPhone(dto.getPhone());
        item.setUsername(item.getPhone());
        item.setSendSmsType(dto.getSendSmsType());
        Map<String, Object> map = JsonUtil.pojoToMap(item);
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.SENDSMS_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName()
                        + this.getEnterpriseToken().getToken(),
                new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return false;
        }
//        ThirdPartyRequest trqRes = null;
//        if (null != responseMap) {
//            responseMap.setRequestMethod(method);
//            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
//            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
//            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
//            thirdPartyRequestMapper.insert(tprEntity);
//        }
        return true;
    }

    @Override
    public boolean sendNewSMS(ThirdPartyRequestDTO dto) {
        AAADTO item = new AAADTO();
        item.setPhone(dto.getPhone());
        item.setUsername(item.getPhone());
        item.setSendSmsType(dto.getSendSmsType());
        Map<String, Object> map = JsonUtil.pojoToMap(item);
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.SENDNEWSMS_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName()
                        + this.getEnterpriseToken().getToken(),
                new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return false;
        }
        Boolean hasKey = redisTemplate.hasKey(dto.getPhone().toString());
        if(hasKey){
            redisTemplate.delete(dto.getPhone());
        }
        return true;
    }

    /**
     * 验证短信验证码
     *
     * @param dto
     * @return
     */
    @Override
    public ResultVO<?> validateSMS(ThirdPartyRequestDTO dto) {
        Map<String, Object> map = JsonUtil.pojoToMap(dto.getAAAdto());
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                this.requestURL + ThirdPartyEnum.VALIDATESMS_BY_AAA.getThirdPartyName(), map, null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 0);
        AAADTO aaAdto = dto.getAAAdto();
        String redisKey=RedisEnum.VALIDATED_CODE.getPre()+aaAdto.getPhone();
        Boolean hasKey = redisTemplate.hasKey(redisKey);
        if (200 != responseMap.getErrorCode()) {
            if(hasKey){
                Object o = redisTemplate.opsForValue().get(redisKey);
                int i = Integer.parseInt(o.toString());
                if(i==3){
                    return ResultVOUtil.returnFail(501, "验证码已输入错误3次，请重新获取验证码");
                }
                redisTemplate.opsForValue().set(redisKey,++i,smsExpiration, TimeUnit.MILLISECONDS);
            }else{
                redisTemplate.opsForValue().set(redisKey,1,smsExpiration, TimeUnit.MILLISECONDS);
            }
            return ResultVOUtil.returnFail(500, "验证码输入错误");
        }else{
            if(hasKey){
                redisTemplate.delete(redisKey);
            }
        }
        return ResultVOUtil.returnSuccess();
    }

    /**
     * 账号登出
     *
     * @param dto
     * @return
     */
    @Override
    public ThirdPartyRequestDTO logoutUserByAAA(ThirdPartyUserBaseInformationDTO param) {
        ThirdPartyRequestDTO dto = new ThirdPartyRequestDTO();
        dto.setToken(param.getToken());
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.LOGOUT_BY_AAA.getThirdPartyName(), JsonUtil.pojoToMap(dto), null,
                ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() + dto.getToken(), new Object(), 1);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }

    /**
     * 用户新增系统绑定
     *
     * @param dto
     * @return
     */
    @Override
    public ThirdPartyRequestDTO bingSystemByAAA(ThirdPartyRequestDTO dto) {
        String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
        ThirdPartyRequestDTO responseMap = thirdPartyRequestUtil.requestAAA(
                requestURL + ThirdPartyEnum.BINDSYSTEM_BY_AAA.getThirdPartyName(),
                JsonUtil.pojoToMap(dto.getAAAdto().getUserBindSystems().get(0)), null, dto.getToken(), new Object(), 0);
        if (200 != responseMap.getErrorCode()) {
            return responseMap;
        }
        if (null != responseMap) {
            responseMap.setRequestMethod(method);
            responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() + CommentUtil.createNo());
            ThirdPartyRequest tprEntity = new ThirdPartyRequest();
            BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
            thirdPartyRequestMapper.insert(tprEntity);
        }
        return responseMap;
    }
    //
    // /**
    // * 用户修改系统绑定
    // *
    // * @param dto
    // * @return
    // */
    // @Override
    // public ResultVO<?> updatebingSystemByAAA(ThirdPartyRequestDTO dto) {
    // String method = this.getClass().getSimpleName() + ":" + new
    // Exception().getStackTrace()[0].getMethodName();
    // ThirdPartyRequestDTO responseMap = AAARequestUtil.requestAAA(
    // requestURL + ThirdPartyEnum.UPDATE_BINDSYSTEM_BY_AAA.getThirdPartyName(),
    // JsonUtil.pojoToMap(dto.getAAAdto()),
    // dto.getToken(),
    // ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() +
    // dto.getToken(),
    // new Object(),
    // 0);
    // if (null != responseMap) {
    // responseMap.setRequestMethod(method);
    // responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() +
    // CommentUtil.createNo());
    // ThirdPartyRequest tprEntity = new ThirdPartyRequest();
    // BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
    // thirdPartyRequestMapper.insert(tprEntity);
    // }
    // return ResultVOUtil.returnSuccess(responseMap.getResponseJson());
    // }

    //TSP设置紧急联系人
    @Override
    public boolean setEmergencyContact(UserBaseInformation dto) {
        boolean resultFalg = true;
        ThirdPartyUserBaseInformation userEntity = new ThirdPartyUserBaseInformation();
        userEntity.setUserId(dto.getId());
        ThirdPartyUserBaseInformation userRon = thirdPartyUserBaseInformationMapper.selectOne(userEntity);
        if (null != userRon && null != userRon.getTspId()) {
            String method = this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName();
            TSPDTO tspRes = new TSPDTO();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("token", userRon.getToken());
            map.put("phone", userRon.getPhone());
            map.put("userId", userRon.getTspId().toString());
            String identityParam = JSONUtils.toJSONString(map);
            C3ReqPVehicleUrgentContacts c3Res = new C3ReqPVehicleUrgentContacts();
            c3Res.setUrgentPersonNum(dto.getEmergencyContactPhone());
            Map<String, Object> C3Ron = (Map<String, Object>) iCarResultService.setDefaultAddressByTSP(c3Res, identityParam);
            if (true != (boolean) C3Ron.get("returnSuccess")) {
                resultFalg = false;
            }
        }
        return resultFalg;
    }


    // /**
    // * 用户删除系统绑定
    // *
    // * @param dto
    // * @return
    // */
    // @Override
    // public ResultVO<?> deletebingSystemByAAA(ThirdPartyRequestDTO dto) {
    // String method = this.getClass().getSimpleName() + ":" + new
    // Exception().getStackTrace()[0].getMethodName();
    // ThirdPartyRequestDTO responseMap = AAARequestUtil.requestAAA(
    // requestURL + ThirdPartyEnum.DELETE_BINDSYSTEM_BY_AAA.getThirdPartyName(),
    // JsonUtil.pojoToMap(dto.getAAAdto()),
    // dto.getToken(),
    // ThirdPartyEnum.AUTHORIZATION_BEARER_BY_AAA.getThirdPartyName() +
    // dto.getToken(),
    // new Object(),
    // 0);
    // if (null != responseMap) {
    // responseMap.setRequestMethod(method);
    // responseMap.setNo(CodeNoEnum.THIRD_PARTY_REQUEST.getTableNO() +
    // CommentUtil.createNo());
    // ThirdPartyRequest tprEntity = new ThirdPartyRequest();
    // BeanCopyUtil.copyPropertiesIgnoreNull(responseMap, tprEntity);
    // thirdPartyRequestMapper.insert(tprEntity);
    // }
    // return ResultVOUtil.returnSuccess(responseMap.getResponseJson());
    // }
}
