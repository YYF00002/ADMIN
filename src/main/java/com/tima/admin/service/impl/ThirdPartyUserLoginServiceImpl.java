package com.tima.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.asyncTask.AsyncTask;
import com.tima.admin.dto.*;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.entity.ThirdPartyUserLogin;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.enums.*;
import com.tima.admin.mapper.ImageRelationMapper;
import com.tima.admin.mapper.ThirdPartyUserBaseInformationMapper;
import com.tima.admin.mapper.ThirdPartyUserLoginMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.service.IThirdPartyRequestService;
import com.tima.admin.service.IThirdPartyUserLoginService;
import com.tima.admin.service.IUserBaseInformationService;
import com.tima.admin.util.*;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.UserBaseInformationVO;
import com.tima.admin.web.UserBaseInformationController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 第三方登录信息表  服务实现类
 * </p>
 *
 * @author YYF
 * @since 2020-03-23
 */
@Slf4j
@Transactional
@Service
public class ThirdPartyUserLoginServiceImpl extends ServiceImpl<ThirdPartyUserLoginMapper, ThirdPartyUserLogin> implements IThirdPartyUserLoginService {


    @Autowired
    private ThirdPartyUserLoginMapper thirdPartyUserLoginMapper;

    @Autowired
    private UserBaseInformationMapper userBaseInformationMapper;

    @Autowired
    private ImageRelationMapper imageRelationMapper;

    @Autowired
    private IUserBaseInformationService userBaseInformationService;

    @Autowired
    private WeixinLoginUtils weixinLoginUtils;

    @Autowired
    private UserBaseInformationController userBaseInformationController;

    @Autowired
    private ThirdPartyRequestServiceImpl thirdPartyRequestService;

    @Value("${wechat.appId}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

    @Value("${jwt.config.expiration}")
    private Long expiration;

    @Value("${VerificationCode.expiration}")
    private Long expirationCode;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;

    @Autowired
    private IThirdPartyRequestService thirdPartyRequest;

    @Autowired
    private AsyncTask asyncTask;



    @Override
    public ResultVO<?> searchBindingForWechat(ThirdPartyUserLoginDTO dto) throws Exception {
        //根据微信临时票据获取access_token、openId、refresh_token

        JSONObject tokenObj = weixinLoginUtils.getAccessTokenBycode(appId, appSecret, dto.getWxCode());
        if(tokenObj.get("errcode")!=null){
            return ResultVOUtil.returnFail(tokenObj.getInteger("errcode"),"获取微信信息失败");
        }
        //根据openId判断是否绑定手机号
        ThirdPartyUserLogin tprUserRes = new ThirdPartyUserLogin();
        tprUserRes.setOpenId(tokenObj.getString("openid"));
        tprUserRes.setType(CommonEnum.WECHAT.getCode());
        ThirdPartyUserLogin tprUserRon = thirdPartyUserLoginMapper.selectOne(tprUserRes);
        JSONObject userInfo = weixinLoginUtils.getAppWeiXinUserInfo(tokenObj.getString("access_token"), "openId");
        if(userInfo.get("errcode")!=null){
            return ResultVOUtil.returnFail(tokenObj.getInteger("errcode"),"获取微信信息失败");
        }
        if (tprUserRon != null && tprUserRon.getUserId() != null) {
            //修改第三方信息
            ThirdPartyUserLogin entity = new ThirdPartyUserLogin();
            tprUserRon.setNick(userInfo.getString("nickname"));
            tprUserRon.setHeadImg(userInfo.getString("headimgurl"));
            tprUserRon.setSex(userInfo.getString("sex"));
            tprUserRon.setToken(tokenObj.getString("access_token"));
            tprUserRon.setRefreshToken(tokenObj.getString("refresh_token"));
            thirdPartyUserLoginMapper.updateById(tprUserRon);
            //根据userId查询用户信息
            UserBaseInformation userBaseInformation = new UserBaseInformation();
            userBaseInformation.setId(tprUserRon.getUserId());
            UserBaseInformationVO userBaseInformationRon = userBaseInformationMapper.selectUserImg(userBaseInformation);
            UserBaseInformationDTO ubiDto = new UserBaseInformationDTO();
            ubiDto.setUserCode(userBaseInformationRon.getUserCode());
            ubiDto.setPassword(this.getPasswordForAAA(userBaseInformationRon.getUserCode()));
            ubiDto.setUserType(UserBaseInformationEnum.APP_USER.getCode());
            //已绑定用户  调用登录接口  直接返回token
            return userBaseInformationService.userLogin(ubiDto);
        }
        if (tprUserRon == null) {
            //根据access_token获取用户信息
            tprUserRon = new ThirdPartyUserLogin();
            tprUserRon.setNick(userInfo.getString("nickname"));
            tprUserRon.setHeadImg(userInfo.getString("headimgurl"));
            tprUserRon.setOpenId(userInfo.getString("openid"));
            tprUserRon.setSex(userInfo.getString("sex"));
            tprUserRon.setType(CommonEnum.WECHAT.getCode());
            tprUserRon.setToken(tokenObj.getString("access_token"));
            tprUserRon.setRefreshToken(tokenObj.getString("refresh_token"));
            tprUserRon.setNo(CodeNoEnum.THIRD_PARTY_USER_LOGIN.getTableNO() + CommentUtil.createNo());
            thirdPartyUserLoginMapper.insert(tprUserRon);
        }
        return ResultVOUtil.returnFail(10004,"未绑定手机号",tprUserRon);
    }

    @Override
    public ResultVO<?> searchBindingForQQ(ThirdPartyUserLoginDTO dto) throws Exception {
        ThirdPartyUserLogin entity = new ThirdPartyUserLogin();
        entity.setType(CommonEnum.QQ.getCode());
        entity.setOpenId(dto.getOpenId());
        ThirdPartyUserLogin thirdPartyUserLogin = thirdPartyUserLoginMapper.selectOne(entity);
        if (thirdPartyUserLogin != null && thirdPartyUserLogin.getUserId() != null) {
            //修改第三方信息
            BeanCopyUtil.copyPropertiesIgnoreNull(dto, thirdPartyUserLogin);
            thirdPartyUserLoginMapper.updateById(thirdPartyUserLogin);
            //已绑定用户  调用登录接口  直接返回token
            UserBaseInformation userBaseInformation = new UserBaseInformation();
            userBaseInformation.setId(thirdPartyUserLogin.getUserId());
            UserBaseInformationVO userBaseInformationRon = userBaseInformationMapper.selectUserImg(userBaseInformation);
            UserBaseInformationDTO ubiDto = new UserBaseInformationDTO();
            ubiDto.setUserCode(userBaseInformationRon.getUserCode());
            ubiDto.setPassword(this.getPasswordForAAA(userBaseInformationRon.getUserCode()));
            ubiDto.setUserType(UserBaseInformationEnum.APP_USER.getCode());
            return userBaseInformationController.userLogin(ubiDto);
        }
        if (thirdPartyUserLogin == null) {
            BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
            entity.setNo(CodeNoEnum.THIRD_PARTY_USER_LOGIN.getTableNO() + CommentUtil.createNo());
            thirdPartyUserLoginMapper.insert(entity);
        }
        return ResultVOUtil.returnFail(ResultEnum.UNBIND_PHONE);
    }

    /**
     * phone  code  openId type
     *
     * @param dto
     * @return
     */
    @Override
    public ResultVO<?> bindPhone(ThirdPartyUserLoginDTO dto) throws Exception {

        //查询手机号是否绑定了应用
        ThirdPartyUserLogin result = thirdPartyUserLoginMapper.selectUserForphoneAndopenId(dto);
        if (result != null) {
            return ResultVOUtil.returnFail(500, "该手机已绑定应用");
        }
        //注册用户   手机号是否注册过交给AAA判断
        UserBaseInformationDTO userBaseInformationDTO = new UserBaseInformationDTO();
        //初始密码8个1
        userBaseInformationDTO.setPassword(MD5.encrypt32("11111111"));
        userBaseInformationDTO.setCode(dto.getVCode());
        userBaseInformationDTO.setPhone(dto.getPhone());
        userBaseInformationDTO.setUserType(UserBaseInformationEnum.APP_USER.getCode());
        log.info("开始注册");
        ResultVO<?> resultVO = userBaseInformationController.addUserBaseInformation(userBaseInformationDTO);
        log.info("注册用户信息返回：{},结果：{}", resultVO.getMsg(),resultVO.getData());
        UserBaseInformation ubi = JsonUtil.jsonToPojo(JSON.toJSONString(resultVO.getData()), UserBaseInformation.class);
        ThirdPartyUserLogin tpUserRes = new ThirdPartyUserLogin();
        tpUserRes.setOpenId(dto.getOpenId());
        tpUserRes.setType(dto.getType());
        ThirdPartyUserLogin tpUserRon = thirdPartyUserLoginMapper.selectOne(tpUserRes);
        if (resultVO.getCode() == 0) {
            //注册成功
            tpUserRon.setUserId(ubi.getId());
            thirdPartyUserLoginMapper.updateById(tpUserRon);
            //调用简单登录方法
            UserBaseInformationVO userBaseInformationVO = new UserBaseInformationVO();
            BeanCopyUtil.copyPropertiesIgnoreNull(ubi,userBaseInformationVO);
            return this.thirdPartyLogin(userBaseInformationVO);
        } else {
            if (resultVO.getMsg().contains("存在")) {
                //表示账号已经存在 直接绑定
                //调用复杂登录接口  防止出现用户在AAA已存在，再APP数据库不存在
                UserBaseInformationDTO userLoginRes = new UserBaseInformationDTO();
                userLoginRes.setUserCode(dto.getPhone());
                userLoginRes.setPassword(this.getPasswordForAAA(dto.getPhone()));
                ResultVO<UserBaseInformationVO> userBaseInformationVOResultVO = userBaseInformationController.userLogin(userLoginRes);
                tpUserRon.setUserId(userBaseInformationVOResultVO.getData().getId());
                thirdPartyUserLoginMapper.updateById(tpUserRon);
                return userBaseInformationVOResultVO;
            } else {
                return ResultVOUtil.returnFail(resultVO.getCode(), resultVO.getMsg());
            }
        }

    }

    private  String  getPasswordForAAA(String userName) {
        String enterprise = thirdPartyRequestService.getEnterpriseToken().getToken();
        ThirdPartyRequestDTO thirdPartyRequestDTO = new ThirdPartyRequestDTO();
        AAADTO aaadto = new AAADTO();
        aaadto.setUsername(userName);
        thirdPartyRequestDTO.setAAAdto(aaadto);
        thirdPartyRequestDTO.setToken(enterprise);
        ThirdPartyRequestDTO userInfo = thirdPartyRequestService.searchUserInfo(thirdPartyRequestDTO);
        ThirdPartyRequestDTO systemDTO = null;
        if (userInfo.getErrorCode() != 200) {
            return null;
        }
        return userInfo.getAAAdto().getPassword();
    }

    private  ResultVO<?>  thirdPartyLogin(UserBaseInformationVO userBaseInformationVO) {
        //查询第三方用户信息
        log.info("简单用户登录：");
        ThirdPartyUserBaseInformationDTO tpUserRes = new ThirdPartyUserBaseInformationDTO();
        AAADTO aaaRes = aaaRes = new AAADTO();
        aaaRes.setUsername(userBaseInformationVO.getUserCode());
        aaaRes.setPassword(userBaseInformationVO.getPassword());
        ThirdPartyRequestDTO tprRes = new ThirdPartyRequestDTO();
        tprRes.setAAAdto(aaaRes);
        ThirdPartyRequestDTO tprRon = thirdPartyRequest.loginUserByAAA(tprRes);
        if(tprRon.getErrorCode()!=200){
            log.info("AAA用户登录：" + tprRes.getErrorCode() + "---" + tprRes.getErrorDescription());
            return ResultVOUtil.returnFail(tprRes.getErrorCode(), "用户名或密码错误");
        }

        ThirdPartyUserBaseInformation thirdPartyUserBaseInformation = new ThirdPartyUserBaseInformation();
        thirdPartyUserBaseInformation.setUserId(userBaseInformationVO.getId());
        ThirdPartyUserBaseInformation tpUser = thirdPartyUserBaseInformationMapper.selectOne(thirdPartyUserBaseInformation);

        //调用积分接口添加用户数据 异步方法  积分接口判断该用户数据是否存在
        PlutomembershipDTO pmsDTO = new PlutomembershipDTO();
        pmsDTO.setUid(tpUser.getAAAId());
        UserBaseInformation userBaseInformation = new UserBaseInformation();
        userBaseInformation.setId(userBaseInformationVO.getId());
        UserBaseInformationVO item = userBaseInformationMapper.selectUserImg(userBaseInformation);
        asyncTask.userLoginAsyncInfo(item,pmsDTO);

        userBaseInformationVO.setAAAId(tpUser.getAAAId());
        userBaseInformationVO.setTSPId(tpUser.getTspId());
        userBaseInformationVO.setAaaToken(tprRon.getToken());

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
