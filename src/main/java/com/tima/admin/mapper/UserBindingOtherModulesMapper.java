package com.tima.admin.mapper;

import com.tima.admin.entity.UserBindingOtherModules;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户绑定其他模块信息表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2019-04-09
 */
public interface UserBindingOtherModulesMapper extends BaseMapper<UserBindingOtherModules> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
