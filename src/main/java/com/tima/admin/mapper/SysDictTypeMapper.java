package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tima.admin.dto.SysDictTypeDTO;
import com.tima.admin.entity.SysDictType;
import com.tima.admin.vo.SysDictTypeVO;

import java.util.List;

/**
 * <p>
 * 系统字典类型表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);

    List<SysDictTypeVO> selectTypeAndData(SysDictTypeDTO dto);
}
