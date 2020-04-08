package com.tima.admin.mapper;

import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 第三方用户信息表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-08-30
 */
public interface ThirdPartyUserBaseInformationMapper extends BaseMapper<ThirdPartyUserBaseInformation> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
