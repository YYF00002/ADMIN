package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tima.admin.dto.SysDictDataDTO;
import com.tima.admin.entity.SysDictData;
import com.tima.admin.vo.SysDictDataVO;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);

    public SysDictDataVO selectSysDictData(SysDictDataDTO dto);
}
