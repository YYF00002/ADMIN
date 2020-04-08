package com.tima.admin.mapper;

import com.tima.admin.entity.AdminIntegralRecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户模块积分记录表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2019-02-21
 */
public interface AdminIntegralRecordMapper extends BaseMapper<AdminIntegralRecord> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
