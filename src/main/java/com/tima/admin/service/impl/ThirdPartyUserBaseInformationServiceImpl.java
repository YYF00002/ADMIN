package com.tima.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.dto.*;
import com.tima.admin.entity.ImageRelation;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.ImageEnum;
import com.tima.admin.enums.ThirdPartyEnum;
import com.tima.admin.feign.IPlutomembership;
import com.tima.admin.mapper.ImageRelationMapper;
import com.tima.admin.mapper.ThirdPartyUserBaseInformationMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.service.IThirdPartyRequestService;
import com.tima.admin.service.IThirdPartyUserBaseInformationService;
import com.tima.admin.util.*;
import com.tima.admin.vo.PlutomembershipVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.ThirdPartyUserBaseInformationVO;
import com.tima.admin.vo.UserBaseInformationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 第三方用户信息表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-08-30
 */
@Slf4j
@Transactional
@Service
public class ThirdPartyUserBaseInformationServiceImpl
		extends ServiceImpl<ThirdPartyUserBaseInformationMapper, ThirdPartyUserBaseInformation>
		implements IThirdPartyUserBaseInformationService {

	@Autowired
	private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;

	@Autowired
	private IThirdPartyRequestService thirdPartyRequest;

	@Autowired
	private UserBaseInformationMapper userBaseInformationMapper;
	
	@Autowired
	private IPlutomembership plutomembership;
	
	@Autowired
	private ImageRelationMapper imageRelationMapper;

	@Override
	public ResultVO<?> addThirdPartyUserBaseInformation(ThirdPartyUserBaseInformationDTO dto) {
		ThirdPartyUserBaseInformation entity = new ThirdPartyUserBaseInformation();
		entity.setUsername(dto.getUsername());
		ThirdPartyUserBaseInformation result = thirdPartyUserBaseInformationMapper.selectOne(entity);
		if (null == result) {
			BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
			entity.setNo(CodeNoEnum.THIRD_PARTY_USER_BASE_INFORMATION.getTableNO() + CommentUtil.createNo());
			thirdPartyUserBaseInformationMapper.insert(entity);
		} else {
			BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
			result.setLastModifiedDate(new Date());
			thirdPartyUserBaseInformationMapper.updateById(result);
		}
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ThirdPartyRequestDTO updatePassword(UserBaseInformation param) {
		ThirdPartyUserBaseInformation entity = new ThirdPartyUserBaseInformation();
		entity.setUserId(param.getId());
		ThirdPartyUserBaseInformation result = thirdPartyUserBaseInformationMapper.selectOne(entity);
		result.setPassword(MD5.encrypt32(param.getPassword()));
		thirdPartyUserBaseInformationMapper.updateById(result);
		result.setPassword(param.getPassword());
		return thirdPartyRequest.updatePasswordByAAA(result);
	}

	@Override
	public ThirdPartyRequestDTO updateUserCode(UserBaseInformation param) {
		ThirdPartyUserBaseInformation entity = new ThirdPartyUserBaseInformation();
		entity.setUserId(param.getId());
		ThirdPartyUserBaseInformation result = thirdPartyUserBaseInformationMapper.selectOne(entity);

        ThirdPartyRequestDTO tprRes = new ThirdPartyRequestDTO();
        AAADTO aaadto = new AAADTO();
        aaadto.setUsername(param.getUserCode());
        tprRes.setToken(result.getToken());
        tprRes.setAAAdto(aaadto);
        ThirdPartyRequestDTO tprRon = thirdPartyRequest.searchUserInfo(tprRes);
        if(tprRon.getAAAdto()!=null){
            tprRon.setErrorCode(500);
            tprRon.setErrorDescription("该账号已存在");
            return tprRon;
        }
        result.setUsername(param.getUserCode());
        result.setPhone(param.getUserCode());
        thirdPartyUserBaseInformationMapper.updateById(result);
		return thirdPartyRequest.updateUserCode(result);
	}

	public ThirdPartyRequestDTO forgetPassword(UserBaseInformationDTO param) {
        ThirdPartyUserBaseInformation result = new ThirdPartyUserBaseInformation();
        // 获得token
		ThirdPartyRequestDTO tokenRon = thirdPartyRequest.getEnterpriseToken();

		ThirdPartyRequestDTO tprRes = new ThirdPartyRequestDTO();
		AAADTO aaaDTO = new AAADTO();
		aaaDTO.setUsername(param.getPhone());
		aaaDTO.setCode(param.getCode());
		aaaDTO.setPhone(param.getPhone());
		aaaDTO.setSendSmsType(ThirdPartyEnum.REGISTER_CODE_TYPE.getThirdPartyName());
		tprRes.setAAAdto(aaaDTO);
		tprRes.setToken(tokenRon.getToken());
		// 验证码
		ThirdPartyRequestDTO resRon = null;
        ResultVO<?> resultVO = thirdPartyRequest.validateSMS(tprRes);
        if (resultVO.getCode()==0) {
			result.setPassword(param.getNewPassword());
			result.setToken(tokenRon.getToken());
            result.setAAAId(param.getAaaId());
            result.setUsername(param.getPhone());
			resRon = thirdPartyRequest.updatePasswordByAAA(result);
			if (resRon.getErrorCode() == 200) {
				result.setPassword(MD5.encrypt32(param.getNewPassword()));
				thirdPartyUserBaseInformationMapper.updateById(result);
			}
			return resRon;
		} else {
			resRon = new ThirdPartyRequestDTO();
			resRon.setErrorCode(resultVO.getCode());
			resRon.setErrorDescription(resultVO.getMsg());
			return resRon;
		}
	}

	// 登出
	@Override
	public ThirdPartyRequestDTO longOut(UserBaseInformationDTO param) {
		ThirdPartyUserBaseInformation entity = new ThirdPartyUserBaseInformation();
		entity.setUserId(param.getId());
		ThirdPartyUserBaseInformation result = thirdPartyUserBaseInformationMapper.selectOne(entity);
		ThirdPartyUserBaseInformationDTO resRes = new ThirdPartyUserBaseInformationDTO();
		BeanCopyUtil.copyPropertiesIgnoreNull(result, resRes);
		ThirdPartyRequestDTO resRon = thirdPartyRequest.logoutUserByAAA(resRes);
		return resRon;
	}

	@Override
	public boolean insertThirdPartyUserBaseInformation(ThirdPartyRequestDTO dto, Long userId) {
		ThirdPartyUserBaseInformation tpUserRes = new ThirdPartyUserBaseInformation();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto.getAAAdto(), tpUserRes);
		List<userBindSystemDTO> bindSys = dto.getAAAdto().getUserBindSystems();
		tpUserRes.setUserId(null);
		tpUserRes.setPassword(MD5.encrypt32(tpUserRes.getPassword()));
		tpUserRes.setUserBindSystems(JsonUtil.pojoToJson(dto.getAAAdto()));
        tpUserRes.setAAAId(dto.getAAAdto().getUserId());
		tpUserRes.setUserId(userId);
		tpUserRes.setNo(CodeNoEnum.THIRD_PARTY_USER_BASE_INFORMATION.getTableNO() + CommentUtil.createNo());
		if (1 == thirdPartyUserBaseInformationMapper.insert(tpUserRes)) {
			return true;
		}
		return false;
	}

	@Override
	public ThirdPartyRequestDTO  longIn(UserBaseInformationDTO param) {
		ThirdPartyUserBaseInformationDTO tpUserRes = new ThirdPartyUserBaseInformationDTO();
		AAADTO aaaRes = aaaRes = new AAADTO();
		aaaRes.setUsername(param.getUserCode());
		aaaRes.setPassword(param.getPassword());
		ThirdPartyRequestDTO tprRes = new ThirdPartyRequestDTO();
		tprRes.setAAAdto(aaaRes);
		ThirdPartyRequestDTO tprRon = thirdPartyRequest.loginUserByAAA(tprRes);
		if (tprRon.getErrorCode() != 200) {
			return tprRon;
		}
		// 判断APP系统里是否有该用户
		UserBaseInformation ubiRes = new UserBaseInformation();
		ubiRes.setUserCode(param.getUserCode());
		UserBaseInformation ubiRon = userBaseInformationMapper.selectOne(ubiRes);
		aaaRes = tprRon.getAAAdto();
		if (null == ubiRon) {
			if(StringUtil.getString_TrimZeroLenAsNull(aaaRes.getPhone())!=null){
				ubiRes.setRealPhone(CommentUtil.dealPhone(aaaRes.getPhone()));
			}
			ubiRes.setPhone(aaaRes.getPhone());
			ubiRes.setUserType(param.getUserType());
			ubiRes.setPassword(aaaRes.getPassword());
			ubiRes.setNo(CodeNoEnum.USER_BASE_INFORMATION.getTableNO() + CommentUtil.createNo());
			userBaseInformationMapper.insert(ubiRes);
			tpUserRes.setUserId(ubiRes.getId());
		} else {
			tpUserRes.setUserId(ubiRon.getId());
            if(StringUtil.getString_TrimZeroLenAsNull(aaaRes.getPhone())!=null){
				ubiRon.setRealPhone(CommentUtil.dealPhone(aaaRes.getPhone()));
			}

			ubiRon.setPhone(aaaRes.getPhone());
			ubiRon.setPassword(aaaRes.getPassword());
			userBaseInformationMapper.updateById(ubiRon);
		}
		List<userBindSystemDTO> bindSys = aaaRes.getUserBindSystems();
		tpUserRes.setUsername(aaaRes.getUsername());
		tpUserRes.setPhone(aaaRes.getPhone());
		tpUserRes.setPassword(aaaRes.getPassword());
		tpUserRes.setUserBindSystems(JsonUtil.pojoToJson(aaaRes));
		tpUserRes.setToken(tprRon.getToken());
		tpUserRes.setRefreshToken(tprRon.getRefreshToken());
		tpUserRes.setAAAId(aaaRes.getUserId());
		tpUserRes.setTspId(aaaRes.getTspId());
		this.addThirdPartyUserBaseInformation(tpUserRes);
		return tprRon;
	}

	@Override
	public ResultVO<?> searchThirdPartyUserBaseInformationOne(ThirdPartyUserBaseInformationDTO dto) {
		UserBaseInformation userBaseInformationReq = new UserBaseInformation();
		if (dto.getPhone()!=null) {
			
			userBaseInformationReq.setPhone(dto.getPhone());
		}else {	
			userBaseInformationReq.setNo(dto.getUserNo());
		}
		
		UserBaseInformation userBaseInformationRon = userBaseInformationMapper.selectOne(userBaseInformationReq);
		if (null == userBaseInformationRon) {
			return ResultVOUtil.returnFail(500, "该用户不存在");
		}
		ThirdPartyUserBaseInformation tpubiRes = new ThirdPartyUserBaseInformation();
		tpubiRes.setUserId(userBaseInformationRon.getId());
		ThirdPartyUserBaseInformationVO resultRon = new ThirdPartyUserBaseInformationVO();
		ThirdPartyUserBaseInformation tpubiRon = thirdPartyUserBaseInformationMapper.selectOne(tpubiRes);
		resultRon.setToken(tpubiRon.getToken());
		resultRon.setAAAId(tpubiRon.getAAAId());
		resultRon.setUsername(tpubiRon.getUsername());
		AAADTO aaadto = JsonUtil.jsonToPojo(tpubiRon.getUserBindSystems(), new TypeReference<AAADTO>() {
		});
		resultRon.setRefreshToken(aaadto.getRefresh_token());
		resultRon.setExpiresIn(aaadto.getExpires_in());
		if (null != tpubiRon.getTspId()) {
			resultRon.setTspId(tpubiRon.getTspId());
		}
		return ResultVOUtil.returnSuccess(resultRon);
	}

	// 刷新token
	@Override
	public ResultVO<?> refreshToken(UserBaseInformationDTO param) {
		UserBaseInformation userBaseInformationReq = new UserBaseInformation();
		userBaseInformationReq.setNo(param.getNo());
		UserBaseInformation userBaseInformationRon = userBaseInformationMapper.selectOne(userBaseInformationReq);
		if (null == userBaseInformationRon) {
			return ResultVOUtil.returnFail(500, "该用户不存在");
		}
		ThirdPartyUserBaseInformation tpubiRes = new ThirdPartyUserBaseInformation();
		tpubiRes.setUserId(userBaseInformationRon.getId());
		ThirdPartyUserBaseInformationVO resultRon = new ThirdPartyUserBaseInformationVO();
		ThirdPartyUserBaseInformation tpubiRon = thirdPartyUserBaseInformationMapper.selectOne(tpubiRes);
		ThirdPartyRequestDTO tprRes = null;
//		if (null != tpubiRon.getTspId()) {
			tprRes = thirdPartyRequest.refreshToken(tpubiRon);
			AAADTO aaaRes = JsonUtil.jsonToPojo(tpubiRon.getUserBindSystems(), new TypeReference<AAADTO>() {
			});
			String token=tprRes.getAAAdto().getAccess_token();
			String refreshToken=tprRes.getAAAdto().getRefresh_token();
			String expiresIn=tprRes.getAAAdto().getExpires_in();
			aaaRes.setAccess_token(token);
			tpubiRon.setToken(token);
			aaaRes.setRefresh_token(refreshToken);
			aaaRes.setExpires_in(expiresIn);
			tpubiRon.setUserBindSystems(JsonUtil.pojoToJson(aaaRes));
			thirdPartyUserBaseInformationMapper.updateById(tpubiRon);
			tprRes=new ThirdPartyRequestDTO();
			tprRes.setToken(token);
			tprRes.setRefreshToken(refreshToken);
			
//		}
		return ResultVOUtil.returnSuccess(tprRes);
	}

	@Override
	public ResultVO<?> selectuserNoByTSPID(ThirdPartyUserBaseInformationDTO dto) {
		ThirdPartyUserBaseInformation tpubiRes = new ThirdPartyUserBaseInformation();
		tpubiRes.setTspId(dto.getTspId());
		ThirdPartyUserBaseInformation tpubiRon = thirdPartyUserBaseInformationMapper.selectOne(tpubiRes);
		if(null==tpubiRon) {
			return ResultVOUtil.returnFail(500, "该用户不存在");
		}
		UserBaseInformation userBaseInformationReq = new UserBaseInformation();
		userBaseInformationReq.setId(tpubiRon.getUserId());
		UserBaseInformation userBaseInformationRon = userBaseInformationMapper.selectOne(userBaseInformationReq);
		if (null == userBaseInformationRon) {
			return ResultVOUtil.returnFail(500, "该用户不存在");
		}
		UserBaseInformationVO ubiResult=new UserBaseInformationVO();
		ubiResult.setNo(userBaseInformationRon.getNo());
		return ResultVOUtil.returnSuccess(ubiResult);
	}

	@Override
	public ResultVO<?> selectuserImageByTSPID(ThirdPartyUserBaseInformationDTO dto) {
		ThirdPartyUserBaseInformation tpubiRes = new ThirdPartyUserBaseInformation();
		tpubiRes.setAAAId(dto.getAAAId());
		ThirdPartyUserBaseInformation tpubiRon = thirdPartyUserBaseInformationMapper.selectOne(tpubiRes);
		if(null==tpubiRon) {
			return ResultVOUtil.returnFail(500, "该AAA用户不存在");
		}
		UserBaseInformation userBaseInformationReq = new UserBaseInformation();
		userBaseInformationReq.setId(tpubiRon.getUserId());
		UserBaseInformation userBaseInformationRon = userBaseInformationMapper.selectOne(userBaseInformationReq);
		if (null == userBaseInformationRon) {
			return ResultVOUtil.returnFail(500, "该APP用户不存在");
		}
		//查询用户头像
		ImageRelation image=new ImageRelation();
		image.setImageType(ImageEnum.HAEDURL.getCode().toString());
		image.setImageTypeId(userBaseInformationRon.getId());
		image.setImageTypeNo(userBaseInformationRon.getNo());
		ImageRelation imageRon=imageRelationMapper.selectOne(image);
		if(imageRon==null||imageRon.getImageUrl()==null){
			return ResultVOUtil.returnFail(500, "该用户暂未设置头像");
		}
		UserBaseInformationVO ubiResult=new UserBaseInformationVO();
		ubiResult.setImageUrl(imageRon.getImageUrl());
		return ResultVOUtil.returnSuccess(ubiResult);
	}

	@Override
	public ResultVO<?> searchThirdPartyUserBaseInformationOneByAAAID(ThirdPartyUserBaseInformationDTO dto) {
		ThirdPartyUserBaseInformation tpubiRes = new ThirdPartyUserBaseInformation();
		tpubiRes.setAAAId(dto.getAAAId());
		ThirdPartyUserBaseInformationVO resultRon = new ThirdPartyUserBaseInformationVO();
		ThirdPartyUserBaseInformation tpubiRon = thirdPartyUserBaseInformationMapper.selectOne(tpubiRes);
		resultRon.setUsername(tpubiRon.getUsername());
		return ResultVOUtil.returnSuccess(resultRon);
	}

}
