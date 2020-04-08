package com.tima.admin.service.impl;

import com.tima.admin.entity.SystemModule;
import com.tima.admin.mapper.SystemModuleMapper;
import com.tima.admin.service.ISystemModuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SystemModuleDTO;
import com.tima.admin.vo.SystemModuleVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 系统模块表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class SystemModuleServiceImpl extends ServiceImpl<SystemModuleMapper, SystemModule> implements ISystemModuleService {
  
   
   @Autowired
   private SystemModuleMapper systemModuleMapper;
   @Override
   public ResultVO<?> searchSystemModuleList(SystemModuleDTO dto){
   EntityWrapper<SystemModule> entityWrapper=new EntityWrapper<SystemModule>();
    SystemModule entity=new SystemModule();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(systemModuleMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchSystemModuleListPage(SystemModuleDTO dto){
    Page<SystemModule> page=new Page<SystemModule>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<SystemModule> entityWrapper=new EntityWrapper<SystemModule>();
    SystemModule entity=new SystemModule();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(systemModuleMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchSystemModuleOne(SystemModuleDTO dto){
   SystemModule entity=new SystemModule();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(systemModuleMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addSystemModule(SystemModuleDTO dto){
   SystemModule entity=new SystemModule();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   entity.setNo("");
   systemModuleMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateSystemModule(SystemModuleDTO dto){
   SystemModule entity=new SystemModule();
    entity.setNo(dto.getNo());
    SystemModule result=systemModuleMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    systemModuleMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteSystemModule(SystemModuleDTO dto){
   SystemModule entity=new SystemModule();
    entity.setNo(dto.getNo()); 
    SystemModule result=systemModuleMapper.selectOne(entity); 
    systemModuleMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchSystemModuleRelation(SystemModuleDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
