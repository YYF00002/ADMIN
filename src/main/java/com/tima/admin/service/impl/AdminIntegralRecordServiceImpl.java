package com.tima.admin.service.impl;

import com.tima.admin.entity.AdminIntegralRecord;
import com.tima.admin.mapper.AdminIntegralRecordMapper;
import com.tima.admin.service.IAdminIntegralRecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.AdminIntegralRecordDTO;
import com.tima.admin.vo.AdminIntegralRecordVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 用户模块积分记录表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2019-02-21
 */
@Slf4j
@Transactional
@Service
public class AdminIntegralRecordServiceImpl extends ServiceImpl<AdminIntegralRecordMapper, AdminIntegralRecord> implements IAdminIntegralRecordService {
  
   
   @Autowired
   private AdminIntegralRecordMapper adminIntegralRecordMapper;
//   @Override
//   public ResultVO<?> searchAdminIntegralRecordList(AdminIntegralRecordDTO dto){
//   EntityWrapper<AdminIntegralRecord> entityWrapper=new EntityWrapper<AdminIntegralRecord>();
//    AdminIntegralRecord entity=new AdminIntegralRecord();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//   	return ResultVOUtil.returnSuccess(adminIntegralRecordMapper.selectList(entityWrapper));
//   }
//   @Override
//   public ResultVO<?> searchAdminIntegralRecordListPage(AdminIntegralRecordDTO dto){
//    Page<AdminIntegralRecord> page=new Page<AdminIntegralRecord>();
//    page.setSize(dto.getSize());
//	page.setCurrent(dto.getCurrent());
//    EntityWrapper<AdminIntegralRecord> entityWrapper=new EntityWrapper<AdminIntegralRecord>();
//    AdminIntegralRecord entity=new AdminIntegralRecord();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//    return ResultVOUtil.returnSuccess(page.setRecords(adminIntegralRecordMapper.selectPage(page,entityWrapper)));
//   }
//   @Override
//   public ResultVO<?> searchAdminIntegralRecordOne(AdminIntegralRecordDTO dto){
//   AdminIntegralRecord entity=new AdminIntegralRecord();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//
//   	return ResultVOUtil.returnSuccess(adminIntegralRecordMapper.selectOne(entity));
//   }
   @Override
   public ResultVO<?> addAdminIntegralRecord(AdminIntegralRecordDTO dto){
   AdminIntegralRecord entity=new AdminIntegralRecord();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   adminIntegralRecordMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
//   @Override
//   public ResultVO<?> updateAdminIntegralRecord(AdminIntegralRecordDTO dto){
//   AdminIntegralRecord entity=new AdminIntegralRecord();
//    entity.setNo(dto.getNo());
//    AdminIntegralRecord result=adminIntegralRecordMapper.selectOne(entity);
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);
//    adminIntegralRecordMapper.updateById(result);
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> deleteAdminIntegralRecord(AdminIntegralRecordDTO dto){
//   AdminIntegralRecord entity=new AdminIntegralRecord();
//    entity.setNo(dto.getNo());
//    AdminIntegralRecord result=adminIntegralRecordMapper.selectOne(entity);
//    adminIntegralRecordMapper.deleteById(result.getId());
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> searchAdminIntegralRecordRelation(AdminIntegralRecordDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
//   	return null;
//   }
}
