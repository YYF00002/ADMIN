package com.tima.admin.mapper;

import com.tima.admin.entity.Demo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * demo表 Mapper 接口
 * </p>
 *
 * @author zwh
 * @since 2018-07-12
 */
public interface DemoMapper extends BaseMapper<Demo> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
