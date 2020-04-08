package com.tima.admin.mapper;

import com.tima.admin.entity.UserAddress;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户收货地址 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
public interface UserAddressMapper extends BaseMapper<UserAddress> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
