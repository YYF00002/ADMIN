package com.tima.admin.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.RecommendedCodeDTO;
import com.tima.admin.dto.TSPRequestSyncVehicle;
import com.tima.admin.entity.RecommendedCode;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.UserBaseInformationEnum;
import com.tima.admin.feign.ICarResultService;
import com.tima.admin.mapper.RecommendedCodeMapper;
import com.tima.admin.mapper.ThirdPartyUserBaseInformationMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.service.IRecommendedCodeService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.RandomStrUtils;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.RecommendedCodeVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.ResultVOByCarControl;
import com.tima.admin.vo.UserBaseInformationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户推荐码 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-08-29
 */
@Slf4j
@Transactional
@Service
public class RecommendedCodeServiceImpl extends ServiceImpl<RecommendedCodeMapper, RecommendedCode>
		implements IRecommendedCodeService {

	@Value("${APP.recommendedCodeTimes}")
	private Integer times;

	@Autowired
	private RecommendedCodeMapper recommendedCodeMapper;

	@Autowired
	private UserBaseInformationMapper userBaseInformationMapper;

	@Autowired
	private ICarResultService iCarResultService;

	@Autowired
	private IRecommendedCodeService recommendedCodeService;

	@Autowired
	private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;



	@Override
	public ResultVO<?> searchRecommendedCodeList(RecommendedCodeDTO dto) {
		EntityWrapper<RecommendedCode> entityWrapper = new EntityWrapper<RecommendedCode>();
		RecommendedCode entity = new RecommendedCode();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entityWrapper.setEntity(entity);
		return ResultVOUtil.returnSuccess(recommendedCodeMapper.selectList(entityWrapper));
	}

	@Override
	public ResultVO<?> searchRecommendedCodeListPage(RecommendedCodeDTO dto) {
		Page<RecommendedCode> page = new Page<RecommendedCode>();
		page.setSize(dto.getSize());
		page.setCurrent(dto.getCurrent());
		EntityWrapper<RecommendedCode> entityWrapper = new EntityWrapper<RecommendedCode>();
		RecommendedCode entity = new RecommendedCode();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entityWrapper.setEntity(entity);
		return ResultVOUtil.returnSuccess(page.setRecords(recommendedCodeMapper.selectPage(page, entityWrapper)));
	}

	@Override
	public ResultVO<?> searchRecommendedCodeOne(RecommendedCodeDTO dto) {
		UserBaseInformationVO result=CommentUtil.getUser();
		if (null !=result) {
			// 查询第三方用户
			ThirdPartyUserBaseInformation userEntity = new ThirdPartyUserBaseInformation();
			userEntity.setUserId(result.getId());
			ThirdPartyUserBaseInformation userRon = thirdPartyUserBaseInformationMapper.selectOne(userEntity);
			TSPRequestSyncVehicle MyVehicle=new TSPRequestSyncVehicle();
			MyVehicle.setPhone(userRon.getPhone());
			MyVehicle.setAaaUserID(userRon.getAAAId().toString());
			if(userRon.getTspId()!=null){
				MyVehicle.setTspUserId(userRon.getTspId().toString());
			}
			//车控部分userID存的是no
			MyVehicle.setUserId(result.getNo());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("token", userRon.getToken());
			String identityParam = JSONUtils.toJSONString(map);
			ResultVOByCarControl C3Result = iCarResultService.findMyVehicle(MyVehicle,identityParam);
			if(C3Result.getStatus()!=null&&C3Result.getStatus().equals("500")){
				log.info(C3Result.getReturnErrMsg());
				return ResultVOUtil.returnFail(500,"请求车辆信息失败");
			}
			List data = (ArrayList)C3Result.getData();
			if (null == data||data.size()==0) {
				return ResultVOUtil.returnFail(500, "该用户无推荐码");
			}
			dto.setUserId(result.getId());
		}
		RecommendedCodeVO rcVO = recommendedCodeMapper.selectCode(dto);
		RecommendedCode rc = new RecommendedCode();
		if (null == rcVO) {
			rcVO = new RecommendedCodeVO();
			// 设置推荐码
			rc.setUserId(result.getId());
			rc.setRecommendedType(UserBaseInformationEnum.RECOMMENDED_CODE.getCode());
			while (true) {
				rc.setCode(RandomStrUtils.generateRandomString(6));
				if (null == recommendedCodeMapper.selectOne(rc)) {
					break;
				}
			}
			rc.setNo(CodeNoEnum.RECOMMENDED_CODE.getTableNO() + CommentUtil.createNo());
			recommendedCodeMapper.insert(rc);
			String code=rc.getCode();
			BeanCopyUtil.copyPropertiesIgnoreNull(rc, rcVO);
		}
		return ResultVOUtil.returnSuccess(rcVO);
	}

	@Override
	public ResultVO<?> addRecommendedCode(RecommendedCodeDTO dto) {
		RecommendedCode entity = new RecommendedCode();
		while (true) {
			entity.setCode(RandomStrUtils.generateRandomString(6));
			if (null == recommendedCodeMapper.selectOne(entity)) {
				break;
			}
		}
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entity.setNo(CodeNoEnum.RECOMMENDED_CODE.getTableNO() + CommentUtil.createNo());
		recommendedCodeMapper.insert(entity);
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> updateRecommendedCode(RecommendedCodeDTO dto) {
		RecommendedCode entity = new RecommendedCode();
		entity.setCode(dto.getCode());
		RecommendedCode result = recommendedCodeMapper.selectOne(entity);
		// 缺少设置推荐码分享次数的判断 目前未确定
		if(result.getRecommendedTime()>=times){
			return ResultVOUtil.returnFail(500,"该推荐码使用次数已达上限");
		}
		result.setRecommendedTime(result.getRecommendedTime() + 1);
		result.setCumulativeTime(result.getCumulativeTime()+1);
		recommendedCodeMapper.updateById(result);
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> deleteRecommendedCode(RecommendedCodeDTO dto) {
		RecommendedCode entity = new RecommendedCode();
		entity.setNo(dto.getNo());
		RecommendedCode result = recommendedCodeMapper.selectOne(entity);
		recommendedCodeMapper.deleteById(result.getId());
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> searchRecommendedCodeRelation(RecommendedCodeDTO dto) {
		// 自定义分页参考依据
		// VehicleCustom vehicleCustom=new VehicleCustom();
		// ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new
		// ConvertUtil<VehicleRO, VehicleCustom>();
		// Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
		// return
		// ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result,
		// convertUtil.entity(ro, vehicleCustom))));
		return null;
	}

	@Override
	public ResultVO<?> validateCode(RecommendedCodeDTO dto) {
		RecommendedCode entity = new RecommendedCode();
		entity.setCode(dto.getCode());
		RecommendedCode result = recommendedCodeMapper.selectOne(entity);
		if(null==result) {
			return ResultVOUtil.returnFail(500, "该验证码无效");
		}
		if(result.getRecommendedTime()>=times){
			return ResultVOUtil.returnFail(500, "该验证码使用已达上限");
		}
		return ResultVOUtil.returnSuccess();
	}


	public ResultVO<?> resetCode() {
		Integer count=0;
		EntityWrapper<RecommendedCode> objectEntityWrapper = new EntityWrapper<RecommendedCode>();
		objectEntityWrapper.setEntity(new RecommendedCode());
		List<RecommendedCode> result=recommendedCodeMapper.selectList(objectEntityWrapper);
		if(result!=null){
			for (RecommendedCode recommendedCode : result) {
				if(recommendedCode.getRecommendedTime()==0){
					continue;
				}
				recommendedCode.setRecommendedTime(0);
				recommendedCodeMapper.updateById(recommendedCode);
				count++;
			}
		}
		log.info("共重置推荐码个数："+count);
		return ResultVOUtil.returnSuccess();
	}

	
}
