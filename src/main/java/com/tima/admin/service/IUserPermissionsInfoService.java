package com.tima.admin.service;

import com.tima.admin.entity.UserPermissionsInfo;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserPermissionsInfoDTO;
import com.tima.admin.vo.UserPermissionsInfoVO;

/**
 * <p>
 * 权限信息表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface IUserPermissionsInfoService extends IService<UserPermissionsInfo> {
//   public ResultVO<?> searchUserPermissionsInfoList(UserPermissionsInfoDTO dto);
   public ResultVO<?> searchUserPermissionsInfoListPage(UserPermissionsInfoDTO dto);
//   public ResultVO<?> searchUserPermissionsInfoOne(UserPermissionsInfoDTO dto);
//   public ResultVO<?> addUserPermissionsInfo(UserPermissionsInfoDTO dto);
//   public ResultVO<?> updateUserPermissionsInfo(UserPermissionsInfoDTO dto);
//   public ResultVO<?> deleteUserPermissionsInfo(UserPermissionsInfoDTO dto);
//   public ResultVO<?> searchUserPermissionsInfoRelation(UserPermissionsInfoDTO dto);
}
