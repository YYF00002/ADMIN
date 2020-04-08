package com.tima.admin.service.impl;

import com.tima.admin.entity.LabelAttribute;
import com.tima.admin.mapper.LabelAttributeMapper;
import com.tima.admin.service.ILabelAttributeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.LabelAttributeDTO;
import com.tima.admin.vo.LabelAttributeVO;
import com.tima.admin.util.BeanCopyUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 标签属性分类 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
@Slf4j
@Transactional
@Service
public class LabelAttributeServiceImpl extends ServiceImpl<LabelAttributeMapper, LabelAttribute> implements ILabelAttributeService {


    @Autowired
    private LabelAttributeMapper labelAttributeMapper;

    @Override
    public ResultVO<?> searchLabelAttributeList(LabelAttributeDTO dto) {
        EntityWrapper<LabelAttribute> entityWrapper = new EntityWrapper<LabelAttribute>();
        LabelAttribute entity = new LabelAttribute();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(labelAttributeMapper.selectList(entityWrapper));
    }

    @Override
    public ResultVO<?> searchLabelAttributeListPage(LabelAttributeDTO dto) {
        Page<LabelAttribute> page = new Page<LabelAttribute>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<LabelAttribute> entityWrapper = new EntityWrapper<LabelAttribute>();
        LabelAttribute entity = new LabelAttribute();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(labelAttributeMapper.selectPage(page, entityWrapper)));
    }

    @Override
    public ResultVO<?> searchLabelAttributeOne(LabelAttributeDTO dto) {
        LabelAttribute entity = new LabelAttribute();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);

        return ResultVOUtil.returnSuccess(labelAttributeMapper.selectOne(entity));
    }

    @Override
    public ResultVO<?> addLabelAttribute(LabelAttributeDTO dto) {
        LabelAttribute entity = new LabelAttribute();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        labelAttributeMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateLabelAttribute(LabelAttributeDTO dto) {
        LabelAttribute entity = new LabelAttribute();
        entity.setId(dto.getId());
        LabelAttribute result = labelAttributeMapper.selectOne(entity);
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        labelAttributeMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteLabelAttribute(LabelAttributeDTO dto) {
        LabelAttribute entity = new LabelAttribute();
        entity.setId(dto.getId());
        LabelAttribute result = labelAttributeMapper.selectOne(entity);
        labelAttributeMapper.deleteById(result.getId());
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> searchLabelAttributeRelation(LabelAttributeDTO dto) {
        //自定义分页参考依据
        //VehicleCustom vehicleCustom=new VehicleCustom();
        //ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
        //Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
        //return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
        return null;
    }
}
