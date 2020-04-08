package com.tima.admin.service.impl;

import com.tima.admin.entity.CountryAreaCode;
import com.tima.admin.mapper.CountryAreaCodeMapper;
import com.tima.admin.service.ICountryAreaCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.CountryAreaCodeDTO;
import com.tima.admin.vo.CountryAreaCodeVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 国统局区域代码 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Slf4j
@Transactional
@Service
public class CountryAreaCodeServiceImpl extends ServiceImpl<CountryAreaCodeMapper, CountryAreaCode> implements ICountryAreaCodeService {
  
   
   @Autowired
   private CountryAreaCodeMapper countryAreaCodeMapper;
//   @Override
//   public ResultVO<?> searchCountryAreaCodeList(CountryAreaCodeDTO dto){
//   EntityWrapper<CountryAreaCode> entityWrapper=new EntityWrapper<CountryAreaCode>();
//    CountryAreaCode entity=new CountryAreaCode();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//   	return ResultVOUtil.returnSuccess(countryAreaCodeMapper.selectList(entityWrapper));
//   }
   @Override
   public ResultVO<?> searchCountryAreaCodeListPage(CountryAreaCodeDTO dto){
    Page<CountryAreaCode> page=new Page<CountryAreaCode>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<CountryAreaCode> entityWrapper=new EntityWrapper<CountryAreaCode>();
    CountryAreaCode entity=new CountryAreaCode();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(countryAreaCodeMapper.selectPage(page,entityWrapper)));
   }
//   @Override
//   public ResultVO<?> searchCountryAreaCodeOne(CountryAreaCodeDTO dto){
//   CountryAreaCode entity=new CountryAreaCode();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//   
//   	return ResultVOUtil.returnSuccess(countryAreaCodeMapper.selectOne(entity));
//   }
//   @Override
//   public ResultVO<?> addCountryAreaCode(CountryAreaCodeDTO dto){
//   CountryAreaCode entity=new CountryAreaCode();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//   //需要开发人员各自定义
//   entity.setNo("");
//   countryAreaCodeMapper.insert(entity);
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> updateCountryAreaCode(CountryAreaCodeDTO dto){
//   CountryAreaCode entity=new CountryAreaCode();
//    entity.setNo(dto.getNo());
//    CountryAreaCode result=countryAreaCodeMapper.selectOne(entity);
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
//    countryAreaCodeMapper.updateById(result);
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> deleteCountryAreaCode(CountryAreaCodeDTO dto){
//   CountryAreaCode entity=new CountryAreaCode();
//    entity.setNo(dto.getNo()); 
//    CountryAreaCode result=countryAreaCodeMapper.selectOne(entity); 
//    countryAreaCodeMapper.deleteById(result.getId());
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> searchCountryAreaCodeRelation(CountryAreaCodeDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
//   	return null;
//   }
}
