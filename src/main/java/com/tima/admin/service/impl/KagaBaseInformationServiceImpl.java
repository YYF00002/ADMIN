package com.tima.admin.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.entity.KagaBaseInformation;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.mapper.KagaBaseInformationMapper;
import com.tima.admin.mapper.ThirdPartyUserBaseInformationMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.service.IKagaBaseInformationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.util.*;
import com.tima.admin.vo.UserBaseInformationVO;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.KagaBaseInformationDTO;
import com.tima.admin.vo.KagaBaseInformationVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 卡嘉用户表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2019-12-23
 */
@Slf4j
@Transactional
@Service
public class KagaBaseInformationServiceImpl extends ServiceImpl<KagaBaseInformationMapper, KagaBaseInformation> implements IKagaBaseInformationService {
  
   
    @Autowired
    private KagaBaseInformationMapper kagaBaseInformationMapper;

    @Autowired
    private UserBaseInformationMapper userBaseInformationMapper;

    @Autowired
    private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;

   @Override
   public ResultVO<?> searchKagaBaseInformationList(KagaBaseInformationDTO dto){
   EntityWrapper<KagaBaseInformation> entityWrapper=new EntityWrapper<KagaBaseInformation>();
    KagaBaseInformation entity=new KagaBaseInformation();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
   	return ResultVOUtil.returnSuccess(kagaBaseInformationMapper.selectList(entityWrapper));
   }
   @Override
   public ResultVO<?> searchKagaBaseInformationListPage(KagaBaseInformationDTO dto){
    Page<KagaBaseInformation> page=new Page<KagaBaseInformation>();
    page.setSize(dto.getSize());
	page.setCurrent(dto.getCurrent());
    EntityWrapper<KagaBaseInformation> entityWrapper=new EntityWrapper<KagaBaseInformation>();
    KagaBaseInformation entity=new KagaBaseInformation();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(page.setRecords(kagaBaseInformationMapper.selectPage(page,entityWrapper)));
   }
   @Override
   public ResultVO<?> searchKagaBaseInformationOne(KagaBaseInformationDTO dto){
   KagaBaseInformation entity=new KagaBaseInformation();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   
   	return ResultVOUtil.returnSuccess(kagaBaseInformationMapper.selectOne(entity));
   }
   @Override
   public ResultVO<?> addKagaBaseInformation(KagaBaseInformationDTO dto){
   KagaBaseInformation entity=new KagaBaseInformation();
   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   kagaBaseInformationMapper.insert(entity);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> updateKagaBaseInformation(KagaBaseInformationDTO dto){
   KagaBaseInformation entity=new KagaBaseInformation();
    entity.setId(dto.getId());
    KagaBaseInformation result=kagaBaseInformationMapper.selectOne(entity);
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);   
    kagaBaseInformationMapper.updateById(result);
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> deleteKagaBaseInformation(KagaBaseInformationDTO dto){
   KagaBaseInformation entity=new KagaBaseInformation();
    entity.setId(dto.getId());
    KagaBaseInformation result=kagaBaseInformationMapper.selectOne(entity); 
    kagaBaseInformationMapper.deleteById(result.getId());
   	return ResultVOUtil.returnSuccess();
   }
   @Override
   public ResultVO<?> searchKagaBaseInformationRelation(KagaBaseInformationDTO dto){
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);		
		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));		
   	return null;
   }

    /**
     * 接受到卡嘉用户数据
     * @param dto
     * @return
     */
    @Override
    public ResultVO<?> login(KagaBaseInformationDTO dto){
        //添加逻辑
        if(dto==null){
            return ResultVOUtil.returnFail();
        }
        //将卡嘉数据插入到数据库
        KagaBaseInformation entity=new KagaBaseInformation();

        entity.setAaaId(dto.getAaaId());
        entity.setType(dto.getType());
        entity.setUserName(dto.getUserName());
        KagaBaseInformation kagaBaseInformation = kagaBaseInformationMapper.selectOne(entity);
        if(kagaBaseInformation==null){
            entity.setPassword(dto.getPassword());
            entity.setPhone(dto.getPhone());
            kagaBaseInformationMapper.insert(entity);
        }else{
            kagaBaseInformation.setPassword(dto.getPassword());
            kagaBaseInformationMapper.updateById(kagaBaseInformation);
        }
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> quickLogin(KagaBaseInformationDTO dto){

        //根据查到的aaa_id到‘kaga_base_inoformation’表里查出所有卡嘉用户
        UserBaseInformationVO user =CommentUtil.getUser() ;
        KagaBaseInformation kagaBaseInformationEntity=new KagaBaseInformation();
        kagaBaseInformationEntity.setAaaId(user.getAAAId()+"");
        EntityWrapper<KagaBaseInformation> wrapper = new EntityWrapper<KagaBaseInformation>();
        wrapper.setEntity(kagaBaseInformationEntity);
        List<KagaBaseInformation> result=kagaBaseInformationMapper.selectList(wrapper);
        return ResultVOUtil.returnSuccess(result);
    }


}
