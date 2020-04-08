package com.tima.admin.mapper;

import com.tima.admin.entity.LabelAttribute;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 标签属性分类 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
public interface LabelAttributeMapper extends BaseMapper<LabelAttribute> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
