package com.tima.admin.service.impl;

import com.tima.admin.entity.MenuPermissionsRelation;
import com.tima.admin.entity.RolePermissionsRelation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.entity.UserPermissionsInfo;
import com.tima.admin.entity.UserRole;
import com.tima.admin.entity.UserRoleRelation;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.mapper.MenuPermissionsRelationMapper;
import com.tima.admin.mapper.RolePermissionsRelationMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.mapper.UserPermissionsInfoMapper;
import com.tima.admin.mapper.UserRoleMapper;
import com.tima.admin.mapper.UserRoleRelationMapper;
import com.tima.admin.service.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserRoleDTO;
import com.tima.admin.vo.UserRoleVO;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private UserBaseInformationMapper userBaseInformationMapper;

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	@Autowired
	private UserPermissionsInfoMapper userPermissionsInfoMapper;

	@Autowired
	private RolePermissionsRelationMapper rolePermissionsRelationMapper;

	@Autowired
	private MenuPermissionsRelationMapper menuPermissionsRelationMapper;

	// @Override
	// public ResultVO<?> searchUserRoleList(UserRoleDTO dto){
	// EntityWrapper<UserRole> entityWrapper=new EntityWrapper<UserRole>();
	// UserRole entity=new UserRole();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
	// entityWrapper.setEntity(entity);
	// return ResultVOUtil.returnSuccess(userRoleMapper.selectList(entityWrapper));
	// }
	@Override
	public ResultVO<?> searchUserRoleListPage(UserRoleDTO dto) {
		Page<UserRole> page = new Page<UserRole>();
		page.setSize(dto.getSize());
		page.setCurrent(dto.getCurrent());
		EntityWrapper<UserRole> entityWrapper = new EntityWrapper<UserRole>();
		UserRole entity = new UserRole();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entityWrapper.setEntity(entity);
		return ResultVOUtil.returnSuccess(page.setRecords(userRoleMapper.selectPage(page, entityWrapper)));
	}

	@Override
	public ResultVO<?> searchUserRoleOne(UserRoleDTO dto) {
		UserRole entity = new UserRole();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);

		return ResultVOUtil.returnSuccess(userRoleMapper.selectOne(entity));
	}

	@Override
	public ResultVO<?> addUserRole(UserRoleDTO dto) {
		UserRole entity = new UserRole();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entity.setNo(CodeNoEnum.USER_ROLE.getTableNO() + CommentUtil.createNo());
		userRoleMapper.insert(entity);
		// 插入角色时插入权限
		UserPermissionsInfo upiRes = new UserPermissionsInfo();
		upiRes.setPermissionsName(entity.getRoleName());
		upiRes.setPermissionsDesc(entity.getRoleDesc());
		upiRes.setNo(CodeNoEnum.USER_PERMISSIONS_INFO.getTableNO() + CommentUtil.createNo());
		userPermissionsInfoMapper.insert(upiRes);
		// 插入角色-权限的关联关系
		RolePermissionsRelation rpr = new RolePermissionsRelation();
		rpr.setRoleId(entity.getId());
		rpr.setPermissionsId(upiRes.getId());
		rolePermissionsRelationMapper.insert(rpr);

		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> updateUserRole(UserRoleDTO dto) {
		UserRole entity = new UserRole();
		entity.setNo(dto.getNo());
		UserRole result = userRoleMapper.selectOne(entity);
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
		userRoleMapper.updateById(result);
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> deleteUserRole(UserRoleDTO dto) {
		UserRole entity = new UserRole();
		entity.setNo(dto.getNo());
		UserRole result = userRoleMapper.selectOne(entity);

		RolePermissionsRelation rprRes = new RolePermissionsRelation();
		rprRes.setRoleId(result.getId());
		RolePermissionsRelation rprRon = rolePermissionsRelationMapper.selectOne(rprRes);
		// 删除权限和菜单的关联
		MenuPermissionsRelation mprRes = new MenuPermissionsRelation();
		mprRes.setPermissionsId(rprRon.getPermissionsId());
		EntityWrapper<MenuPermissionsRelation> entityWrapper=new EntityWrapper<MenuPermissionsRelation>();
		entityWrapper.setEntity(mprRes);
		List<MenuPermissionsRelation> listRon=menuPermissionsRelationMapper.selectList(entityWrapper);
		for (MenuPermissionsRelation menuPermissionsRelation : listRon) {
			menuPermissionsRelationMapper.deleteById(menuPermissionsRelation);
		}
		
		// 删除用户-角色关联表
		UserRoleRelation urrRes = new UserRoleRelation();
		urrRes.setUserRoleId(result.getId());
		EntityWrapper<UserRoleRelation> urrWrapper=new EntityWrapper<UserRoleRelation>();
		urrWrapper.setEntity(urrRes);
		List<UserRoleRelation> urrListRon=userRoleRelationMapper.selectList(urrWrapper);
		for (UserRoleRelation userRoleRelation : urrListRon) {
			userRoleRelationMapper.deleteById(userRoleRelation);
		}
		
		// 删除角色-权限关联表
		rolePermissionsRelationMapper.deleteById(rprRon);
		// 删除权限
		UserPermissionsInfo upiRes = new UserPermissionsInfo();
		upiRes.setId(rprRon.getPermissionsId());
		userPermissionsInfoMapper.deleteById(upiRes);
		// 删除角色
		userRoleMapper.deleteById(result.getId());
		return ResultVOUtil.returnSuccess();
	}
	// @Override
	// public ResultVO<?> searchUserRoleRelation(UserRoleDTO dto){
	// //自定义分页参考依据
	// //VehicleCustom vehicleCustom=new VehicleCustom();
	// //ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new
	// ConvertUtil<VehicleRO, VehicleCustom>();
	// //Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
	// //return
	// ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result,
	// convertUtil.entity(ro, vehicleCustom))));
	// return null;
	// }
}
