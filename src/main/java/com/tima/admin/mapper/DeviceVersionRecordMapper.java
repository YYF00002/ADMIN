package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tima.admin.dto.DeviceVersionRecordDTO;
import com.tima.admin.entity.DeviceVersionRecord;
import com.tima.admin.vo.DeviceVersionRecordVO;

/**
 * <p>
 * 设备版本记录表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
public interface DeviceVersionRecordMapper extends BaseMapper<DeviceVersionRecord> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);

    DeviceVersionRecordVO selectDeviceVersion(DeviceVersionRecordDTO dto);

}
