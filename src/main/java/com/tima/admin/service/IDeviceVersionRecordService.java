package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.DeviceVersionRecordDTO;
import com.tima.admin.entity.DeviceVersionRecord;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 设备版本记录表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
public interface IDeviceVersionRecordService extends IService<DeviceVersionRecord> {
//   public ResultVO<?> searchDeviceVersionRecordList(DeviceVersionRecordDTO dto);
//   public ResultVO<?> searchDeviceVersionRecordListPage(DeviceVersionRecordDTO dto);
   public ResultVO<?> searchDeviceVersionRecordOne(DeviceVersionRecordDTO dto);
   public ResultVO<?> addDeviceVersionRecord(DeviceVersionRecordDTO dto);
   public ResultVO<?> updateDeviceVersionRecord(DeviceVersionRecordDTO dto);
//   public ResultVO<?> deleteDeviceVersionRecord(DeviceVersionRecordDTO dto);
//   public ResultVO<?> searchDeviceVersionRecordRelation(DeviceVersionRecordDTO dto);
}
