package com.tima.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.AdvertisingManagementDTO;
import com.tima.admin.entity.AdvertisingManagement;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.CommonEnum;
import com.tima.admin.mapper.AdvertisingManagementMapper;
import com.tima.admin.service.IAdvertisingManagementService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 广告页管理 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2020-02-18
 */
@Slf4j
@Transactional
@Service
public class AdvertisingManagementServiceImpl extends ServiceImpl<AdvertisingManagementMapper, AdvertisingManagement> implements IAdvertisingManagementService {


    @Autowired
    private AdvertisingManagementMapper advertisingManagementMapper;


    @Override
    public ResultVO<?> searchAdvertisingManagementListPage(AdvertisingManagementDTO dto) {
        Page<AdvertisingManagement> page = new Page<AdvertisingManagement>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<AdvertisingManagement> entityWrapper = new EntityWrapper<AdvertisingManagement>();
        AdvertisingManagement entity = new AdvertisingManagement();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        entityWrapper.orderBy("created_date", false);
        return ResultVOUtil.returnSuccess(page.setRecords(advertisingManagementMapper.selectPage(page, entityWrapper)));
    }

    @Override
    public ResultVO<?> searchAdvertisingManagementOne(AdvertisingManagementDTO dto) {
        AdvertisingManagement entity = new AdvertisingManagement();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);

        return ResultVOUtil.returnSuccess(advertisingManagementMapper.selectOne(entity));
    }

    @Override
    public ResultVO<?> addAdvertisingManagement(AdvertisingManagementDTO dto) {
        AdvertisingManagement entity = new AdvertisingManagement();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        //需要开发人员各自定义
        entity.setNo(CodeNoEnum.ADVERTISING_MANAGEMENT.getTableNO() + CommentUtil.createNo());
        advertisingManagementMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateAdvertisingManagement(AdvertisingManagementDTO dto) {
        AdvertisingManagement entity = new AdvertisingManagement();
        entity.setNo(dto.getNo());
        AdvertisingManagement result = advertisingManagementMapper.selectOne(entity);
        if(dto.getStatus().equals(CommonEnum.OPEN)){
            //要启用时先把其他启用的禁用掉
            AdvertisingManagement advertisingManagementDto = new AdvertisingManagement();
            advertisingManagementDto.setStatus(CommonEnum.OPEN.getCode());
            AdvertisingManagement advertisingManagementRon = advertisingManagementMapper.selectOne(advertisingManagementDto);
            if(advertisingManagementRon!=null){
                advertisingManagementRon.setStatus(CommonEnum.CLOSE.getCode());
                advertisingManagementMapper.updateById(advertisingManagementRon);
            }
        }
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        advertisingManagementMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteAdvertisingManagement(AdvertisingManagementDTO dto) {
        AdvertisingManagement entity = new AdvertisingManagement();
        entity.setNo(dto.getNo());
        AdvertisingManagement result = advertisingManagementMapper.selectOne(entity);
        advertisingManagementMapper.deleteById(result.getId());
        return ResultVOUtil.returnSuccess();
    }

}
