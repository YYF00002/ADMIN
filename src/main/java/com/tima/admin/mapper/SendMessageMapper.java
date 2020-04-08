package com.tima.admin.mapper;

import com.tima.admin.entity.SendMessage;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 消息推送 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
public interface SendMessageMapper extends BaseMapper<SendMessage> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
