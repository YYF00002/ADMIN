package com.tima.admin.mapper;

import com.tima.admin.entity.LabelInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 标签信息 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
