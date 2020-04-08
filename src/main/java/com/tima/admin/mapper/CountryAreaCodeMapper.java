package com.tima.admin.mapper;

import com.tima.admin.entity.CountryAreaCode;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 国统局区域代码 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
public interface CountryAreaCodeMapper extends BaseMapper<CountryAreaCode> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
