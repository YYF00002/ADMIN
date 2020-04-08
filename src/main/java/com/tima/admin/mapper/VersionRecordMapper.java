package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tima.admin.dto.VersionRecordDTO;
import com.tima.admin.entity.VersionRecord;
import com.tima.admin.vo.VersionRecordVO;

/**
 * <p>
 * 版本记录表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
public interface VersionRecordMapper extends BaseMapper<VersionRecord> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);

    VersionRecordVO selectNewVersion(VersionRecordDTO dto);
}
