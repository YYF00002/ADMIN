package com.tima.admin.mapper;

import com.tima.admin.entity.SystemModule;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 系统模块表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface SystemModuleMapper extends BaseMapper<SystemModule> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
