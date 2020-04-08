package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tima.admin.dto.LevelChangesRecordDTO;
import com.tima.admin.entity.LevelChangesRecord;
import com.tima.admin.vo.LevelChangesRecordVO;

import java.util.List;

/**
 * <p>
 * 会员等级变动明细表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
public interface LevelChangesRecordMapper extends BaseMapper<LevelChangesRecord> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);

    List<LevelChangesRecordVO> selectLevelChangesRecordList(LevelChangesRecordDTO dto);
}
