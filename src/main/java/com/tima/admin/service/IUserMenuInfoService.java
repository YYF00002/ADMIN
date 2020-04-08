package com.tima.admin.service;

import com.tima.admin.entity.UserMenuInfo;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.TreeNodeVO;
import com.tima.admin.dto.UserMenuInfoDTO;
import com.tima.admin.vo.UserMenuInfoVO;

/**
 * <p>
 * 用户菜单信息表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface IUserMenuInfoService extends IService<UserMenuInfo> {
   public ResultVO<?> searchUserMenuInfoList(UserMenuInfoDTO dto);
//   public ResultVO<?> searchUserMenuInfoListPage(UserMenuInfoDTO dto);
   public ResultVO<?> searchUserMenuInfoOne(UserMenuInfoDTO dto);
   public ResultVO<?> addUserMenuInfo(UserMenuInfoDTO dto);
   public ResultVO<?> updateUserMenuInfo(UserMenuInfoDTO dto);
   public ResultVO<?> deleteUserMenuInfo(UserMenuInfoDTO dto);
//   public ResultVO<?> searchUserMenuInfoRelation(UserMenuInfoDTO dto);
   
}
