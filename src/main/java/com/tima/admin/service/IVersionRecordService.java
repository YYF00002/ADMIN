package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.VersionRecordDTO;
import com.tima.admin.entity.VersionRecord;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 版本记录表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
public interface IVersionRecordService extends IService<VersionRecord> {
//   public ResultVO<?> searchVersionRecordList(VersionRecordDTO dto);
   public ResultVO<?> searchVersionRecordListPage(VersionRecordDTO dto);
//   public ResultVO<?> searchVersionRecordOne(VersionRecordDTO dto);
   public ResultVO<?> addVersionRecord(VersionRecordDTO dto);
   public ResultVO<?> updateVersionRecord(VersionRecordDTO dto);
   public ResultVO<?> deleteVersionRecord(VersionRecordDTO dto);

   public ResultVO<?> selectNewVersion(VersionRecordDTO dto);
//   public ResultVO<?> searchVersionRecordRelation(VersionRecordDTO dto);
}
