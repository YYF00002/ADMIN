package com.tima.admin.mapper;

import com.tima.admin.entity.KagaBaseInformation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 卡嘉用户表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2019-12-26
 */
public interface KagaBaseInformationMapper extends BaseMapper<KagaBaseInformation> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
