package com.tima.admin.service.impl;

import com.tima.admin.entity.ImageRelation;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.ImageEnum;
import com.tima.admin.mapper.ImageRelationMapper;
import com.tima.admin.service.IImageRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.ImageRelationDTO;
import com.tima.admin.vo.ImageRelationVO;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 图片关联表 服务实现类
 * </p>
 *
 * @author zwh
 * @since 2018-07-17
 */
@Slf4j
@Transactional
@Service
public class ImageRelationServiceImpl extends ServiceImpl<ImageRelationMapper, ImageRelation> implements IImageRelationService {
  
   @Autowired
   
   private ImageRelationMapper imageRelationMapper;
//   @Override
//   public ResultVO<?> searchImageRelationList(ImageRelationDTO dto){
//   EntityWrapper<ImageRelation> entityWrapper=new EntityWrapper<ImageRelation>();
//    ImageRelation entity=new ImageRelation();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//   	return ResultVOUtil.returnSuccess(imageRelationMapper.selectList(entityWrapper));
//   }
//   @Override
//   public ResultVO<?> searchImageRelationListPage(ImageRelationDTO dto){
//    Page<ImageRelation> page=new Page<ImageRelation>();
//    page.setSize(dto.getSize());
//	page.setCurrent(dto.getCurrent());
//    EntityWrapper<ImageRelation> entityWrapper=new EntityWrapper<ImageRelation>();
//    ImageRelation entity=new ImageRelation();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//    return ResultVOUtil.returnSuccess(page.setRecords(imageRelationMapper.selectPage(page,entityWrapper)));
//   }
//   @Override
//   public ResultVO<?> searchImageRelationOne(ImageRelationDTO dto){
//   ImageRelation entity=new ImageRelation();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//   
//   	return ResultVOUtil.returnSuccess(imageRelationMapper.selectOne(entity));
//   }
   @Override
   public ResultVO<?> addImageRelation(ImageRelationDTO dto){
   ImageRelation entity=new ImageRelation();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   //需要开发人员各自定义
   entity.setNo(CodeNoEnum.IMAGE_RELATION.getTableNO() + CommentUtil.createNo());
   entity.setImageType(ImageEnum.HAEDURL.getCode().toString());
   imageRelationMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateImageRelation(ImageRelationDTO dto){
   ImageRelation entity=new ImageRelation();
    entity.setNo(dto.getNo());
    ImageRelation result=imageRelationMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    imageRelationMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
//   @Override
//   public ResultVO<?> deleteImageRelation(ImageRelationDTO dto){
//   ImageRelation entity=new ImageRelation();
//    entity.setNo(dto.getNo()); 
//    ImageRelation result=imageRelationMapper.selectOne(entity); 
//    imageRelationMapper.deleteById(result.getId());
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> searchImageRelationRelation(ImageRelationDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
//   	return null;
//   }
}
