package com.tima.admin.service.impl;

import com.tima.admin.entity.LabelEffect;
import com.tima.admin.mapper.LabelEffectMapper;
import com.tima.admin.service.ILabelEffectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.LabelEffectDTO;
import com.tima.admin.vo.LabelEffectVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 标签效能状态分类分类 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
@Slf4j
@Transactional
@Service
public class LabelEffectServiceImpl extends ServiceImpl<LabelEffectMapper, LabelEffect> implements ILabelEffectService {
  
   
   @Autowired
   private LabelEffectMapper labelEffectMapper;
   @Override
   public ResultVO<?> searchLabelEffectList(LabelEffectDTO dto){
   EntityWrapper<LabelEffect> entityWrapper=new EntityWrapper<LabelEffect>();
    LabelEffect entity=new LabelEffect();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(labelEffectMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchLabelEffectListPage(LabelEffectDTO dto){
    Page<LabelEffect> page=new Page<LabelEffect>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<LabelEffect> entityWrapper=new EntityWrapper<LabelEffect>();
    LabelEffect entity=new LabelEffect();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(labelEffectMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchLabelEffectOne(LabelEffectDTO dto){
   LabelEffect entity=new LabelEffect();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(labelEffectMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addLabelEffect(LabelEffectDTO dto){
   LabelEffect entity=new LabelEffect();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   labelEffectMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateLabelEffect(LabelEffectDTO dto){
   LabelEffect entity=new LabelEffect();
    LabelEffect result=labelEffectMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    labelEffectMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteLabelEffect(LabelEffectDTO dto){
   LabelEffect entity=new LabelEffect();
    LabelEffect result=labelEffectMapper.selectOne(entity);
    labelEffectMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchLabelEffectRelation(LabelEffectDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }
}
