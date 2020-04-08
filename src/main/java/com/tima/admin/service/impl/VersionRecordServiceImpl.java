package com.tima.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.VersionRecordDTO;
import com.tima.admin.entity.DeviceVersionRecord;
import com.tima.admin.entity.VersionRecord;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.mapper.DeviceVersionRecordMapper;
import com.tima.admin.mapper.VersionRecordMapper;
import com.tima.admin.service.IVersionRecordService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 版本记录表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
@Slf4j
@Transactional
@Service
public class VersionRecordServiceImpl extends ServiceImpl<VersionRecordMapper, VersionRecord> implements IVersionRecordService {


    @Autowired
    private VersionRecordMapper versionRecordMapper;

    @Autowired
    private DeviceVersionRecordMapper deviceVersionRecordMapper;

    //   @Override
//   public ResultVO<?> searchVersionRecordList(VersionRecordDTO dto){
//   EntityWrapper<VersionRecord> entityWrapper=new EntityWrapper<VersionRecord>();
//    VersionRecord entity=new VersionRecord();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//   	return ResultVOUtil.returnSuccess(versionRecordMapper.selectList(entityWrapper));
//   }
    @Override
    public ResultVO<?> searchVersionRecordListPage(VersionRecordDTO dto) {
        Page<VersionRecord> page = new Page<VersionRecord>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<VersionRecord> entityWrapper = new EntityWrapper<VersionRecord>();
        VersionRecord entity = new VersionRecord();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(versionRecordMapper.selectPage(page, entityWrapper)));
    }


//   @Override
//   public ResultVO<?> searchVersionRecordOne(VersionRecordDTO dto){
//   VersionRecord entity=new VersionRecord();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//
//   	return ResultVOUtil.returnSuccess(versionRecordMapper.selectOne(entity));
//   }


    @Override
    public ResultVO<?> addVersionRecord(VersionRecordDTO dto) {
        VersionRecord entity = new VersionRecord();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entity.setNo(CodeNoEnum.VERSION_RECORD.getTableNO() + CommentUtil.createNo());
        versionRecordMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }


    @Override
    public ResultVO<?> updateVersionRecord(VersionRecordDTO dto) {
        VersionRecord entity = new VersionRecord();
        entity.setNo(dto.getNo());
        VersionRecord result = versionRecordMapper.selectOne(entity);
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        versionRecordMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteVersionRecord(VersionRecordDTO dto) {
        VersionRecord entity = new VersionRecord();
        entity.setNo(dto.getNo());
        VersionRecord result = versionRecordMapper.selectOne(entity);
        if (null != result) {
            versionRecordMapper.deleteById(result.getId());
        }
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> selectNewVersion(VersionRecordDTO dto) {
        return ResultVOUtil.returnSuccess(versionRecordMapper.selectNewVersion(dto));
    }
//   @Override
//   public ResultVO<?> searchVersionRecordRelation(VersionRecordDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
//   	return null;
//   }
}
