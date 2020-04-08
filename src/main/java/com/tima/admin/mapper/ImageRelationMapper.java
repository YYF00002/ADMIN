package com.tima.admin.mapper;

import com.tima.admin.entity.ImageRelation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 图片关联表 Mapper 接口
 * </p>
 *
 * @author zwh
 * @since 2018-07-17
 */
public interface ImageRelationMapper extends BaseMapper<ImageRelation> {

   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
