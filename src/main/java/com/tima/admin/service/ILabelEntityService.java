package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.LabelEntityDTO;
import com.tima.admin.entity.LabelEntity;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 标签实体 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
public interface ILabelEntityService extends IService<LabelEntity> {
//   public ResultVO<?> searchLabelEntityList(LabelEntityDTO dto);
//   public ResultVO<?> searchLabelEntityListPage(LabelEntityDTO dto);
//   public ResultVO<?> searchLabelEntityOne(LabelEntityDTO dto);
   public ResultVO<?> addLabelEntityToUser(LabelEntityDTO dto);
   public ResultVO<?> updateLabelEntity(LabelEntityDTO dto);
   public ResultVO<?> addLabelEntityManyWeb(LabelEntityDTO dto);
   public ResultVO<?> setVehicleLabel(LabelEntityDTO dto);
//   public ResultVO<?> deleteLabelEntity(LabelEntityDTO dto);
//   public ResultVO<?> searchLabelEntityRelation(LabelEntityDTO dto);
}
