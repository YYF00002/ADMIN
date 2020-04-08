package com.tima.admin.mapper;

import com.tima.admin.entity.ThirdPartyRequest;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 第三方请求记录表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
public interface ThirdPartyRequestMapper extends BaseMapper<ThirdPartyRequest> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
