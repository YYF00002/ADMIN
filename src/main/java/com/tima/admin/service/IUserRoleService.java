package com.tima.admin.service;

import com.tima.admin.entity.UserRole;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserRoleDTO;
import com.tima.admin.vo.UserRoleVO;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface IUserRoleService extends IService<UserRole> {
//   public ResultVO<?> searchUserRoleList(UserRoleDTO dto);
   public ResultVO<?> searchUserRoleListPage(UserRoleDTO dto);
   public ResultVO<?> searchUserRoleOne(UserRoleDTO dto);
   public ResultVO<?> addUserRole(UserRoleDTO dto);
   public ResultVO<?> updateUserRole(UserRoleDTO dto);
   public ResultVO<?> deleteUserRole(UserRoleDTO dto);
//   public ResultVO<?> searchUserRoleRelation(UserRoleDTO dto);
}
