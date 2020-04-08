package com.tima.admin.service;

import com.tima.admin.entity.UserAddress;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserAddressDTO;
import com.tima.admin.vo.UserAddressVO;

/**
 * <p>
 * 用户收货地址 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
public interface IUserAddressService extends IService<UserAddress> {
   public ResultVO<?> searchUserAddressList(UserAddressDTO dto);
//   public ResultVO<?> searchUserAddressListPage(UserAddressDTO dto);
   public ResultVO<?> searchUserAddressOne(UserAddressDTO dto);
   public ResultVO<?> addUserAddress(UserAddressDTO dto);
   public ResultVO<?> updateUserAddress(UserAddressDTO dto);
   public ResultVO<?> deleteUserAddress(UserAddressDTO dto);
//   public ResultVO<?> searchUserAddressRelation(UserAddressDTO dto);
   public ResultVO<?> setDefaultAddress(UserAddressDTO dto);
}
