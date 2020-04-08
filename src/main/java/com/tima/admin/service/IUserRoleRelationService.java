package com.tima.admin.service;

import com.tima.admin.entity.UserRoleRelation;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserRoleRelationDTO;
import com.tima.admin.vo.UserRoleRelationVO;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface IUserRoleRelationService extends IService<UserRoleRelation> {
//   public ResultVO<?> searchUserRoleRelationList(UserRoleRelationDTO dto);
//   public ResultVO<?> searchUserRoleRelationListPage(UserRoleRelationDTO dto);
//   public ResultVO<?> searchUserRoleRelationOne(UserRoleRelationDTO dto);
   public ResultVO<?> addUserRoleRelation(List<UserRoleRelationDTO> dto);
//   public ResultVO<?> updateUserRoleRelation(UserRoleRelationDTO dto);
   public ResultVO<?> deleteUserRoleRelation(UserRoleRelationDTO dto);
//   public ResultVO<?> searchUserRoleRelationRelation(UserRoleRelationDTO dto);
   //根据角色查用户集合
   public ResultVO<?> selectUserRoleRelationListPage(UserRoleRelationDTO dto);
   //根据用户查角色
   public ResultVO<?> selectUserRoleByUserListPage(UserRoleRelationDTO dto);
}
