package com.tima.admin.service.impl;

import com.tima.admin.entity.Demo;
import com.tima.admin.mapper.DemoMapper;
import com.tima.admin.service.IDemoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.DemoDTO;
import com.tima.admin.vo.DemoVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * demo表 服务实现类
 * </p>
 *
 * @author zwh
 * @since 2018-07-12
 */
@Slf4j
@Transactional
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {
  
   @Autowired
   
   private DemoMapper demoMapper;
   @Override
   public ResultVO<?> searchDemoList(DemoDTO dto){
   EntityWrapper<Demo> entityWrapper=new EntityWrapper<Demo>();
    Demo entity=new Demo();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   	return ResultVOUtil.returnSuccess(demoMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchDemoListPage(DemoDTO dto){
    Page<Demo> page=new Page<Demo>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<Demo> entityWrapper=new EntityWrapper<Demo>();
    Demo entity=new Demo();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(demoMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchDemoOne(DemoDTO dto){
   Demo entity=new Demo();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(demoMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addDemo(DemoDTO dto){
   Demo entity=new Demo();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   entity.setNo("");
   demoMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateDemo(DemoDTO dto){
   Demo entity=new Demo();
    entity.setNo(dto.getNo());
    Demo result=demoMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    demoMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteDemo(DemoDTO dto){
   Demo entity=new Demo();
    entity.setNo(dto.getNo()); 
    Demo result=demoMapper.selectOne(entity); 
    demoMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchDemoRelation(DemoDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
