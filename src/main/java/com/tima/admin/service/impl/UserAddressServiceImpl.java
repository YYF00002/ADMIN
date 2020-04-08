package com.tima.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.UserAddressDTO;
import com.tima.admin.entity.CountryAreaCode;
import com.tima.admin.entity.UserAddress;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.UserAddressEnum;
import com.tima.admin.mapper.CountryAreaCodeMapper;
import com.tima.admin.mapper.UserAddressMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.service.IUserAddressService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.UserBaseInformationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户收货地址 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
@Slf4j
@Transactional
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

	@Autowired
	private UserAddressMapper userAddressMapper;

	@Autowired
	private CountryAreaCodeMapper countryAreaCodeMapper;

	@Autowired

	private UserBaseInformationMapper userBaseInformationMapper;


//	private UserBaseInformation user=CommentUtil.getUser();

	@Override
	public ResultVO<?> searchUserAddressList(UserAddressDTO dto) {
		EntityWrapper<UserAddress> entityWrapper = new EntityWrapper<UserAddress>();
		UserAddress entity = new UserAddress();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entity.setUserNo(CommentUtil.getUser().getNo());
		entityWrapper.setEntity(entity);
		return ResultVOUtil.returnSuccess(userAddressMapper.selectList(entityWrapper));
	}

	// @Override
	// public ResultVO<?> searchUserAddressListPage(UserAddressDTO dto) {
	// Page<UserAddress> page = new Page<UserAddress>();
	// page.setSize(dto.getSize());
	// page.setCurrent(dto.getCurrent());
	// EntityWrapper<UserAddress> entityWrapper = new EntityWrapper<UserAddress>();
	// UserAddress entity = new UserAddress();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
	// entityWrapper.setEntity(entity);
	// return
	// ResultVOUtil.returnSuccess(page.setRecords(userAddressMapper.selectPage(page,
	// entityWrapper)));
	// }

	@Override
	public ResultVO<?> searchUserAddressOne(UserAddressDTO dto) {
		UserAddress entity = new UserAddress();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);

		return ResultVOUtil.returnSuccess(userAddressMapper.selectOne(entity));
	}

	@Override
	public ResultVO<?> addUserAddress(UserAddressDTO dto) {

		UserBaseInformationVO userBaseInformationRon = CommentUtil.getUser();
		// 省市查询
		CountryAreaCode areaRes = new CountryAreaCode();
		areaRes.setCode(dto.getProvinceCode());
		CountryAreaCode provinceInfo = countryAreaCodeMapper.selectOne(areaRes);
		areaRes.setCode(dto.getCityCode());
		CountryAreaCode cityInfo = countryAreaCodeMapper.selectOne(areaRes);
		UserAddress entity = new UserAddress();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entity.setNo(CodeNoEnum.USER_ADDREEE.getTableNO() + CommentUtil.createNo());
		entity.setUserId(userBaseInformationRon.getId());
		entity.setProvinceId(provinceInfo.getId());
		entity.setProvinceName(provinceInfo.getName());
		entity.setCityId(cityInfo.getId());
		entity.setCityName(cityInfo.getName());
		userAddressMapper.insert(entity);
		EntityWrapper<UserAddress> wrapper = new EntityWrapper<>();
		UserAddress addressRes = new UserAddress();
		addressRes.setUserId(entity.getUserId());
		wrapper.setEntity(addressRes);
		List<UserAddress> addressList = userAddressMapper.selectList(wrapper);
		if (addressList.size() == 1) {
			entity.setIsDefault(UserAddressEnum.IS_DEFAULT.getCode());
			userAddressMapper.updateById(entity);
		}
		return ResultVOUtil.returnSuccess(entity);
	}

	@Override
	public ResultVO<?> updateUserAddress(UserAddressDTO dto) {
		// UserBaseInformation userBaseInformationReq = new UserBaseInformation();
		// userBaseInformationReq.setNo(dto.getUserNo());
		// UserBaseInformation
		// userBaseInformationRon=userBaseInformationMapper.selectOne(userBaseInformationReq);
		//
		UserAddress entity = new UserAddress();
		entity.setNo(dto.getNo());
		entity.setUserNo(CommentUtil.getUser().getNo());
		UserAddress result = userAddressMapper.selectOne(entity);
		if (null != result) {
			BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
			CountryAreaCode areaRes = new CountryAreaCode();
			areaRes.setCode(dto.getProvinceCode());
			CountryAreaCode provinceInfo = countryAreaCodeMapper.selectOne(areaRes);
			areaRes.setCode(dto.getCityCode());
			CountryAreaCode cityInfo = countryAreaCodeMapper.selectOne(areaRes);

			result.setProvinceId(provinceInfo.getId());
			result.setProvinceName(provinceInfo.getName());
			result.setCityId(cityInfo.getId());
			result.setCityName(cityInfo.getName());
			result.setUserId(result.getUserId());
			result.setUserNo(result.getUserNo());
			result.setIsDefault(result.getIsDefault());
			userAddressMapper.updateById(result);
		}

		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> deleteUserAddress(UserAddressDTO dto) {
		UserAddress entity = new UserAddress();
		entity.setNo(dto.getNo());
		UserAddress result = userAddressMapper.selectOne(entity);
		Long userId = result.getUserId();
		userAddressMapper.deleteById(result.getId());

		EntityWrapper<UserAddress> wrapper = new EntityWrapper<>();
		entity = new UserAddress();
		entity.setUserId(userId);
		wrapper.setEntity(entity);
		List<UserAddress> resultList = userAddressMapper.selectList(wrapper);
		if (resultList.size() == 0) {
			return ResultVOUtil.returnSuccess();
		} else if (resultList.size() == 1) {
			UserAddress addressRes = new UserAddress();
			addressRes = resultList.get(0);
			addressRes.setIsDefault(UserAddressEnum.IS_DEFAULT.getCode());
			userAddressMapper.updateById(addressRes);
		} else {
			boolean falg = false;
			for (UserAddress userAddress : resultList) {
				if (userAddress.getIsDefault() == UserAddressEnum.IS_DEFAULT.getCode()) {
					falg = true;
				}
			}
			if (falg == false) {
				UserAddress addressRes = resultList.get(0);
				addressRes.setIsDefault(UserAddressEnum.IS_DEFAULT.getCode());
				userAddressMapper.updateById(addressRes);
			}
		}
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> setDefaultAddress(UserAddressDTO dto) {
		UserAddress entityReq = new UserAddress();
		entityReq.setIsDefault(UserAddressEnum.IS_DEFAULT.getCode());
		entityReq.setUserNo(CommentUtil.getUser().getNo());
		UserAddress entityRon = userAddressMapper.selectOne(entityReq);
		if (null != entityRon) {
			// 先将原来的默认地址更改为非默认地址，在设置新的默认地址
			entityRon.setIsDefault(UserAddressEnum.IS_NOT_DEFAULT.getCode());
			userAddressMapper.updateById(entityRon);
		}
		entityReq.setNo(dto.getNo());
		entityReq.setIsDefault(UserAddressEnum.IS_NOT_DEFAULT.getCode());
		UserAddress userAddressRon = userAddressMapper.selectOne(entityReq);
		userAddressRon.setIsDefault(UserAddressEnum.IS_DEFAULT.getCode());
		userAddressMapper.updateById(userAddressRon);
		return ResultVOUtil.returnSuccess();

	}

	// @Override
	// public ResultVO<?> searchUserAddressRelation(UserAddressDTO dto) {
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
}
