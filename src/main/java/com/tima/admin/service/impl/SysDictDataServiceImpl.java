package com.tima.admin.service.impl;

import com.tima.admin.entity.SysDictData;
import com.tima.admin.mapper.SysDictDataMapper;
import com.tima.admin.service.ISysDictDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SysDictDataDTO;
import com.tima.admin.vo.SysDictDataVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
@Slf4j
@Transactional
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {
  
   
   @Autowired
   private SysDictDataMapper sysDictDataMapper;
   @Override
   public ResultVO<?> searchSysDictDataList(SysDictDataDTO dto){
   EntityWrapper<SysDictData> entityWrapper=new EntityWrapper<SysDictData>();
    SysDictData entity=new SysDictData();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(sysDictDataMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchSysDictDataListPage(SysDictDataDTO dto){
    Page<SysDictData> page=new Page<SysDictData>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<SysDictData> entityWrapper=new EntityWrapper<SysDictData>();
    SysDictData entity=new SysDictData();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(sysDictDataMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchSysDictDataOne(SysDictDataDTO dto){
   SysDictData entity=new SysDictData();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(sysDictDataMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addSysDictData(SysDictDataDTO dto){
   SysDictData entity=new SysDictData();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   sysDictDataMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateSysDictData(SysDictDataDTO dto){
   SysDictData entity=new SysDictData();
    SysDictData result=sysDictDataMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    sysDictDataMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteSysDictData(SysDictDataDTO dto){
   SysDictData entity=new SysDictData();
    SysDictData result=sysDictDataMapper.selectOne(entity);
    sysDictDataMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchSysDictDataRelation(SysDictDataDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
