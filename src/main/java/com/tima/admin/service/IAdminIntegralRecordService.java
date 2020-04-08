package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.AdminIntegralRecordDTO;
import com.tima.admin.entity.AdminIntegralRecord;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 用户模块积分记录表 服务类
 * </p>
 *
 * @author YYF
 * @since 2019-02-21
 */
public interface IAdminIntegralRecordService extends IService<AdminIntegralRecord> {
//   public ResultVO<?> searchAdminIntegralRecordList(AdminIntegralRecordDTO dto);
//   public ResultVO<?> searchAdminIntegralRecordListPage(AdminIntegralRecordDTO dto);
//   public ResultVO<?> searchAdminIntegralRecordOne(AdminIntegralRecordDTO dto);
   public ResultVO<?> addAdminIntegralRecord(AdminIntegralRecordDTO dto);
//   public ResultVO<?> updateAdminIntegralRecord(AdminIntegralRecordDTO dto);
//   public ResultVO<?> deleteAdminIntegralRecord(AdminIntegralRecordDTO dto);
//   public ResultVO<?> searchAdminIntegralRecordRelation(AdminIntegralRecordDTO dto);
}
