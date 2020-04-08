package com.tima.admin.service.impl;

import com.tima.admin.entity.ResourcePermissionsRelation;
import com.tima.admin.mapper.ResourcePermissionsRelationMapper;
import com.tima.admin.service.IResourcePermissionsRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.ResourcePermissionsRelationDTO;
import com.tima.admin.vo.ResourcePermissionsRelationVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 资源权限关联表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class ResourcePermissionsRelationServiceImpl extends ServiceImpl<ResourcePermissionsRelationMapper, ResourcePermissionsRelation> implements IResourcePermissionsRelationService {
  
   
   @Autowired
   private ResourcePermissionsRelationMapper resourcePermissionsRelationMapper;
   @Override
   public ResultVO<?> searchResourcePermissionsRelationList(ResourcePermissionsRelationDTO dto){
   EntityWrapper<ResourcePermissionsRelation> entityWrapper=new EntityWrapper<ResourcePermissionsRelation>();
    ResourcePermissionsRelation entity=new ResourcePermissionsRelation();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(resourcePermissionsRelationMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchResourcePermissionsRelationListPage(ResourcePermissionsRelationDTO dto){
    Page<ResourcePermissionsRelation> page=new Page<ResourcePermissionsRelation>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<ResourcePermissionsRelation> entityWrapper=new EntityWrapper<ResourcePermissionsRelation>();
    ResourcePermissionsRelation entity=new ResourcePermissionsRelation();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(resourcePermissionsRelationMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchResourcePermissionsRelationOne(ResourcePermissionsRelationDTO dto){
   ResourcePermissionsRelation entity=new ResourcePermissionsRelation();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(resourcePermissionsRelationMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addResourcePermissionsRelation(ResourcePermissionsRelationDTO dto){
   ResourcePermissionsRelation entity=new ResourcePermissionsRelation();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   entity.setNo("");
   resourcePermissionsRelationMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateResourcePermissionsRelation(ResourcePermissionsRelationDTO dto){
   ResourcePermissionsRelation entity=new ResourcePermissionsRelation();
    entity.setNo(dto.getNo());
    ResourcePermissionsRelation result=resourcePermissionsRelationMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    resourcePermissionsRelationMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteResourcePermissionsRelation(ResourcePermissionsRelationDTO dto){
   ResourcePermissionsRelation entity=new ResourcePermissionsRelation();
    entity.setNo(dto.getNo()); 
    ResourcePermissionsRelation result=resourcePermissionsRelationMapper.selectOne(entity); 
    resourcePermissionsRelationMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchResourcePermissionsRelationRelation(ResourcePermissionsRelationDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
