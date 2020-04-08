package com.tima.admin.mapper;

import com.tima.admin.entity.UserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
