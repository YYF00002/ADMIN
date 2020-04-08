package com.tima.admin.service;

import com.tima.admin.entity.RolePermissionsRelation;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.RolePermissionsRelationDTO;
import com.tima.admin.vo.RolePermissionsRelationVO;

/**
 * <p>
 * 角色权限关联表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
public interface IRolePermissionsRelationService extends IService<RolePermissionsRelation> {
	// public ResultVO<?>
	// searchRolePermissionsRelationList(RolePermissionsRelationDTO dto);
	// public ResultVO<?>
	// searchRolePermissionsRelationListPage(RolePermissionsRelationDTO dto);
	// public ResultVO<?>
	// searchRolePermissionsRelationOne(RolePermissionsRelationDTO dto);
	public ResultVO<?> addRolePermissionsRelation(RolePermissionsRelationDTO dto);

	// public ResultVO<?> updateRolePermissionsRelation(RolePermissionsRelationDTO
	// dto);
	public ResultVO<?> deleteRolePermissionsRelation(RolePermissionsRelationDTO dto);

	// public ResultVO<?>
	// searchRolePermissionsRelationRelation(RolePermissionsRelationDTO dto);
	// 根据角色查权限
	public ResultVO<?> selectPermissionsByRole(RolePermissionsRelationDTO dto);

	// 根据权限查角色
	public ResultVO<?> selectRoleByPermissions(RolePermissionsRelationDTO dto);

}
