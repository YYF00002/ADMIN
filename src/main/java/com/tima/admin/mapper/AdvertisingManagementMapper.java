package com.tima.admin.mapper;

import com.tima.admin.entity.AdvertisingManagement;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 广告页管理 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2020-02-18
 */
public interface AdvertisingManagementMapper extends BaseMapper<AdvertisingManagement> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
