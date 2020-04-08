package com.tima.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.DeviceVersionRecordDTO;
import com.tima.admin.dto.VersionRecordDTO;
import com.tima.admin.entity.DeviceVersionRecord;
import com.tima.admin.entity.VersionRecord;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.VersionEnum;
import com.tima.admin.mapper.DeviceVersionRecordMapper;
import com.tima.admin.mapper.VersionRecordMapper;
import com.tima.admin.service.IDeviceVersionRecordService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.DeviceVersionRecordVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.VersionRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 设备版本记录表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
@Slf4j
@Transactional
@Service
public class DeviceVersionRecordServiceImpl extends ServiceImpl<DeviceVersionRecordMapper, DeviceVersionRecord> implements IDeviceVersionRecordService {


    @Autowired
    private DeviceVersionRecordMapper deviceVersionRecordMapper;

    @Autowired
    private VersionRecordMapper versionRecordMapper;
//    @Override
//    public ResultVO<?> searchDeviceVersionRecordList(DeviceVersionRecordDTO dto) {
//        EntityWrapper<DeviceVersionRecord> entityWrapper = new EntityWrapper<DeviceVersionRecord>();
//        DeviceVersionRecord entity = new DeviceVersionRecord();
//        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//        entityWrapper.setEntity(entity);
//        return ResultVOUtil.returnSuccess(deviceVersionRecordMapper.selectList(entityWrapper));
//    }

//    @Override
//    public ResultVO<?> searchDeviceVersionRecordListPage(DeviceVersionRecordDTO dto) {
//        Page<DeviceVersionRecord> page = new Page<DeviceVersionRecord>();
//        page.setSize(dto.getSize());
//        page.setCurrent(dto.getCurrent());
//        EntityWrapper<DeviceVersionRecord> entityWrapper = new EntityWrapper<DeviceVersionRecord>();
//        DeviceVersionRecord entity = new DeviceVersionRecord();
//        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//        entityWrapper.setEntity(entity);
//        return ResultVOUtil.returnSuccess(page.setRecords(deviceVersionRecordMapper.selectPage(page, entityWrapper)));
//    }

    @Override
    public ResultVO<?> searchDeviceVersionRecordOne(DeviceVersionRecordDTO dto) {
        //查询设备版本号  如果不存在就插入  存在对比当前版本
        VersionRecord versionRecordRes = new VersionRecord();
        versionRecordRes.setVersionNumber(dto.getVersionNumber());
        versionRecordRes.setVersionType(VersionEnum.VERSION_TYPE_ANDROID.getCode());
        VersionRecord versionRecordRon = versionRecordMapper.selectOne(versionRecordRes);


        DeviceVersionRecordVO deviceVersionRecord = deviceVersionRecordMapper.selectDeviceVersion(dto);
        if (null == deviceVersionRecord) {
            //调用添加方法执行添加
            if(versionRecordRon!=null){
                dto.setVersionId(versionRecordRon.getId());
            }
            this.addDeviceVersionRecord(dto);
            deviceVersionRecord=new DeviceVersionRecordVO();
            deviceVersionRecord.setDeviceName(dto.getDeviceName());
        }

        //查询最新的版本号
        VersionRecordDTO versionRecord = new VersionRecordDTO();
        versionRecord.setVersionType(VersionEnum.VERSION_TYPE_ANDROID.getCode());
        VersionRecordVO versionRecordVO = versionRecordMapper.selectNewVersion(versionRecord);
        int flag=CommentUtil.compareVersion(versionRecordVO.getVersionNumber(),dto.getVersionNumber());
      if(flag==0||flag==-1){
          deviceVersionRecord.setOrUpdate(VersionEnum.NOT_UPDATE.getCode());
      }else{
          deviceVersionRecord.setOrUpdate(VersionEnum.IS_UPDATE.getCode());
      }
        deviceVersionRecord.setVersionNumber(versionRecordVO.getVersionNumber());

        return ResultVOUtil.returnSuccess(deviceVersionRecord);
    }

    @Override
    public ResultVO<?> addDeviceVersionRecord(DeviceVersionRecordDTO dto) {
        DeviceVersionRecord entity = new DeviceVersionRecord();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entity.setNo(CodeNoEnum.DEVICE_VERSION_RECORD.getTableNO() + CommentUtil.createNo());
        deviceVersionRecordMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateDeviceVersionRecord(DeviceVersionRecordDTO dto) {
        VersionRecord versionRecordRes = new VersionRecord();
        versionRecordRes.setVersionNumber(dto.getVersionNumber());
        versionRecordRes.setVersionType(VersionEnum.VERSION_TYPE_ANDROID.getCode());
        VersionRecord versionRecordRon = versionRecordMapper.selectOne(versionRecordRes);
        if (versionRecordRon == null) {
            return ResultVOUtil.returnFail(500, "不存在该版本号");
        }
        DeviceVersionRecord entity = new DeviceVersionRecord();
        entity.setDeviceName(dto.getDeviceName());
        DeviceVersionRecord result = deviceVersionRecordMapper.selectOne(entity);
        result.setVersionId(versionRecordRon.getId());
        deviceVersionRecordMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

//    @Override
//    public ResultVO<?> deleteDeviceVersionRecord(DeviceVersionRecordDTO dto) {
//        DeviceVersionRecord entity = new DeviceVersionRecord();
//        entity.setNo(dto.getNo());
//        DeviceVersionRecord result = deviceVersionRecordMapper.selectOne(entity);
//        deviceVersionRecordMapper.deleteById(result.getId());
//        return ResultVOUtil.returnSuccess();
//    }
//
//    @Override
//    public ResultVO<?> searchDeviceVersionRecordRelation(DeviceVersionRecordDTO dto) {
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//        //ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//        //Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//        //return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
//        return null;
//    }
}
