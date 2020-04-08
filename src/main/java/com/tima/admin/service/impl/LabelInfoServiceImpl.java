package com.tima.admin.service.impl;

import com.tima.admin.entity.LabelAttribute;
import com.tima.admin.entity.LabelInfo;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.mapper.LabelAttributeMapper;
import com.tima.admin.mapper.LabelEntityMapper;
import com.tima.admin.mapper.LabelInfoMapper;
import com.tima.admin.service.ILabelInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.util.CommentUtil;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.LabelInfoDTO;
import com.tima.admin.vo.LabelInfoVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 标签信息 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
@Slf4j
@Transactional
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo> implements ILabelInfoService {


    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private LabelAttributeMapper labelAttributeMapper;


    @Override
    public ResultVO<?> searchLabelInfoList(LabelInfoDTO dto) {
        EntityWrapper<LabelInfo> entityWrapper = new EntityWrapper<LabelInfo>();
        LabelInfo entity = new LabelInfo();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(labelInfoMapper.selectList(entityWrapper));
    }

    @Override
    public ResultVO<?> searchLabelInfoListPage(LabelInfoDTO dto) {
        LabelInfo entity = new LabelInfo();
        if (dto.getAttrNo() != null) {
            LabelAttribute labelAttributeRes = new LabelAttribute();
            labelAttributeRes.setNo(dto.getAttrNo());
            LabelAttribute labelAttributeRon = labelAttributeMapper.selectOne(labelAttributeRes);
            if (labelAttributeRon != null) {
                entity.setAttrId(labelAttributeRon.getId());
            }
        }
        Page<LabelInfo> page = new Page<LabelInfo>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<LabelInfo> entityWrapper = new EntityWrapper<LabelInfo>();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(labelInfoMapper.selectPage(page, entityWrapper)));
    }

    @Override
    public ResultVO<?> searchLabelInfoOne(LabelInfoDTO dto) {
        LabelInfo entity = new LabelInfo();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);

        return ResultVOUtil.returnSuccess(labelInfoMapper.selectOne(entity));
    }

    @Override
    public ResultVO<?> addLabelInfo(LabelInfoDTO dto) {
        LabelAttribute labelAttributeRes = new LabelAttribute();
        labelAttributeRes.setNo(dto.getAttrNo());
        LabelAttribute labelAttributeRon = labelAttributeMapper.selectOne(labelAttributeRes);
        if (labelAttributeRon == null) {
            return ResultVOUtil.returnFail(500, "改标签属性不存在");
        }
        LabelInfo entity = new LabelInfo();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        //需要开发人员各自定义
        entity.setNo(CodeNoEnum.LABEL_INFO.getTableNO() + CommentUtil.createNo());
        entity.setAttrId(labelAttributeRon.getId());
        labelInfoMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateLabelInfo(LabelInfoDTO dto) {
        LabelInfo entity = new LabelInfo();
        entity.setNo(dto.getNo());
        LabelInfo result = labelInfoMapper.selectOne(entity);
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        labelInfoMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteLabelInfo(LabelInfoDTO dto) {
        LabelInfo entity = new LabelInfo();
        entity.setNo(dto.getNo());
        LabelInfo result = labelInfoMapper.selectOne(entity);
        labelInfoMapper.deleteById(result.getId());
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> searchLabelInfoRelation(LabelInfoDTO dto) {
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
        //ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
        //Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
        //return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
        return null;
    }

}
