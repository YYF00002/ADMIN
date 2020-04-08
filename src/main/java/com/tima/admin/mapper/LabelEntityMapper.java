package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tima.admin.dto.LabelEntityDTO;
import com.tima.admin.entity.LabelEntity;
import com.tima.admin.vo.LabelEntityVO;

import java.util.List;

/**
 * <p>
 * 标签实体 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
public interface LabelEntityMapper extends BaseMapper<LabelEntity> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
    public LabelEntity selectupdateMemberLabel(LabelEntityDTO dto);

    public List<LabelEntityVO> selectUserByLabel(List<Long> dto);
}
