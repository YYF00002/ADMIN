package com.tima.admin.service.impl;

import com.tima.admin.entity.SysDictType;
import com.tima.admin.mapper.SysDictTypeMapper;
import com.tima.admin.service.ISysDictTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SysDictTypeDTO;
import com.tima.admin.vo.SysDictTypeVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 系统字典类型表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
@Slf4j
@Transactional
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {
  
   
   @Autowired
   private SysDictTypeMapper sysDictTypeMapper;
   @Override
   public ResultVO<?> searchSysDictTypeList(SysDictTypeDTO dto){
//   EntityWrapper<SysDictType> entityWrapper=new EntityWrapper<SysDictType>();
//    SysDictType entity=new SysDictType();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(sysDictTypeMapper.selectTypeAndData(dto));
   }
   @Override
   public ResultVO<?> searchSysDictTypeListPage(SysDictTypeDTO dto){
    Page<SysDictType> page=new Page<SysDictType>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<SysDictType> entityWrapper=new EntityWrapper<SysDictType>();
    SysDictType entity=new SysDictType();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(sysDictTypeMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchSysDictTypeOne(SysDictTypeDTO dto){
   SysDictType entity=new SysDictType();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(sysDictTypeMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addSysDictType(SysDictTypeDTO dto){
   SysDictType entity=new SysDictType();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   sysDictTypeMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateSysDictType(SysDictTypeDTO dto){
   SysDictType entity=new SysDictType();
    SysDictType result=sysDictTypeMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    sysDictTypeMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteSysDictType(SysDictTypeDTO dto){
   SysDictType entity=new SysDictType();
    SysDictType result=sysDictTypeMapper.selectOne(entity);
    sysDictTypeMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchSysDictTypeRelation(SysDictTypeDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
