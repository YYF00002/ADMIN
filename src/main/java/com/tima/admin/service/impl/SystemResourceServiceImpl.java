package com.tima.admin.service.impl;

import com.tima.admin.entity.SystemResource;
import com.tima.admin.mapper.SystemResourceMapper;
import com.tima.admin.service.ISystemResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SystemResourceDTO;
import com.tima.admin.vo.SystemResourceVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 系统资源表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class SystemResourceServiceImpl extends ServiceImpl<SystemResourceMapper, SystemResource> implements ISystemResourceService {
  
   
   @Autowired
   private SystemResourceMapper systemResourceMapper;
   @Override
   public ResultVO<?> searchSystemResourceList(SystemResourceDTO dto){
   EntityWrapper<SystemResource> entityWrapper=new EntityWrapper<SystemResource>();
    SystemResource entity=new SystemResource();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(systemResourceMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchSystemResourceListPage(SystemResourceDTO dto){
    Page<SystemResource> page=new Page<SystemResource>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<SystemResource> entityWrapper=new EntityWrapper<SystemResource>();
    SystemResource entity=new SystemResource();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(systemResourceMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchSystemResourceOne(SystemResourceDTO dto){
   SystemResource entity=new SystemResource();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(systemResourceMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addSystemResource(SystemResourceDTO dto){
   SystemResource entity=new SystemResource();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   entity.setNo("");
   systemResourceMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateSystemResource(SystemResourceDTO dto){
   SystemResource entity=new SystemResource();
    entity.setNo(dto.getNo());
    SystemResource result=systemResourceMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    systemResourceMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteSystemResource(SystemResourceDTO dto){
   SystemResource entity=new SystemResource();
    entity.setNo(dto.getNo()); 
    SystemResource result=systemResourceMapper.selectOne(entity); 
    systemResourceMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchSystemResourceRelation(SystemResourceDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
