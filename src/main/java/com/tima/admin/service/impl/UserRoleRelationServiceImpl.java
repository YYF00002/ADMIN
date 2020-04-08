package com.tima.admin.service.impl;

import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.entity.UserRole;
import com.tima.admin.entity.UserRoleRelation;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.mapper.UserRoleMapper;
import com.tima.admin.mapper.UserRoleRelationMapper;
import com.tima.admin.service.IUserRoleRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserRoleRelationDTO;
import com.tima.admin.vo.UserRoleRelationVO;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.ConvertUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation>
		implements IUserRoleRelationService {

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	@Autowired
	private UserBaseInformationMapper userBaseInformationMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	// @Override
	// public ResultVO<?> searchUserRoleRelationList(UserRoleRelationDTO dto){
	// EntityWrapper<UserRoleRelation> entityWrapper=new
	// EntityWrapper<UserRoleRelation>();
	// UserRoleRelation entity=new UserRoleRelation();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
	// entityWrapper.setEntity(entity);
	// return
	// ResultVOUtil.returnSuccess(userRoleRelationMapper.selectList(entityWrapper));
	// }
	// @Override
	// public ResultVO<?> searchUserRoleRelationListPage(UserRoleRelationDTO dto){
	// Page<UserRoleRelation> page=new Page<UserRoleRelation>();
	// page.setSize(dto.getSize());
	// page.setCurrent(dto.getCurrent());
	// EntityWrapper<UserRoleRelation> entityWrapper=new
	// EntityWrapper<UserRoleRelation>();
	// UserRoleRelation entity=new UserRoleRelation();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
	// entityWrapper.setEntity(entity);
	// return
	// ResultVOUtil.returnSuccess(page.setRecords(userRoleRelationMapper.selectPage(page,entityWrapper)));
	// }
	// @Override
	// public ResultVO<?> searchUserRoleRelationOne(UserRoleRelationDTO dto) {
	// UserRoleRelation entity = new UserRoleRelation();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
	//
	// return ResultVOUtil.returnSuccess(userRoleRelationMapper.selectOne(entity));
	// }

	@Override
	public ResultVO<?> addUserRoleRelation(List<UserRoleRelationDTO> dto) {
		// 删除原来的
		EntityWrapper<UserRoleRelation> entityWrapper = new EntityWrapper<UserRoleRelation>();
		UserRoleRelation urr = new UserRoleRelation();
		urr.setUserId(dto.get(0).getUserId());
		entityWrapper.setEntity(urr);
		List<UserRoleRelation> oldResult = userRoleRelationMapper.selectList(entityWrapper);
		for (UserRoleRelation userRoleRelation : oldResult) {
			userRoleRelationMapper.deleteById(userRoleRelation);
		}

		// 绑定新增的
		UserRoleRelation urRes = null;
		for (UserRoleRelationDTO urrDTO : dto) {
			urRes = new UserRoleRelation();
			urRes.setUserRoleId(urrDTO.getUserRoleId());
			urRes.setUserId(urrDTO.getUserId());
			userRoleRelationMapper.insert(urRes);
		}
		return ResultVOUtil.returnSuccess();
	}

	// @Override
	// public ResultVO<?> updateUserRoleRelation(UserRoleRelationDTO dto) {
	// UserRoleRelation entity = new UserRoleRelation();
	// UserRoleRelation result = userRoleRelationMapper.selectOne(entity);
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
	// userRoleRelationMapper.updateById(result);
	// return ResultVOUtil.returnSuccess();
	// }

	@Override
	public ResultVO<?> deleteUserRoleRelation(UserRoleRelationDTO dto) {
		UserRoleRelation entity = new UserRoleRelation();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		// entity.setNo(dto.getNo());
		UserRoleRelation result = userRoleRelationMapper.selectOne(entity);
		userRoleRelationMapper.deleteById(result.getId());
		return ResultVOUtil.returnSuccess();
	}

	// @Override
	// public ResultVO<?> searchUserRoleRelationRelation(UserRoleRelationDTO dto) {
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
	public ResultVO<?> selectUserRoleRelationListPage(UserRoleRelationDTO dto) {
		UserRole urRes = new UserRole();
		urRes.setNo(dto.getUserRoleNo());
		UserRole urRon = userRoleMapper.selectOne(urRes);
		dto.setUserRoleId(urRon.getId());
		UserRoleRelationVO urrVORes = new UserRoleRelationVO();
		ConvertUtil<UserRoleRelationDTO, UserRoleRelationVO> convertUtil = new ConvertUtil<UserRoleRelationDTO, UserRoleRelationVO>();
		Page<UserRoleRelationVO> result = convertUtil.pageCommon(dto, urrVORes);

		return ResultVOUtil
				.returnSuccess(result.setRecords(userRoleRelationMapper.selectUserRoleRelationListPage(result, dto)));
	}

	@Override
	public ResultVO<?> selectUserRoleByUserListPage(UserRoleRelationDTO dto) {
		UserBaseInformation ubiRes = new UserBaseInformation();
		ubiRes.setNo(dto.getUserNo());
		UserBaseInformation ubiRon = userBaseInformationMapper.selectOne(ubiRes);

		dto.setUserId(ubiRon.getId());
		UserRoleRelationVO urrVORes = new UserRoleRelationVO();
		ConvertUtil<UserRoleRelationDTO, UserRoleRelationVO> convertUtil = new ConvertUtil<UserRoleRelationDTO, UserRoleRelationVO>();
		Page<UserRoleRelationVO> result = convertUtil.pageCommon(dto, urrVORes);

		return ResultVOUtil
				.returnSuccess(result.setRecords((userRoleRelationMapper.selectUserRoleByUserListPage(result, dto))));
	}
}
