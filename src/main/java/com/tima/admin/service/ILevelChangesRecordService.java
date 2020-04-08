package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.LevelChangesRecordDTO;
import com.tima.admin.entity.LevelChangesRecord;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 会员等级变动明细表 服务类
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
public interface ILevelChangesRecordService extends IService<LevelChangesRecord> {
   public ResultVO<?> searchLevelChangesRecordList(LevelChangesRecordDTO dto);
//   public ResultVO<?> searchLevelChangesRecordListPage(LevelChangesRecordDTO dto);
//   public ResultVO<?> searchLevelChangesRecordOne(LevelChangesRecordDTO dto);
//   public ResultVO<?> addLevelChangesRecord(LevelChangesRecordDTO dto);
   public ResultVO<?> updateLevelChangesRecord(LevelChangesRecordDTO dto);
//   public ResultVO<?> deleteLevelChangesRecord(LevelChangesRecordDTO dto);
//   public ResultVO<?> searchLevelChangesRecordRelation(LevelChangesRecordDTO dto);
}
