package com.tima.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.dto.LabelEntityDTO;
import com.tima.admin.dto.PlutomembershipDTO;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.*;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.LabelEnum;
import com.tima.admin.feign.IPlutomembership;
import com.tima.admin.mapper.*;
import com.tima.admin.service.ILabelEntityService;
import com.tima.admin.util.*;
import com.tima.admin.vo.PlutomembershipDataVO;
import com.tima.admin.vo.PlutomembershipVO;
import com.tima.admin.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 标签实体 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
@Slf4j
@Transactional
@Service
public class LabelEntityServiceImpl extends ServiceImpl<LabelEntityMapper, LabelEntity> implements ILabelEntityService {


    @Autowired
    private LabelEntityMapper labelEntityMapper;
    @Autowired
    private IPlutomembership plutomembership;

    @Autowired
    private UserBaseInformationMapper userBaseInformationMapper;

    @Autowired
    private ThirdPartyUserBaseInformationMapper thirdPartyUserBaseInformationMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private LevelChangesRecordMapper levelChangesRecordMapper;



    //   @Override
//   public ResultVO<?> searchLabelEntityList(LabelEntityDTO dto){
//   EntityWrapper<LabelEntity> entityWrapper=new EntityWrapper<LabelEntity>();
//    LabelEntity entity=new LabelEntity();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//   	return ResultVOUtil.returnSuccess(labelEntityMapper.selectList(entityWrapper));
//   }
//   @Override
//   public ResultVO<?> searchLabelEntityListPage(LabelEntityDTO dto){
//    Page<LabelEntity> page=new Page<LabelEntity>();
//    page.setSize(dto.getSize());
//	page.setCurrent(dto.getCurrent());
//    EntityWrapper<LabelEntity> entityWrapper=new EntityWrapper<LabelEntity>();
//    LabelEntity entity=new LabelEntity();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//    return ResultVOUtil.returnSuccess(page.setRecords(labelEntityMapper.selectPage(page,entityWrapper)));
//   }
//   @Override
//   public ResultVO<?> searchLabelEntityOne(LabelEntityDTO dto){
//   LabelEntity entity=new LabelEntity();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//
//   	return ResultVOUtil.returnSuccess(labelEntityMapper.selectOne(entity));
//   }
//    @Override
//    public ResultVO<?> addLabelEntity(LabelEntityDTO dto) {
//        LabelEntity entity = new LabelEntity();
//        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//        entity.setNo(CodeNoEnum.LABEL_ENTITY.getTableNO() + CommentUtil.createNo());
//        labelEntityMapper.insert(entity);
//        return ResultVOUtil.returnSuccess();
//    }



    @Override
    public ResultVO<?>  updateLabelEntity(LabelEntityDTO dto) {
        ThirdPartyUserBaseInformation tubiRes = new ThirdPartyUserBaseInformation();
        tubiRes.setAAAId(dto.getUid());
        ThirdPartyUserBaseInformation tubiRon = thirdPartyUserBaseInformationMapper.selectOne(tubiRes);
        if (tubiRon == null) {
            return ResultVOUtil.returnFail(500, "该用户不存在");
        }
        LabelInfo labelInfoRes = new LabelInfo();
        labelInfoRes.setId(dto.getLevelId());
        LabelInfo labelInfoRon = labelInfoMapper.selectOne(labelInfoRes);
        if (labelInfoRon == null) {
            return ResultVOUtil.returnFail(500, "不存在改该标签");
        }
        LabelEntityDTO leDto = new LabelEntityDTO();
        leDto.setUid(tubiRon.getUserId());
        LabelEntity result = labelEntityMapper.selectupdateMemberLabel(leDto);
        Long oldLabelId=null;
        if(null!=result){
            oldLabelId=result.getLabelId();
            result.setLabelId(labelInfoRon.getId());
            labelEntityMapper.updateById(result);
        }else{
            result=new LabelEntity();
            result.setLabelId(labelInfoRon.getId());
            result.setUid(tubiRon.getUserId());
            result.setNo(CodeNoEnum.LABEL_ENTITY.getTableNO() + CommentUtil.createNo());
            labelEntityMapper.insert(result);
        }
        //添加等级变动明细记录
        if(labelInfoRon.getAttrId().intValue()==LabelEnum.MEMBER_LABEL.getCode()){
            LevelChangesRecord levelChangesRecord = new LevelChangesRecord();
            levelChangesRecord.setUid(tubiRon.getUserId());
            levelChangesRecord.setLabelIdOld(oldLabelId);
            levelChangesRecord.setLabelIdNew(labelInfoRon.getId());
            levelChangesRecord.setNo(CodeNoEnum.LEVEL_CHANGES_RECORD.getTableNO()+CommentUtil.createNo());
            levelChangesRecordMapper.insert(levelChangesRecord);
        }


        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> addLabelEntityManyWeb(LabelEntityDTO dto) {
        UserBaseInformation userBaseInformationRes = null;
        UserBaseInformation userBaseInformationRon = null;
        List<UserBaseInformation> useList = new ArrayList<>();
        for (String no : dto.getUserNos()) {
            userBaseInformationRes = new UserBaseInformation();
            userBaseInformationRes.setNo(no);
            userBaseInformationRon = userBaseInformationMapper.selectOne(userBaseInformationRes);
            if (userBaseInformationRon != null) {
                useList.add(userBaseInformationRon);
            }
        }
        LabelInfo labelInfoRes = new LabelInfo();
        labelInfoRes.setNo(dto.getLabelNo());
        LabelInfo labelInfoRon = labelInfoMapper.selectOne(labelInfoRes);
        if (labelInfoRon == null) {
            return ResultVOUtil.returnFail(500, "不存在改该标签");
        }

        LabelEntity leRes = new LabelEntity();
        leRes.setLabelId(labelInfoRon.getId());
        for (UserBaseInformation ubi : useList) {
            leRes.setUid(ubi.getId());
            leRes.setNo(CodeNoEnum.LABEL_ENTITY.getTableNO() + CommentUtil.createNo());
            labelEntityMapper.insert(leRes);
        }


        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> setVehicleLabel(LabelEntityDTO dto) {
        UserBaseInformation userBaseInformationRon = null;
        UserBaseInformation userBaseInformationRes = new UserBaseInformation();
        userBaseInformationRes.setNo(dto.getUserNo());
        userBaseInformationRon = userBaseInformationMapper.selectOne(userBaseInformationRes);
        if (userBaseInformationRon == null) {
            return ResultVOUtil.returnFail(500, "该用户不存在");
        }
        LabelInfo labelInfoRes = new LabelInfo();
        labelInfoRes.setAttrId(new Long(LabelEnum.CAR_OWNER.getCode()));
        LabelInfo labelInfoRon = labelInfoMapper.selectOne(labelInfoRes);
        if (labelInfoRon == null) {
            return ResultVOUtil.returnFail(500, "不存在该标签");
        }
        LabelEntity labelEntityRes = new LabelEntity();
        labelEntityRes.setUid(userBaseInformationRon.getId());
        labelEntityRes.setLabelId(labelInfoRon.getId());
        LabelEntity labelEntityRon = labelEntityMapper.selectOne(labelEntityRes);
        if (dto.getIsOwner() == 0) {
            //车主
            if (labelEntityRon == null) {
                //添加
                labelEntityRes.setNo(CodeNoEnum.LABEL_ENTITY.getTableNO() + CommentUtil.createNo());
                labelEntityMapper.insert(labelEntityRes);
            }

        } else {
            //非车主
            if (labelEntityRon != null) {
                labelEntityMapper.deleteById(labelEntityRon);
            }
        }
        return ResultVOUtil.returnSuccess();
    }
//   @Override
//   public ResultVO<?> deleteLabelEntity(LabelEntityDTO dto){
//   LabelEntity entity=new LabelEntity();
//    entity.setNo(dto.getNo());
//    LabelEntity result=labelEntityMapper.selectOne(entity);
//    labelEntityMapper.deleteById(result.getId());
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> searchLabelEntityRelation(LabelEntityDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
//   	return null;
//   }


    @Override
    public ResultVO<?> addLabelEntityToUser(LabelEntityDTO dto) {

        //查询用户会员等级
        UserBaseInformation userBaseInformation = new UserBaseInformation();
        userBaseInformation.setId(dto.getUid());
        UserBaseInformation ubiRon = userBaseInformationMapper.selectOne(userBaseInformation);

        ResultVO<?> resultLevel = this.addOrUpdateLabelEntity(ubiRon);
        if(resultLevel.getCode()!=0){
            return ResultVOUtil.returnFail(resultLevel.getCode(), resultLevel.getMsg());
        }
        //查询用户性别
        ResultVO<?> resultSex = this.addOrUpdateLabelSex(ubiRon);
        if(resultSex.getCode()!=0){
            return ResultVOUtil.returnFail(resultSex.getCode(), resultSex.getMsg());
        }

        return ResultVOUtil.returnSuccess();
    }


    public ResultVO<?> addOrUpdateLabelEntity(UserBaseInformation dto) {
        PlutomembershipDTO plutomembershipDTO = new PlutomembershipDTO();
        plutomembershipDTO.setNo(dto.getNo());
        PlutomembershipVO plutomembershipVO = plutomembership.searchIntegralCountList(plutomembershipDTO);
        if (plutomembershipVO.getCode() == 500) {
            return ResultVOUtil.returnFail(500, "获取用户等级--哑巴！！！");
        }
        List<PlutomembershipDataVO> plutomembershipDataVOS = JsonUtil.jsonToPojoList(JSON.toJSONString(plutomembershipVO.getData()), new TypeReference<List<PlutomembershipDataVO>>() {
        });
//        if (plutomembershipDataVOS == null || plutomembershipDataVOS.size() == 0) {
//            return ResultVOUtil.returnSuccess();
//        }
//        PlutomembershipDataVO data = plutomembershipDataVOS.get(0);
//        LabelInfo labelInfoRes = new LabelInfo();
//        labelInfoRes.setId(new Long(data.getLevelId()));
//        LabelInfo labelInfoRon = labelInfoMapper.selectOne(labelInfoRes);
//        if (labelInfoRon == null) {
//            return ResultVOUtil.returnFail(500, "不存在改该标签");
//        }
//        LabelEntityDTO item= new LabelEntityDTO();
//        item.setUid(dto.getId());
//        item.setLabelId(labelInfoRon.getId());
//        LabelEntity labelEntityVO = labelEntityMapper.selectupdateMemberLabel(item);
//        if (labelEntityVO == null) {
//            item.setNo(CodeNoEnum.LABEL_ENTITY.getTableNO() + CommentUtil.createNo());
//            item.setUpdateTime(new Date());
//            LabelEntity labelEntity = new LabelEntity();
//            BeanCopyUtil.copyPropertiesIgnoreNull(item, labelEntity);
//            labelEntityMapper.insert(labelEntity);
//        } else {
//            labelEntityMapper.updateById(labelEntityVO);
//        }
        return ResultVOUtil.returnSuccess();
    }


    //更改用户性别标签
    public ResultVO<?> addOrUpdateLabelSex(UserBaseInformation dto) {
        LabelInfo labelInfoRes = new LabelInfo();

        if(StringUtil.getString_TrimZeroLenAsNull(dto.getSex())!=null&&dto.getSex()==1){
            //男
            labelInfoRes.setId(new Long(LabelEnum.MAN.getCode()));
        }else if(StringUtil.getString_TrimZeroLenAsNull(dto.getSex())!=null&&dto.getSex()==2){
            //女
            labelInfoRes.setId(new Long(LabelEnum.WOMAN.getCode()));
        }else{
            return ResultVOUtil.returnFail(500,"为用户设置性别标签：该用户没有设置性别");
        }
        LabelInfo labelInfoRon = labelInfoMapper.selectOne(labelInfoRes);
        if (labelInfoRon == null) {
            return ResultVOUtil.returnFail(500, "不存在改该标签");
        }
        LabelEntity entity = new LabelEntity();
        entity.setUid(dto.getId());
        EntityWrapper<LabelEntity> wrapper = new EntityWrapper<>();
        wrapper.setEntity(entity);
        wrapper.in("label_id",new Long[]{new Long(LabelEnum.MAN.getCode()),new Long(LabelEnum.WOMAN.getCode())});
        List<LabelEntity> labelEntities = labelEntityMapper.selectList(wrapper);
        if (labelEntities.size() == 0||labelEntities==null) {
            entity.setNo(CodeNoEnum.LABEL_ENTITY.getTableNO() + CommentUtil.createNo());
            entity.setLabelId(labelInfoRes.getId());
            labelEntityMapper.insert(entity);
        } else {
            labelEntities.get(0).setLabelId(labelInfoRes.getId());
            labelEntityMapper.updateById(labelEntities.get(0));
        }
        return ResultVOUtil.returnSuccess();

    }
}
