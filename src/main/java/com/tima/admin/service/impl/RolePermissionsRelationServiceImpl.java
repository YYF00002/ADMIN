package com.tima.admin.service.impl;

import com.tima.admin.entity.RolePermissionsRelation;
import com.tima.admin.entity.UserPermissionsInfo;
import com.tima.admin.entity.UserRole;
import com.tima.admin.mapper.RolePermissionsRelationMapper;
import com.tima.admin.mapper.UserPermissionsInfoMapper;
import com.tima.admin.mapper.UserRoleMapper;
import com.tima.admin.service.IRolePermissionsRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.RolePermissionsRelationDTO;
import com.tima.admin.vo.RolePermissionsRelationVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Slf4j
@Transactional
@Service
public class RolePermissionsRelationServiceImpl extends
		ServiceImpl<RolePermissionsRelationMapper, RolePermissionsRelation> implements IRolePermissionsRelationService {

	@Autowired
	private RolePermissionsRelationMapper rolePermissionsRelationMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private UserPermissionsInfoMapper userPermissionsInfoMapper;

//	@Override
//	public ResultVO<?> searchRolePermissionsRelationList(RolePermissionsRelationDTO dto) {
//		EntityWrapper<RolePermissionsRelation> entityWrapper = new EntityWrapper<RolePermissionsRelation>();
//		RolePermissionsRelation entity = new RolePermissionsRelation();
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//		entityWrapper.setEntity(entity);
//		return ResultVOUtil.returnSuccess(rolePermissionsRelationMapper.selectList(entityWrapper));
//	}

//	@Override
//	public ResultVO<?> searchRolePermissionsRelationListPage(RolePermissionsRelationDTO dto) {
//		Page<RolePermissionsRelation> page = new Page<RolePermissionsRelation>();
//		page.setSize(dto.getSize());
//		page.setCurrent(dto.getCurrent());
//		EntityWrapper<RolePermissionsRelation> entityWrapper = new EntityWrapper<RolePermissionsRelation>();
//		RolePermissionsRelation entity = new RolePermissionsRelation();
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//		entityWrapper.setEntity(entity);
//		return ResultVOUtil
//				.returnSuccess(page.setRecords(rolePermissionsRelationMapper.selectPage(page, entityWrapper)));
//	}

//	@Override
//	public ResultVO<?> searchRolePermissionsRelationOne(RolePermissionsRelationDTO dto) {
//		RolePermissionsRelation entity = new RolePermissionsRelation();
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//
//		return ResultVOUtil.returnSuccess(rolePermissionsRelationMapper.selectOne(entity));
//	}

	@Override
	public ResultVO<?> addRolePermissionsRelation(RolePermissionsRelationDTO dto) {
		UserRole urRes = new UserRole();
		urRes.setNo(dto.getRoleNo());
		UserRole urRon = userRoleMapper.selectOne(urRes);
		
		UserPermissionsInfo upiRes=new UserPermissionsInfo();
		upiRes.setNo(dto.getPermissionsNo());
		UserPermissionsInfo upiRon=userPermissionsInfoMapper.selectOne(upiRes);
		
		RolePermissionsRelation entity = new RolePermissionsRelation();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entity.setRoleId(urRon.getId());
		entity.setPermissionsId(upiRon.getId());
		rolePermissionsRelationMapper.insert(entity);
		return ResultVOUtil.returnSuccess();
	}

//	@Override
//	public ResultVO<?> updateRolePermissionsRelation(RolePermissionsRelationDTO dto) {
//		RolePermissionsRelation entity = new RolePermissionsRelation();
//		// entity.setNo(dto.getNo());
//		RolePermissionsRelation result = rolePermissionsRelationMapper.selectOne(entity);
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
//		rolePermissionsRelationMapper.updateById(result);
//		return ResultVOUtil.returnSuccess();
//	}

	@Override
	public ResultVO<?> deleteRolePermissionsRelation(RolePermissionsRelationDTO dto) {
		
		RolePermissionsRelation entity = new RolePermissionsRelation();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		// entity.setNo(dto.getNo());
		RolePermissionsRelation result = rolePermissionsRelationMapper.selectOne(entity);
		rolePermissionsRelationMapper.deleteById(result.getId());
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> selectPermissionsByRole(RolePermissionsRelationDTO dto) {
		UserRole urRes=new UserRole();
		urRes.setNo(dto.getRoleNo());
		UserRole urRon = userRoleMapper.selectOne(urRes);
		
		RolePermissionsRelationDTO rprRes = new RolePermissionsRelationDTO();
		rprRes.setRoleId(urRon.getId());
		return ResultVOUtil.returnSuccess(rolePermissionsRelationMapper.selectPermissionsByRole(rprRes));
	}

	@Override
	public ResultVO<?> selectRoleByPermissions(RolePermissionsRelationDTO dto) {
		UserPermissionsInfo upiRes=new UserPermissionsInfo();
		upiRes.setNo(dto.getPermissionsNo());
		UserPermissionsInfo upiRon=userPermissionsInfoMapper.selectOne(upiRes);
		
		
		RolePermissionsRelationDTO uprRon = new RolePermissionsRelationDTO();
		uprRon.setPermissionsId(upiRon.getId());
		return ResultVOUtil.returnSuccess(rolePermissionsRelationMapper.selectRoleByPermissions(uprRon));
	}

//	@Override
//	public ResultVO<?> searchRolePermissionsRelationRelation(RolePermissionsRelationDTO dto) {
//		// 自定义分页参考依据
//		// VehicleCustom vehicleCustom=new VehicleCustom();
//		// ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new
//		// ConvertUtil<VehicleRO, VehicleCustom>();
//		// Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//		// return
//		// ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result,
//		// convertUtil.entity(ro, vehicleCustom))));
//		return null;
//	}
}
